import javax.swing.*;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.*;

public class Plant extends LivingThing {
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
    int grow = 10; //when next plant will grow //ska vara lägrä
    int seed = 0; //counts ticks for when next plant will grow

    private final ImageIcon image = new ImageIcon("Plant.gif");


    public Plant(Pasture pasture, Point position) {
        this.pasture = pasture;
        this.position = position;
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
        seed++;
        if (seed == grow) { //When to grow
            makeNewPlant();
            seed = 0;
        }
        if(occupied()) {
            die();
        }
    }

    public void makeNewPlant() {
        Point newPlantPosition = new Point((int) getPosition().getX() + chooseDirX(), (int) getPosition().getY() + chooseDirY());
        Entity plant = new Plant(pasture, newPlantPosition);
        this.pasture.addEntity(plant);
    }

    public String type() {
        return "Plant";
    }

    public ImageIcon getImage() {
        return image;
    }
}