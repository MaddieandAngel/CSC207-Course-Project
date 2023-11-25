package use_case;

import entity.Deck;
import entity.Enemy;
import interface_adapter.APIAccessInterface;

import java.io.IOException;
import java.util.Random;

public class EnemyBehaviour {

    private String action;
    private int cardValue = -1;
    private char cardSuit = '\0';
    private final APIAccessInterface apiAccess;
    private final Random randomizer;
    private final Deck deck;
    private final Enemy enemy;

    public EnemyBehaviour(APIAccessInterface apiAccessInterface, Deck deck, Enemy enemy) throws IOException {
        apiAccess = apiAccessInterface;
        this.deck = deck;
        this.enemy = enemy;
        randomizer = new Random();
        performRandomAction();
    }

    public void performRandomAction() throws IOException {
        // Random number generator. 0 = attack, 1 = defend, 2 = draw. That way we can just lower the origin or bound
        // if the enemy cannot attack or draw

        int actionID;
        if (apiAccess.GetCardsInPile(deck, "enemyHand").length == 0) { // Enemy has no cards and thus cannot attack
            actionID = randomizer.nextInt(1,3);
        }
        else if (apiAccess.GetCardsInPile(deck, "enemyHand").length > 5) { // Enemy has a full hand and thus cannot draw
            actionID = randomizer.nextInt(0,2);
        }
        else {
            actionID = randomizer.nextInt(0,3);
        }

        if (actionID == 0){
            action = "attack";
            enemyAttack();
        }
        else if (actionID == 1){
            action = "defend";
        }
        else { // actionID == 2
            action = "draw";
            enemyDraw();
        }
    }

    private void enemyAttack() throws IOException {
        //Sets cardValue and cardSuit
        String[] enemyHand = apiAccess.GetCardsInPile(deck, "enemyHand");
        // This method should only be called when enemyHand has at least one card in it
        int cardUsed = randomizer.nextInt(0, enemyHand.length);
        cardValue = apiAccess.GetCardValue(enemyHand[cardUsed]);
        cardSuit = apiAccess.GetCardSuit(enemyHand[cardUsed]);
        apiAccess.CardPlayed(deck.getDeckID(), "enemyHand", enemyHand[cardUsed]);
    }

    public void enemyDraw() throws IOException {
        // This one is public because it's called when an enemy is generated
        boolean successfulDraw = false;
        int attempts = 0;
        String newCard = "";

        while (!successfulDraw || attempts < 10){ // Tries at most 10 times to draw a preferred card for the enemy
            apiAccess.DrawCard(deck, "possibleEnemyHandAddition");
            // Creates a new temporary pile with only one card in it.
            newCard = apiAccess.GetCardsInPile(deck, "possibleEnemyHandAddition")[0];

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
                apiAccess.MovePileToDeck(deck, "possibleEnemyHandAddition");
            }
            attempts++;
        }
        // Removes the new card from the temporary pile, so that it can be added to the enemy's actual hand
        apiAccess.MovePileToDeck(deck, "possibleEnemyHandAddition");
        apiAccess.AddToPile(deck.getDeckID(), "enemyHand", newCard);
    }

    public String getAction() {
        return action;
    }
    public int getCardValue() {
        return cardValue;
    }
    public char getCardSuit() {
        return cardSuit;
    }
}
