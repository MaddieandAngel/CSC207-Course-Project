package use_case.AttackButton.CardButton;

import entity.Enemy;
import entity.Player;

public class CardButtonInputData {

    private Player player;

    private Enemy enemy;

    private int cardValue;

    public CardButtonInputData(Player player, Enemy enemy, int cardValue) {
        this.player = player;
        this.enemy = enemy;
        this.cardValue = cardValue;
    }

    public int getPlayerCurrentHealth() { return this.player.getCurrentHealth();}

    public int getPlayerMaxHealth() { return this.player.getMaxHealth();}

    public int getPlayerLevel() { return this.player.getLevel();}

    public boolean hasRevivePotion() { return this.player.getInventory().numOfRevive() > 0;}

    public void useRevivePotion() { this.player.getInventory().useItem(0, this.player);}

    public int getEnemyHealth() { return this.enemy.getCurrentHealth();}

    public int getEnemyLevel() { return this.enemy.getLevel();}

    public int getCardValue() { return this.cardValue;}
}
