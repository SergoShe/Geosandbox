public class Triangle implements Shape {
    private final String name;
    private final double sideA;
    private final double sideB;
    private final double sideC;
    private final InputShapeType type = InputShapeType.TRIANGLE;

    public Triangle(String name, double sideA, double sideB, double sideC) {
        this.name = name;
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public InputShapeType getType() {
        return type;
    }

    @Override
    public double getArea() {
        double p = (sideA + sideB + sideC) / 2;
        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
    }

    @Override
    public double getPerimeter() {
        return sideA + sideB + sideC;
    }

    public double[] getSides() {
        return new double[]{sideA, sideB, sideC};
    }

    public double[] getAngles() {
        final double alpha = angleCalculation(sideA, sideB, sideC);
        final double beta = angleCalculation(sideB, sideA, sideC);
        final double gamma = 180 - alpha - beta;
        return new double[]{alpha, beta, gamma};
    }

    public boolean isRightTriangle() {
        for (double angle : getAngles()) {
            if (angle == 90) {
                return true;
            }
        }
        return false;
    }

    public boolean isEquilateralTriangle() {
        return sideA == sideB && sideA == sideC;
    }

    private double angleCalculation(double sideA, double sideB, double sideC) {
        return Math.toDegrees(Math.acos((sideB * sideB + sideC * sideC - sideA * sideA) / (2 * sideB * sideC)));
    }
}