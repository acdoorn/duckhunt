package models;
import containers.MoveContainer;
import factories.BehaviourFactory;
import factories.UnitFactory;

public class Bird extends Unit{
	
//	private int x;
//	private int y;
	private color c;
//	private BufferedImage image;
	private int width = 100;
	private int height = 70;
//	
	
	public enum color {red,green,blue};
	
	public Bird(MoveContainer mc, BehaviourFactory bf,double x, double y, double dx, double dy, color c) {
		super( mc,  bf, x,  y,  dx,  dy);
//		this.x = xpos;
//		this.y = ypos;
		this.c = c;
//		this.image = image;
	}
	
	public Bird() {
		// TODO Auto-generated constructor stub
	}

	public color getColor() {
		return c;
	}
	
	@Override
	public void die(){
		
	}
	
	@Override
	public boolean isBird(){
		return true;
	}
	
	public static void register(){
		Bird greenbird = new Bird();
		greenbird.c = color.green;
		UnitFactory.getInstance().RegisterUnit("greenbird", greenbird);
		Bird redbird = new Bird();
		redbird.c = color.red;
		UnitFactory.getInstance().RegisterUnit("redbird", redbird);
		Bird bluebird = new Bird();
		bluebird.c = color.green;
		UnitFactory.getInstance().RegisterUnit("bluebird", bluebird);
	}

//	public void isClicked(){
//		
//	}

	@Override
	public Unit createInstance(MoveContainer mc, BehaviourFactory bf, double x, double y, double dx, double dy) {
		Bird b = new Bird(mc,  bf,  x,  y,  dx,  dy, this.c);
		return b;
	}
	
	
	

}
