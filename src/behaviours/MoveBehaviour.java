package behaviours;

import models.Unit;

public class MoveBehaviour implements Behaviour {

	private Unit unit;

    public MoveBehaviour(Unit unit)
    {
        this.unit = unit;
    }

    public void Behave(float deltaTime)
    {
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
