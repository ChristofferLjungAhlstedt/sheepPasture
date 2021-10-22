import javax.swing.ImageIcon;
import java.awt.Point;

public class Sheep extends Animal {
    private final ImageIcon image = new ImageIcon("sheep.gif");
    String food = "Plant";

    public Sheep(Pasture pasture, Point position) {
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
        Entity sheep = new Sheep(pasture, position);
        this.pasture.addEntity(sheep);
    }

    @Override
    public ImageIcon getImage() {
        return image;
    }

    @Override
    public String type() {
        return "Sheep";
    }
}