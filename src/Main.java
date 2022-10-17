import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try {

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            ShapeBuilder shapeBuilder = new ShapeBuilder();
            ArrayList<Shape> shapeList = new ArrayList<>();
            boolean isExit = false;
            while (!isExit) {
                System.out.println("Enter option number:");
                System.out.println("1.New\n2.List\n0.Exit");
                Option option = Option.valueOf(Integer.parseInt(reader.readLine()));
                switch (option) {
                    case NEW -> {
                        try {
                            Shape shape = shapeBuilder.build();
                            shapeList.add(shape);
                        } catch (IOException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    case LIST -> {
                        if (shapeList.isEmpty()) {
                            System.out.println("List is empty.");
                        } else {
                            for (Shape shape : shapeList) {
                                System.out.println(shape.getName());
                            }
                        }
                    }
                    case EXIT -> isExit = true;
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Incorrect symbol. Choose the number");
        }
    }
}