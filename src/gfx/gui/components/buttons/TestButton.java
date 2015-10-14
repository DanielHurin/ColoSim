
package gfx.gui.components.buttons;

import gfx.gui.components.ClickButtonCircle;
import java.awt.event.ActionEvent;

public class TestButton extends ClickButtonCircle{

    public TestButton(String desc) {
        super(0, 0, desc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
    
}
