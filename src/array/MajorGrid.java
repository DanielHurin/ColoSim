
package array;

import gfx.gui.GameBoard;


public class MajorGrid {
    
    private static TileGrid[][] majorGrid;
    
    private static GameBoard gameBoard;
    
    public static void init(int width, int height){
        generateRandom();
    }
    
    public static TileGrid getTileGrid(int column, int row){
        return majorGrid[column][row];
    }
    
    public static void setTileGrid(int column, int row, TileGrid tileGrid){
        majorGrid[column][row] = tileGrid;
    }
    
    public static GameBoard getBoard(){
        return gameBoard;
    }
    
    public static void setBoard(GameBoard gameBoard){
        MajorGrid.gameBoard = gameBoard;
    }
    
    public static void generateRandom(){
        //TODO: Write Generation Code
    }
    
    public static void renderAll(){
        int[] xY = {0,0};  
        for(int x = 0; x < majorGrid.length; x++)
            for(int y = 0; y < majorGrid[x].length; y++){
                xY = majorGrid[x][y].renderTileGrid(xY);
            }
        
    }
    
}
