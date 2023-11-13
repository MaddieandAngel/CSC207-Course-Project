package entity;

public interface Enemy {
    int getLevel();
    int getCurrentHealth();
    void setHealth(int health);
    String getName();
    char getPreferredSuit();
    int getMinimumPreferredValue();
    int getMaximumPreferredValue();
}
