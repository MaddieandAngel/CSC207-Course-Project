package entity;

public class EnemyFactory implements CharacterFactory {

    //TODO: Unfinished
    @Override
    public Character create(int level) {
        return new Enemy(0, level);
    }
}
