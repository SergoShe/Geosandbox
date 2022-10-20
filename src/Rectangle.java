public class Rectangle implements Shape {
    private final String name;
    private final double sideA;
    private final double sideB;

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
    public double getArea() {
        return sideA * sideB;
    }

    @Override
    public double getPerimeter() {
        return (sideA + sideB) * 2;
    }
}