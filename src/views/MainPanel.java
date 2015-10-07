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
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import containers.InputContainer;
import models.Unit;

public class MainPanel extends JPanel {
    private BufferedImage background;
    private ArrayList<UnitView> unitViews;
    private HashMap<Unit, UnitView> views;

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
    		for(UnitView v : unitViews){
    			if(v.getUnit() == null){
    				this.remove(v);
    				unitViews.remove(v);
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
    			uv.repaint();
    			
    		}
    	}

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
        for(UnitView v : unitViews){
        	v.draw(g);
        }
        
    }
    
    

    
    public HashMap<Unit, UnitView> getViews(){
    	return views;
    }
}
