// Prajwal Khatiwada
// ID: 1002239223

// Represents a staircase pattern using width and height

public class StaircaseLine implements Line {
    private double width;
    private double height;

    // Default constructor
    public StaircaseLine() {
        this.width = 1.0;
        this.height = 1.0;
    }

    // Parameterized constructor
    public StaircaseLine(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // Accessors
    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    // Mutators
    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    // Implements Line interface
    public double getYPoint(double x) {
        int steps = (int)(x / width);
        return steps * height;
    }
}
