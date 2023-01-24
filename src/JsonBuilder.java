import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.Collection;
import java.util.HashMap;

public class JsonBuilder {
    Gson gson;

    public void toJSON(HashMap<String, Shape> shapeList, String nameFIle) throws IOException {
        gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(transformShapeList(shapeList.values()));
        BufferedWriter writer = new BufferedWriter(new FileWriter(nameFIle + ".json"));
        writer.write(json);
        writer.close();
    }

    public ShapeList fromJSON(String pathWay) throws FileNotFoundException {
        gson = new Gson();
        BufferedReader reader = new BufferedReader(new FileReader(pathWay));
        ShapeList shapeList = gson.fromJson(reader,ShapeList.class);
        System.out.println(shapeList);
        return shapeList;
    }

    /*
    private ShapeList transformShapeList(Collection<Shape> values) {
        ShapeList shapeList = new ShapeList();
        for (Shape shape : values) {
            switch (shape.getType()){
                case RECTANGLE -> shapeList.setRectangle((Rectangle) shape);
                case TRIANGLE -> shapeList.setTriangle((Triangle) shape);
                case CIRCLE -> shapeList.setCircle((Circle) shape);
            }
        }
        return shapeList;
    }
     */

    private ShapeList transformShapeList(Collection<Shape> values) {
        ShapeList shapeList = new ShapeList();
        values.forEach(x -> setShape(x, shapeList));
        return shapeList;
    }

    private void setShape(Shape shape, ShapeList shapeList) {
        switch (shape.getType()){
            case RECTANGLE -> shapeList.setRectangle((Rectangle) shape);
            case TRIANGLE -> shapeList.setTriangle((Triangle) shape);
            case CIRCLE -> shapeList.setCircle((Circle) shape);
        }
    }
}