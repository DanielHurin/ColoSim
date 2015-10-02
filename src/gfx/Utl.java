
package gfx;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import utl.console.Console;


public class Utl {
    
    private static BufferedImage spriteSheet;
    
    private static final int SPRITEWIDTH = 64;
    private static final int SPRITEHEIGHT = 64;
    
    public static void loadSpriteSheet(String path){
        try{
            spriteSheet = ImageIO.read(new File(path));
        }catch(IOException ioe){
            Console.flag("Error creating the SpriteSheet at path: "+path, ioe);
        }       
    }
    
    public static BufferedImage makeSprite(int row, int column){
        return spriteSheet.getSubimage(SPRITEWIDTH*row, SPRITEHEIGHT*column, SPRITEWIDTH, SPRITEHEIGHT);
    }
}
