import java.util.HashMap;
import java.util.Map;

enum UserScenarioMode {
    NEW(1),
    LIST(2),
    EXIT(0);

    private final int value;
    private static final Map<Integer, UserScenarioMode> map = new HashMap<>();

    UserScenarioMode(int value) {
        this.value = value;
    }

    static {
        for (UserScenarioMode mode : UserScenarioMode.values()) {
            map.put(mode.value, mode);
        }
    }

    public static UserScenarioMode valueOf(int value) {
        if (!map.containsKey(value)) {
            throw new IllegalArgumentException("Wrong user mode");
        }
        return map.get(value);
    }

    public int getValue() {
        return value;
    }
}
