import com.google.gson.*;

import java.lang.reflect.Type;

public class ShapeListDeserializer implements JsonDeserializer<ShapeList> {
    @Override
    public ShapeList deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
        ShapeList shapeList = new ShapeList();
        JsonObject jsonObject = json.getAsJsonObject();
        jsonObject.entrySet().forEach(entry -> shapeList.setShape(entry.getKey(), setShape(entry.getValue(), context)));
        return shapeList;
    }

    private Shape setShape(JsonElement value, JsonDeserializationContext context) {
        String type = String.valueOf(value.getAsJsonObject().get("type"));
        ExternalShapeType shapeType = ExternalShapeType.valueOf(type.substring(1,type.length()-1));
        switch (shapeType) {
            case RECTANGLE -> {
                return context.<Rectangle>deserialize(value, Rectangle.class);
            }
            case TRIANGLE -> {
                return context.<Triangle>deserialize(value,Triangle.class);
            }
            case CIRCLE -> {
                return context.<Circle>deserialize(value, Circle.class);
            }
        }
        return null;
    }
}
