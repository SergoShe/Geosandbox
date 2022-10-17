import java.util.HashMap;
import java.util.Map;

enum Option {
    NEW(1),
    LIST(2),
    EXIT(0);

    private final int value;
    private static final Map<Integer, Option> map = new HashMap<>();

    Option(int value) {
        this.value = value;
    }

    static {
        for (Option option : Option.values()) {
            map.put(option.value, option);
        }
    }

    public static Option valueOf(int value) {
        if (!map.containsKey(value)) {
            throw new IllegalArgumentException("Option not found");
        }
        return map.get(value);
    }

    public int getValue() {
        return value;
    }
}
