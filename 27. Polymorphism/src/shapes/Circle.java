package shapes;

public class Circle extends Shape {
    private final Double radius;

    public Circle(Double radius) {
        this.radius = radius;
    }

    @Override
    protected Double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    protected Double calculateArea() {
        return Math.PI * radius * radius;
    }
}
