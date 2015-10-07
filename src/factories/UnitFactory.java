package factories;

import java.util.HashMap;

import containers.MoveContainer;
import models.Unit;

public class UnitFactory {
	private static UnitFactory instance;
	private HashMap<String, Unit> unitHash;

    private UnitFactory() { 
    	unitHash = new HashMap<String, Unit>();
    }

    public static UnitFactory getInstance() {

        if (instance == null)
        {
            instance = new UnitFactory();
        }
        return instance;
    }
    
    
    public void RegisterUnit(String name, Unit unit){
    	unitHash.put(name, unit);
    }
    
    public Unit createUnit(String name, double x, double y, double dx, double dy){
    	Unit unit;
    	if(unitHash.containsKey(name)){
    		unit = unitHash.get(name).createInstance(MoveContainer.getInstance(), BehaviourFactory.getInstance(), x, y, dx, dy);
    		return unit;
    	} else {
    		return null;
    	}
    	
    }
    


}

