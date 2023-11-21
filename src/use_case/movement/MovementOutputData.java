package use_case.movement;

public class MovementOutputData {

    private final String directions;
    private String enemyName;
    private int enemyLevel;
    private String itemName;

    public MovementOutputData(String directions){
        this.directions = directions;
        enemyName = "";
        enemyLevel = -1;
        itemName = "";
    }

    public String getDirections() {
        return directions;
    }
    public String getEnemyName() {
        return enemyName;
    }
    public int getEnemyLevel() {
        return enemyLevel;
    }
    public String getItemName() {
        return itemName;
    }

    public void setEnemyName(String enemyName) {
        this.enemyName = enemyName;
    }
    public void setEnemyLevel(int enemyLevel) {
        this.enemyLevel = enemyLevel;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
