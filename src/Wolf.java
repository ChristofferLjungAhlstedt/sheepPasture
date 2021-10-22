import javax.swing.ImageIcon;
import java.awt.Point;

public class Wolf extends Animal {
    private final ImageIcon image = new ImageIcon("wolf.gif");
    String food = "Sheep";

    public Wolf(Pasture pasture, Point position) {
        this.pasture = pasture;
        this.position = position;
    }

    @Override
    public void tick() {
        if (canMakeBebe()) {
            makeBebe();
        }
        move();
        onEntityAndEatIfFood(food);
        battleForLivingSpace();
    }

    public void makeBebe() {
        Entity wolf = new Wolf(pasture, position);
        this.pasture.addEntity(wolf);
    }

    @Override
    public ImageIcon getImage() {
        return image;
    }

    @Override
    public String type() {
        return "Wolf";
    }
}
