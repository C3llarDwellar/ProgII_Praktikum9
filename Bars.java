import java.awt.*;

/**
 * Created by Tom on 29.06.2016.
 */
public class Bars extends Panel{
    private int width = 50;
    private int height[] = {0, 0, 0, 0};
    private Image image;

    public Bars(int height[], Image image){
        int all = height[0] + height[1] + height[2] + height[3];
        this.height[0] = height[0] * 1000 / all;
        this.height[1] = height[1] * 1000 / all;
        this.height[2] = height[2] * 1000 / all;
        this.height[3] = height[3] * 1000 / all;
        this.image = image;
    }

    public void paint(Graphics graphics){
        graphics.drawImage(image, 0, 0, this);

        Graphics2D g2d = (Graphics2D) graphics;
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));

        graphics.setColor(Color.BLUE);
        graphics.fillRect(50, image.getHeight(this) - this.height[0], this.width, this.height[0]);

        graphics.setColor(Color.RED);
        graphics.fillRect(150, image.getHeight(this) - this.height[1], this.width, this.height[1]);

        graphics.setColor(Color.GREEN);
        graphics.fillRect(250, image.getHeight(this) - this.height[2], this.width, this.height[2]);

        graphics.setColor(Color.BLACK);
        graphics.fillRect(350, image.getHeight(this) - this.height[3], this.width, this.height[3]);
    }

    public Dimension getPreferredSize(){
        return new Dimension(image.getWidth(this), image.getHeight(this));
    }
}