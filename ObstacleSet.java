import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.List;

public class ObstacleSet {
    private List<Obstacle> obstacles;

    public ObstacleSet() {
        obstacles = new ArrayList<Obstacle>();
    }

    public void add(Obstacle o) {
        obstacles.add(o);
    }

    public void draw(Graphics window) {
        for (Obstacle o : obstacles) {
            o.draw(window);
        }
    }

    public void move() {
        for (Obstacle o : obstacles) {
            o.move();
        }
    }

    public int size() {
        return obstacles.size();
    }

}


