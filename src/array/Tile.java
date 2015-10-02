
package array;


public class Tile {
    
    private int type;
    
    public Tile(){
        generateTile();
    }
    
    public Tile(int type){
        this.type = type;
    }
    
    public void setType(int type){
        this.type = type;
    }
    
    public int getType(){
        return this.type;
    }
    
    public void generateTile(){
        //TODO: Random Tile Type Code
    }
}
