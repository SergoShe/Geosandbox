import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShapeBuilder {
    private int countCircle = 0;
    private int countRectangle = 0;
    private int countTriangle = 0;
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public Shape build() throws IOException {
        boolean isBack = false;
        while (!isBack) {
            System.out.println("Enter figure number:");
            System.out.println("1.Rectangle\n2.Triangle\n3.Circle\n0.Back");
            try {
                InputShapeType shapeType = InputShapeType.valueOf(Integer.parseInt(reader.readLine()));
                switch (shapeType) {
                    case RECTANGLE -> {
                        return createRectangle();
                    }

                    case TRIANGLE -> {
                        return createTriangle();
                    }

                    case CIRCLE -> {
                        return createCircle();
                    }

                    case UNKNOWN -> isBack = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Enter incorrect commamd. Enter a number from list.\n");
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }

    private Shape createRectangle() throws IOException {
        System.out.print("Enter name: ");
        String name = reader.readLine();
        System.out.print("Enter side A: ");
        double sideA = Double.parseDouble(reader.readLine());
        System.out.print("Enter side B: ");
        double sideB = Double.parseDouble(reader.readLine());
        if (name.isEmpty()) {
            countRectangle++;
            name = "Rectangle_" + countRectangle;
        }
        return new Rectangle(name, sideA, sideB);
    }

    private Shape createTriangle() throws IOException {
        System.out.print("Enter name: ");
        String name = reader.readLine();
        System.out.print("Enter side A: ");
        double sideA = Double.parseDouble(reader.readLine());
        System.out.print("Enter side B: ");
        double sideB = Double.parseDouble(reader.readLine());
        System.out.print("Enter side B: ");
        double sideC = Double.parseDouble(reader.readLine());
        if (name.isEmpty()) {
            countTriangle++;
            name = "Triangle_" + countTriangle;
        }
        return new Triangle(name, sideA, sideB, sideC);
    }

    private Shape createCircle() throws IOException {
        System.out.print("Enter name: ");
        String name = reader.readLine();
        System.out.print("Enter radius: ");
        double radius = Double.parseDouble(reader.readLine());
        if (name.isEmpty()) {
            countCircle++;
            name = "Circle_" + countCircle;
        }
        return new Circle(name, radius);
    }
}