package levels;

import controllers.BaseLevelState;
import factories.LevelFactory;

public class Level1 extends BaseLevelState {
    public Level1()
    {
        id = 1;
        velocity = 1.0F;
        levelFactory = LevelFactory.getInstance();
    }
}
