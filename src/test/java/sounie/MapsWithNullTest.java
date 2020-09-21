package sounie;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNull;

public class MapsWithNullTest {
    @Test
    void getOrDefaultWhenValueIsNull() {
        Map<String, String> ordinaryMap = new HashMap<>();

        final String someKey = "mapKey";
        ordinaryMap.put(someKey, null);

        String returnedValue = ordinaryMap.getOrDefault(someKey, "not null");

        assertNull(returnedValue);
    }
}
