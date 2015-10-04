
package gfx.assets;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import utl.console.Console;


public class Utl {
    
    private static BufferedImage spriteSheet;
    
    private static final int SPRITESIZE = 64;
    
    public static void loadSpriteSheet(String path){
        try{
            spriteSheet = ImageIO.read(new File(path));
        }catch(IOException ioe){
            Console.flag("Error creating the SpriteSheet at path: "+path, ioe);
        }       
    }
    
    public static BufferedImage makeSprite(int row, int column){
        return spriteSheet.getSubimage(SPRITESIZE*row, SPRITESIZE*column, SPRITESIZE, SPRITESIZE);
    }
    
    public static int getSpriteSize(){
        return SPRITESIZE;
    }
}
