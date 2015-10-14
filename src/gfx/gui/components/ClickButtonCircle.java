package gfx.gui.components;

import gfx.assets.Assets;
import java.awt.Color;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public abstract class ClickButtonCircle extends AbstractAction implements ComponentListener{
    
    private final ImageIcon baseIcon;
    private final ImageIcon clickedIcon;
    private final ImageIcon panIcon;
    
    private final JButton component;
    
    public ClickButtonCircle(int row, int column, String desc){
        baseIcon = new ImageIcon(Assets.buttonSheet.makeButtonFancy(row, column)[0]);
        clickedIcon = new ImageIcon(Assets.buttonSheet.makeButtonFancy(row, column)[1]);
        panIcon = new ImageIcon(Assets.buttonSheet.makeButtonFancy(row, column)[2]);
        
        putValue(SHORT_DESCRIPTION, desc);
        
        component = new JButton(this);
        
        component.setIcon(baseIcon);
        component.setPressedIcon(clickedIcon);
        component.setRolloverIcon(panIcon);
        component.setBounds(new Rectangle(baseIcon.getIconWidth(),baseIcon.getIconHeight()));
        component.setFocusPainted(false);
        component.setContentAreaFilled(false);
        component.setBorderPainted(false);
    }
    
    @Override
    public abstract void actionPerformed(ActionEvent e);
    
    
    @Override
    public void componentResized(ComponentEvent ce) {
    }

    @Override
    public void componentMoved(ComponentEvent ce) {
    }

    @Override
    public void componentShown(ComponentEvent ce) {
    }

    @Override
    public void componentHidden(ComponentEvent ce) {
    }
    
    public Component getComponent(){
        return this.component;
    }
}
