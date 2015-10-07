package views;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import models.Unit;

public class MainPanel extends JPanel {
    private BufferedImage background;
    private ArrayList<UnitView> views;

    public MainPanel() {
    	views = new ArrayList<UnitView>();
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
    
    public void createUnitView(Unit u){
    	views.add(new UnitView(u));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        

        drawImage(g, background);
        
        for(UnitView v : views){
        	v.update(g);
        }
        Toolkit.getDefaultToolkit().sync();
        
    }

    private void drawImage(Graphics g, BufferedImage image) {

        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        
    }
}
