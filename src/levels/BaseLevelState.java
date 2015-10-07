package levels;

import java.util.Random;

import models.Bird;
import models.Unit;
import controllers.GameController;
import factories.UnitFactory;

public abstract class BaseLevelState implements ILevel {
	private GameController gameController;
    public String Name;
    public int Level;
    public int Kills;
    
    protected String[] AllowedUnits;
    protected int MaxUnits;
    protected int MaxSpawns; 
    protected double SpawnDelay;
    protected double TimeBeforeStart; 

    protected double _lastSpawn;
    protected int _totalSpawns;
    protected int _totalClicks;
    protected int _totalHits;
    protected int _totalMisses;
    
    private Random rnd = new Random();

    protected boolean _hasEnded;
    protected boolean _hasStarted;
	public Integer id;

    protected  boolean IsPerfect()
    {
       return (_totalMisses == 0 && Kills == _totalSpawns);
    }

    public BaseLevelState()
    {
        Kills = 0;

        _lastSpawn = 0;
        _totalSpawns = 0;
        _totalClicks = 0;
        _totalHits = 0;
        _totalMisses = 0;

        _hasStarted = false;
        _hasEnded = false;
    }


    public Unit TryCreateUnit(GameController game)
    {
        // Spawn niks als het level nog niet begonnen is of als het maximale aantal units gespawned is. 
        if (!_hasStarted || _totalSpawns >= MaxSpawns)
            return null;

        // Geen units op het veld, negeer delay
        if (game.getUnitContainer().getNumUnits() == 0)
            _lastSpawn = 0;

        // Als er units bijmogen en de spawnDelay voorbij is, spawn een nieuwe unit
        if ((game.getUnitContainer().getNumUnits() < MaxUnits) )//&&(game.getTime() - _lastSpawn > SpawnDelay)
        {
//            _lastSpawn = game.getTime();
            _totalSpawns++;
            return UnitFactory.getInstance().createUnit(AllowedUnits[rnd.nextInt(AllowedUnits.length)], 20, 20, 5, 5, Bird.color.blue);
//            return UnitFactory<Unit>.Create(AllowedUnits[rnd.nextInt(AllowedUnits.length)]);
            //return UnitFactory.createRandomUnit(game, AllowedUnits);
        }

        return null;
    }

    public void Update(GameController game)
    {
//        if (!_hasStarted)
//        {
//        	if(_startTime)
//            if (Double.IsNaN(_startTime))
//                _startTime = game.Time;
//
//            if (game.Time - _startTime > TimeBeforeStart)
//                _hasStarted = true;
//        }
//
//        if (LevelIsOngoing())
//        {
//            _totalClicks += game.InputContainer.NumClicks;
//            _totalHits += game.InputContainer.EarnedScore;
//            _totalMisses += game.InputContainer.NumMisses;
//        }
//
//        if (LevelIsDone(game))
//        {
//            StartNextLevel(game);
//        }
    }

    protected abstract void StartNextLevel(GameController game);

    /// <summary>
    /// Controleert of het level helemaal is afgelopen (klaar om een nieuw level te starten).
    /// </summary>
    /// <param name="game">Instantie van de game controller</param>
    /// <returns>true als het level is afgelopen</returns>
//    protected virtual boolean LevelIsDone(GameController game)
//    {
//        // After spawning all units, go to the next level
//        return (_totalSpawns >= MaxSpawns &&
//            game.UnitContainer.NumUnits == 0);
//    }
//
//    /// <summary>
//    /// Controleert of het level nog bezig is. Dit kan false zijn voor alle units weg zijn. 
//    /// </summary>
//    /// <returns>true als het level nog bezig is.</returns>
//    protected virtual bool LevelIsOngoing()
//    {
//        return _hasStarted && !_hasEnded;
//    }
//
//    protected virtual void EndLevel(IGame game)
//    {
//        _hasEnded = true;
//        _totalSpawns = MaxSpawns;
//        LevelFactory.Instance.EndLevel(game);
//    };
}
