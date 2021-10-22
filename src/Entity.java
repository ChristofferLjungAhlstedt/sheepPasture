import javax.swing.*;
import java.awt.*;

/**
 * This is the superclass of all entities in the pasture simulation
 * system. This interface <b>must</b> be implemented by all entities
 * that exists in the simulation of the pasture.
 * @see Pasture
 * @see PastureGUI
 */
public interface Entity {

    /**
     * Returns the position of this entity in the simulation system.
     * @return the position of this entity.
     * @see Pasture
     * @see Point
     */
    public Point getPosition();

    /**
     * Sets the position of this entity.
     * @param newPosition the new position of this entity.
     * @see Point
     */
    public void setPosition(Point newPosition);

    /**
     * Performs the relevant actions of this entity, depending on what
     * kind of entity it is.
     */
    public void tick();

    /** 
     * Returns the icon of this entity, to be displayed by the pasture
     * gui. 
     * @see PastureGUI
     */
    public ImageIcon getImage();

    /**
     * Returns the name of the entity
     */
    public String type();
}