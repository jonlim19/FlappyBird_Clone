import java.awt.*;

public class Bird {
    private int speed;
    private Rectangle player;
    private boolean jump = false;
    public Bird(Rectangle player){
        this.player = player;
        speed = 5;
    }

    public void BirdMovement(){
        player.setLocation((int)player.getX(),(int)player.getY() + speed);
    }

    public int getSpeed() {
        return speed;
    }

    public Rectangle getPlayer() {
        return player;
    }

    public void setJump(boolean jump) {
        this.jump = jump;
    }

    public void BirdJump(){
        if(jump==true){
            player.setLocation((int)player.getX(),(int)player.getY() -75);
        }
    }

    public void colourBird(Graphics g){
        g.setColor(Color.white);
        g.fillRect((int)player.getX(),(int)player.getY(),(int)player.getWidth(),(int)player.getHeight());
    }
}
