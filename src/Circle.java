public class Circle extends Shape{
    private final double radius;

    public Circle(double radius){
        this.radius = radius;
    }

    @Override
    public double showArea() {
        return Math.PI*Math.pow(radius,2);
    }

    @Override
    public double showPerimeter() {
        return 2*Math.PI*radius;
    }
}
