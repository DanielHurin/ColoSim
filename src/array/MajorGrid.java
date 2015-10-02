
package array;


public class MajorGrid {
    
    public TileGrid[][] majorGrid;
    
    public MajorGrid(int width, int height){
        generateRandom();
    }
    
    public TileGrid getTileGrid(int column, int row){
        return majorGrid[column][row];
    }
    
    public void setTileGrid(int column, int row, TileGrid tileGrid){
        majorGrid[column][row] = tileGrid;
    }
    
    public void generateRandom(){
        //TODO: Write Generation Code
    }
    
}
