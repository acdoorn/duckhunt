package factories;

import models.Unit;
import behaviours.MoveBehaviour;

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
}
