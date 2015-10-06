package levels;

import controllers.BaseLevelState;
import factories.LevelFactory;

public class Level4  extends BaseLevelState {
    public Level4()
    {
        id = 4;
        velocity = 1.6F;
        levelFactory = LevelFactory.getInstance();
    }
}
