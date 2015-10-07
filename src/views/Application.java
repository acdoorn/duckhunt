package views;

import java.awt.EventQueue;

import javax.swing.JFrame;



public class Application extends JFrame {

    
    public Application() {

        initUI();
    }

    private void initUI() {

        add(new Board());
        pack();
        setSize(1600, 1200);

        setTitle("Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }    
    

    
    
}