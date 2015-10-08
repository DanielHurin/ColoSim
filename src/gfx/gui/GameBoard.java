package gfx.gui;

import array.MajorGrid;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;
import utl.console.Console;

public class GameBoard extends JFrame{
    
    private Canvas canvas;
    private JPanel panel;
    
    private int x = 0;
    private int y = 0;
    
    private int oldX = 0;
    private int oldY = 0;
    
    private int width;
    private int height;
    
    private volatile Graphics g;
    private volatile BufferStrategy bs;
    
    private static volatile int[] offsets = {0,0};
    
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
        this.setLayout(null);
        
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(this.width,this.height));
        panel.setBounds(0,0,this.width,this.height);
        panel.setLayout(null);
        
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(this.width,this.height));
        canvas.setBounds(0, 0, canvas.getPreferredSize().width, canvas.getPreferredSize().height);
                
        panel.add(canvas);
        
        this.add(panel);
        this.pack();
    }
    
    public Dimension getCanvasSize(){
        return this.canvas.getSize();
    }
    
    public boolean isInited(){
        return this.inited;
    }
    
    public boolean newRenderStart(){
        bs = canvas.getBufferStrategy();
        if(bs==null){
            canvas.createBufferStrategy(3);
            return false;
        }
        g = bs.getDrawGraphics();
        this.inited = true;
        return true;
    }
    
    public void newRenderEnd(){
        bs.show();
        bs.show();
        g.clearRect(0, 0, canvas.getPreferredSize().width, canvas.getPreferredSize().height);
        g.dispose();
        this.inited = false;
    }
    
    public void draw(BufferedImage bI, int xLoc, int yLoc){
        if(inited){
            g.drawImage(bI, xLoc, yLoc, this.canvas);
        }
    }
    
}
