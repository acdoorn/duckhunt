package containers;


import java.util.ArrayList;
import java.util.List;

import models.Unit;
import controllers.GameController;

public class UnitContainer
{

    private List<Unit> _units;
    private List<Unit> getUnits()
        {
            if (_units == null)
            {
                _units = new ArrayList<Unit>();
            }
            return _units;
        }

    public int getNumUnits(){ return getUnits().size(); }

    public void AddUnit(Unit unit)
    {
    	_units.add(unit);
    }

    public void ClearDestroyedUnits()
    {
    	//TODO clear all units that are dead
    }

    public void ClearAllUnits()
    {
        for (Unit unit: getUnits())
        {
        	//TODO die
        }
        ClearDestroyedUnits();
    }

    public void CleanupUnits()
    {
        for (Unit unit : getUnits())
        {
            //TODO cleanup
        }
    }

    public void UpdateAllUnits(GameController game)
    {
        for (Unit unit : getUnits())
        {
            //TODO Update
        }
    }

    public void DrawAllUnits(GameController game)
    {
        for (Unit unit : getUnits())
        {
        	//TODO draw
        }
    }

    public void FixedTimePassed(GameController game)
    {
        for (Unit unit : getUnits())
        {
            //TODO
        }
    }
}