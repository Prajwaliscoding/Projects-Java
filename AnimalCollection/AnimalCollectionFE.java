import java.util.Scanner;

public class AnimalCollectionFE {
// Static variables per spec
	static Scanner keyboard = new Scanner(System.in);
	static AnimalCollection aCollection = new AnimalCollection();

	public static void main(String[] args) {
		System.out.println("Welcome to the Animal Collection!");
		int choice;
		do {
			System.out.println();
			System.out.println("Enter 1. To Add an Animal.");
			System.out.println("Enter 2. To Remove an Animal.");
			System.out.println("Enter 9. To Quit.");
			choice = readInt();
			if (choice == 1) {
				addFlow();
				aCollection.printAnimals();
			} else if (choice == 2) {
				removeFlow();
				aCollection.printAnimals();
			}
		} while (choice != 9);
		aCollection.printAnimals();
		System.out.println("Goodbye!");
	}

// ----- Flows -----
	private static void addFlow() {
		int kind = askKind();
		Animal a = buildAnimal(kind);
		if (a != null) {
			aCollection.addAnimal(a);
		}
	}

	private static void removeFlow() {
		int kind = askKind();
		Animal a = buildAnimal(kind);
		if (a != null) {
			aCollection.removeAnimal(a);
		}
	}

// Menu for type of animal
	private static int askKind() {
		System.out.println("Enter the kind of Animal.");
		System.out.println("1. For Animal");
		System.out.println("2. For Cat");
		System.out.println("3. For Dog");
		System.out.println("4. For House Cat");
		System.out.println("5. For Leopard");
		System.out.println("6. For Domestic Dog");
		System.out.println("7. For Wolf");
		int k = readInt();
		if (k < 1 || k > 7)
			k = 1;
		return k;
	}

// Creates an instance by asking for the exact fields, in order
private static Animal buildAnimal(int kind) {
if (kind == 1) {
String name = askString("Enter the Animal's Name");
double weight = askDouble("Enter the Animal's Weight");
return new Animal(name, weight);
} else if (kind == 2) {
String name = askString("Enter the Animal's Name");
double weight = askDouble("Enter the Animal's Weight");
String mood = askString("Enter the Cat's mood. \"sleepy\",
\"playful\", \"hungry\"");
return new Cat(name, weight, mood);
} else if (kind == 3) {
String name = askString("Enter the Animal's Name");
double weight = askDouble("Enter the Animal's Weight");
int energy = askInt("Enter the Dog's Energy Level. Between 1 and
100.");
return new Dog(name, weight, energy);
} else if (kind == 4) {
String name = askString("Enter the Animal's Name");
double weight = askDouble("Enter the Animal's Weight");
String mood = askString("Enter the Cat's mood. \"sleepy\",
\"playful\", \"hungry\"");
String type = askString(
"Enter the House Cat's Type. \"short hair\",
\"ragdoll\", \"sphinx\", \"Scottish fold\"");
return new HouseCat(name, weight, mood, type);
} else if (kind == 5) {
String name = askString("Enter the Animal's Name");
double weight = askDouble("Enter the Animal's Weight");
String mood = askString("Enter the Cat's mood. \"sleepy\",
\"playful\", \"hungry\"");
int spots = askInt("Enter the Leopard's Spots. Greater than or
equal to 1.");
return new Leopard(name, weight, mood, spots);
} else if (kind == 6) {
String name = askString("Enter the Animal's Name");
double weight = askDouble("Enter the Animal's Weight");
int energy = askInt("Enter the Dog's Energy Level. Between 1 and
100.");
String type = askString("Enter the Domestic Dog's Type.
\"retriever\", \"terrier\", \"husky\", \"mutt\"");
return new DomesticDog(name, weight, energy, type);
} else { // kind == 7
String name = askString("Enter the Animal's Name");
double weight = askDouble("Enter the Animal's Weight");
int energy = askInt("Enter the Dog's Energy Level. Between 1 and
100.");
String leader = askString("Enter the Wolf's Pack Leader's Name");
return new Wolf(name, weight, energy, leader);
}
}

// ----- Small input helpers -----
	private static String askString(String prompt) {
		System.out.println(prompt);
		String s = keyboard.nextLine();
		while (s.trim().length() == 0) {
			s = keyboard.nextLine();
		}
		return s;
	}

	private static double askDouble(String prompt) {
		System.out.println(prompt);
		while (!keyboard.hasNextDouble()) {
			keyboard.nextLine();
			System.out.println(prompt);
		}
		double v = keyboard.nextDouble();
		keyboard.nextLine(); // consume rest of line
		return v;
	}

	private static int askInt(String prompt) {
		System.out.println(prompt);
		return readInt();
	}

	private static int readInt() {
		while (!keyboard.hasNextInt()) {
			keyboard.nextLine();
			System.out.println("Please enter a whole number.");
		}
		int v = keyboard.nextInt();
		keyboard.nextLine(); // consume newline
		return v;
	}
}
