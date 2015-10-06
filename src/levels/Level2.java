package levels;

import controllers.BaseLevelState;
import factories.LevelFactory;

public class Level2 extends BaseLevelState {
    public Level2()
    {
        id = 2;
        velocity = 1.2F;
        levelFactory = LevelFactory.getInstance();
    }
}
