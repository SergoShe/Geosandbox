package geosandbox;

import java.util.HashMap;
import java.util.Map;

enum UserScenarioMode {
    EXIT(0),
    NEW(1),
    LIST(2),
    SHOW(3),
    SAVE(4),
    LOAD(5);

    private final int value;
    private static final Map<Integer, UserScenarioMode> map = new HashMap<>();

    UserScenarioMode(int value) {
        this.value = value;
    }

    static {
        for (UserScenarioMode mode : UserScenarioMode.values()) {
            map.put(mode.getValue(), mode);
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
