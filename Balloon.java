import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.util.List;

public class Balloon extends MovingThing {
    private int speed;
    private Image image;
    public Balloon() {
        this(10, 10, 10, 10, 3);
    }
    public Balloon(int x, int y, int w, int h, int s) {
        super(x, y, w, h);
        speed=s;
        try
        {
            URL url = getClass().getResource("/images/balloon.png");
            image = ImageIO.read(url);
        }
            catch(Exception e)
        {
            System.out.println("guys balloons arent working idk what to do now");
        }
    }

    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int s) {
        speed = s;
    }

    public void draw(Graphics window) {
        window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
    }

    public void move() {
        setX(getX() - speed);
    }
}
