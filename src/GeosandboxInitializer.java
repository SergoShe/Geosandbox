import java.io.IOException;
import java.util.ArrayList;

public class GeosandboxInitializer {
    public static void main(String[] args) {
        try {
            ArrayList<Shape> shapeList = new ArrayList<>();
            Geosandbox geosandbox = new Geosandbox();
            geosandbox.start(shapeList);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Incorrect symbol. Choose the number");
        }
    }
}