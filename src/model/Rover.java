/**
 * Amdocs Test
 * 
 * Programming Problem: Mars Rovers
 */
package model;

/**
 * Purpose: Store rover informations about position and facing.
 * 
 * Date: 02/08/2020 
 * 
 * @author Jeremihas Caruso<jeremihas.caruso@gmail.com>
 *
 */
public class Rover {
    private int xPosition, yPosition; // Positions
    private FaceRover faceRover; // Facing

    /**
     * Constructor
     */
    public Rover() { }

    /**
     * Constructor with parameters.
     * 
     * @param xPosition Horizontal position
     * @param yPosition Vertical position
     * @param faceRover Facing direction     
     * 
     * @throws Exception 
     */
    public Rover(int xPosition, int yPosition, FaceRover faceRover) throws Exception {
        this.setXPosition(xPosition);
        this.setYPosition(yPosition);
        this.setFace(faceRover);
    }

    /**
     * Getters and Setters
     */
    public int getXPosition() {
        return xPosition;
    }

    public void setXPosition(int xPosition) throws Exception {
        if(xPosition < 0) {
            throw new Exception(RoversMarsExceptions.POSITION_NEGATIVE);
        }

        
        this.xPosition = xPosition;
    }

    public int getYPosition() {
        return yPosition;
    }

    public void setYPosition(int yPosition) throws Exception {
        if(yPosition < 0) {
            throw new Exception(RoversMarsExceptions.POSITION_NEGATIVE);
        }

        this.yPosition = yPosition;
    }

    public FaceRover getFace() {
        return faceRover;
    }

    public void setFace(FaceRover face) {
        this.faceRover = face;
    }

    /**
     * Rover moves forward according facing.
     * 
     * @throws Exception 
     */
    private void moveForward(Plateau plateau) throws Exception {
        switch (this.faceRover) {
            case NORTH: // Face to North
                this.yPosition += 1;
                break;

            case EAST: // Face to East
                this.xPosition += 1;
                break;

            case SOUTH: // Face to South
                this.yPosition -= 1;
                break;

            case WEST: // Face to West
                this.xPosition -= 1;
                break;
        }

        plateau.validate(this.xPosition, this.yPosition);
    }

    /**
     * Moves rover according character.
     * 
     * @param move Character of the movement
     * @param plateau The plateau to be checked when rover moves
     * 
     * @throws Exception Case movement is not indentified
     */
    public void move(char move, Plateau plateau) throws Exception {
        switch (move) {
            case Moves.LEFT:
                this.faceRover = FaceRover.turnLeft(this.faceRover);
                break;

            case Moves.RIGHT:
                this.faceRover = FaceRover.turnRight(this.faceRover);
                break;

            case Moves.FORWARD:
                this.moveForward(plateau);
                break;

            default:
                throw new Exception(RoversMarsExceptions.MOVIMENT_NOT_IDENTIFIED);
        }
    }
}
