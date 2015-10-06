package controllers;

import factories.LevelFactory;

public class BaseLevelState {
	private GameController gameController;
    protected LevelFactory levelFactory;
    public int id;
    public float velocity;
    
    //constructor for gameController
    public BaseLevelState(GameController gc)
    {
        id = 0;
        gameController = gc;
        levelFactory = LevelFactory.getInstance();
    }

    //constructor for levels
    public BaseLevelState() { }

    public void setGame(GameController gc)
    {
        gameController = gc;
    }

    public void Update() { }

    public void Draw()
    {
//        if (gameController.dispatcher.CheckAccess())
//        {
////            gameController.window.Background = color;
//        }
//        else
//        {
////            gameController.dispatcher.Invoke(() => gameController.window.Background = color);
//        }
    }

    public void NextLevel()
    {
        BaseLevelState nextLevel = levelFactory.NextLevel(this);

        if(nextLevel == null)
        {
            //finished
//            gameController.Finish();
        }

//        gameController.SetLevel(nextLevel);
    }
}
