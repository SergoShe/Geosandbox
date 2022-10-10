import java.util.HashMap;
import java.util.Map;

enum Figure {
    RECTANGLE(1),
    TRIANGLE(2),
    CIRCLE(3);

    private final int value;
    private static final Map<Integer, Figure> map = new HashMap<>();

    Figure(int value) {
        this.value = value;
    }

    static {
        for (Figure figure : Figure.values()) {
            map.put(figure.value, figure);
        }
    }

    public static Figure valueOf(int value) {
        if (!map.containsKey(value)) {
            throw new NullPointerException("Figure not found");
        }
        return map.get(value);

    }

    public int getValue() {
        return value;
    }
}
