package parsers;

import java.util.HashMap;
import java.util.Map;

public enum FileType {
    JSON(1),
    XML(2);

    private final int value;
    private static final Map<Integer, FileType> map = new HashMap<>();

    FileType(int value) {
        this.value = value;
    }

    static {
        for (FileType type : FileType.values()) {
            map.put(type.getValue(), type);
        }
    }

    public static FileType valueOf(int value) {
        if (!map.containsKey(value)) {
            throw new IllegalArgumentException("Type not found");
        }
        return map.get(value);
    }

    public int getValue() {
        return value;
    }
}
