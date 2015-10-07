package models;

import java.awt.image.BufferedImage;

import containers.DrawContainer;
import containers.MoveContainer;
import factories.BehaviourFactory;

public class Bullet extends Unit{
	
	public Unit CreateInstance(MoveContainer mc, BehaviourFactory bf,double x, double y, double dx, double dy, BufferedImage im){
		Bullet b = new Bullet(mc, bf, x, y,  dx,  dy,  im);
		return b;
	}

	public Bullet(MoveContainer mc, BehaviourFactory bf,double x, double y, double dx, double dy, BufferedImage im) {
		super( mc,  bf, x,  y,  dx,  dy,  im);
		// TODO Auto-generated constructor stub
	}
	
	public static void Register(){
		// register bullet at the unitfactory
	}
	
}
