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

public class Game extends Canvas implements KeyListener, Runnable
{
  //uncomment when ready
  
  // private Character char;
  private List<Balloon> balloons;
  private List<Obstacles> obstacles;
  private List<Obstacles> bullets;

  // pause/end game
  private boolean pause = false;
  private boolean end = false;
  private int score = 0;
  private int lives = 0;

  //functionality
  private boolean[] keys;
  private BufferedImage back;

  //timing
  private long lastObstacle; //seconds since the last obstacle was summoned
  private long lastBullet; //seconds since the last bullet was summoned
  private long lastBalloon; //seconds since the last balloon was summoned

  //constructor
  public Game(String charChoice) {
    setBackground(Color.black); // maybe we can change the background in the future?
    keys = new boolean[1];

    // char = new Character(charChoice, x, y, w, h);
    balloons = new List<Balloons>;
    obstacles = new List<Obstacles>;
    bullets = new List<Obstacles>;

    this.addKeyListener(this);
    new Thread(this).start();

    setVisible(true);  
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
    graphToBack.setColor(Color.PURPLE);
    graphToBack.drawString("game title", 25, 50);
    graphToBack.setColor(Color.BLACK);
    graphToBack.fillRect(0,0,800,600);

    // char.draw(graphToBack);
    for (Balloon b: balloons) {
      b.draw();
    }
    for (Obstacle o : obstacles) {
      o.draw();
    }
    for (Obstacle o : bullets) {
      o.draw();
    }

    

  
}
