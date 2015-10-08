package levels;

import java.util.Random;

import controllers.GameController;
import factories.UnitFactory;
import models.Unit;

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
        if (/*!_hasStarted ||*/ _totalSpawns >= MaxSpawns)
            return null;

        // Geen units op het veld, negeer delay
        if (game.getUnitContainer().getNumUnits() == 0)
            _lastSpawn = 0;

        // Als er units bijmogen en de spawnDelay voorbij is, spawn een nieuwe unit
        if ((game.getUnitContainer().getNumUnits() < MaxUnits) )//&&(game.getTime() - _lastSpawn > SpawnDelay)
        {
//            _lastSpawn = game.getTime();
            _totalSpawns++;
            return UnitFactory.getInstance().createUnit(AllowedUnits[rnd.nextInt(AllowedUnits.length)], rnd.nextInt(1600), rnd.nextInt(900), 1, 0);
//            return UnitFactory<Unit>.Create(AllowedUnits[rnd.nextInt(AllowedUnits.length)]);
            //return UnitFactory.createRandomUnit(game, AllowedUnits);
        }

        return null;
    }


    protected abstract void StartNextLevel(GameController game);

}
