package entity;

public class CurrentEnemyFactory implements EnemyFactory{
    @Override
    public Enemy create(int id, int level) {
        return new CurrentEnemy(id, level);
    }
}
