
package array;

import gfx.assets.Utl;
import gfx.gui.GameBoard;
import java.awt.Point;


public class MajorGrid {
    
    private static TileGrid[][] majorGrid;
    
    private static Point offsetLim; 
    
    private static GameBoard gameBoard;
    private static boolean boardUpdate = false;
    private static boolean isFirstTime = true;
    
    public static void init(int width, int height){
        majorGrid = new TileGrid[width][height];
        for(int x = 0; x < width; x++)
            for(int y = 0; y < height; y++)
                majorGrid[x][y] = new TileGrid();
        gameBoard = new GameBoard(width*16*Utl.SPRITEDIMENSIONS,height*16*Utl.SPRITEDIMENSIONS);
    }
    
    public static void setUpdate(){
        boardUpdate = true;
    }
    
    public static boolean getUpdate(){
        return boardUpdate;
    }
    
    public static TileGrid[][] getMajorGrid(){
        return majorGrid;
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
    
    public static void render(int[] offsets){
        
        while(!gameBoard.isInited())
            gameBoard.newRenderStart();
        
        final int SD = Utl.SPRITEDIMENSIONS;
        
        int xLoc = offsets[0];
        int yLoc = offsets[1];
        
        int XORG = offsets[0];
        int YORG = offsets[1];
        
        int yPoint = 0;
        
        for(TileGrid[] tileGridArray:majorGrid){
            for(TileGrid tileGrid:tileGridArray){
                for(Tile[] tileGridRow:tileGrid.getTileGrid()){
                    for(Tile tile:tileGridRow){
                        gameBoard.draw(tile.render(), xLoc, yLoc);
                        xLoc+=SD;
                    }
                    xLoc = XORG;
                    yLoc += SD;
                }
            }
            yPoint = yLoc;
            yLoc = YORG;
            xLoc += tileGridArray[0].getTileGrid()[0].length*SD;
            XORG = xLoc;
        }
        gameBoard.newRenderEnd();
        if(MajorGrid.getLimits()==null)
            MajorGrid.offsetLim = new Point(xLoc,yPoint);
        MajorGrid.boardUpdate = false;
    }
    
    public static Point getLimits(){
        return offsetLim;
    }
    
}
