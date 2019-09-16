import java.awt.*;
import java.util.Random;
public class Pillar {
    private int width;
    private int height;
    private Bird player;
    private Random generate = new Random();
    private Rectangle top;
    private Rectangle bottom;
    public Pillar(Bird player){
        int location = generate.nextInt(120)+100;
        this.player = player;
        this.width = 30;
        this.height = generate.nextInt(100);
        this.bottom = new Rectangle(location,0,width,height);
        this.bottom = new Rectangle(location,GamePanel.screenWidth,width,height);
    }

    public void generateTopPillars(){

    }
}
