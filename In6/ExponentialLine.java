// Prajwal Khatiwada
// ID: 1002239223

// Represents y = x ^ exponent

public class ExponentialLine implements Line {
    private double exponent;

    // Default constructor
    public ExponentialLine() {
        this.exponent = 2.0;
    }

    // Parameterized constructor
    public ExponentialLine(double exponent) {
        this.exponent = exponent;
    }

    // Accessor
    public double getExponent() {
        return exponent;
    }

    // Mutator
    public void setExponent(double exponent) {
        this.exponent = exponent;
    }

    // Implements Line interface
    public double getYPoint(double x) {
        return Math.pow(x, exponent);
    }
}
