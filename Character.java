import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.util.List;

public class Character 
{
  private Image image;

  public Character(String o, int x, int y, int w, int h, int s) { 
    super(x,y,w,h);
    try {
      URL url = getClass().getResource(o+".png");
    }
    catch(Exception e) {
      //empty
    }
  }

  public void jump() {
    //make char jump
  }

  public void draw(Graphics window) {
    window.drawImage(image, getX(), getY(), getWidth(), getHeight(), null);
  }

  public String toString() {
    return super.toString();
}
