
package states;

import array.MajorGrid;
import utl.console.Console;


public class GameboardState extends State{

    @Override
    public void run() {
        
        float now;
        float before = System.nanoTime();
        float delta = 0;
        float deltaSum = 0;
        final int FPS = 60;
        float timePerTick = 1000000000 / FPS;
        int numTicks = 0;
        
        while(running){
            now = System.nanoTime();
            delta += now - before;
            before = now;
            if(delta >= timePerTick){
                deltaSum += delta;
                tick();
                render();
                delta -= timePerTick;
                numTicks++;
            }
            if(deltaSum>=1000000000){
                Console.outl("FPS Stats:\nNum Ticks: "+numTicks+"\nTime Taken: "+deltaSum+"\n");
                delta = 0;
                numTicks = 0;
                deltaSum = 0;
            }
        }
        
    }

    @Override
    public void tick() {
        
        
        
    }

    @Override
    public void render() {
        
        MajorGrid.render();
        
    }
    
    
    
}
