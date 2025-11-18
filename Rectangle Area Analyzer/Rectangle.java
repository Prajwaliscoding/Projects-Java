public class Rectangle {
    // Store rectangle's length
    private double lengthValue;
    // Store rectangle's width
    private double widthValue;

    // Constructor: initialize length and width when object is created
    public Rectangle(double lengthValue, double widthValue) {
        this.lengthValue = lengthValue;
        this.widthValue = widthValue;
    }

    // Getter method: returns length
    public double getLength() {
        return lengthValue;
    }

    // Getter method: returns width
    public double getWidth() {
        return widthValue;
    }

    // Calculate and return area (length × width)
    public double getArea() {
        return lengthValue * widthValue;
    }
}
