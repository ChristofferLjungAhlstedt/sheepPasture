import java.awt.Point;
import java.util.Iterator;

public abstract class LivingThing implements Entity {

    protected Point position;
    protected Pasture pasture;

    @Override
    public Point getPosition() {
        return position;
    }
    @Override
    public void setPosition(Point newPosition) {
        position = newPosition;

    }

    public void die() {
        this.pasture.removeEntity(this);
    }

    public boolean occupied() {
        Iterator<Entity> it = this.pasture.getEntities().iterator();
        String selfType = this.type();
        while (it.hasNext()) {
            Entity object = it.next(); 
            Point usedSpace = object.getPosition();
            if((usedSpace.equals(this.position)) && (this != object) && (object.type().equals(selfType))){
                return true;
            }
        }
        return false;
    }
}
