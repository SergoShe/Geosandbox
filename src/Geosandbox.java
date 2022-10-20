import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Geosandbox {

    public void start(ArrayList<Shape> shapeList) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean isExit = false;
        while (!isExit) {
            System.out.println("Enter option number:");
            System.out.println("1.New\n2.List\n0.Exit");
            UserScenarioMode scenarioMode = UserScenarioMode.valueOf(Integer.parseInt(reader.readLine()));
            switch (scenarioMode) {
                case NEW -> {
                    try {
                        shapeList.add(newShape());
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case LIST -> showList(shapeList);

                case EXIT -> isExit = true;
            }
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
