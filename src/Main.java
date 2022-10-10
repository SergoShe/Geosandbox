import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            Shape shape = ShapeBuilder.build();
            System.out.println("Area: " + shape.getArea());
            System.out.println("Perimeter: " + shape.getPerimeter());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}