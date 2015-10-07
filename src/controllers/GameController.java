package controllers;
import javax.swing.JFrame;
import javax.swing.JPanel;

import containers.MoveContainer;
import views.MainFrame;
import views.MainPanel;
import containers.UnitContainer;

public class GameController extends JFrame {
	private boolean gameRunning = true;
	private int lastFpsTime;
	private JPanel mainPanel;
	private UnitContainer unitContainer;

	public GameController() {
		initUI();
		this.unitContainer = new UnitContainer();
	}
	
	private void initUI() {
		mainPanel = new MainPanel();
		new MainFrame(mainPanel);
	}
	
	public UnitContainer getUnitContainer() {
		return unitContainer;
	}
	
	public void startGame(){
	   
	      Thread loop = new Thread()
	      {
	         public void run()
	         {
	            gameLoop();
	         }
	      };
	      loop.start();
	   
	}
	
	   public void gameLoop()
	   {
	      long lastLoopTime = System.nanoTime();
	      final int TARGET_FPS = 60;
	      final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;   


	      while (gameRunning)
	      {

	         long now = System.nanoTime();
	         long updateLength = now - lastLoopTime;
	         lastLoopTime = now;
	         double delta = updateLength / ((double)OPTIMAL_TIME);

	         // update the frame counter
	         lastFpsTime += updateLength;
	         
	         
	         // update the game logic
	         doGameUpdates(delta);
	         
	         // draw everyting
	         render();
	         
	         try{
	        	 Thread.sleep( (lastLoopTime-System.nanoTime() + OPTIMAL_TIME)/1000000 );
	        	 }
	         catch(Exception e){
	        	 e.printStackTrace();
	         }
	      }
	      
	   }
	   
	   private void doGameUpdates(double delta)
	   {
		   // updates times delta, so we have no problems with fps/gameupdates
		   MoveContainer.getInstance().moveUnits(delta);
	      
	   }
	   
	   private void render(){
		   
		   mainPanel.repaint();
	   }


	
}