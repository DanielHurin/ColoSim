
package array;

import gfx.assets.Utl;


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
    
    public void generateRandom(){
        
        for(int x = 0; x < tileGrid.length; x++)
            for(int y = 0; y < tileGrid[x].length; y++){
                tileGrid[x][y].generateTile();
            }
    }
    
    /**
     * Use this method to draw a section of the board.  It will draw directly to the GameBoard,
     * and will not draw if it does not exist.
     * @param xY The user must pass in a two long array of Ints: the first is x, the second is Y.
     * @return 
     */
    public int[] renderTileGrid(int[] xY){
        
        if(xY.length!=2||MajorGrid.getBoard()==null)
            return null;
        
        int xLoc = xY[0]; //x Location
        int yLoc = xY[1]; //y Location
        
        final int SPRITEDIMENSION = Utl.getSpriteSize();
        
        final int SS = gfx.assets.Utl.getSpriteSize(); //SpriteSize
        
        for(int x = 0; x < tileGrid.length; x++){            
            for(int y = 0; y < tileGrid.length; y++){
                MajorGrid.getBoard().draw(tileGrid[x][y].render(),xLoc,yLoc);
                xLoc+=SPRITEDIMENSION;
            }
            xLoc-=SPRITEDIMENSION*tileGrid[x].length;
            yLoc+=SPRITEDIMENSION;
        }    
        int[] toReturn = {xLoc,yLoc};
        return toReturn;
    }
}
