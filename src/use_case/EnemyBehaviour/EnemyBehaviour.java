package use_case.EnemyBehaviour;

import entity.Deck;
import entity.Enemy;
import interface_adapter.APIAccessInterface;

import java.io.IOException;
import java.util.Random;

public class EnemyBehaviour implements EnemyBehaviourInterface{

    private final APIAccessInterface apiAccess;
    private final Random randomizer;
    private final Enemy enemy;

    public EnemyBehaviour(APIAccessInterface apiAccessInterface, Enemy enemy) throws IOException {
        apiAccess = apiAccessInterface;
        this.enemy = enemy;
        randomizer = new Random();
    }

    public EnemyBehaviourOutputData performRandomAction() throws IOException {
        // Random number generator. 0 = attack, 1 = defend, 2 = draw. That way we can just lower the origin or bound
        // if the enemy cannot attack or draw

        int actionID;
        if (apiAccess.GetCardsInPile("enemyHand").length == 0) { // Enemy has no cards and thus cannot attack
            actionID = randomizer.nextInt(1,3);
        }
        else if (apiAccess.GetCardsInPile("enemyHand").length > 5) { // Enemy has a full hand and thus cannot draw
            actionID = randomizer.nextInt(0,2);
        }
        else {
            actionID = randomizer.nextInt(0,3);
        }

        if (actionID == 0){
            return enemyAttack();
        }
        else if (actionID == 1){
            return new EnemyBehaviourOutputData("defend", -1, ' ', "");
        }
        else { // actionID == 2
            enemyDraw();
            return new EnemyBehaviourOutputData("draw", -1, ' ', "");
        }
    }

    private EnemyBehaviourOutputData enemyAttack() throws IOException {
        //Sets cardValue and cardSuit
        String[] enemyHand = apiAccess.GetCardsInPile("enemyHand");
        // This method should only be called when enemyHand has at least one card in it
        int cardUsed = randomizer.nextInt(0, enemyHand.length);
        int cardValue = apiAccess.GetCardValue(enemyHand[cardUsed]);
        char cardSuit = apiAccess.GetCardSuit(enemyHand[cardUsed]);
        apiAccess.CardPlayed("enemyHand", enemyHand[cardUsed]);

        return new EnemyBehaviourOutputData("attack", cardValue, cardSuit, enemyHand[cardUsed]);
    }

    private void enemyDraw() throws IOException {
        // This one is public because it's called when an enemy is generated
        boolean successfulDraw = false;
        int attempts = 0;
        String newCard = "";

        while (!successfulDraw || attempts < 10){ // Tries at most 10 times to draw a preferred card for the enemy
            apiAccess.DrawCard("possibleEnemyHandAddition");
            // Creates a new temporary pile with only one card in it.
            newCard = apiAccess.GetCardsInPile("possibleEnemyHandAddition")[0];

            if (enemy.getPreferredSuit() != '\0' && apiAccess.GetCardSuit(newCard) == enemy.getPreferredSuit()){
                // new card is the enemy's preferred suit, if it has a preferred suit
               successfulDraw = true;
            }
            else if ((enemy.getMinimumPreferredValue() <= apiAccess.GetCardValue(newCard)) &&
                    (apiAccess.GetCardValue(newCard) <= enemy.getMaximumPreferredValue())){
                // new card is within the enemy's preferred value range
                successfulDraw = true;
            }
            else{
                // new card is not what the enemy wants. Return it to the deck and try again
                apiAccess.MovePileToDeck("possibleEnemyHandAddition");
            }
            attempts++;
        }
        // Adds the new card to the enemy's actual hand
        apiAccess.AddToPile("enemyHand", newCard);
        //apiAccess.MovePileToDeck(deck, "possibleEnemyHandAddition");
        // ^ The above code has been commented out since I don't think it's necessary anymore? The possibleEnemyHandAddition pile
        // only ever has one card in it, which was just moved into a new pile, so it should be empty
    }

    public void enemyDrawInitialHand() throws IOException {
        //Draws five cards
        for (int i = 0; i < 5; i++) {
            enemyDraw();
        }
    }
}
