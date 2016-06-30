import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Edwin on 13/06/2016.
 */
/*arguments order: name1 val1 name2 val2 name3 val3 imgURL*/

public class DataGraph extends Panel {

    private Image image;

    private DataGraph(Image image){
        this.image = image;
    }

    public static void main(String[] args){

        Frame frame = new Frame();
        Image image = frame.getToolkit().getImage(args[6]);
        DataGraph dataGraph = new DataGraph(image);

        Bars bars = new Bars(Integer.parseInt(args[1]), Integer.parseInt(args[3]), Integer.parseInt(args[5]), image);
        Pie pie = new Pie(Integer.parseInt(args[1]), Integer.parseInt(args[3]), Integer.parseInt(args[5]), image);

        dataGraph.alterFrame(frame);

        MediaTracker tracker = new MediaTracker(dataGraph);
        tracker.addImage(image, 1);
        try{
            tracker.waitForAll();
        }catch (Exception e){
            System.out.println("well shit");
        }

        double[] percentage = dataGraph.percentages(Integer.parseInt(args[1]), Integer.parseInt(args[3]), Integer.parseInt(args[5]));

        //frame.add(dataGraph);
        frame.add(bars);
        frame.add(pie);
        frame.add(new TextArea(
                "BLUE: " + args[0] + " - " + args[1] + " - " + percentage[0] + "%\n" +
                "RED: " + args[2] + " - " + args[3] + " - " + percentage[1] + "%\n" +
                "GREEN: " +args[4] + " - " + args[5] + " - " + percentage[2] +"%", 4, 30
        ));
        frame.pack();
        frame.setVisible(true);


    }

    private double[] percentages(int val1, int val2, int val3){
        int all = val1 + val2 + val3;
        double[] percentage = {val1 * 100 / all, val2 * 100 / all, val3 * 100 / all};
        return percentage;
    }

    //initializes new Frame with a GridBaLayout
    private void alterFrame(Frame frame){
        frame.setLayout(new FlowLayout());
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                super.windowClosing(windowEvent);
                System.exit(0);
            }
        });
    }


}
