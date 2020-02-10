/**
 * Amdocs Test
 * 
 * Programming Problem: Mars Rovers
 */
package testcases;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import model.FaceRover;
import model.Plateau;
import model.Rover;
import model.RoversMarsExceptions;

/**
 * Purpose: Testcases for Plateau.
 * 
 * Date: 02/09/2020 
 * 
 * @author Jeremihas Caruso<jeremihas.caruso@gmail.com>
 *
 */
class PlateauTest {
    private static Plateau plateau;
    private static Rover rover;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        plateau = new Plateau(5, 6);
        rover = new Rover(3, 3, FaceRover.EAST);

        plateau.addRover(rover);
    }

    /**
     * FROM Rover initialized before
     * CALL the method gets positions and face
     * EXPECTED Same parameters initialized
     */
    @Test
    void testAddRover() {
        assertEquals(5, plateau.getX());
        assertEquals(6, plateau.getY());
        assertEquals(rover, plateau.getRovers().get(0));
    }

    /**
     * FROM Rover initialized before
     * CALL the method validates position
     * EXPECTED The position is inner plateau and is not occupied
     */
    @Test
    void testValidate() throws Exception {
        plateau.validate(2, 3);

        assertEquals(5, plateau.getX());
        assertEquals(6, plateau.getY());
        assertEquals(rover, plateau.getRovers().get(0));
    }

    /**
     * FROM Rover initialized before
     * CALL the method validates position
     * EXPECTED Exception message with the position is occupied
     */
    @Test
    void testValidateCollision() {
        String eMessage = null;

        try {
            plateau.validate(3, 3);
        } catch (Exception e) {
            eMessage = e.getMessage();
        }

        assertEquals(5, plateau.getX());
        assertEquals(6, plateau.getY());
        assertEquals(rover, plateau.getRovers().get(0));
        assertEquals(RoversMarsExceptions.ROVERS_COLLISION, eMessage);
    }

    /**
     * FROM Rover initialized before
     * CALL the method validates position
     * EXPECTED Exception message with the position is out the plateau
     */
    @Test
    void testValidateOutPlateau() {
        String eMessage = null;

        try {
            plateau.validate(-1, 0);
        } catch (Exception e) {
            eMessage = e.getMessage();
        }

        assertEquals(5, plateau.getX());
        assertEquals(6, plateau.getY());
        assertEquals(rover, plateau.getRovers().get(0));
        assertEquals(RoversMarsExceptions.OUT_THE_PLATEAU, eMessage);
    }
}
