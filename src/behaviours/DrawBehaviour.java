package behaviours;

import models.Unit;

public class DrawBehaviour implements Behaviour {
	private Unit unit;

    public DrawBehaviour(Unit unit)
    {
        this.unit = unit;
    }

    public void Behave(double deltaTime)
    {
//        if (unit.dispatcher.CheckAccess())
//        {
//            unit.rect.Margin = new Thickness(unit.x, unit.y, unit.size, unit.size);
//        }
//        else
//        {
//            unit.dispatcher.Invoke(() => unit.rect.Margin = new Thickness(unit.x, unit.y, unit.size, unit.size));
//        }

    }
}
