package shapes;

public class Main {
    public static void main(String[] args) {
        printShape(new Rectangle(2.00, 4.00));
        printShape(new Circle(13.42));
    }

    private static void printShape(Shape shape) {
        System.out.printf("Shape with perimeter %.2f and area %.2f\n",
                shape.calculatePerimeter(), shape.calculateArea());
    }
}
