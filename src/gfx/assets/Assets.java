package gfx.assets;

import gfx.gui.Components.ClickButtons.*;
import gfx.gui.Components.ClickButtonCircle;


public class Assets {
    
    //Sprite X Y is scaled in Utl!
    
    //==All Assets Will Be Defined Here==\\
    
    public static final SpriteSheet terrainSheet = new SpriteSheet("Resources/Sprites/Terrain/TerrainSprites.png");
    public static final ButtonSheet buttonSheet = new ButtonSheet("Resources/Sprites/UI/ButtonsSideBar.png");
    
    public static final Sprite grass = new Sprite(0,0,terrainSheet);
    public static final Sprite plains = new Sprite(0,1,terrainSheet);
    public static final Sprite forest = new Sprite(1,0,terrainSheet);
    public static final Sprite ocean = new Sprite(1,1,terrainSheet);
    
    public static final ClickButtonCircle test = new Test(buttonSheet.makeButtonFancy(0, 0));
    
    //==Nothing Should Be Put Beyond This Line==\\
    
}
