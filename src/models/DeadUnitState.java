package models;

import java.awt.Point;

import controllers.GameController;

public class DeadUnitState extends BaseUnitState
{
    private double Timer;
    private double DespawnTime;
    private double FadeTime;

    private double _originalWidth = Double.NaN;
    private double _originalHeight = Double.NaN;
    

    public DeadUnitState(Unit unit, double despawnTime, double fadeTime)
    {
        Timer = 0;
        DespawnTime = despawnTime;
        FadeTime = fadeTime;
    }

    public DeadUnitState(Unit unit)
    {
        Timer = 0;
        DespawnTime = 1.50;
        FadeTime = 0.75;
    }

    public int onClick(Unit unit, Point point)
    {
        // Dode units kunnen geen punten opleveren.
        return 0;
    }

    public void Update(Unit unit, GameController game)
    {
        if (Double.isNaN(_originalHeight))
        {
        	_originalHeight = unit.getHeight();
        	_originalWidth = unit.getWidth();
        }

        Timer += game.getDelta();

        if (Timer > DespawnTime)
            unit.die();
        else if (Timer > (DespawnTime - FadeTime))
        {
            // Tijd dat de unit al aan het faden is
            double sizeRatio = 1 - (((Timer - DespawnTime) + FadeTime) / FadeTime);

            unit.setWidth(_originalWidth * sizeRatio);
            unit.setHeight(_originalHeight * sizeRatio);
        }
    }
}