package classbox;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
    }

    private void setLength(double length) {
        validateData(length, "Length");
        this.length = length;
    }

    private void setWidth(double width) {
        validateData(width, "Width");
        this.width = width;
    }

    private void setHeight(double height) {
        validateData(height, "Height");
        this.height = height;
    }

    private void validateData(double data, String errorPrefix) {
        if (data <= 0) {
            throw new IllegalArgumentException(errorPrefix + " cannot be zero or negative.");
        }
    }

    public double calculateSurfaceArea() {
        return (length * width * 2) + (length * height * 2) + (width * height * 2);
    }

    public double calculateLateralSurfaceArea() {
        return (length * height * 2) + (width * height * 2);
    }

    public double calculateVolume() {
        return length * width * height;
    }
}
