import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Edwin on 13/06/2016.
 */
public class DataGraph extends Panel {
    static void main(String[] args){
        Frame frame = new Frame();
        frame.setLayout(new GridBagLayout());
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                super.windowClosing(windowEvent);
                System.exit(0);
            }
        });
    }


}
