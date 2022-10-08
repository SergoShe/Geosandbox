import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            Shape shape;
            System.out.println("Choose a figure:");
            System.out.println("1.Rectangle\n2.Triangle\n3.Circle");
            shape = ShapeBuilder.build(reader.readLine());
            System.out.println(shape.showArea());
            System.out.println(shape.showPerimeter());
    }
}