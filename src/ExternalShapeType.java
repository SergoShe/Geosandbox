import java.util.HashMap;
import java.util.Map;

enum ExternalShapeType {
    UNKNOWN(0),
    RECTANGLE(1),
    TRIANGLE(2),
    CIRCLE(3);

    private final int value;
    private static final Map<Integer, ExternalShapeType> map = new HashMap<>();

    ExternalShapeType(int value) {
        this.value = value;
    }

    static {
        for (ExternalShapeType shapeType : ExternalShapeType.values()) {
            map.put(shapeType.value, shapeType);
        }
    }

    public static ExternalShapeType valueOf(int value) {
        if (!map.containsKey(value)) {
            throw new IllegalArgumentException("Shape not found");
        }
        return map.get(value);
    }

    public int getValue() {
        return value;
    }
}
