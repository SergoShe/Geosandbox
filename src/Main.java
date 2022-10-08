import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            Shape shape = ShapeBuilder.build();
            System.out.println(shape.showArea());
            System.out.println(shape.showPerimeter());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}