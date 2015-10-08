package levels;

import controllers.GameController;
import factories.LevelFactory;

public class GeneratedLevel extends BaseLevelState
{
    public int getShotsLeft()
    {
        return _maxShots - _totalClicks;
    }
    protected int _maxShots;

    public GeneratedLevel(int level, String[] allowedUnits, int maxLivingUnits, int maxSpawns, double spawnDelay, int maxShots)
    {
    	System.out.println("generating level: " + level + " maxSpawns: " + maxSpawns);
        Level = level;
        AllowedUnits = allowedUnits;
        MaxUnits = maxLivingUnits;
        MaxSpawns = maxSpawns;
        _maxShots = maxShots;
        SpawnDelay = spawnDelay;
    }

	@Override
    public void Update(GameController game)
    {
//		System.out.println(Kills + " " + MaxSpawns + " " + MaxUnits);
		if(Kills == MaxSpawns) {
			Kills = 0;
			this.StartNextLevel(game);
		}
        if (_totalClicks >= _maxShots)
        {
//            EndLevel(game);
        }
    }

	@Override
	public void StartNextLevel(GameController game)
    {
		LevelFactory.getInstance().currentLevel = null;
         LevelFactory.getInstance().NextLevel(game, Level);
    }

}
