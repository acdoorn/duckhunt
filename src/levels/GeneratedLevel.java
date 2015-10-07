package levels;

import controllers.GameController;
import factories.LevelFactory;

public class GeneratedLevel extends BaseLevelState
{
//    public int Level; //{ get { return _level; } }

//    protected String[] AllowedUnits;// { get { return _allowedUnits; } }
//    protected int MaxUnits; //{ get { return _maxLivingUnits; } }
//    protected int MaxSpawns; //{ get { return _maxSpawns; } }
//    protected double SpawnDelay; //{ get { return _spawnDelay; } }
//    protected double TimeBeforeStart;// { get { return 2.5; } }

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
    	System.out.println("generating level: " + level);
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

        if (_totalClicks >= _maxShots)
        {
//            EndLevel(game);
        }
    }

	@Override
    protected void StartNextLevel(GameController game)
    {
        // Perfecte game, bonus level
        if (IsPerfect()){
//            LevelFactory.getInstance().BonusLevel(game, _level);
        }
        // Minimaal 75% van de Units dood, level gehaald
        else if (GotMinKills())
            LevelFactory.getInstance().NextLevel(game, Level);
        else
            LevelFactory.getInstance().GameOver(game);
    }

    /// <summary>
    /// Controleert of het minimale aantal Units is geraakt dit level. 
    /// Regels: 1 unit weg laten komen mag altijd. Bij meer mag dit maximaal 25% van de units in het level zijn. 
    /// </summary>
    /// <returns>true als het level gehaald is</returns>
    protected boolean GotMinKills()
    {
        int misses = MaxSpawns - Kills;

        return (misses <= 1) || 
            (misses <= MaxSpawns * 0.25);
    }
}
