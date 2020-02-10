/**
 * Amdocs Test
 * 
 * Programming Problem: Mars Rovers
 */
package testcases;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import model.CardinalCompass;
import model.FaceRover;
import model.RoversMarsExceptions;

/**
 * Purpose: Testcases for FaceRover.
 * 
 * Date: 02/09/2020 
 * 
 * @author Jeremihas Caruso<jeremihas.caruso@gmail.com>
 *
 */
class FaceRoverTest {

    /**
     * FROM FaceRover
     * CALL the method gets first character
     * EXPECTED Character according to  cardinal compass
     */
    @Test
    void testGetFirstLetter() {
        assertEquals(CardinalCompass.NORTH, FaceRover.NORTH.getFirstLetter());
        assertEquals(CardinalCompass.EAST, FaceRover.EAST.getFirstLetter());
        assertEquals(CardinalCompass.SOUTH, FaceRover.SOUTH.getFirstLetter());
        assertEquals(CardinalCompass.WEST, FaceRover.WEST.getFirstLetter());
    }

    /**
     * FROM FaceRover
     * CALL the method turns left the face
     * EXPECTED FaceRover with new position
     */
    @Test
    void testTurnLeft() throws Exception {
        assertEquals(FaceRover.WEST, FaceRover.turnLeft(FaceRover.NORTH));
        assertEquals(FaceRover.NORTH, FaceRover.turnLeft(FaceRover.EAST));
        assertEquals(FaceRover.EAST, FaceRover.turnLeft(FaceRover.SOUTH));
        assertEquals(FaceRover.SOUTH, FaceRover.turnLeft(FaceRover.WEST));
    }

    /**
     * FROM null element
     * CALL the method tries to turn left
     * EXPECTED Exception message
     */
    @Test
    void testTurnLeftNull() {
        String eMessage = null;

        try {
            FaceRover.turnLeft(null);
        } catch (Exception e) {
            eMessage = e.getMessage();
        }

        assertEquals(RoversMarsExceptions.TURN_NULL, eMessage);
    }

    /**
     * FROM FaceRover
     * CALL the method turns right the face
     * EXPECTED FaceRover with new position
     */
    @Test
    void testTurnRight() throws Exception {
        assertEquals(FaceRover.EAST, FaceRover.turnRight(FaceRover.NORTH));
        assertEquals(FaceRover.SOUTH, FaceRover.turnRight(FaceRover.EAST));
        assertEquals(FaceRover.WEST, FaceRover.turnRight(FaceRover.SOUTH));
        assertEquals(FaceRover.NORTH, FaceRover.turnRight(FaceRover.WEST));
    }

    /**
     * FROM null element
     * CALL the method tries to turn right
     * EXPECTED Exception message
     */
    @Test
    void testTurnRightNull() {
        String eMessage = null;

        try {
            FaceRover.turnRight(null);
        } catch (Exception e) {
            eMessage = e.getMessage();
        }

        assertEquals(RoversMarsExceptions.TURN_NULL, eMessage);
    }

    /**
     * FROM CardinalCompass
     * CALL the method gets FaceRover
     * EXPECTED FaceRover according to CardinalCompass
     */
    @Test
    void testGetByFirstLetter() throws Exception {
        assertEquals(FaceRover.NORTH, FaceRover.getByFirstLetter(CardinalCompass.NORTH));
        assertEquals(FaceRover.EAST, FaceRover.getByFirstLetter(CardinalCompass.EAST));
        assertEquals(FaceRover.SOUTH, FaceRover.getByFirstLetter(CardinalCompass.SOUTH));
        assertEquals(FaceRover.WEST, FaceRover.getByFirstLetter(CardinalCompass.WEST));
    }

    /**
     * FROM CardinalCompass
     * CALL the method tries to get FaceRover
     * EXPECTED Exception message
     */
    @Test
    void testGetByFirstLetterNotIdentified() {
        String eMessage = null;

        try {
            FaceRover.getByFirstLetter('X');
        } catch (Exception e) {
            eMessage = e.getMessage();
        }

        assertEquals(RoversMarsExceptions.FACE_NOT_IDENTIFIED, eMessage);
    }
}
