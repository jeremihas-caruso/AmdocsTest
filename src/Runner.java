/**
 * Amdocs Test
 * 

 */
import java.util.Scanner;

import model.FaceRover;
import model.Plateau;
import model.Rover;

/**
 * Runner program
 * 
 * @author Jeremihas Caruso<jeremihas.caruso@gmail.com>
 *
 */
public class Runner {
	private static final String SPLIT_SEPARATION = " ";

	/**
	 * Main program
	 * 
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		// Process the plateau input
		System.out.print("Enter dimensions of the plateau (in the form x y):");
		String input = scanner.nextLine();

		if(!validateInput(input)) return;

        Plateau plateau = new Plateau(getXPlateu(input),
				  					  getYPlateu(input));

		// Process the rovers input
        Rover rover = null;
        while(true) {
    		// Process the rover initial position and face input
			System.out.print("Enter drop information for the rover (in the form x y h):");
			input = scanner.nextLine();

			if(!validateInput(input)) return;
			
			rover = new Rover(getXPosition(input),
        					  getYPosition(input),
        					  getFaceRover(input));

    		// Process the instruction for the rover
			System.out.print("Enter instructions for the rover (in the form LMRMMMLMM):");
			input = scanner.nextLine();

			if(!validateInput(input)) return;

			movingRover(input, rover, plateau);

			plateau.addRover(rover);

			// Print output for the rover
			System.out.println(rover.getXPosition() + " " + rover.getYPosition() + " " + rover.getFace().getFirstLetter());
        }
	}

	private static void movingRover(String line, Rover rover, Plateau plateau) throws Exception {
		for (int i = 0; i < line.length(); i++) {
			rover.move(line.charAt(i), plateau);
		}
	}

	private static int getXPlateu(String line) {
        String[] lineStringArray = line.split(SPLIT_SEPARATION);

		return Integer.parseInt(lineStringArray[0]);
	}

	private static int getYPlateu(String line) {
        String[] lineStringArray = line.split(SPLIT_SEPARATION);

		return Integer.parseInt(lineStringArray[1]);
	}

	private static int getXPosition(String line) {
        String[] lineStringArray = line.split(SPLIT_SEPARATION);

		return Integer.parseInt(lineStringArray[0]);
	}

	private static int getYPosition(String line) {
        String[] lineStringArray = line.split(SPLIT_SEPARATION);

		return Integer.parseInt(lineStringArray[1]);
	}

	private static FaceRover getFaceRover(String line) throws Exception {
        String[] lineStringArray = line.split(SPLIT_SEPARATION);

		return FaceRover.getByFirstLetter(lineStringArray[2].charAt(0));
	}

	private static boolean validateInput(String input) {
		if(input.trim().isEmpty()) {
			System.out.println("Mars Rovers finished");
			return false;
		}

		return true;
	}
}
