package levels;

import controllers.GameController;
import factories.LevelFactory;

public class GeneratedLevel extends BaseLevelState
{
//    public int Level; //{ get { return _level; } }



    public int getShotsLeft()
    {
        return _maxShots - _totalClicks;
    }

//    protected int _level;
//    protected String[] _allowedUnits;
//    protected int _maxLivingUnits;
//    protected int _maxSpawns;
    protected int _maxShots;
//    protected double _spawnDelay;

    public GeneratedLevel(int level, String[] allowedUnits, int maxLivingUnits, int maxSpawns, double spawnDelay, int maxShots)
    {
    	System.out.println("generating level: ");
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
//		System.out.println(game.getCurrentScore() + " " + MaxSpawns);
		if(Kills == MaxSpawns) {
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
         LevelFactory.getInstance().NextLevel(game, Level);
    }

}
