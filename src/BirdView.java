import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class BirdView extends JPanel{
	
	private Bird b;
	private ImageIcon birdImage;
	
	
	public BirdView(Bird bird){
		this.b = bird;
		switch(b.getColor()){
		case green: birdImage
			break;
		case blue: break;
		case red: break;
		default: break;//green
			
		}
	}
	

}
