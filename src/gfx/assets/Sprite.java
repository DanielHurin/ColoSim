
package gfx.assets;

import java.awt.image.BufferedImage;


public class Sprite {
    
    private final BufferedImage sprite;
    
    public Sprite(int x,int y, SpriteSheet spriteSheet){
        sprite = spriteSheet.makeSprite(x, y);
    }
    
    public BufferedImage getSprite(){
        return this.sprite;
    }
    
}
