import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Geosandbox {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void start() {
        HashMap<String, Shape> shapeList = new HashMap<>();
        work(shapeList);
    }

    private void work(HashMap<String, Shape> shapeList) {
        boolean isExit = false;
        while (!isExit) {
            System.out.println("Enter option number:");
            System.out.println("1.New\n2.List\n3.Show shape\n0.Exit");
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
            for (String shapeName : shapeList.keySet()) {
                System.out.println(shapeName);
            }
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
                System.out.println("Type: " + shape.getType());
                System.out.println("Area: " + String.format("%.2f", shape.getArea()));
                System.out.println("Perimeter: " + String.format("%.2f", shape.getPerimeter()));
            } else {
                System.out.println("Shape not found");
            }
        } else {
            System.out.println("List is empty.");
        }

    }
}
