package levels;

import controllers.BaseLevelState;
import factories.LevelFactory;

public class Level5  extends BaseLevelState {
    public Level5()
    {
        id = 5;
        velocity = 2F;
        levelFactory = LevelFactory.getInstance();
    }
}
