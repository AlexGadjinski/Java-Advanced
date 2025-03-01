package shapes;

public class Rectangle extends Shape {
    private final Double height;
    private final Double width;

    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
    }

    @Override
    protected Double calculatePerimeter() {
        return (height + width) * 2;
    }

    @Override
    protected Double calculateArea() {
        return height * width;
    }
}
