// import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;

// import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
// import java.util.List;

public class Obstacle extends MovingThing {
  private int speed;
  private Image image;

  public Obstacle() {
    super(10,10,10,10);
    speed=5;
      try {
		  URL url = getClass().getResource("/images/chair.png");
      image = ImageIO.read(url);
	  }
	  catch(Exception e) {
		  //empty
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
      image = ImageIO.read(url);
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

    public void move(String s) {
        setX(getX()-speed);
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
