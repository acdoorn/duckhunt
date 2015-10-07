package containers;


import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import controllers.GameController;
import models.Unit;

public class UnitContainer
{
	private static UnitContainer instance;
	public static UnitContainer getInstance(){
		if(instance == null){
			instance = new UnitContainer();
		}
		return instance;
	}
	private UnitContainer(){
		
	}
    private List<Unit> _units;
    public List<Unit> getUnits()
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
    	getUnits().add(unit);
    }
    
    public void removeUnit(Unit unit){
    	getUnits().remove(unit);
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
        // not needed i believe.
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

	public int HandleClick(Point point) {
		int value = 0;
        for (Unit unit : getUnits())
        {
    		System.out.println(unit.getState().toString()+ ", " +point.toString());
            value = unit.getState().onClick(unit, point);
        }
        return value;
        
	}
}