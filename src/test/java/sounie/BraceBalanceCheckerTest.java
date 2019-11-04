package sounie;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BraceBalanceCheckerTest {
    @Test
    public void shouldMatchSimple() {
        String simple = "()";

        BraceBalanceChecker checker = new BraceBalanceChecker();

        assertTrue(checker.isBalanced(simple));
    }

    @Test
    public void shouldRejectIncorrectOrder() {
        String closedBeforeOpen = ")(";

        BraceBalanceChecker checker = new BraceBalanceChecker();

        assertFalse(checker.isBalanced(closedBeforeOpen));
    }

    @Test
    public void shouldAcceptMixOfNestedBracketsAndBraces() {
        String mixedBracketsAndBraces = "([]{[]})";

        BraceBalanceChecker checker = new BraceBalanceChecker();

        assertTrue(checker.isBalanced(mixedBracketsAndBraces));
    }

    @Test
    public void shouldAllowNonBracketCharacters() {
        String lettersWithBrackets = "Hello () My name is [].";

        BraceBalanceChecker checker = new BraceBalanceChecker();

        assertTrue(checker.isBalanced(lettersWithBrackets));
    }
}