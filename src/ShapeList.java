import java.util.ArrayList;

public class ShapeList {
    private ArrayList<Rectangle> rectangles = new ArrayList<>();
    private ArrayList<Triangle> triangles = new ArrayList<>();
    private ArrayList<Circle> circles = new ArrayList<>();

    public ArrayList<Rectangle> getRectangles() {
        return rectangles;
    }

    public void setRectangles(ArrayList<Rectangle> rectangles) {
        this.rectangles = rectangles;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangles.add(rectangle);
    }

    public ArrayList<Triangle> getTriangles() {
        return triangles;
    }

    public void setTriangles(ArrayList<Triangle> triangles) {
        this.triangles = triangles;
    }

    public void setTriangle(Triangle triangle) {
        this.triangles.add(triangle);
    }

    public ArrayList<Circle> getCircles() {
        return circles;
    }

    public void setCircles(ArrayList<Circle> circles) {
        this.circles = circles;
    }

    public void setCircle(Circle circle) {
        this.circles.add(circle);
    }
}
