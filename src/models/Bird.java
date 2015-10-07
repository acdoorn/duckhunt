package models;
import java.awt.image.BufferedImage;

public class Bird {
	
	private int x;
	private int y;
	private color c;
	private BufferedImage image;
	private int width = 100;
	private int height = 70;
	
	
	public enum color {red,green,blue};
	
	public Bird(int xpos, int ypos, color c, BufferedImage image){
		this.x = xpos;
		this.y = ypos;
		this.c = c;
		this.image = image;
	}
	
	public color getColor() {
		return c;
	}

	public void isClicked(){
		
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public BufferedImage getImage() {
		return image;
	}
	
	public void setX(int newX) {
		this.x = newX;
	}

	public void setY(int newY) {
		this.y = newY;
	}
	

}
