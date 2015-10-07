package models;

import java.awt.image.BufferedImage;

import behaviours.MoveBehaviour;

public class Unit {
	protected double x;
	protected double y;
	protected double deltax;
	

	protected double deltay;
	protected double width;
	protected double height;
	protected BufferedImage image;
	
	private MoveBehaviour moveBehaviour;
	
//	public abstract Unit CreateUnit(MoveContainer mv, BehaviourFactory bf);
	
	public Unit(double x, double y, double dx, double dy, BufferedImage im){
		this.x = x;
		this.y = y;
		this.deltax = dx;
		this.deltay = dy;
		this.image = im;
	}
	
	public void die(){
		
	}
	
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
	
	public BufferedImage getImage() {
		return image;
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
