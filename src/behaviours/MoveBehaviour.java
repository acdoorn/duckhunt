package behaviours;

import models.Unit;

public class MoveBehaviour implements Behaviour {

	private Unit unit;

    public MoveBehaviour(Unit unit)
    {
        this.unit = unit;
    }

    public void behave(double delta)
    {
    	unit.setX(unit.getX() + unit.getDeltax()*delta);
    	unit.setY(unit.getY() + unit.getDeltay()*delta);
    	// TODO fix these hardcoded numbers to dynamical numbers.
    	if(unit.getX() < -100 || unit.getX() > 1800 || unit.getY() < -100 || unit.getY() > 1300){
    		unit.die();
    	}
    	
        //unit.x++;
//        if (unit.gotShot)
//        {
//            GameController.score += 10;
//            unit.x = -unit.size;
//            unit.y = Unit.rnd.Next(26, 300);
//            if (unit.dispatcher.CheckAccess())
//            {
//                unit.rect.Margin = new Thickness(unit.x, unit.y, unit.size, unit.size);
//            }
//            else
//            {
//                unit.dispatcher.Invoke(() => unit.rect.Margin = new Thickness(unit.x, unit.y, unit.size, unit.size));
//            }
//            unit.gotShot = false;
//        }
//        unit.x += (0.20F * deltaTime) * unit.velocity;
//        if (unit.x > 750)
//        {
//            GameController.score -= 100;
//            unit.x = -unit.size;
//        }

    }

}
