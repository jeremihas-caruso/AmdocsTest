/**
 * Amdocs Test
 * 
 * Programming Problem: Mars Rovers
 */
package model;

/**
 * Purpose: Indentify and turn a face rover.
 * 
 * Date: 02/08/2020 
 * 
 * @author Jeremihas Caruso<jeremihas.caruso@gmail.com>
 *
 */
public enum FaceRover {
    NORTH(CardinalCompass.NORTH), // Face to North
    EAST(CardinalCompass.EAST), // Face to East
    SOUTH(CardinalCompass.SOUTH), // Face to South
    WEST(CardinalCompass.WEST); // Face to West

    private final char firstLetter;

    /**
     * Constructor
     */
    FaceRover(char firstLetter) {
        this.firstLetter = firstLetter;
    }

    /**
     * Getter
     */
    public char getFirstLetter() {
        return this.firstLetter;
    }

    /**
     * Changes rover's face turning left.
     * 
     * @return FaceRover Rover's face after turn left
     * 
     * @throws Exception If face input is null
     */
    public static FaceRover turnLeft(FaceRover faceRover) throws Exception {
        if(faceRover == null) {
            throw new Exception(RoversMarsExceptions.TURN_NULL);
        }

        switch (faceRover) {
            case NORTH: return WEST; 
            case EAST: return NORTH; 
            case SOUTH: return EAST; 
            default: return SOUTH;
        }
    }

    /**
     * Changes rover's face turning right.
     * 
     * @return FaceRover Rover's face after turn right
     * 
     * @throws Exception If face input is null
     */
    public static FaceRover turnRight(FaceRover faceRover) throws Exception {
        if(faceRover == null) {
            throw new Exception(RoversMarsExceptions.TURN_NULL);
        }

        switch (faceRover) {
            case NORTH: return EAST; 
            case EAST: return SOUTH; 
            case SOUTH: return WEST; 
            default: return NORTH;
        }
    }

    /**
     * Gets rover's face from first letter.
     * 
     * @return integer according rover's face after turn left
     * 
     * @throws Exception If can not identify first letter
     */
    public static FaceRover getByFirstLetter(char letter) throws Exception {
        switch (letter) {
            case CardinalCompass.NORTH: return NORTH; 
            case CardinalCompass.EAST: return EAST; 
            case CardinalCompass.SOUTH: return SOUTH; 
            case CardinalCompass.WEST: return WEST;

            default:
                throw new Exception(RoversMarsExceptions.FACE_NOT_IDENTIFIED);
        }
    }
}
