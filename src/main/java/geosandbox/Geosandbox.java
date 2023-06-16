package geosandbox;

import geosandbox.shape.Circle;
import geosandbox.shape.Rectangle;
import geosandbox.shape.Shape;
import geosandbox.shape.Triangle;
import parsers.FileType;
import parsers.JsonBuilder;
import parsers.XMLBuilder;

import java.io.*;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;

public class Geosandbox {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    HashMap<String, Shape> shapeList;
    public Geosandbox(ShapeList shapeList){
        this.shapeList = transformShapeList(shapeList);
    }

    public HashMap<String, Shape>  start() {
        work(shapeList);
        return shapeList;
    }

    private void work(HashMap<String, Shape> shapeList) {
        boolean isExit = false;
        while (!isExit) {
            System.out.println("Enter option number:");
            System.out.println("1.New\n2.List\n3.Show shape\n4.Export file\n5.Import file\n0.Exit");
            try {
                UserScenarioMode scenarioMode = UserScenarioMode.valueOf(Integer.parseInt(reader.readLine()));
                switch (scenarioMode) {
                    case NEW -> {
                        Shape shape = newShape();
                        if (shape != null) {
                            shapeList.put(shape.getName(), shape);
                        }
                    }
                    case LIST -> showList(shapeList);

                    case SHOW -> showShape(shapeList);

                    case EXIT -> isExit = true;

                    case SAVE -> saveFile(shapeList);

                    case LOAD -> {
                        HashMap<String, Shape> list = loadFile();
                        if (list != null) {
                            shapeList.putAll(list);
                        }
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Enter incorrect command. Enter a number from list.\n");
            } catch (IllegalArgumentException | IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Shape newShape() throws IOException {
        ShapeBuilder shapeBuilder = new ShapeBuilder();
        return shapeBuilder.build();
    }

    private void showList(HashMap<String, Shape> shapeList) {
        if (!shapeList.isEmpty()) {
            shapeList.keySet().forEach(System.out::println);
        } else {
            System.out.println("List is empty.");
        }
    }

    private void showShape(HashMap<String, Shape> shapeList) throws IOException {
        if (!shapeList.isEmpty()) {
            System.out.println("Enter shape name:");
            String shapeName = reader.readLine();
            if (shapeList.containsKey(shapeName)) {
                Shape shape = shapeList.get(shapeName);
                System.out.println("Name: " + shape.getName());
                System.out.println("Type: " + shape.getType().toString().toLowerCase());
                System.out.println("Area: " + String.format("%.2f", shape.getArea()));
                System.out.println("Perimeter: " + String.format("%.2f", shape.getPerimeter()));
                switch (shapeList.get(shapeName).getType()) {
                    case RECTANGLE -> {
                        Rectangle rectangle = (Rectangle) shape;
                        System.out.println("Sides: " + Arrays.toString(rectangle.getSides()));
                        System.out.println("Diagonal: " + String.format("%.2f", rectangle.getDiagonal()));
                        System.out.println("Is Square: " + rectangle.isSquare());
                    }
                    case TRIANGLE -> {
                        Triangle triangle = (Triangle) shape;
                        System.out.println("Sides: " + Arrays.toString(triangle.getSides()));
                        System.out.println("Angles: " + Arrays.toString(triangle.getAngles()));
                        System.out.println("Is Right Triangle: " + triangle.isRightTriangle());
                        System.out.println("Is Equilateral Triangle: " + triangle.isEquilateralTriangle());
                    }
                    case CIRCLE -> {
                        Circle circle = (Circle) shape;
                        System.out.println("Radius: " + String.format("%.2f", circle.getRadius()));
                        System.out.println("Diameter: " + String.format("%.2f", circle.getDiameter()));
                    }
                }
            } else {
                System.out.println("Shape not found.");
            }
        } else {
            System.out.println("List is empty.");
        }
    }

    private void saveFile(HashMap<String, Shape> shapeList) throws IOException {
        System.out.println("Enter name file: ");
        String name = reader.readLine();
        System.out.println("Enter file format:");
        System.out.println("1.JSON\n2.XML");
        try {
            FileType type = FileType.valueOf(Integer.parseInt(reader.readLine()));
            switch (type) {
                case JSON -> {
                    JsonBuilder worker = new JsonBuilder();
                    worker.toJSON(shapeList, name);
                }
                case XML -> {
                    XMLBuilder worker = new XMLBuilder();
                    worker.toXML(shapeList, name);
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Enter incorrect command. Enter a number from list.\n");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private HashMap<String, Shape> loadFile() {
        HashMap<String, Shape> shapeList = new HashMap<>();
        System.out.println("Enter file path:");
        try {
            String pathWay = String.valueOf(Path.of(reader.readLine()).toAbsolutePath());
            File file = new File(pathWay);
            if (!file.exists()) {
                throw new FileNotFoundException("File not found.");
            }
            FileType fileType = FileType.valueOf(pathWay.substring(pathWay.lastIndexOf('.') + 1).toUpperCase());
            switch (fileType) {
                case JSON -> {
                    JsonBuilder worker = new JsonBuilder();
                    shapeList = transformShapeList(worker.fromJSON(pathWay));
                }
                case XML -> {
                    XMLBuilder worker = new XMLBuilder();
                    shapeList = worker.fromXML(pathWay);
                }
            }
            if (shapeList != null) {
                return shapeList;
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: incorrect type file.");
        } catch (Exception e) {
            System.out.println("Failed to read file.");
            System.out.println("Error message: " + e.getMessage());
        }
        return null;
    }

    private HashMap<String, Shape> transformShapeList(ShapeList inputShapeList) {
        HashMap<String, Shape> shapeList = new HashMap<>();
        inputShapeList.getRectangles().forEach(shape -> shapeList.put(shape.getName(), new Rectangle(shape.getName(), shape.getSides()[0], shape.getSides()[1])));
        inputShapeList.getTriangles().forEach(shape -> shapeList.put(shape.getName(), new Triangle(shape.getName(), shape.getSides()[0], shape.getSides()[1], shape.getSides()[2])));
        inputShapeList.getCircles().forEach(shape -> shapeList.put(shape.getName(), new Circle(shape.getName(), shape.getRadius())));
        return shapeList;
    }
}