package use_case.EnemyBehaviour;

import java.io.IOException;

public interface EnemyBehaviourInterface {

    EnemyBehaviourOutputData performRandomAction() throws IOException;

    void enemyDrawInitialHand() throws IOException;
}
