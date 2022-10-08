public class Rectangle extends Shape{

    private final double sideA;
    private final double sideB;

    public Rectangle(double sideA, double sideB){
        this.sideA = sideA;
        this.sideB = sideB;
    }

    @Override
    public double showArea() {
        return sideA*sideB;
    }

    @Override
    public double showPerimeter() {
        return (sideA+sideB)*2;
    }
}
