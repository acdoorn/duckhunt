package factories;

import behaviours.MoveBehaviour;
import models.Unit;

public class BehaviourFactory {
	private static BehaviourFactory instance;
	
	private BehaviourFactory() {}
	
	public static BehaviourFactory getInstance() {
		if(instance == null) {
			instance = new BehaviourFactory();
		}
		return instance;
	}
	
	 public MoveBehaviour createMoveBehaviour(Unit unit)
     {
         return new MoveBehaviour(unit);
     }
//     public DrawBehaviour createDrawBehaviour(Unit unit)
//     {
//         return new DrawBehaviour(unit, 0.07, 0, true);
//     }
}
