import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.util.List;

public class Obstacle extends MovingThing {
  private int speed;
  private Image image;

  public Obstacle() {
    // generate random obstacle
    int rand = (int) Math.random()*3;
    if (rand==0) {
    }
    if (rand==1) {
    }
    if (rand==2) {
    }
  }

  // o => obstacle type.. (spike, etc.)
  // w => width
  // h => height
  // s => speed
  public Obstacle(String o, int x, int y, int w, int h, int s) {
	  super(x, y, w,h);
	  speed=s;
	  //image
	  try {
		  URL url = getClass().getResource(o+".png");
	  }
	  catch(Exception e) {
		  //empty
	  }
  }

    public void setSpeed(int s) {
        speed = s;
    }

    public int getSpeed() {
        return speed;
    }

    public void move() {
        setX(getX()-speed);
    }

	public void draw(Graphics window) {
		window.drawImage(image, getX(), getY(), getWidth(), getHeight(), null);
	}

	public String toString() {
		return super.toString() + " " + getSpeed();
	}
}
