package models;
import java.awt.Color;

import containers.MoveContainer;
import factories.BehaviourFactory;

public class Bird extends Unit{
	
//	private int x;
//	private int y;
	private color c;
//	private BufferedImage image;
//	private int width = 100;
//	private int height = 70;
//	
	
	public enum color {red,green,blue};
	
	public Bird(MoveContainer mc, BehaviourFactory bf,double x, double y, double dx, double dy, color c) {
		super( mc,  bf, x,  y,  dx,  dy);
//		this.x = xpos;
//		this.y = ypos;
		this.c = c;
//		this.image = image;
	}
	
	public color getColor() {
		return c;
	}
	
	@Override
	public void die(){
		
	}
	
	public static void register(){
		// register bird at the unitfactory
	}

//	public void isClicked(){
//		
//	}

	@Override
	public Unit createInstance(MoveContainer mc, BehaviourFactory bf, double x, double y, double dx, double dy, color color) {
		Bird b = new Bird(mc,  bf,  x,  y,  dx,  dy, color);
		return b;
	}
	
	
	

}
