package views;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	
	public MainFrame(JPanel window) {

        add(window);
        pack();
        setSize(1600, 1200);

        setTitle("Duckhunt");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setVisible(true);
	}

}
