import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {
	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		String playagain;
		
		do {
			System.out.println("Welcome to Rock, Paper, Scissors game!\n");
			
			
			Random random = new Random();
			
			int human = 0;        // variable to track human player's score
			int computer = 0;     // variable to track computer's score
			
			String[] choices = {"rock", "paper", "scissors"};
			
			// Loop for exactly 3 rounds of the game
			for(int i=0;i<3;i++) {
				
				System.out.printf("\nRound %d\n",i+1);
				System.out.print("Please enter Rock, Paper, or Scissors: ");
				String human_input = keyboard.next();
				String comp_input = choices[random.nextInt(choices.length)];
				human_input = human_input.toLowerCase();
				
				if(comp_input.equals("rock") && human_input.equals("paper")) {
						System.out.println("Computer chose Rock.\nYou win this round.");
						human++;
						System.out.printf("Human %d\nComputer %d\n", human, computer);
					}
				else if(comp_input.equals("paper") && human_input.equals("scissors")) {
					 	System.out.println("Computer chose Paper.\nYou win this round.");
						human++;
						System.out.printf("Human %d\nComputer %d\n", human, computer);
					}
				else if(comp_input.equals("scissors") && human_input.equals("rock")){
						System.out.println("Computer chose Scissors.\nYou win this round.");
						human++;
						System.out.printf("Human %d\nComputer %d\n", human, computer);
					}
				else if(comp_input.equals("scissors") && human_input.equals("paper")) {
						System.out.println("Computer chose Scissors.\nComputer win this round.");
						computer++;
						System.out.printf("Human %d\nComputer %d\n", human, computer);
					}
				else if(comp_input.equals("paper") && human_input.equals("rock")) {
						System.out.println("Computer chose Paper.\nComputer win this round.");
						computer++;
						System.out.printf("Human %d\nComputer %d\n", human, computer);
					}
				else if(comp_input.equals("rock") && human_input.equals("scissors")) {
						System.out.println("Computer chose Rock.\nComputer win this round.");
						computer++;
						System.out.printf("Human %d\nComputer %d\n", human, computer);
					}
				else if(comp_input.equals("paper") && human_input.equals("paper")) {
						System.out.println("Computer chose Paper aswell.\nDraw in this round.");
						System.out.printf("Human %d\nComputer %d\n", human, computer);
					}
				else if(comp_input.equals("scissors") && human_input.equals("scissors")) {
						System.out.println("Computer chose Scissors aswell.\nDraw in this round.");
						System.out.printf("Human %d\nComputer %d\n", human, computer);
					}
				else if(comp_input.equals("rock") && human_input.equals("rock")) {
						System.out.println("Computer chose Rock aswell.\nDraw in this round.");
						System.out.printf("Human %d\nComputer %d\n", human, computer);
					}
				
				// If invalid input is provided, computer automatically wins the round
				else {
					System.out.println("Computer win this round as wrong input provided.");
					computer++;
					System.out.printf("Human %d\nComputer %d", human, computer);
				}
				
			// After 3 rounds, determine the overall winner
			}
			System.out.println("\nFinal Score:");
			System.out.printf("Human %d \nComputer %d\n", human, computer);
			if(human == computer) {
				System.out.println("\nDraw Overall.");
			}
			else if(human > computer) {
				System.out.println("\nCongratulations! You are the overall winner.");
			}
			else {
				System.out.println("\nComputer is the overall winner.");
			}

		    System.out.print("\nWould you like to play again? (yes/no): ");
		    playagain = keyboard.next().toLowerCase();

		} while (playagain.equals("yes"));    // replay loop continues until user types "no"
		
		System.out.println("\n\nThanks for playing!");
		keyboard.close();    // close scanner to free system resources
	}	
}
