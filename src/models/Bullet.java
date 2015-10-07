package models;

import containers.MoveContainer;
import factories.BehaviourFactory;
import factories.UnitFactory;
import models.Bird.color;

public class Bullet extends Unit{
	
	public Unit createInstance(MoveContainer mc, BehaviourFactory bf,double x, double y, double dx, double dy){
		Bullet b = new Bullet(mc, bf, x, y,  dx,  dy);
		return b;
	}

	public Bullet(MoveContainer mc, BehaviourFactory bf,double x, double y, double dx, double dy) {
		super( mc,  bf, x,  y,  dx,  dy);
		// TODO Auto-generated constructor stub
	}
	
	public Bullet() {
		// TODO Auto-generated constructor stub
	}

	public static void register(){
		UnitFactory.getInstance().RegisterUnit("bullet", new Bullet());
	}

	@Override
	public Unit createInstance(MoveContainer mc, BehaviourFactory bf, double x, double y, double dx, double dy,
			color color) {
		Bullet b = new Bullet(mc, bf, x, y,  dx,  dy);
		return b;
	}
	
}
