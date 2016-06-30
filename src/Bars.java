import java.awt.*;

/**
 * Created by Edwin on 29/06/2016.
 */
public class Bars extends Panel{
    private int width = 200;
    private int[] value = {0, 0, 0};
    private Image image;
    private int height[] = {0, 0, 0};

    public Bars(int val1, int val2, int val3, Image image){
        this.value[0] = val1 * 10;
        this.value[1] = val2 * 10;
        this.value[2] = val3 * 10;
        this.image = image;
        this.height = this.calculateHeight(value);
    }

    //calculates the percentages of the three values
    private int[] calculateHeight(int[] value){
        int all = value[0] + value[1] + value[2];
        int[] percentage = {0, 0, 0};

        percentage[0] = value[0] * 1000 / all;
        percentage[1] = value[1] * 1000 / all;
        percentage[2] = value[2] * 1000 / all;

        return percentage;
    }

    public void paint(Graphics graphics){
        graphics.drawImage(image, 0, 0, this);

        Graphics2D g2d = (Graphics2D) graphics;
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));

        graphics.setColor(Color.BLUE);
        graphics.fillRect(50,image.getHeight(this) - this.height[0], this.width, this.height[0]);

        graphics.setColor(Color.RED);
        graphics.fillRect(300, image.getHeight(this) - this.height[1], this.width, this.height[1]);

        graphics.setColor(Color.GREEN);
        graphics.fillRect(550, image.getHeight(this) - this.height[2], this.width, this.height[2]);
    }

    public Dimension getPreferredSize(){
        return new Dimension(image.getWidth(this), image.getHeight(this));
    }
}
