package sounie;

import java.util.Map;
import java.util.Stack;

/**
 * Validate that opening and closing brackets of different kinds are symmetrical.
 * Cannot have non-matching closing when other type of bracket is open.
 */
public class BraceBalanceChecker {
    private final Stack<Character> openBrackets;
    private final Map<Character, Character> bracketCharacters = Map.of('{', '}', '[', ']', '(', ')');
    private final Map<Character, Character> reverseMatch = Map.of('}', '{', ']', '[', ')', '(');

    BraceBalanceChecker() {
        openBrackets = new Stack<>();
    }

    boolean isBalanced(String input) {
        boolean result = true;

        for (int i = 0; i < input.length(); i++) {
            Character character = input.charAt(i);
            if (bracketCharacters.containsKey(character)) {
                openBrackets.push(character);
            } else {
                if (reverseMatch.containsKey(character)) {
                    if (!openBrackets.isEmpty() && openBrackets.peek().equals(reverseMatch.get(character))) {
                        openBrackets.pop();
                    } else {
                        result = false;
                        break;
                    }
                }
            }
        }

        return result && openBrackets.isEmpty();
    }
}
