package models;

import java.util.Random;

import javax.swing.JFrame;

import behaviours.DrawBehaviour;
import behaviours.MoveBehaviour;
import containers.DrawContainer;
import containers.MoveContainer;
import factories.BehaviourFactory;

public abstract class Unit
{
    public int direction;
    public int size;
    public float heading;
    public float x;
    public float y;
    public float velocity;
    public boolean gotShot;
    public int score;

    protected JFrame window;
    public static Random rnd = new Random();
    private MoveContainer moveContainer;
    private DrawContainer drawContainer;
    private BehaviourFactory behaviourFactory;
    private DrawBehaviour drawBehaviour;
    private MoveBehaviour moveBehaviour;

    public Unit(MoveContainer mc, DrawContainer dc, BehaviourFactory bf, JFrame window)
    {
        moveContainer = mc;
        drawContainer = dc;
        behaviourFactory = bf;
        this.window = window;
       
        moveBehaviour = bf.CreateMoveBehaviour(this);
        drawBehaviour = bf.CreateDrawBehaviour(this);
        moveContainer.Add(moveBehaviour);
        drawContainer.Add(drawBehaviour);

        this.window = window;
    }

    public Unit() { }

    public abstract Unit CreateInstance(MoveContainer mc, DrawContainer dc, BehaviourFactory bf, JFrame window);


}
