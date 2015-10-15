
package array;

import array.TileGrid.TileGridFlavor;
import gfx.assets.Assets;
import java.awt.image.BufferedImage;
import utl.console.Console;

public final class Tile{

    private TileType type;
    private final TileGridFlavor flavor;
    
    public static enum TileType{
        GRASS(Assets.grass.getSprite()),
        PLAINS(Assets.plains.getSprite()),
        FOREST(Assets.forest.getSprite()),
        OCEAN(Assets.ocean.getSprite());
        
        private final BufferedImage image;
        
        TileType(BufferedImage image){
            this.image = image;
        }
        
        public BufferedImage getImage(){
            return this.image;
        }
        
    }
    
    public Tile(TileGridFlavor flavor){
        this.flavor = flavor;
        generateType();
    }
    
    public Tile(TileType type){
        this.type = type;
        this.flavor = TileGridFlavor.LAND;
    }
    
    public void generateType(){
        if(this.flavor == TileGridFlavor.LAND)
            type = TileType.values()[(int)((Math.random()*TileType.values().length-1))];
        if(this.flavor == TileGridFlavor.OCEAN)
            type = TileType.OCEAN;
    }
    
    public void setType(TileType type){
        this.type = type;
    }
    
    public TileGridFlavor getFlavor(){
        return this.flavor;
    }
    
    public BufferedImage render(){
        return type.getImage();
    }
    
}