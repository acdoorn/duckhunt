package models;


import java.awt.Point;

import behaviours.MoveBehaviour;
import containers.MoveContainer;
import factories.BehaviourFactory;

public abstract class Unit
{
	
	protected double x;
	protected double y;
	protected double deltax;
	protected double deltay;
	protected double width;
	protected double height;
	protected BaseUnitState state;
	protected boolean dead;
	
	
	public int score;

//    public static Random rnd = new Random();
    private MoveContainer moveContainer;
    private BehaviourFactory behaviourFactory;

    private MoveBehaviour moveBehaviour;

	
//	public abstract Unit CreateUnit(MoveContainer mv, BehaviourFactory bf);
	
	public Unit(){
		
	}
	
	
	
	
    

    public Unit(MoveContainer mc, BehaviourFactory bf,double x, double y, double dx, double dy)
    {
        moveContainer = mc;
        behaviourFactory = bf;
        this.x = x;
		this.y = y;
		this.deltax = dx;
		this.deltay = dy;
		this.state = new AliveUnitState();
       
        moveBehaviour = bf.createMoveBehaviour(this);

        moveContainer.add(moveBehaviour);
        this.dead = false;
    }
    

    public void die(){
    	this.dead = true;
		MoveContainer.getInstance().remove(moveBehaviour);
		//UnitContainer.getInstance().removeUnit(this);
		
		
	}

    private BaseUnitState _state;
    
    public int onClick(Point point)
    {
        return _state.onClick(this, point);
    }
    
    public boolean isDead(){
    	return dead;
    }
    
    public boolean isHit(Point point)
    {
        return (point.x > x &&
            point.x < x+100 &&
            point.y > y &&
            point.y < y+70);
    }

    
    public void setState(BaseUnitState state) {
    	this.state = state;
    }
    
    public BaseUnitState getState() {
    	return state;
    }
    
    public boolean isBird(){
    	return false;
    }

    public abstract Unit createInstance(MoveContainer mc, BehaviourFactory bf,double x, double y, double dx, double dy);

    public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public double getWidth() {
		return width;
	}
	
	public double getHeight() {
		return height;
	}

	
	public void setX(double newX) {
		this.x = newX;
	}

	public void setY(double newY) {
		this.y = newY;
	}
	
	public void setWidth(double newWidth) {
		this.width = newWidth;
	}

	public void setHeight(double newHeight) {
		this.height = newHeight;
	}
	
	public double getDeltax() {
		return deltax;
	}

	public void setDeltax(double deltax) {
		this.deltax = deltax;
	}

	public double getDeltay() {
		return deltay;
	}

	public void setDeltay(double deltay) {
		this.deltay = deltay;
	}

}
