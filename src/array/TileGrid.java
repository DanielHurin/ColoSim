
package array;


public class TileGrid {
    
    private Tile[][] tileGrid = new Tile[16][16];
    
    public TileGrid(){
        generateRandom();
    }
    
    public TileGrid(Tile[][] tileGrid){
        this.tileGrid = tileGrid;
    }
    
    public void setTile(int column, int row, Tile tile){
        tileGrid[column][row] = tile;
    }
    
    public Tile getTile(int column, int row){
        return tileGrid[column][row];
    }
    
    public Tile[][] generateRandom(){
        return null;//TODO: Write Random Tile Assigning Code
    }
}
