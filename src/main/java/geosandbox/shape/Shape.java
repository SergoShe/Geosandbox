package geosandbox.shape;

import geosandbox.ExternalShapeType;

public interface Shape {

    String getName();

    ExternalShapeType getType();

    double getArea();

    double getPerimeter();
}