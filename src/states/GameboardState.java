
package states;

import array.MajorGrid;
import java.awt.MouseInfo;
import java.awt.Point;
import utl.console.Console;


public class GameboardState extends State{
    
    private int[] offsets = new int[2];
    private int[] offsetsOld = new int[2];
    
    private Point offsetLimit = new Point();
    
    @Override
    public void run() {
        double now;
        double before = System.nanoTime();
        double delta = 0;
        double deltaSum = 0;
        final int FPS = 120;
        double timePerTick = 1000000000 / FPS;
        int numTicks = 0;
        while(running){
            now = System.nanoTime();
            delta += now - before;
            before = now;
            if(delta >= timePerTick){
                deltaSum += delta;
                tick();
                render();
                //delta -= timePerTick;
                delta = 0;
                numTicks++;
            }
            if(deltaSum>=1000000000){
                Console.outl("FPS Stats:\nNum Ticks: "+numTicks+"\nTime Taken: "+deltaSum+"\n");
                numTicks = 0;
                deltaSum = 0;
            }
        }
    }

    @Override
    public void tick(){
        
        offsetLimit = MajorGrid.getLimits();
        if(offsetLimit == null)
            offsetLimit = new Point(0,0);
        int dBX = MajorGrid.getBoard().getSize().width/4;
        int dBY = MajorGrid.getBoard().getSize().height/4;
        
        int xLoc = MouseInfo.getPointerInfo().getLocation().x;
        int yLoc = MouseInfo.getPointerInfo().getLocation().y;
        
        int PPM = 8;
        
        if(!(xLoc <= MajorGrid.getBoard().getLocationOnScreen().x)&&!(xLoc >= MajorGrid.getBoard().getLocationOnScreen().x+MajorGrid.getBoard().getSize().width)&&
           !(yLoc <= MajorGrid.getBoard().getLocationOnScreen().y)&&!(yLoc >= MajorGrid.getBoard().getLocationOnScreen().y+MajorGrid.getBoard().getSize().height)){
            
            if(yLoc<=dBY && offsets[1]+PPM <= 0)
                offsets[1] += PPM;
            if(xLoc<=dBX && offsets[0]+PPM <= 0)
                offsets[0] += PPM;
            if(yLoc>=MajorGrid.getBoard().getSize().height-dBY && Math.abs(offsets[1]+PPM)+MajorGrid.getBoard().getSize().height <= this.offsetLimit.y-MajorGrid.getBoard().getInsets().top)
                offsets[1] -= PPM;
            if(xLoc>=MajorGrid.getBoard().getSize().width-dBX && Math.abs(offsets[0]+PPM)+MajorGrid.getBoard().getSize().width <= this.offsetLimit.x)
                offsets[0] -= PPM;
        }
    };
    
    @Override
    public void render() {
        if(((offsetsOld[0]!=offsets[0])||(offsetsOld[1]!=offsets[1])||MajorGrid.getUpdate())||(offsetLimit.y==0))
            MajorGrid.render(offsets);
        offsetsOld[0]=offsets[0];
        offsetsOld[1]=offsets[1];
    }
    
}
