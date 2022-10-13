import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShapeBuilder {

    public Shape build() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter figure number:");
        System.out.println("1.Rectangle\n2.Triangle\n3.Circle");
        InputShapeType shapeType = InputShapeType.valueOf(Integer.parseInt(reader.readLine()));
        return switch (shapeType) {
            case RECTANGLE -> createRectangle();

            case TRIANGLE -> createTriangle();

            case CIRCLE -> createCircle();
        };
    }

    private Shape createRectangle() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter side A: ");
        double sideA = Double.parseDouble(reader.readLine());
        System.out.print("Enter side B: ");
        double sideB = Double.parseDouble(reader.readLine());
        return new Rectangle(sideA, sideB);
    }

    private Shape createTriangle() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter side A: ");
        double sideA = Double.parseDouble(reader.readLine());
        System.out.print("Enter side B: ");
        double sideB = Double.parseDouble(reader.readLine());
        System.out.print("Enter side B: ");
        double sideC = Double.parseDouble(reader.readLine());
        return new Triangle(sideA, sideB, sideC);
    }

    private Shape createCircle() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter radius: ");
        double radius = Double.parseDouble(reader.readLine());
        return new Circle(radius);
    }
}