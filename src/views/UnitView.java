package views;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import models.Bird;
import models.Unit;

public class UnitView extends JPanel{
	
	
	private Unit unit;
	private BufferedImage image;
	
	public UnitView(Unit unit){
		this.unit = unit;
		if(unit.isBird()){
			createBirdView();
		} else {
			createBulletView();
		}

		
		
	}
	
	public Unit getUnit(){
		return unit;
	}
	
	private void createBirdView(){
		Bird b = (Bird) unit;
		switch(b.getColor()){
		case green: loadImage("./src/images/greenbird.png");
			break;
		case blue: loadImage("./src/images/bluebird.png");
			break;
		case red: loadImage("./src/images/redbird.png");
			break;
		default: loadImage("./src/images/greenbird.png");
		break;
			
		}
	}
	
	private void createBulletView(){
		// TODO createBulletView
	}

	public void draw(Graphics g){
		if(image != null){
			g.drawImage(image,(int)unit.getX(), (int)unit.getY(), (int)unit.getWidth() , (int)unit.getHeight() , this);
		}
	}
	
	private void loadImage(String location){
		if(image == null){
			try {
				 image = ImageIO.read(new File(location));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				image = null;
			}

		}
	}

}

	

