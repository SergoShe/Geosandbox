import java.util.HashMap;
import java.util.LinkedHashMap;

public class ShapeList {
    HashMap<String, Shape> shapeList = new LinkedHashMap<>();

    public HashMap<String, Shape> getShapeList() {
        return new LinkedHashMap<>(shapeList);
    }

    public Shape getShape(String name){
        return shapeList.get(name);
    }

    public void setShapeList(HashMap<String, Shape> shapeList) {
        this.shapeList.putAll(shapeList);
    }

    public void setShape(String name, Shape shape){
        this.shapeList.put(name,shape);
    }

}
