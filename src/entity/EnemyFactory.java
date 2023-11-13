package entity;

import java.util.Random;

public class EnemyFactory implements CharacterFactory {

    @Override
    public Character create(int level) {
        Random random_id = new Random();
        return new Enemy(random_id.nextInt(0,6), level);
    }
}
