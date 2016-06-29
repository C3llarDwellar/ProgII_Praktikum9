import java.awt.*;

/**
 * Created by Edwin on 29/06/2016.
 */
public class Bars extends Panel{
    private int width = 200;
    private int height1, height2, height3, panelHeight, panelWidth;
    private Image image;

    public Bars(int height1, int height2, int height3, Image image){
        this.height1 = height1 * 10;
        this.height2 = height2 * 10;
        this.height3 = height3 * 10;
        this.image = image;
    }
    public void paint(Graphics graphics){
        graphics.drawImage(image, 0, 0, this);

        graphics.setColor(Color.BLUE);
        graphics.fillRect(50, 750 - this.height1, this.width, this.height1);

        graphics.setColor(Color.RED);
        graphics.fillRect(300, 750 - this.height2, this.width, this.height2);

        graphics.setColor(Color.GREEN);
        graphics.fillRect(550, 750 - this.height3, this.width, this.height3);
    }

    public Dimension getPreferredSize(){
        return new Dimension(image.getWidth(this), image.getHeight(this));
    }
}
