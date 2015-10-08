package models;

import java.awt.Point;

import factories.LevelFactory;

public class AliveUnitState extends BaseUnitState
{

    public AliveUnitState()
    {
    }

    public int onClick(Unit unit, Point point)
    {
    	System.out.println("HIT ALIVE STATE");
        if (unit.isHit(point))
        {
        	System.out.println("HIT UNIT");
            LevelFactory.getInstance().getCurrentLevel().Kills++;
            unit.setState(new DeadUnitState(unit));
            unit.die();
            return 1;
        }
        return 0;
    }


}
