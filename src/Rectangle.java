public class Rectangle implements Shape {
    private final String name;
    private final double sideA;
    private final double sideB;
    private final String type = Rectangle.class.getTypeName();

    public Rectangle(String name, double sideA, double sideB) {
        this.name = name;
        this.sideA = sideA;
        this.sideB = sideB;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public double getArea() {
        return sideA * sideB;
    }

    @Override
    public double getPerimeter() {
        return (sideA + sideB) * 2;
    }
}