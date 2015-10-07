package controllers;
import java.awt.EventQueue;





public class GameController {
	private boolean gameRunning = true;
	private int lastFpsTime;

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
		   
	      
	   }
	   
	   private void render(){
		   // update all the things
	   }


	
}