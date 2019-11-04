package sounie;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class PrimitivesOnlyBraceBalanceCheckerTest {
    @Test
    public void shouldMatchSimple() throws Exception {
        InputStream is = new ByteArrayInputStream("()".getBytes());

        PrimitivesOnlyBraceBalanceChecker checker = new PrimitivesOnlyBraceBalanceChecker();

        assertTrue(checker.isBalanced(is));
    }

    @Test
    public void shouldRejectIncorrectOrder() throws Exception {
        InputStream is = new ByteArrayInputStream(")(".getBytes());

        PrimitivesOnlyBraceBalanceChecker checker = new PrimitivesOnlyBraceBalanceChecker();

        assertFalse(checker.isBalanced(is));
    }

    @Test
    public void shouldAllowNonBracketCharacters() throws Exception {
        InputStream is = new ByteArrayInputStream("Hello () My name is [].".getBytes());

        PrimitivesOnlyBraceBalanceChecker checker = new PrimitivesOnlyBraceBalanceChecker();

        assertTrue(checker.isBalanced(is));
    }

    @Test
    public void shouldAcceptMixOfNestedBracketsAndBraces() throws Exception {
        InputStream is = new ByteArrayInputStream("([]{[]})".getBytes());

        PrimitivesOnlyBraceBalanceChecker checker = new PrimitivesOnlyBraceBalanceChecker();

        assertTrue(checker.isBalanced(is));
    }

    @Test
    public void shouldAcceptLargeStack() throws Exception {
        InputStream is = new ByteArrayInputStream("(((((((({{{{{{{{[[[[[[[[]]]]]]]]}}}}}}}}))))))))".getBytes());
        PrimitivesOnlyBraceBalanceChecker checker = new PrimitivesOnlyBraceBalanceChecker();

        assertTrue(checker.isBalanced(is));
    }

    @Test
    public void shouldReadLargeFile() throws Exception {
        InputStream is = PrimitivesOnlyBraceBalanceCheckerTest.class.getResourceAsStream("/shakespeare.txt");

        PrimitivesOnlyBraceBalanceChecker checker = new PrimitivesOnlyBraceBalanceChecker();

        boolean result = checker.isBalanced(is);

        assertFalse(result);
        assertEquals(2697, checker.getFailedPosition());
    }
}