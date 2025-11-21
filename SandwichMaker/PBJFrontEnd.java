import java.util.Scanner;

public class PBJFrontEnd {
 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);

     System.out.println("-----------------------------------");
     System.out.println("Welcome to the PBJ Sandwich Maker!");
     System.out.println("-----------------------------------");

     boolean again;
     do {
         System.out.println("-----Sandwich 1-----");
         PBJSandwich s1 = buildSandwichFromInput(sc);

         System.out.println();
         System.out.println("-----Sandwich 2-----");
         PBJSandwich s2 = buildSandwichFromInput(sc);

         // Print both sandwiches
         System.out.println();
         System.out.println("-----Sandwich 1-----");
         System.out.println(s1.toString());

         System.out.println("-----Sandwich 2-----");
         System.out.println(s2.toString());

         // Equality
         System.out.println("Are they the same sandwich? " + s1.equals(s2));

         // Restart?
         System.out.println();
         System.out.print("Would you like to restart? Enter \"y\" to restart or anything else to quit: ");
         String choice = sc.nextLine().trim();
         again = choice.equalsIgnoreCase("y");

         System.out.println();
     } while (again);

     sc.close();
 }

 // ---- Helper to build a PBJSandwich from user input (organized for readability) ----
 private static PBJSandwich buildSandwichFromInput(Scanner sc) {
     System.out.println("Top Slice of Bread Information");
     Bread top = readBread(sc);

     System.out.println("Peanut Butter Information");
     PeanutButter pb = readPeanutButter(sc);

     System.out.println("Jelly Information");
     Jelly j = readJelly(sc);

     System.out.println("Bottom Slice of Bread Information");
     Bread bottom = readBread(sc);

     return new PBJSandwich(top, pb, j, bottom);
 }

 // ---- Input readers with validation handled by setters ----
 private static Bread readBread(Scanner sc) {
     System.out.print("Enter name of the bread: ");
     String name = sc.nextLine();

     System.out.print("Enter the number of calories: ");
     int calories = readIntSafely(sc);

     System.out.print("Enter the type of bread. Must be \"Honey Wheat\", \"White\", \"Whole Grain\", or \"Whole Wheat\": ");
     String type = sc.nextLine();

     return new Bread(name, calories, type);
 }

 private static PeanutButter readPeanutButter(Scanner sc) {
     System.out.print("Enter name of the peanut butter: ");
     String name = sc.nextLine();

     System.out.print("Enter the number of calories: ");
     int calories = readIntSafely(sc);

     System.out.print("Is it crunchy? Enter \"true\", or \"false\": ");
     boolean crunchy = readBooleanSafely(sc);

     return new PeanutButter(name, calories, crunchy);
 }

 private static Jelly readJelly(Scanner sc) {
     System.out.print("Enter name of the jelly: ");
     String name = sc.nextLine();

     System.out.print("Enter the number of calories: ");
     int calories = readIntSafely(sc);

     System.out.print("Enter the fruit type. Must be \"Apple\", \"Blackberry\", \"Grape\", \"Blueberry\", or \"Tomato\": ");
     String fruit = sc.nextLine();

     return new Jelly(name, calories, fruit);
 }

 // ---- Safe numeric/boolean reads (keeps prompts simple; invalid entries fall back to defaults via setters) ----
 private static int readIntSafely(Scanner sc) {
     int val;
     String raw = sc.nextLine().trim();
     try {
         val = Integer.parseInt(raw);
     } catch (NumberFormatException e) {
         val = Integer.MIN_VALUE; // will be rejected by setters and defaulted
     }
     return val;
 }

 private static boolean readBooleanSafely(Scanner sc) {
     // Any non-"true" string becomes false (matches the typical boolean parse)
     String raw = sc.nextLine().trim();
     return raw.equalsIgnoreCase("true");
 }
}
