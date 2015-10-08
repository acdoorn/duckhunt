package controllers;
import javax.swing.JFrame;
import javax.swing.JPanel;

import models.Bird;
import models.Bullet;
import models.Unit;
import views.MainFrame;
import views.MainPanel;
import containers.InputContainer;
import containers.MoveContainer;
import containers.UnitContainer;
import factories.LevelFactory;

public class GameController extends JFrame {
	private boolean gameRunning = true;
	private int lastFpsTime;
	private MainPanel mainPanel;
	private MainFrame mainFrame;
	private UnitContainer unitContainer;
	private InputContainer inputContainer;
	private double delta;
    private int fps;
    
    public static int score = 0;

	public GameController() {
		initUI();
		this.unitContainer = UnitContainer.getInstance();
		this.inputContainer = InputContainer.getInstance();
		Bird.register();
		Bullet.register();
		LevelFactory.getInstance().NewGame(this);
		 
	}
	
	private void initUI() {
		mainPanel = new MainPanel();
		mainFrame = new MainFrame(mainPanel);
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
	
	   private void gameLoop()
	   {
	      long lastLoopTime = System.nanoTime();
	      final int TARGET_FPS = 60;
	      final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;  
          

	      while (gameRunning)
	      {

	         long now = System.nanoTime();
	         long updateLength = now - lastLoopTime;
	         lastLoopTime = now;
	         delta = updateLength / ((double)OPTIMAL_TIME);

	         // update the frame counter
	         lastFpsTime += updateLength;
	         fps++;
	         
	         // update our FPS counter if a second has passed since
	         // we last recorded
	         if (lastFpsTime >= 1000000000)
	         {
	            System.out.println("(FPS: "+fps+")");
	            lastFpsTime = 0;
	            fps = 0;
	         }
	         

			   mainPanel.UpdateUnitViews(unitContainer.getUnits());
	         // update the game logic
	         doGameUpdates(delta);
	         
	         // draw everyting
	         render();
	         
	         try{
	        	 if((lastLoopTime-System.nanoTime() + OPTIMAL_TIME) > 0)
	        		 Thread.sleep( (lastLoopTime-System.nanoTime() + OPTIMAL_TIME)/1000000 );
	        	 }
	         catch(Exception e){
	        	 e.printStackTrace();
	         }
	      }
	      
	   }
	   
	   public void setGameRunning(boolean b) {
		   gameRunning = b;
	   }
	   
	   private void doGameUpdates(double delta)
	   {
		   // updates times delta, so we have no problems with fps/gameupdates
		   if(unitContainer.getNumUnits() != 0){
		   MoveContainer.getInstance().moveUnits(delta);
		   }
//		   unitContainer.ClearDestroyedUnits();


           LevelFactory.getInstance().getCurrentLevel().Update(this);

           unitContainer.UpdateAllUnits(this);

           Unit newUnit = LevelFactory.getInstance().getCurrentLevel().TryCreateUnit(this);
           if (newUnit != null)
           {
               unitContainer.AddUnit(newUnit);
           }
           inputContainer.HandleInputs(this);

	      
	   }
	   
	   public double getDelta() {
		   return delta;
	   }
	   
	   public JPanel getMainPanel() {
		   return mainPanel;
	   }
	   public JFrame getMainFrame() {
		   return mainFrame;
	   }
	   
	   private void render(){
		   mainPanel.repaint();
	   }


	
}