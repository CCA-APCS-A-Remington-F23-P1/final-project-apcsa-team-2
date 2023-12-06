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

  // pause/end game
  boolean pause = false;
  boolean end = false;

  private boolean[] keys;
  private BufferedImage back;
  private int score = 0;
  private int lives = 0;
}
