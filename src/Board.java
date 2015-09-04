import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Board extends JPanel{

    private BufferedImage background;

    public Board() {
       try {                
          background = ImageIO.read(new File("./src/images/background.png"));
       } catch (IOException ex) {
            // handle exception...       
    	   }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, -350, null); // see javadoc for more info on the parameters            
    }

}