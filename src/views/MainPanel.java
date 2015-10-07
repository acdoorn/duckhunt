package views;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import models.Unit;

public class MainPanel extends JPanel {
    private BufferedImage background;
    private HashMap<Unit, UnitView> views;

    public MainPanel() {
    	views = new HashMap<Unit, UnitView>();
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
    	
        setPreferredSize(new Dimension(1600, 1200));
        setDoubleBuffered(true);
    }
    
    // call this method when a new unit is created.
    public void UpdateUnitViews(List<Unit> units){
    	for(Unit u : units){
    		if(!views.containsKey(u)){
    			views.put(u, new UnitView(u, this));
    		}
    	}
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, getWidth(), getHeight(), this);

        
        Iterator<Entry<Unit, UnitView>> it = views.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Unit, UnitView> pair = (Entry<Unit, UnitView>)it.next();
            if(pair.getKey() != null){
            	UnitView uv = pair.getValue();
            	uv.update(g);
            } else {
            	views.remove(pair.getKey(), pair.getValue());
            }
            it.remove(); // avoids a ConcurrentModificationException
        }
        //Toolkit.getDefaultToolkit().sync();
        
    }

    
    public HashMap<Unit, UnitView> getViews(){
    	return views;
    }
}
