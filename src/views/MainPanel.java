package views;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import containers.InputContainer;
import factories.LevelFactory;
import models.Unit;

public class MainPanel extends JPanel {
    private BufferedImage background;
    private ArrayList<UnitView> unitViews;
    private HashMap<Unit, UnitView> views;
    private JTextPane score;
    private int points;

    public MainPanel() {
    	views = new HashMap<Unit, UnitView>();
    	unitViews = new ArrayList<UnitView>();
        initBoard();
    }

    private BufferedImage loadImage(String imagePath) {

    	try {
			return ImageIO.read(new File(imagePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    }

    private void initBoard() {
    	
    	
    	this.background = loadImage("./src/images/background.png");
    	
    	score = new JTextPane();
    	score.setEditable(false);
    	score.setText("Score: 0" /* + LevelFactory.getInstance().currentLevel.Kills*/);
    	this.add(score);
    	this.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				InputContainer.getInstance().AddClick(arg0.getPoint());
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
    		
    	});
        setPreferredSize(new Dimension(1600, 1200));
        setDoubleBuffered(true);
    }
    
    // call this method when a new unit is created.
    public void UpdateUnitViews(List<Unit> units){
    	
    	for(Unit u : units){
    		boolean existing = false;
    		
    		for(Iterator<UnitView> iterator = unitViews.iterator(); iterator.hasNext();){
    			UnitView v = iterator.next();
    			if(v.getUnit() == null){ //if(v.getUnit().getState() == died){
    				this.remove(v);
    				iterator.remove();
    			}else {
	    			if(v.getUnit().equals(u)){
	    				existing = true;
	    			}
    			}
    		}
    		if(!existing){
    			UnitView uv = new UnitView(u);
    			unitViews.add(uv);
    			this.add(uv);
    			
    		}
    	}
    	if(LevelFactory.getInstance().currentLevel != null){
    		points = LevelFactory.getInstance().currentLevel.Kills;
    	} else {
    		points = 0;
    	}
    	
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        score.setText("Score: " + points);
        g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
        for(UnitView v : unitViews){
        	v.draw(g);
        }
        
    }
    
    

    
    public HashMap<Unit, UnitView> getViews(){
    	return views;
    }
}
