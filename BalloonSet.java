import java.util.ArrayList;

public class BalloonSet {

    private static ArrayList<Balloon> balloons;
    private boolean isReady = true;

    public BalloonSet() {
        balloons = new ArrayList<Balloon>();
    }


    public void newSet(int ct) {
        if (isReady) {
            int roll = (int) (Math.random() * 100) + 1;

            if (roll <= 33) allSame(ct,"UP");
            else if (roll > 33 && roll <= 67) allSame(ct, "DOWN");
            else alternating(ct);
        }
    }

    
    public void move() {
        for (Balloon b : balloons) {
            b.move();
        }
    }


    public void allSame(int ct, String where) {
        int x = 50;
        int y = 0;

        if (where.equals("UP")) y = 100;
        else if (where.equals("DOWN")) y = 20;


        for (int i = 0; i < ct; i++) {
            balloons.add(new Balloon(x,y));
            x += 20;
        }
    }

    public void alternating(int ct) {
        int a = 0;
        int x = 50;

        for (int i = 0; i < ct; i++) {
            if (a == 0) {
                balloons.add(new Balloon(x, 100));
                a = 1;
            }
            else {
                balloons.add(new Balloon(x, 20));
                a = 0;
            }
        }
    }
    

    public void cleanUp() {
        Balloon b;
        for (int i = 0; i < balloons.size(); i++) {
            b = balloons.get(i);
            if (b.getX() <= 10) balloons.remove(b);
        }
    }

    public void update() {
        move();
        cleanUp();

        int randInt = (int) (Math.random() * 100) + 1;
        boolean feelingLikeIt = false;
        if (randInt <= 30) feelingLikeIt = true;

        if (balloons.size() <= 7 && feelingLikeIt) newSet((int) (Math.random() * 5) + 1);
    }
}