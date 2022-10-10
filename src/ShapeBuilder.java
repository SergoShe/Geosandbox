import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShapeBuilder {

    public static Shape build() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter figure number:");
        System.out.println("1.Rectangle\n2.Triangle\n3.Circle");
        Figure figure = Figure.valueOf(Integer.parseInt(reader.readLine()));
        return switch (figure) {
            case RECTANGLE -> createRectangle();

            case TRIANGLE -> createTriangle();

            case CIRCLE -> createCircle();
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