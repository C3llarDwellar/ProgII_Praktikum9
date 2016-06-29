import java.awt.*;

/**
 * Created by Edwin on 29/06/2016.
 */
public class Bars {
    int width = 20;
    int height1, height2, height3;

    public Bars(int height1, int height2, int height3){
        this.height1 = height1;
        this.height2 = height2;
        this.height3 = height3;
    }

    public void paint(Graphics bars){
        bars.drawRect(0, 0, this.width, this.height1);
        bars.drawRect(0, 0, this.width, this.height2);
        bars.drawRect(0, 0, this.width, this.height3);
    }
}
