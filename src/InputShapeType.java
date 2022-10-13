import java.util.HashMap;
import java.util.Map;

enum InputShapeType {
    RECTANGLE(1),
    TRIANGLE(2),
    CIRCLE(3);

    private final int value;
    private static final Map<Integer, InputShapeType> map = new HashMap<>();

    InputShapeType(int value) {
        this.value = value;
    }

    static {
        for (InputShapeType shapeType : InputShapeType.values()) {
            map.put(shapeType.value, shapeType);
        }
    }

    public static InputShapeType valueOf(int value) {
        if (!map.containsKey(value)) {
            throw new IllegalArgumentException("Figure not found");
        }
        return map.get(value);
    }

    public int getValue() {
        return value;
    }
}
