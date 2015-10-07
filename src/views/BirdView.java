package views;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import models.Bird;

public class BirdView extends JPanel{
	
	private Bird b;
	private ImageIcon birdImage;
	
	
	public BirdView(Bird bird){
		this.b = bird;
		switch(b.getColor()){
		case green: // 
			break;
		case blue: break;
		case red: break;
		default: break;//green
			
		}
	}
	

}
