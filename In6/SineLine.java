// Prajwal Khatiwada
// ID: 1002239223

// Represents y = amplitude * sin(x * frequency)

public class SineLine implements Line {
    private double amplitude;
    private double frequency;

    // Default constructor
    public SineLine() {
        this.amplitude = 1.0;
        this.frequency = 1.0;
    }

    // Parameterized constructor
    public SineLine(double amplitude, double frequency) {
        this.amplitude = amplitude;
        this.frequency = frequency;
    }

    // Accessors
    public double getAmplitude() {
        return amplitude;
    }

    public double getFrequency() {
        return frequency;
    }

    // Mutators
    public void setAmplitude(double amplitude) {
        this.amplitude = amplitude;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

    // Implements Line interface
    public double getYPoint(double x) {
        return amplitude * Math.sin(x * frequency);
    }
}
