import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShapeBuilder {

    public static Shape build(String string) throws IOException {
        return switch (string) {
            case "1" -> createRectangle();
            case "2" -> createTriangle();
            case "3" -> createCircle();
            default -> throw new IllegalArgumentException("Error");
        };
    }

    private static Shape createRectangle() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter side A: ");
        double sideA = Double.parseDouble(reader.readLine());
        System.out.print("Enter side B: ");
        double sideB = Double.parseDouble(reader.readLine());
        return new Rectangle(sideA, sideB);
    }

    private static Shape createTriangle() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter side A: ");
        double sideA = Double.parseDouble(reader.readLine());
        System.out.print("Enter side B: ");
        double sideB = Double.parseDouble(reader.readLine());
        System.out.print("Enter side B: ");
        double sideC = Double.parseDouble(reader.readLine());
        return new Triangle(sideA, sideB, sideC);
    }

    private static Shape createCircle() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter radius: ");
        double radius = Double.parseDouble(reader.readLine());
        return new Circle(radius);
    }
}
