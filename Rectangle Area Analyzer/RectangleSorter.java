import java.util.Scanner;

public class RectangleSorter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Rectangle[] rectangles = null;

        System.out.println("Welcome to the Rectangle Sorter!");
        int numRectangles = 0;

        // Ask until user enters a valid positive number of rectangles
        while (numRectangles <= 0) {
            System.out.println("How many Rectangles are we creating?");
            numRectangles = scanner.nextInt();
            if (numRectangles <= 0) {
                System.out.println("Invalid size. Please enter a positive integer.");
            }
        }

        rectangles = new Rectangle[numRectangles];

        // Input rectangle dimensions one by one
        for (int i = 0; i < rectangles.length; i++) {
            System.out.println("Enter the length for Rectangle " + i);
            double lengthInput = scanner.nextDouble();
            System.out.println("Enter the width for Rectangle " + i);
            double widthInput = scanner.nextDouble();
            rectangles[i] = new Rectangle(lengthInput, widthInput);
        }

        boolean running = true;
        while (running) {
            printMenu(); // Display options to the user
            int userChoice = scanner.nextInt();

            if (userChoice == 0) {
                System.out.println("Goodbye");
                running = false; // Exit program
            } else if (userChoice == 1) {
                if (isValid(rectangles)) {
                    Rectangle[] ascending = copyArray(rectangles); 
                    selectionSort(ascending, true); // Sort ascending
                    System.out.println("Areas Smallest to Largest");
                    printAreas(ascending);
                }
            } else if (userChoice == 2) {
                if (isValid(rectangles)) {
                    Rectangle[] descending = copyArray(rectangles);
                    selectionSort(descending, false); // Sort descending
                    System.out.println("Areas Largest to Smallest");
                    printAreas(descending);
                }
            } else if (userChoice == 3) {
                if (isValid(rectangles)) {
                    System.out.println("The Maximum Area is " + getMax(rectangles));
                }
            } else if (userChoice == 4) {
                if (isValid(rectangles)) {
                    System.out.println("The Minimum Area is " + getMin(rectangles));
                }
            } else if (userChoice == 5) {
                if (isValid(rectangles)) {
                    System.out.println("The Average Area is " + getAverage(rectangles));
                }
            } else if (userChoice == 9) {
                // Option to reenter rectangle data without restarting program
                System.out.println("Welcome to the Rectangle Sorter!");
                int newSize = 0;
                while (newSize <= 0) {
                    System.out.println("How many Rectangles are we creating?");
                    newSize = scanner.nextInt();
                    if (newSize <= 0) {
                        System.out.println("Invalid size. Please enter a positive integer.");
                    }
                }
                rectangles = new Rectangle[newSize];
                for (int i = 0; i < rectangles.length; i++) {
                    System.out.println("Enter the length for Rectangle " + i);
                    double lengthInput = scanner.nextDouble();
                    System.out.println("Enter the width for Rectangle " + i);
                    double widthInput = scanner.nextDouble();
                    rectangles[i] = new Rectangle(lengthInput, widthInput);
                }
            } else {
                System.out.println("Invalid choice."); // Handle wrong inputs
            }
        }
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("Choose from the following:");
        System.out.println("1. Sort Rectangles by Smallest to Largest");
        System.out.println("2. Sort Rectangles by Largest to Smallest");
        System.out.println("3. Get Maximum Area");
        System.out.println("4. Get Minimum Area");
        System.out.println("5. Get Average Area");
        System.out.println("9. Reenter Rectangle Data");
        System.out.println("0. To Quit");
    }

    private static boolean isValid(Rectangle[] rectangles) {
        // Prevents operations on empty or null arrays
        if (rectangles == null || rectangles.length == 0) {
            System.out.println("Cannot operate on an empty collection.");
            return false;
        } else {
            return true;
        }
    }

    private static Rectangle[] copyArray(Rectangle[] source) {
        // Create a new array so original is not modified
        Rectangle[] copy = new Rectangle[source.length];
        for (int i = 0; i < source.length; i++) {
            copy[i] = new Rectangle(source[i].getLength(), source[i].getWidth());
        }
        return copy;
    }

    private static void selectionSort(Rectangle[] arr, boolean ascending) {
        // Selection sort algorithm for rectangles by area
        for (int i = 0; i < arr.length - 1; i++) {
            int targetIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (ascending) {
                    if (arr[j].getArea() < arr[targetIndex].getArea()) {
                        targetIndex = j;
                    }
                } else {
                    if (arr[j].getArea() > arr[targetIndex].getArea()) {
                        targetIndex = j;
                    }
                }
            }
            Rectangle temp = arr[i];
            arr[i] = arr[targetIndex];
            arr[targetIndex] = temp;
        }
    }

    private static double getAverage(Rectangle[] arr) {
        // Calculate average area
        double totalArea = 0.0;
        for (int i = 0; i < arr.length; i++) {
            totalArea += arr[i].getArea();
        }
        return totalArea / arr.length;
    }

    private static double getMin(Rectangle[] arr) {
        // Find smallest area
        double minArea = arr[0].getArea();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].getArea() < minArea) {
                minArea = arr[i].getArea();
            }
        }
        return minArea;
    }

    private static double getMax(Rectangle[] arr) {
        // Find largest area
        double maxArea = arr[0].getArea();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].getArea() > maxArea) {
                maxArea = arr[i].getArea();
            }
        }
        return maxArea;
    }

    private static void printAreas(Rectangle[] arr) {
        // Print all rectangle areas in the array
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i].getArea());
        }
    }
}
