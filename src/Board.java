import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Board extends JPanel
        implements Runnable {
    private final int INITIAL_X = 1600;
    private final int INITIAL_Y = -40;
    private final int DELAY = 5;
    
    private BufferedImage background;
    private Bird blueBird;

    private Image star;
    private Thread animator;
    private int x, y;

    public Board() {

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
    	
        setPreferredSize(new Dimension(1600, 900));
        setDoubleBuffered(true);
    	blueBird = new Bird(1600, 20, Bird.color.red, loadImage("./src/images/bluebird.png"));

//        loadImage();

        this.x = INITIAL_X;
        this.y = INITIAL_Y;
    }

    @Override
    public void addNotify() {
        super.addNotify();

        animator = new Thread(this);
        animator.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        

        drawImage(g, background);
        drawImage(g, blueBird);
    }

    private void drawImage(Graphics g, BufferedImage image) {

        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        Toolkit.getDefaultToolkit().sync();
    }
    
    private void drawImage(Graphics g, Bird b) {

        g.drawImage(b.getImage(), b.getX(), b.getY(), b.getWidth(), b.getHeight(), this);
        Toolkit.getDefaultToolkit().sync();
    }

    private void cycle() {

        blueBird.setX(blueBird.getX()-1);
        y += 1;

        if (blueBird.getX() < -100) {

            blueBird.setY(blueBird.getY()+80);
            blueBird.setX(1800);
        }
    }

    @Override
    public void run() {

        long beforeTime, timeDiff, sleep;

        beforeTime = System.currentTimeMillis();

        while (true) {

            cycle();
            repaint();

            timeDiff = System.currentTimeMillis() - beforeTime;
            sleep = DELAY - timeDiff;

            if (sleep < 0) {
                sleep = 2;
            }

            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                System.out.println("Interrupted: " + e.getMessage());
            }

            beforeTime = System.currentTimeMillis();
        }
    }
}