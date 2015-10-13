package gfx.gui.Components;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public abstract class ClickButtonCircle extends JButton{
    
    private BufferedImage baseIcon;
    private BufferedImage clickedIcon;
    private BufferedImage panIcon;
    
    public ClickButtonCircle(BufferedImage[] iImages){
        baseIcon = iImages[0];
        clickedIcon = iImages[1];
        panIcon = iImages[2];
        init();
    }
    
    private void init(){
        
        this.setBounds(new Rectangle(baseIcon.getWidth(),baseIcon.getHeight()));
        
        this.setIcon(new ImageIcon(baseIcon));
        this.setPressedIcon(new ImageIcon(clickedIcon));
        this.setRolloverIcon(new ImageIcon(panIcon));
        
        this.setContentAreaFilled(false);
        this.setFocusPainted(false);
        this.setBorderPainted(false);
        
    }
    
}
