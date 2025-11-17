// Prajwal Khatiwada
// ID: 1002239223

// Represents a line with equation y = slope * x

public class SlopedLine implements Line {
    private double slope;

    // Default constructor
    public SlopedLine() {
        this.slope = 1.0;
    }

    // Parameterized constructor
    public SlopedLine(double slope) {
        this.slope = slope;
    }

    // Accessor
    public double getSlope() {
        return slope;
    }

    // Mutator
    public void setSlope(double slope) {
        this.slope = slope;
    }

    // Implements Line interface
    public double getYPoint(double x) {
        return slope * x;
    }
}
