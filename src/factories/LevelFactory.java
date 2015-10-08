package factories;

import java.util.HashMap;

import levels.BaseLevelState;
import levels.GeneratedLevel;
import containers.UnitContainer;
import controllers.GameController;

public class LevelFactory {
	private static LevelFactory instance;
	private HashMap<Integer, BaseLevelState> levelMap = new HashMap<Integer, BaseLevelState>();
	public GeneratedLevel currentLevel;

    private LevelFactory() {}

    public static LevelFactory getInstance()
    {
    	if (instance == null)
    	{
         	instance = new LevelFactory();
    	}
    	return instance;
    }

    public void addLevelToMap(BaseLevelState level)
    {
    	levelMap.put(level.id, level);
    }
    
    public void NextLevel(GameController game, int currentLevel)
    {
    	game.setGameRunning(false);
    	
    	UnitContainer.getInstance().ClearAllUnits();
        this.currentLevel = CreateLevel(currentLevel + 1);

    	game.setGameRunning(true);
        

    }
    
    private GeneratedLevel CreateLevel(int level)
    {
        return new GeneratedLevel(level, 
            GetAllowedUnits(level), 
            GetMaxLivingUnits(level), 
            GetMaxSpawns(level),
            GetSpawnDelay(level), 
            GetMaxShots(level));
    }

	public void GameOver(GameController game) {
		// TODO Auto-generated method stub
		
	}
	
	private String[] GetAllowedUnits(int level)
    {
        if (level % 3 == 0) // Elk derde level, alleen bluebird units
            return new String[] { "bluebird" };
        if (level % 2 == 1) // Elk oneven level dat geen derde is, alle units
            return new String[] { "bluebird", "redbird", "greenbird" };
        
        // anders alleen redbird
        return new String[] { "redbird" };
    }
	
    private int GetMaxLivingUnits(int level)
    {
        if (level <= 1)
            return 5;
        if (level <= 3)
            return 4;
        if (level <= 6)
            return 3;
        if (level <= 10)
            return 2;
        return 1;
    }

    private int GetMaxSpawns(int level)
    {
        return (int)(Math.floor(Math.sqrt(level) *2)) + 1;
    }

    private double GetSpawnDelay(int level)
    {
        return 1.0/(double)GetMaxLivingUnits(level);
    }

    private int GetMaxShots(int level)
    {
        // We willen minimaal 1 schot per unit, met 3 bonus schoten voor ieder level
        int result = GetMaxSpawns(level) + 3;

        // In eerdere levels krijg je extra schoten
        if (level < 15)
        {
            result += ((15 - level) /2);
        }

        return result;
    }

	public GeneratedLevel getCurrentLevel() {
		return currentLevel;
	}

	public void NewGame(GameController game) {
        NextLevel(game, 0);
		
	}

}
