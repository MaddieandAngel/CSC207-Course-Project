package entity;

public interface Player {

    int getLevel();
    int getCurrentHealth();
    int getMaxHealth();
    void setHealth(int health);
    void levelUp();
    int getExperiencePoints();
    void setExperiencePoints(int exp);
    int getMaxCardHold();
    void setMaxCardHold(int cardHold);

}
