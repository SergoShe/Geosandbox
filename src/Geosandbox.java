import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Geosandbox {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void start() {
        ArrayList<Shape> shapeList = new ArrayList<>();
        work(shapeList);
    }

    private void work(ArrayList<Shape> shapeList) {
        try {
            boolean isExit = false;
            while (!isExit) {
                System.out.println("Enter option number:");
                System.out.println("1.New\n2.List\n0.Exit");
                try {
                    UserScenarioMode scenarioMode = UserScenarioMode.valueOf(Integer.parseInt(reader.readLine()));
                    switch (scenarioMode) {
                        case NEW -> {
                            Shape shape = newShape();
                            if (shape != null) {
                                shapeList.add(shape);
                            }
                        }
                        case LIST -> showList(shapeList);

                        case EXIT -> isExit = true;
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Incorrect symbol. Enter a number from list.\n");
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private Shape newShape() throws IOException {
        ShapeBuilder shapeBuilder = new ShapeBuilder();
        return shapeBuilder.build();
    }

    private void showList(ArrayList<Shape> shapeList) {
        if (shapeList.isEmpty()) {
            System.out.println("List is empty.");
        } else {
            for (Shape shape : shapeList) {
                System.out.println(shape.getName());
            }
        }
    }
}
