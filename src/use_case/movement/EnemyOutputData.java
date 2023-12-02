package use_case.movement;

public class EnemyOutputData {

    private String enemyName;
    private int enemyLevel;

    public EnemyOutputData(String enemyName, int enemyLevel){
        this.enemyName = enemyName;
        this.enemyLevel = enemyLevel;
    }

    public String getEnemyName() {
        return enemyName;
    }
    public int getEnemyLevel() {
        return enemyLevel;
    }

    public void setEnemyName(String enemyName) {
        this.enemyName = enemyName;
    }
    public void setEnemyLevel(int enemyLevel) {
        this.enemyLevel = enemyLevel;
    }

}
