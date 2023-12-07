import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.util.List;
import java.util.ArrayList;

public class Balloon extends MovingThing {
    private int speed;
    private Image image;
    private static ArrayList<Balloon> balloons = new ArrayList<Balloon>();
    private static int defW = 10;
    private static int defH = 10;
    private static int defS = 3;
    private static int defX = 50;
    private static int defY = 100;


    public Balloon() {
        this(defX, defY, defW, defH, defS);
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
        balloons.add(this);
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

    public void move(String dir) {
        if (dir.equals("UP")) setY(getY() + speed);
        else if (dir.equals("DOWN")) setY(getY() - speed);
        else if (dir.equals("RIGHT")) setX(getX() + speed);
        else if (dir.equals("LEFT")) setX(getX() - speed);
    }

    public static void moveAll() {
        for (Balloon b : balloons) {
            b.move();
        }
    }

    public static void newSet(int ct) {
        int rand = (int) (Math.random() * 100) + 1;

        if (rand <= 33) allSame(ct,"UP");
        else if (rand > 33 && rand <= 67) allSame(ct, "DOWN");
        else alternating(ct);
    }


    public static void allSame(int ct, String where) {
        int x = 50;
        int y = 0;

        if (where.equals("UP")) y = 100;
        else if (where.equals("DOWN")) y = 20;


        for (int i = 0; i < ct; i++) {
            balloons.add(new Balloon(x,y,defW, defH, defS));
            x += 20;
        }
    }

    public static void alternating(int ct) {
        int a = 0;
        int x = 50;

        for (int i = 0; i < ct; i++) {
            if (a == 0) {
                balloons.add(new Balloon(x, 100, defW, defH, defS));
                a = 1;
            }
            else {
                balloons.add(new Balloon(x, 20, defW, defH, defS));
                a = 0;
            }
        }
    }
    

    public static void cleanUp() {
        Balloon b;
        for (int i = 0; i < balloons.size(); i++) {
            b = balloons.get(i);
            if (b.getX() <= 10) balloons.remove(b);
        }
    }
}