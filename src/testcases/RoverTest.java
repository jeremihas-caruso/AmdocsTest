/**
 * Amdocs Test
 * 
 * Programming Problem: Mars Rovers
 */
package testcases;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.FaceRover;
import model.Moves;
import model.Plateau;
import model.Rover;
import model.RoversMarsExceptions;

/**
 * Purpose: Testcases for Rover.
 * 
 * Date: 02/09/2020 
 * 
 * @author Jeremihas Caruso<jeremihas.caruso@gmail.com>
 *
 */
class RoverTest {
    private static Plateau plateau;
    private static Rover rover;

    @BeforeEach
    void setUp() throws Exception {
        plateau = new Plateau(5, 6);
        rover = new Rover(3, 3, FaceRover.EAST);
    }

    /**
     * FROM Rover initialized before
     * CALL the method sets a negative horizontal positions
     * EXPECTED Exception message
     */
    @Test
    void testSetXPositionNegative() {
        String eMessage = null;

        try {
            rover.setXPosition(-1);
        } catch (Exception e) {
            eMessage = e.getMessage();
        }

        assertEquals(3, rover.getXPosition());
        assertEquals(3, rover.getYPosition());
        assertEquals(FaceRover.EAST, rover.getFace());
        assertEquals(RoversMarsExceptions.POSITION_NEGATIVE, eMessage);
    }

    /**
     * FROM Rover initialized before
     * CALL the method sets a negative verical positions
     * EXPECTED Exception message
     */
    @Test
    void testSetYPositionNegative() {
        String eMessage = null;
        
        try {
            rover.setYPosition(-1);
        } catch (Exception e) {
            eMessage = e.getMessage();
        }

        assertEquals(3, rover.getXPosition());
        assertEquals(3, rover.getYPosition());
        assertEquals(FaceRover.EAST, rover.getFace());
        assertEquals(RoversMarsExceptions.POSITION_NEGATIVE, eMessage);
    }

    /**
     * FROM Rover initialized before
     * CALL the method turns left the rover's face
     * EXPECTED Just face is changed according
     */
    @Test
    void testMoveTurnLeft() throws Exception {
        rover.move(Moves.LEFT, plateau);

        assertEquals(3, rover.getXPosition());
        assertEquals(3, rover.getYPosition());
        assertEquals(FaceRover.NORTH, rover.getFace());

        rover.move(Moves.LEFT, plateau);

        assertEquals(3, rover.getXPosition());
        assertEquals(3, rover.getYPosition());
        assertEquals(FaceRover.WEST, rover.getFace());

        rover.move(Moves.LEFT, plateau);

        assertEquals(3, rover.getXPosition());
        assertEquals(3, rover.getYPosition());
        assertEquals(FaceRover.SOUTH, rover.getFace());

        rover.move(Moves.LEFT, plateau);

        assertEquals(3, rover.getXPosition());
        assertEquals(3, rover.getYPosition());
        assertEquals(FaceRover.EAST, rover.getFace());
    }

    /**
     * FROM Rover initialized before
     * CALL the method turns right the rover's face
     * EXPECTED Just face is changed according
     */
    @Test
    void testMoveTurnRight() throws Exception {
        rover.move(Moves.RIGHT, plateau);

        assertEquals(3, rover.getXPosition());
        assertEquals(3, rover.getYPosition());
        assertEquals(FaceRover.SOUTH, rover.getFace());

        rover.move(Moves.RIGHT, plateau);

        assertEquals(3, rover.getXPosition());
        assertEquals(3, rover.getYPosition());
        assertEquals(FaceRover.WEST, rover.getFace());

        rover.move(Moves.RIGHT, plateau);

        assertEquals(3, rover.getXPosition());
        assertEquals(3, rover.getYPosition());
        assertEquals(FaceRover.NORTH, rover.getFace());

        rover.move(Moves.RIGHT, plateau);

        assertEquals(3, rover.getXPosition());
        assertEquals(3, rover.getYPosition());
        assertEquals(FaceRover.EAST, rover.getFace());
    }

    /**
     * FROM Rover initialized before
     * CALL the method moves forward the rover
     * EXPECTED Movement according the rover's face
     */
    @Test
    void testMove() throws Exception {
        rover.move(Moves.FORWARD, plateau);

        assertEquals(4, rover.getXPosition());
        assertEquals(3, rover.getYPosition());
        assertEquals(FaceRover.EAST, rover.getFace());

        rover.move(Moves.RIGHT, plateau);
        rover.move(Moves.FORWARD, plateau);

        assertEquals(4, rover.getXPosition());
        assertEquals(2, rover.getYPosition());
        assertEquals(FaceRover.SOUTH, rover.getFace());

        rover.move(Moves.RIGHT, plateau);
        rover.move(Moves.FORWARD, plateau);

        assertEquals(3, rover.getXPosition());
        assertEquals(2, rover.getYPosition());
        assertEquals(FaceRover.WEST, rover.getFace());

        rover.move(Moves.RIGHT, plateau);
        rover.move(Moves.FORWARD, plateau);

        assertEquals(3, rover.getXPosition());
        assertEquals(3, rover.getYPosition());
        assertEquals(FaceRover.NORTH, rover.getFace());
    }

    /**
     * FROM Rover initialized before
     * CALL the method tries to use a invalid movement
     * EXPECTED Exception message
     */
    @Test
    void testMoveNotIdentified() {
        String eMessage = null;

        try {
            rover.move('X', plateau);
        } catch (Exception e) {
            eMessage = e.getMessage();
        }

        assertEquals(3, rover.getXPosition());
        assertEquals(3, rover.getYPosition());
        assertEquals(FaceRover.EAST, rover.getFace());
        assertEquals(RoversMarsExceptions.MOVIMENT_NOT_IDENTIFIED, eMessage);
    }
}
