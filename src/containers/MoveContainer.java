package containers;

import java.util.List;

import behaviours.MoveBehaviour;

public class MoveContainer {
	

	public List<MoveBehaviour> behaviours;
	
	public void Add(MoveBehaviour _moveBehaviour)
    {
        behaviours.add(_moveBehaviour);
    }

    public void Remove(MoveBehaviour _moveBehaviour)
    {
        if (behaviours.contains(_moveBehaviour))
        {
            behaviours.remove(_moveBehaviour);
        }
    }

    public void MoveUnits(float deltaTime)
    {
        for (MoveBehaviour behavior : behaviours)
        {
            behavior.Behave(deltaTime);
        }
    }
}
