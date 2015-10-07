package views;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MainPanel extends JPanel {
    private BufferedImage background;

    public MainPanel() {

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

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        

        drawImage(g, background);
    }

    private void drawImage(Graphics g, BufferedImage image) {

        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        Toolkit.getDefaultToolkit().sync();
    }
}
