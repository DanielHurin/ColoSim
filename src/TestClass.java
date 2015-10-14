
import gfx.gui.components.buttons.TestButton;
import javax.swing.JFrame;
import states.GameboardState;

public class TestClass {
    
    public static volatile GameboardState GBS = new GameboardState();
    
    
    public static void main(String[] args) {
        
        //==TestButtons==\\
        
        TestButton test = new TestButton("A simple test Button");
        
        //==InitMajorGrid==\\
    
        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setVisible(true);
        frame.add(test.getComponent());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        
        /*
        MajorGrid.init(2,2);
        
        GBS.start();
        try{
            Thread.sleep(10000);
            Console.out("Done Sleeping!");
        }catch(InterruptedException iE){
            Console.flag("Error Sleeping Main Thread", iE);
        }
        MajorGrid.getTileGrid(0,0).getTile(0,0).setType(3);
        */
    }
    
}
