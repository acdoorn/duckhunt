import javax.swing.JFrame;

import controllers.GameController;

public class Main {

	public static void main(String[] args) {
		Application ex = new Application();
		
		GameController gc = new GameController();
		gc.startGame();
		
        
        ex.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        ex.setVisible(true);
		
	    
	    
	}
}
