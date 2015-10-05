
import array.MajorGrid;
import states.GameboardState;
import utl.console.Console;

public class TestClass {
    
    public static GameboardState GBS = new GameboardState();
    
    
    public static void main(String[] args) {
        //==InitMajorGrid==\\
    
        MajorGrid.init(2,2);
        
        GBS.start();
        try{
            Thread.sleep(10000);
            Console.out("Done Sleeping!");
        }catch(InterruptedException iE){
            Console.flag("Error Sleeping Main Thread", iE);
        }
        MajorGrid.getTileGrid(0,0).getTile(0,0).setType(3);
    }
    
}
