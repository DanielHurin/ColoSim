package gfx.gui.components;

import gfx.assets.Assets;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

public class CursorOverlay{

    private final Cursor cursor;
    private boolean isActive = false;
    private static Overlay overlay;
    
    public static CursorOverlay grassTile = new CursorOverlay(Overlay.GRASSTILE);
    public static CursorOverlay plainsTile = new CursorOverlay(Overlay.PLAINSTILE);
    public static CursorOverlay forestTile = new CursorOverlay(Overlay.FORESTTILE);
    
    private final CursorOverlay[] ALLOVERLAYS = {grassTile,plainsTile,forestTile};
    
    public static enum Overlay{
        
        GRASSTILE(Assets.grass.getSprite()),
        PLAINSTILE(Assets.plains.getSprite()),
        FORESTTILE(Assets.forest.getSprite());
        
        private final BufferedImage image;
        
        Overlay(BufferedImage image){
            this.image = image;
        }
        
        public BufferedImage getImage(){
            return this.image;
        }
        
    }
    
    public CursorOverlay(Overlay overLay) {
        Point point = new Point(overLay.getImage().getWidth()/2,overLay.getImage().getHeight()/2);
        this.cursor = Toolkit.getDefaultToolkit().createCustomCursor(overLay.getImage(), point, "");
    }
    
    public boolean getActive(){
        return this.isActive;
    }
    
    public void setActive(boolean active){
        this.isActive = active;
    }
    
    public void activateCursor(Component component){
        boolean overlayActive = false;
        for(CursorOverlay currentOverlay: ALLOVERLAYS)
            if(currentOverlay.isActive)
                overlayActive = true;
        if(overlayActive)
            return;
        component.setCursor(this.cursor);
        this.isActive = true;
    }
    
    public void deactivateCursor(Component component){
        boolean overlayActive = true;
        for(CursorOverlay currentOverlay: ALLOVERLAYS)
            if(!currentOverlay.isActive)
                overlayActive = false;
        if(!overlayActive)
            return;
        component.setCursor(Cursor.getDefaultCursor());
        this.isActive = false;
    }
    
}
