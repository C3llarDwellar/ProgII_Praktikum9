import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.RenderedImage;
import java.net.URL;

/**
 * Created by Edwin on 13/06/2016.
 */
/*arguments order: name1 val1 name2 val2 name3 val3 imgURL*/

public class DataGraph extends Panel {

    private Image image;

    private Bars bars;

    private DataGraph(Image image){
        this.image = image;
    }

    public static void main(String[] args){

        Frame frame = new Frame();
        Image image = frame.getToolkit().getImage(args[6]);
        DataGraph dataGraph = new DataGraph(image);

        int[] percentage = dataGraph.calculatePercentages(Integer.parseInt(args[1]),Integer.parseInt(args[3]),Integer.parseInt(args[5]));
        dataGraph.bars = new Bars(percentage[0], percentage[1], percentage[2]);

        dataGraph.alterFrame(frame);

        MediaTracker tracker = new MediaTracker(dataGraph);
        tracker.addImage(image, 1);
        try{
            tracker.waitForAll();
        }catch (Exception e){
            System.out.println("well shit");
        }

        frame.add(dataGraph);
        frame.pack();
        frame.setVisible(true);


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

    //calculates the percentages of the three values
    private int[] calculatePercentages(int val1, int val2, int val3){
        int all = val1 + val2 + val3;
        int[] percentage = {0, 0, 0};

        percentage[0] = val1 * 100 / all;
        percentage[1] = val2 * 100 / all;
        percentage[2] = val3 * 100 / all;

        return percentage;
    }

    //paints background Image to the Frame
    public void paint(Graphics graphics){
        graphics.drawImage(image, 0, 0, this);
        graphics.drawRect(0, image.getHeight(this) - bars.height1, bars.width, bars.height1);
        graphics.drawRect(25, image.getHeight(this) - bars.height2, bars.width, bars.height2);
        graphics.drawRect(50, image.getHeight(this) - bars.height3, bars.width, bars.height3);

    }

    //adjust to size of Image
    public Dimension getPreferredSize(){
        return new Dimension(image.getWidth(this), image.getHeight(this));
    }
}
