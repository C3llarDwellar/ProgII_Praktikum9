import java.awt.*;

/**
 * Created by Tom on 29.06.2016.
 */
public class Pie extends Panel {
    private int width = 200;
    private int arc[] = {0, 0, 0};
    private Image image;

    public Pie(int arc[], Image image){
        int all = arc[0] + arc[1] + arc[2];
        this.arc[0] = arc[0] * 360 / all;
        this.arc[1] = arc[1] * 360 / all;
        this.arc[2] = arc[2] * 360 / all;
        this.image = image;
    }
    public void paint(Graphics graphics){
        graphics.drawImage(image, 0, 0, this);

        Graphics2D g2d = (Graphics2D) graphics;
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));

        graphics.setColor(Color.BLUE);
        graphics.fillArc(50, 100, this.width, this.width, 0, arc[0]);
    }

    public Dimension getPreferredSize(){
        return new Dimension(image.getWidth(this), image.getHeight(this));
    }
}