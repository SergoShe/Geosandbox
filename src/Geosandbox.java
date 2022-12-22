import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Geosandbox {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void start() {
        HashMap<String, Shape> shapeList = new LinkedHashMap<>();
        work(shapeList);
    }

    private void work(HashMap<String, Shape> shapeList) {
        boolean isExit = false;
        while (!isExit) {
            System.out.println("Enter option number:");
            System.out.println("1.New\n2.List\n3.Show shape\n4.Export file\n0.Exit");
            try {
                UserScenarioMode scenarioMode = UserScenarioMode.valueOf(Integer.parseInt(reader.readLine()));
                switch (scenarioMode) {
                    case NEW -> {
                        Shape shape = newShape();
                        if (shape != null) {
                            shapeList.put(shape.getName(), shape);
                        }
                    }
                    case LIST -> showList(shapeList);

                    case SHOW -> showShape(shapeList);

                    case EXIT -> isExit = true;

                    case SAVE -> saveFile(shapeList);
                }
            } catch (NumberFormatException e) {
                System.out.println("Enter incorrect command. Enter a number from list.\n");
            } catch (IllegalArgumentException | IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Shape newShape() throws IOException {
        ShapeBuilder shapeBuilder = new ShapeBuilder();
        return shapeBuilder.build();
    }

    private void showList(HashMap<String, Shape> shapeList) {
        if (!shapeList.isEmpty()) {
            shapeList.keySet().forEach(System.out::println);
        } else {
            System.out.println("List is empty.");
        }
    }

    private void showShape(HashMap<String, Shape> shapeList) throws IOException {
        if (!shapeList.isEmpty()) {
            System.out.println("Enter shape name:");
            String shapeName = reader.readLine();
            if (shapeList.containsKey(shapeName)) {
                Shape shape = shapeList.get(shapeName);
                System.out.println("Name: " + shape.getName());
                System.out.println("Type: " + shape.getType().toString().toLowerCase());
                System.out.println("Area: " + String.format("%.2f", shape.getArea()));
                System.out.println("Perimeter: " + String.format("%.2f", shape.getPerimeter()));
                switch (shapeList.get(shapeName).getType()) {
                    case RECTANGLE -> {
                        Rectangle rectangle = (Rectangle) shape;
                        System.out.println("Sides: " + Arrays.toString(rectangle.getSides()));
                        System.out.println("Diagonal: " + String.format("%.2f", rectangle.getDiagonal()));
                        System.out.println("Is Square: " + rectangle.isSquare());
                    }
                    case TRIANGLE -> {
                        Triangle triangle = (Triangle) shape;
                        System.out.println("Sides: " + Arrays.toString(triangle.getSides()));
                        System.out.println("Angles: " + Arrays.toString(triangle.getAngles()));
                        System.out.println("Is Right Triangle: " + triangle.isRightTriangle());
                        System.out.println("Is Equilateral Triangle: " + triangle.isEquilateralTriangle());
                    }
                    case CIRCLE -> {
                        Circle circle = (Circle) shape;
                        System.out.println("Radius: " + String.format("%.2f", circle.getRadius()));
                        System.out.println("Diameter: " + String.format("%.2f", circle.getDiameter()));
                    }
                }
            } else {
                System.out.println("Shape not found.");
            }
        } else {
            System.out.println("List is empty.");
        }
    }

    private void saveFile(HashMap<String, Shape> shapeList) throws IOException {
        System.out.println("Enter name file: ");
        String name = reader.readLine();
        System.out.println("Enter file format:");
        System.out.println("1.JSON\n2.XML");
        String enter = reader.readLine();
        if (enter.equals("1")) {
            JSONWorker worker = new JSONWorker();
            worker.toJSON(shapeList, name);
        } else if (enter.equals("2")) {
            XMLWorker worker = new XMLWorker();
            try {
                worker.toXML(shapeList, name);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }
}