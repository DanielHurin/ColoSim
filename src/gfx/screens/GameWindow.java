package gfx.screens;

import java.awt.Canvas;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameWindow extends JFrame{
    
    private Canvas canvas;
    private JPanel panel;
    
    public GameWindow(){
        init();
    }
    
    private void init(){
        
        this.setVisible(true);
        
        canvas = new Canvas();
                
        this.add(canvas);
        
        this.pack();
    }
    
    public void reSize(){
        //Make a Call to Configs to get WindowSize 
    }
    
}
