import java.util.Scanner;
import java.util.Random;

public class PotHoleDriving {

	// The 10x10 playing grid
	String[][] grid = new String[10][10];

	// Track player's position: row = Y direction, col = X direction
	int playerRow = 0; // vertical movement
	int playerCol = 0; // horizontal movement

	Scanner input = new Scanner(System.in); // scanner for user input
	Random rng = new Random(); // random generator for potholes

	public static void main(String[] args) {
		PotHoleDriving game = new PotHoleDriving(); // create game object
		game.start();
	}

	public void start() {
		boolean playAgain = true;
		while (playAgain) {
			setupGrid(); // reset the grid for a new round
			boolean gameOver = false;

			System.out.println("Welcome to Pothole Driving!  Get home while");
			System.out.println("avoiding potholes!\n");

			while (!gameOver) {
				printGrid(); // show the board each turn
				System.out.println();
				System.out.println("Enter either a -1, 0, or 1 in the X or 9 to quit");
				int moveX = input.nextInt(); // X-direction movement
				if (moveX == 9) {
					System.out.println("Game quit!");
					return;
				}
				System.out.println("Enter either a -1,0, or 1 in the Y");
				int moveY = input.nextInt(); // Y-direction movement

				gameOver = makeMove(moveX, moveY); // attempt the move

				// Check win condition
				if (playerRow == 9 && playerCol == 9) {
					printGrid();
					System.out.println("You reached the goal!");
					gameOver = true;
				}
			}

			// Ask to replay after win or loss
			System.out.print("Would you like to play again? (yes/no): ");
			String ans = input.next();
			if (!ans.equalsIgnoreCase("yes")) {
				playAgain = false;
				System.out.println("Goodbye!");
			}
		}
	}

	public void setupGrid() {
		// reset player start position
		playerRow = 0;
		playerCol = 0;

		// fill grid with empty spaces
		for (int r = 0; r < 10; r++) {
			for (int c = 0; c < 10; c++) {
				grid[r][c] = "_";
			}
		}

		// place 5 random potholes in safe positions
		int potholesPlaced = 0;
		while (potholesPlaced < 5) {
			int r = rng.nextInt(10);
			int c = rng.nextInt(10);
			if ((r == 0 && c == 0) || (r == 9 && c == 9))
				continue; // skip start/goal
			if (!grid[r][c].equals("#")) {
				grid[r][c] = "#"; // pothole
				potholesPlaced++;
			}
		}

		// place goal and starting position
		grid[9][9] = "^";
		grid[playerRow][playerCol] = "X";
	}

	// Handles a single player move
	public boolean makeMove(int dx, int dy) {
		// clear old player position unless at the goal
		if (!(playerRow == 9 && playerCol == 9)) {
			grid[playerRow][playerCol] = "_";
		}

		// update position
		playerRow += dy;
		playerCol += dx;

		// bounds check (keep within 0-9 range)
		if (playerRow < 0)
			playerRow = 0;
		if (playerRow > 9)
			playerRow = 9;
		if (playerCol < 0)
			playerCol = 0;
		if (playerCol > 9)
			playerCol = 9;

		// collision check
		if (grid[playerRow][playerCol].equals("#")) {
			System.out.println("OH NO! You hit a pothole!");
			return true; // game over
		}

		// mark new position if not at goal
		if (!(playerRow == 9 && playerCol == 9)) {
			grid[playerRow][playerCol] = "X";
		}
		return false;
	}

	public void printGrid() {
		System.out.println();
		for (int r = 0; r < 10; r++) {
			for (int c = 0; c < 10; c++) {
				if (grid[r][c].equals("#")) { // hide potholes
					System.out.print("_");
				} else {
					System.out.print(grid[r][c]);
				}
			}
			System.out.println();
		}
	}
}
