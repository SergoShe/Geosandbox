public class Circle implements Shape {
    private final String name;
    private final double radius;
    private final ExternalShapeType type = ExternalShapeType.CIRCLE;

    public Circle(String name, double radius) {
        this.name = name;
        this.radius = radius;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ExternalShapeType getType() {
        return type;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    public double getRadius() {
        return radius;
    }

    public double getDiameter() {
        return radius * 2;
    }
}