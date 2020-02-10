/**
 * Amdocs Test
 * 
 * Programming Problem: Mars Rovers
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Purpose: Store plateau informations about size and rovers added.
 * 
 * Date: 02/08/2020 
 * 
 * @author Jeremihas Caruso<jeremihas.caruso@gmail.com>
 *
 */
public class Plateau {
    private int x, y; // Plateau size
    private List<Rover> rovers = new ArrayList<Rover>(); // Rovers on plateau

    /**
     * Constructor
     */
    public Plateau() { }

    /**
     * Constructor with parameters
     *  
     * @param x
     * @param y
     */
    public Plateau(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Getters and Setters
     */
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public List<Rover> getRovers() {
        return rovers;
    }

    public void setRovers(List<Rover> rovers) {
        this.rovers = rovers;
    }

    /**
     * Add rover in plateau.
     * 
     * @param rover The rover to be added 
     */
    public void addRover(Rover rover) {
        this.rovers.add(rover);
    }

    /**
     * Validates position according to plateau border and occupation.
     * 
     * @param xPosition The horizontal position to be checked
     * @param yPosition The vertical position to be checked
     * 
     * @throws ExceptionIf out the plateau or position is occupied
     */
    public void validate (int xPosition, int yPosition) throws Exception {
        validateOutThePlateau(xPosition, yPosition);
        validateOccupation(xPosition, yPosition);
    }

    private void validateOutThePlateau(int xPosition, int yPosition) throws Exception {
        if (xPosition > this.x || yPosition > this.y
                || xPosition < 0 || yPosition < 0)
                throw new Exception(RoversMarsExceptions.OUT_THE_PLATEAU);
    }

    private void validateOccupation(int xPosition, int yPosition) throws Exception {
        for (Rover rover: this.rovers) {
            if (xPosition == rover.getXPosition() && yPosition == rover.getYPosition())
                    throw new Exception(RoversMarsExceptions.ROVERS_COLLISION);
        }
    }
}
