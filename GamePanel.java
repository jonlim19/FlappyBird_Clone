import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements KeyListener {
    private boolean running = true;
    private int pressedKey;
    private Bird bird = new Bird(new Rectangle(50, 250, 50, 50));
    private Pillar pillar = new Pillar(bird);
    private JPanel background;
    public static int screenWidth;
    public static int screenHeight;

    public GamePanel(){
        background = new JPanel();
        setBackground(Color.lightGray);
        screenWidth = background.getWidth();
        screenHeight = background.getHeight();
        addKeyListener(this);
        setFocusable(true);
        setPreferredSize(new Dimension(600,600));
        GameLoop gameLoop = new GameLoop();
        new Thread(gameLoop).start();
    }

    class GameLoop extends Thread {  // Gameloopfor udpdating all with 60 FPS
        private static final int FPS = 60;
        private static final long maxLoopTime = 1000 / FPS;

        @Override
        public void run() {
            long timestamp;
            long oldTimestamp;

            while (running == true) {

                oldTimestamp = System.currentTimeMillis();

                timestamp = System.currentTimeMillis();

                updateGameObjects();
                updateScreen();

                if (timestamp - oldTimestamp <= maxLoopTime) {

                    try {
                        Thread.sleep(maxLoopTime - (timestamp - oldTimestamp));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }


    }
    public void updateGameObjects() {
        bird.BirdMovement();
        if(bird.isJump()==true){
            bird.BirdJump();
            bird.setJump(false);
        }
    }

    public void updateScreen() { // repaint Screen
        super.repaint();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        bird.colourBird(g);
    }
    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent event) {
        pressedKey = event.getKeyCode();
        if(pressedKey== KeyEvent.VK_UP){
            bird.setJump(true);
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
