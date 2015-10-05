package gfx.gui;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameBoard extends JFrame{
    
    private Canvas canvas;
    private JPanel panel;
    
    private int width;
    private int height;
    
    private Graphics g;
    private BufferStrategy bs;
    
    private boolean inited = false;
    
    public GameBoard(int x, int y){
        width = x;
        height = y;
        init();
    }
    
    private void init(){
        
        this.setVisible(true);
        this.setPreferredSize(new Dimension(this.width,this.height));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(this.width,this.height));
                
        this.add(canvas);
        
        this.pack();
        while(!inited){
            inited = initPart2();
        }
    }
    
    private boolean initPart2(){
        bs = canvas.getBufferStrategy();
        if(bs==null){
            canvas.createBufferStrategy(3);
            return false;
        }
        g = bs.getDrawGraphics();
        bs.show();
        bs.show();
        return true;
    }
    
    public void resize(int width, int height){
        this.width = width;
        this.height = height;
        if(inited){
            this.setPreferredSize(new Dimension(this.width,this.height));
        }
        //Make a Call to Configs to get WindowSize 
    }
    
    public void draw(BufferedImage bI, int xLoc, int yLoc){
        if(inited){
            g.drawImage(bI, xLoc, yLoc, null);
        }
    }
    
    public void drawRender(){
        if(inited){
            bs.show();
        }
    }
}
