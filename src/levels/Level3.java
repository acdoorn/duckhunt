package levels;

import controllers.BaseLevelState;
import factories.LevelFactory;

public class Level3  extends BaseLevelState {
    public Level3()
    {
        id = 3;
        velocity = 1.4F;
        levelFactory = LevelFactory.getInstance();
    }
}
