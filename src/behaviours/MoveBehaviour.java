package behaviours;

import models.Unit;

public class MoveBehaviour implements Behaviour {

	private Unit unit;

    public MoveBehaviour(Unit unit)
    {
        this.unit = unit;
    }

    public void behave(double delta)
    {
    	unit.setX(unit.getX() + unit.getDeltax()*delta);
    	unit.setY(unit.getY() + unit.getDeltay()*delta);
    	if(unit.getX() < -100 || unit.getX() > 1800 || unit.getY() < -100 || unit.getY() > 1300){
    		System.exit(1);
    	}
    	

    }

}
