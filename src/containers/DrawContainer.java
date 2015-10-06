package containers;

import java.awt.Container;
import java.util.List;

import behaviours.DrawBehaviour;

public class DrawContainer extends Container{

	public List<DrawBehaviour> behaviours;
	
    public void Add(DrawBehaviour _drawBehaviour)
    {
        behaviours.add(_drawBehaviour);
    }

    public void Remove(DrawBehaviour _drawBehaviour)
    {
        if (behaviours.contains(_drawBehaviour))
        {
            behaviours.remove(_drawBehaviour);
        }
    }

    public void DrawUnits(float deltaTime)
    {
        for(DrawBehaviour behaviour : behaviours)
        {
            behaviour.Behave(deltaTime);
        }
    }
}
