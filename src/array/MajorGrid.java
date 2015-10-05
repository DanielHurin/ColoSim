
package array;

import gfx.assets.Utl;
import gfx.gui.GameBoard;
import utl.console.Console;


public class MajorGrid {
    
    private static TileGrid[][] majorGrid;
    
    private static GameBoard gameBoard;
    
    public static void init(int width, int height){
        majorGrid = new TileGrid[width][height];
        for(int x = 0; x < width; x++)
            for(int y = 0; y < height; y++)
                majorGrid[x][y] = new TileGrid();
        gameBoard = new GameBoard(width*16*Utl.SPRITEDIMENSIONS,height*16*Utl.SPRITEDIMENSIONS);
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
    
    public static void render(){
        
        final int SPRITEDIMENSION = Utl.SPRITEDIMENSIONS;
        
        int[] xY = {0,0};  
        for(int x = 0; x < majorGrid.length; x++){
            for(int y = 0; y < majorGrid[x].length; y++){
                xY = majorGrid[x][y].renderTileGrid(xY);
            }
            xY[0] += SPRITEDIMENSION*majorGrid[x][0].getSize();
            xY[1] = 0;
        }
        gameBoard.drawRender();
    }
    
}
