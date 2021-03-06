package containers;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import controllers.GameController;

public class InputContainer
{
	private static InputContainer instance;
    private List<Point> _clickedPoints;
    
    private int _numClicks;
    private int _numHits;
    
    private int earnedScore;
    
    public int getEarnedScore() {
    	return earnedScore;
    }
    
    public static InputContainer getInstance(){
    	if(instance == null){
    		instance = new InputContainer();
    	}
    	return instance;
    }

    private InputContainer()
    {
        _clickedPoints = new ArrayList<Point>();
    }

    public void HandleInputs(GameController game)
    {
        	_numClicks = _clickedPoints.size();
        	earnedScore = 0;

            for (Point point : _clickedPoints)
            {
                int score = game.getUnitContainer().HandleClick(point);
                earnedScore += score;
            }
            _clickedPoints.clear();
    }

    public void AddClick(Point point)
    {
            _clickedPoints.add(point);
    }
}
