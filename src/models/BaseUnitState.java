package models;

import java.awt.Point;

import behaviours.MoveBehaviour;
import containers.MoveContainer;

public abstract class BaseUnitState
{
    private String _name;

    private Unit _parent;

    private MoveBehaviour _moveBehaviour;
    
    public BaseUnitState()
    {
    }
    
    public abstract int onClick(Unit unit, Point point);


    
    protected void die(){
		MoveContainer.getInstance().remove(_moveBehaviour);
	}
}