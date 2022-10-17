public class Circle implements Shape {
    private final String name;
    private static int count = 0;
    private final double radius;

    public Circle(String name, double radius) {
        this.name = name;
        this.radius = radius;
    }

    public Circle(double radius) {
        count++;
        name = "Circle_" + count;
        this.radius = radius;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}