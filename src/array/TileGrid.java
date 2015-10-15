
package array;

import utl.console.Console;


public class TileGrid {
    
    private Tile[][] tileGrid = new Tile[16][16];
    private final TileGridFlavor tileGridFlavor;
    
    public static enum TileGridFlavor{
        LAND,OCEAN;
    }
    
    public TileGrid(){
        tileGridFlavor = randomFlavor();
        generateRandom();
    }
    
    public TileGrid(TileGridFlavor tileGridFlavor){
        this.tileGridFlavor = tileGridFlavor;
        generateRandom();
    }
    
    public TileGrid(Tile[][] tileGrid){
        this.tileGridFlavor = randomFlavor();
        this.tileGrid = tileGrid;
    }
    
    public TileGridFlavor getFlavor(){
        return this.tileGridFlavor;
    }
    
    public Tile[][] getTileGrid(){
        return tileGrid;
    }
    
    public void setTile(int column, int row, Tile tile){
        tileGrid[column][row] = tile;
    }
    
    public Tile getTile(int column, int row){
        return tileGrid[column][row];
    }
    
    private TileGridFlavor randomFlavor(){
        return TileGridFlavor.values()[(int)((Math.random())*TileGridFlavor.values().length)];
    }
    
    private void generateRandom(){
        for(int x = 0; x < tileGrid.length; x++)
            for(int y = 0; y < tileGrid[x].length; y++){
                tileGrid[x][y] = new Tile(this.tileGridFlavor);
            }
    }
    
}
