import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShapeBuilder {

    public static Shape build() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean isCorrect = false;
        Shape shape = null;
        while (!isCorrect) {
            System.out.println("Enter a figure:");
            System.out.println("- Rectangle\n- Triangle\n- Circle");
            switch (reader.readLine().toLowerCase()) {
                case "rectangle" -> {
                    shape = createRectangle();
                    isCorrect = true;
                }
                case "triangle" -> {
                    shape = createTriangle();
                    isCorrect = true;
                }
                case "circle" -> {
                    shape = createCircle();
                    isCorrect = true;
                }
                default -> System.out.println("Incorrect. Try Again.\n");
            }
        }
        return shape;
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
