import javax.swing.*;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.*;

public class Dummy implements Entity {
    int[] possibleMovesX = {-1,
        0,
        1
    };
    int[] possibleMovesY = {-1,
        0,
        1
    };
    int choosenDirX;
    int choosenDirY;
    int borderMin = 0;
    int borderMaxY = 19; //Border -1
    int borderMaxX = 24; //Border -1

    private final ImageIcon image = new ImageIcon("unknown.gif");

    protected Point position;

    protected Pasture pasture;

    public Dummy(Pasture pasture) {
        this.pasture = pasture;
    }

    public Dummy(Pasture pasture, Point position) {
        this.pasture = pasture;
        this.position = position;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point newPosition) {
        position = newPosition;
    }

    public int chooseDirX() {
        int randomX = ThreadLocalRandom.current().nextInt(0, 2 + 1);
        if ((int) getPosition().getX() == borderMaxX) {
            choosenDirX = -1;
        } else if ((int) getPosition().getX() == borderMin) {
            choosenDirX = 1;
        } else {
            choosenDirX = possibleMovesX[randomX];
        }
        return choosenDirX;
    }

    public int chooseDirY() {
        int randomY = ThreadLocalRandom.current().nextInt(0, 2 + 1);
        if ((int) getPosition().getY() == borderMaxY) {
            choosenDirY = -1;
        } else if ((int) getPosition().getY() == borderMin) {
            choosenDirY = 1;
        } else {
            choosenDirY = possibleMovesX[randomY];
        }

        return choosenDirY;
    }

    public void tick() {

        System.out.println(position);
        setPosition(new Point((int) getPosition().getX() + chooseDirX(), (int) getPosition().getY() + chooseDirY()));

    }

    public String type() {
        return "Dummy";
    }

    public ImageIcon getImage() {
        return image;
    }
}