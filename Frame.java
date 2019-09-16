import javax.swing.*;
import java.awt.*;

public class Frame {
    GamePanel panel = new GamePanel();

    public Frame(){
        JFrame frame = new JFrame("FlappyBirds");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(600,600));
        frame.pack();
        frame.add(panel);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args){
        new Frame();
    }
}
