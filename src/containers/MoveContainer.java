package containers;

import java.util.ArrayList;
import java.util.List;

import behaviours.MoveBehaviour;

public class MoveContainer {
	private static MoveContainer mv;
	public static MoveContainer getInstance(){
		if(mv == null){
			mv = new MoveContainer();
		}
		return mv;
	}

	private MoveContainer(){
		behaviours = new ArrayList<MoveBehaviour>();
	}
	public List<MoveBehaviour> behaviours;
	
	public void add(MoveBehaviour _moveBehaviour)
    {
        behaviours.add(_moveBehaviour);
    }

    public void remove(MoveBehaviour _moveBehaviour)
    {
        if (behaviours.contains(_moveBehaviour))
        {
            behaviours.remove(_moveBehaviour);
        }
    }

    public void moveUnits(double delta)
    {
    	if(behaviours.size() != 0){
	        for (MoveBehaviour behavior : behaviours)
	        {
	            behavior.behave(delta);
	        }
    	}
    }
}
