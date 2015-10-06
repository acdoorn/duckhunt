package factories;

import levels.Level1;
import controllers.BaseLevelState;

public class LevelFactory {
	private static LevelFactory instance;

    private LevelFactory() { }

    public static LevelFactory getInstance()
    {
        {
            if (instance == null)
            {
                instance = new LevelFactory();
            }
            return instance;
        }
    }

    public BaseLevelState NextLevel(BaseLevelState currentLevel)
    {
        if (currentLevel == null) return null;

        switch (currentLevel.id)
        {
            case 0:
                return new Level1();
            case 1:
//                return new Level2();
            case 2:
//                return new Level3();
            case 3:
//                return new Level4();
            case 4:
//                return new Level5();
            default:
                //finished
                return null;
        }

    }
}
