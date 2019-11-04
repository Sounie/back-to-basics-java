package sounie;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeCheckerTest {
    @Test
    public void shouldAcceptSingleCharacter() {
        PalindromeChecker checker = new PalindromeChecker();

        assertTrue(checker.isPalindrome("a"));
    }

    @Test
    public void shouldRejectNonPalindrome() {
        PalindromeChecker checker = new PalindromeChecker();

        assertFalse(checker.isPalindrome("AB"));
    }

    @Test
    public void shouldAcceptSimplePalindrome() {
        PalindromeChecker checker = new PalindromeChecker();

        assertTrue(checker.isPalindrome("BB"));
    }

    @Test
    public void shouldRejectLongNonPalindrome() {
        PalindromeChecker checker = new PalindromeChecker();

        assertFalse(checker.isPalindrome("abcdefgfdcba"));
    }

    @Test
    public void shouldAcceptLongPalindrome() {
        PalindromeChecker checker = new PalindromeChecker();

        assertTrue(checker.isPalindrome("abcdefghijklmnoponmlkjihgfedcba"));
    }

    @Test
    public void shouldSkipWhitespace() {
        PalindromeChecker checker = new PalindromeChecker();

        assertTrue(checker.isPalindrome("abcdefghijk   lmno  ponmlk jihgfedcb a"));
    }

    @Test
    public void shouldHandleUnbalancedInvalidCharacters() {
        PalindromeChecker checker = new PalindromeChecker();

        assertTrue(checker.isPalindrome("   ABBA "));
    }
}