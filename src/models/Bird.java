package models;
import java.awt.image.BufferedImage;

public class Bird extends Unit{
	
//	private int x;
//	private int y;
	private color c;
//	private BufferedImage image;
//	private int width = 100;
//	private int height = 70;
//	
	
	public enum color {red,green,blue};
	
	public Bird(double xpos, double ypos, double dx, double dy, color c, BufferedImage image){
		super(xpos, ypos, dx, dy, image);
//		this.x = xpos;
//		this.y = ypos;
		this.c = c;
//		this.image = image;
	}
	
	public color getColor() {
		return c;
	}

	public void isClicked(){
		
	}
	
	
	

}
