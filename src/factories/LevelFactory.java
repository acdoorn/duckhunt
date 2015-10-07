package factories;

import java.util.HashMap;

import levels.BaseLevelState;
import levels.GeneratedLevel;
import levels.ILevel;
import controllers.GameController;

public class LevelFactory {
	private static LevelFactory instance;
	private HashMap<Integer, BaseLevelState> levelMap = new HashMap<Integer, BaseLevelState>();
	public ILevel currentLevel;

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
        game.getUnitContainer().ClearAllUnits();
        this.currentLevel = CreateLevel(currentLevel + 1);
    }
    
    private ILevel CreateLevel(int level)
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
        if (level % 3 == 0) // Elk derde level, beide units
            return new String[] { "chicken", "bunny" };
        if (level % 2 == 1) // Elk oneven level dat geen derde is, alleen chickens
            return new String[] { "chicken" };
        
        // anders alleen bunnys
        return new String[] { "bunny" };
    }

    /// <summary>
    /// Functie om het maximale aantal units van het huidige level te bepalen.
    /// </summary>
    /// <param name="level">het huidige level</param>
    /// <returns>het aantal units.</returns>
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

    /// <summary>
    /// Functie om het totaal aantal enemies per level te bepalen.
    /// </summary>
    /// <param name="level">Het huidige level</param>
    /// <returns>Het aantal units om te spawnen</returns>
    private int GetMaxSpawns(int level)
    {
        return (int)(Math.floor(Math.sqrt(level) *2)) + 1;
    }

    /// <summary>
    /// Functie om de delay tussen spawns per level te bepalen.
    /// </summary>
    /// <param name="level">het huidige level</param>
    /// <returns>de delay voor spawnen</returns>
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

}