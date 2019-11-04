package sounie;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class DecimalSummerTest {

    @Test
    public void shouldAddWholeNumbers() {
        DecimalSummer summer = new DecimalSummer();

        assertEquals("23", summer.doSum(Set.of("20", "3")));
    }

    @Test
    public void shouldAddDecimalValues() {
        DecimalSummer summer = new DecimalSummer();

        assertEquals("0.3", summer.doSum(List.of("0.1", "0.1", "0.1")));
    }

    @Test
    public void shouldAddDecimalValuesToTwoPoints() {
        DecimalSummer summer = new DecimalSummer();

        assertEquals("0.25", summer.doSum(List.of("0.1", "0.1", "0.05")));
    }
}