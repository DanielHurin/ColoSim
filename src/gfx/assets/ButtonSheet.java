package gfx.assets;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import utl.console.Console;

public class ButtonSheet{

    private final int BUTTONSIZE = 64;
    
    private BufferedImage buttonSheet;
    
    public ButtonSheet(String path){
        try{
            buttonSheet = ImageIO.read(new File(path));
        }catch(IOException ioe){
            Console.flag("Error creating the SpriteSheet at path: "+path, ioe);
        }       
    }
    
    public BufferedImage[] makeButtonFancy(int row, int column){
        BufferedImage[] toReturn = new BufferedImage[3];
        toReturn[0] = buttonSheet.getSubimage(BUTTONSIZE*row, BUTTONSIZE*column, BUTTONSIZE, BUTTONSIZE);
        toReturn[1] = buttonSheet.getSubimage(BUTTONSIZE*row, BUTTONSIZE*column+BUTTONSIZE, BUTTONSIZE, BUTTONSIZE);
        toReturn[2] = buttonSheet.getSubimage(BUTTONSIZE*row, BUTTONSIZE*column+(BUTTONSIZE*2), BUTTONSIZE, BUTTONSIZE);
        return toReturn;
    }
    
    public BufferedImage makeButton(int row, int column){
        return buttonSheet.getSubimage(BUTTONSIZE*row, BUTTONSIZE*3*column, BUTTONSIZE, BUTTONSIZE);
    }
    
    public int getButtonSize(){
        return BUTTONSIZE;
    }
    
}
