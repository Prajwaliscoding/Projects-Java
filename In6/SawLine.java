// Prajwal Khatiwada
// ID: 1002239223

// Represents y = x mod modValue

public class SawLine implements Line {
    private double modValue;

    // Default constructor
    public SawLine() {
        this.modValue = 1.0;
    }

    // Parameterized constructor
    public SawLine(double modValue) {
        this.modValue = modValue;
    }

    // Accessor
    public double getModValue() {
        return modValue;
    }

    // Mutator
    public void setModValue(double modValue) {
        this.modValue = modValue;
    }

    // Implements Line interface
    public double getYPoint(double x) {
        return x % modValue;
    }
}
