package models;

import java.awt.Point;

import controllers.GameController;
import factories.LevelFactory;

public class AliveUnitState extends BaseUnitState
{

    public AliveUnitState()
    {
    }

    public int onClick(Unit unit, Point point)
    {
        if (unit.isHit(point))
        {
            LevelFactory.getInstance().getCurrentLevel().Kills++;
            GameController.score++;
            unit.setState(new DeadUnitState(unit));
            unit.die();
            return 1;
        }
        return 0;
    }


}
