import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Game extends Canvas implements KeyListener, Runnable
{
    private Character charter;
    private BalloonSet balloons;
    private ObstacleSet obstacles;
    private ObstacleSet bullets;
    private BufferedImage backg;

    private String bgLocation = "images/bg.jpg";
    private File bg;

    // pause/end game
    private boolean pause = false;
    private boolean end = false;
    private int score = 0;
    private int lives = 0;

    // functionality
    private boolean[] keys;

    // timing
    private long lastObstacle; // seconds since the last obstacle was summoned
    private long lastBullet; // seconds since the last bullet was summoned
    private long lastBalloon; // seconds since the last balloon was summoned

    // constructor
    public Game(String charChoice) {
        try {
            bg = new File(bgLocation);
        } catch (Exception f) {
            System.out.println("Couldn't open bg file");
        }

        try {
            backg = ImageIO.read(bg);
        } catch (IOException e) {
            System.out.println("Couldn't load background");
        }

        setBackground(Color.black);
        keys = new boolean[1];

        balloons = new BalloonSet();
        obstacles = new ObstacleSet();
        bullets = new ObstacleSet();

        lastBalloon = 0;
        lastObstacle = 0;
        lastBullet = 0;

        this.addKeyListener(this);
        new Thread(this).start();

        setVisible(true);

        charter = new Character(charChoice, 20, 20, 20, 20, 3);
    }

    public void update(Graphics window) {
        paint(window);
    }

    public void paint(Graphics window) {
        if (end) {
            return;
        }
        if (pause) {
            if (keys[0]) {
                pause = false;
                keys[0] = false;
            } else {
                return;
            }
        }

        Graphics2D twoDGraph = (Graphics2D) window;

        if (backg != null) {
            twoDGraph.drawImage(backg, 0, 0, this);
        }

        balloons.update(charter);
        obstacles.draw(twoDGraph);
        bullets.draw(twoDGraph);
        twoDGraph.drawString("score : " + score, 25, 25);
        twoDGraph.drawString("lives : " + lives, 25, 50);

        if (keys[0]) {
            charter.jump();
        }

        if (System.currentTimeMillis() - lastObstacle > Math.random() * 300 + 100) {
            obstacles.add(new Obstacle());
            lastObstacle = System.currentTimeMillis();
        }

        if (System.currentTimeMillis() - lastBullet > Math.random() * 300 + 100) {
            obstacles.add(new Obstacle("bullet", 100, 100, 10, 10, 5));
            lastBullet = System.currentTimeMillis();
        }
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            keys[0] = true;
        }
        repaint();
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            keys[0] = false;
        }
        repaint();
    }

    public void keyTyped(KeyEvent e) {
        // empty
    }

    public void run() {
        try {
            while (true) {
                Thread.currentThread().sleep(5);
            }
        } catch (Exception e) {
        }
    }
}
