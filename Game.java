import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Game extends Canvas implements KeyListener, Runnable
{
  //uncomment when ready
  
  // private Character char;
  private BalloonSet balloons;
  private ObstacleSet obstacles;
  private ObstacleSet bullets;

  // pause/end game
  private boolean pause = false;
  private boolean end = false;
  private int score = 0;
  private int lives = 0;

  //functionality
  private boolean[] keys;
  private File bg = new File("/images/Parallax_No_Car.gif");
  private BufferedImage back = ImageIO.read(bg);

  //timing
  private long lastObstacle; //seconds since the last obstacle was summoned
  private long lastBullet; //seconds since the last bullet was summoned
  // private long lastBalloon; //seconds since the last balloon was summoned

  //constructor
  public Game(String charChoice) {
    setBackground(Color.black); // maybe we can change the background in the future?
    keys = new boolean[1];

    // char = new Character(charChoice, x, y, w, h);
    balloons = new BalloonSet();
    obstacles = new ObstacleSet();
    bullets = new ObstacleSet();

    this.addKeyListener(this);
    new Thread(this).start();

    setVisible(true); 
  
    Character charter = new Character();

  }

  public void update(Graphics window)
  {
    paint(window);
  }

  public void paint(Graphics window) {
    if (end) {
      return;
    }
    if (pause) {
      if(keys[0]) {
        pause = false;
        keys[0] = false;
      }
      else {
        return;
      }
    }

    Graphics2D twoDGraph = (Graphics2D)window;
    if (back==null) {
      back = (BufferedImage)(createImage(getWidth(),getHeight()));
    }
    Graphics graphToBack = back.createGraphics();
    graphToBack.setColor(Color.BLUE);
    graphToBack.drawString("game title", 25, 50);
    graphToBack.setColor(Color.BLACK);
    graphToBack.fillRect(0,0,800,600);

    // char.draw(graphToBack);
    balloons.update();
    obstacles.draw(graphToBack);
    bullets.draw(graphToBack);
    graphToBack.drawString("score : " + score, 25, 25);
    graphToBack.drawString("lives : " + lives, 25, 50);

    //uncomment when ready
     if (keys[0]) {
       charter.jump();
     }

    // add random obstacle after 1-4 seconds
    if(System.currentTimeMillis() - lastObstacle > Math.random()*300+100) {
      obstacles.add(new Obstacle());
      lastObstacle = System.currentTimeMillis();
    }

    //things that need to be added:
    //add balloon after some amount of seconds (use lastBalloon and System.currentTimeMillis())
    //adding bullets after some amount of seconds (use lastBullet and System.currentTimeMillis())
    // getting hit and losing a life
    // getting hit and losing the game

    twoDGraph.drawImage(back,null,0,0);
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
    //empty
  }

  public void run() {
    try {
      while(true) {
        Thread.currentThread().sleep(5);
      }
    } catch(Exception e) {
    }
  }
  
}
