import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Tom on 29.06.2016.
 */

/*arguments order: val1 val2 val3 val4 name1 name2 name3 name4 imgURL*/

public class DataGraph extends Panel {

    private Image image;

    private DataGraph(Image image){
        this.image = image;
    }

    public static void main(String[] args){

        Frame frame = new Frame();
        frame.setLayout(new FlowLayout());
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                super.windowClosing(windowEvent);
                System.exit(0);
            }
        });
        Image image = frame.getToolkit().getImage(args[8]);
        DataGraph dataGraph = new DataGraph(image);
        int val[] = {0, 0, 0, 0};
        String[] name = {"", "", "", ""};

        for (int i = 0; i < 4; i++){
            val[i] = Integer.parseInt(args[i]);
            name[i] = args[i+4];
        }

        Bars bars = new Bars(val, image);
        Pie pie = new Pie(val, image);

        MediaTracker tracker = new MediaTracker(dataGraph);
        tracker.addImage(image, 1);
        try{
            tracker.waitForAll();
        }catch (Exception e){
            System.out.println("well shit");
        }

        frame.add(bars);
        frame.add(pie);
        frame.add(new TextArea(
                "Blue:\t" + args[4] + " - " + args[0] +
                "\nRed:\t" + args[5] + " - " + args[1] +
                "\nGreen:\t" + args[6] + " - " + args[2] +
                "\nBlack:\t" + args[7] + " - " + args[3]
        , 5, 30));
        frame.pack();
        frame.setVisible(true);
    }
}