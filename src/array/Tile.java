
package array;

import gfx.assets.Assets;
import java.awt.image.BufferedImage;


public class Tile {
    
    private int type;
    private boolean update = true;
    
    public Tile(){
        generateTile();
    }
    
    public Tile(int type){
        this.type = type;
    }
    
    public void setType(int type){
        this.type = type;
        this.update = true;
    }
    
    public int getType(){
        return this.type;
    }
    /**
     * This function will randomly generate the tile.  A value of 0 is grass, 1 plains, 2 forest, 3 ocean
     */
    
    private void generateTile(){
        this.type = (int)(Math.random()*(3));
    }
    
    public void setUpdate(){
        this.update = true;
    }
    
    public boolean getUpdate(){
        return update;
    }
    
    /**
     * This function will render the tile.  Returns a BufferedImage from the Assets class
     * @return 
     */
    public BufferedImage render(){
        this.update = false;
        switch(type){
            case 0: //Grass
                return Assets.grass.getSprite();
            case 1: //Plains
                return Assets.plains.getSprite();
            case 2: //Forest
                return Assets.forest.getSprite();
            case 3: //Ocean
                return Assets.ocean.getSprite();
            default: //Grass
                return Assets.grass.getSprite();
        }
    }
}
