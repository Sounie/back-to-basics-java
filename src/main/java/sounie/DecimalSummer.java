package sounie;

import java.math.BigDecimal;
import java.util.Collection;

/**
 * Take a collection of decimal values as String and calculate their sum.
 */
public class DecimalSummer {
    public String doSum(Collection<String> inputValues) {
        BigDecimal sum = inputValues.stream()
                .map(BigDecimal::new)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return sum.toString();
    }
}
