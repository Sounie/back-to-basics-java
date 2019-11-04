package sounie;

public class PalindromeChecker {
    public boolean isPalindrome(String maybe) {
        boolean result = true;
        int rightSideIndex = maybe.length();
        for (int i = 0; i < rightSideIndex; i++) {
            // Get to valid character from each side or terminate
            char leftChar = maybe.charAt(i);

            while (!isAlpha(leftChar) && i < rightSideIndex)
            {
                i++;
                leftChar = maybe.charAt(i);
            }

            if (!isAlpha(leftChar)) {
                result = false;
                break;
            }
            rightSideIndex--;
            while (!isAlpha(maybe.charAt(rightSideIndex)) && rightSideIndex > i) {
                rightSideIndex--;
            }
            if (!isAlpha(maybe.charAt(rightSideIndex))) {
                result = false;
                break;
            }

            System.out.println("checking " + leftChar + " versus " + maybe.charAt(rightSideIndex));

            if (maybe.charAt(i) != maybe.charAt(rightSideIndex)) {
                result = false;
                break;
            }

        }

        return result;
    }

    private boolean isAlpha(char candidate) {
        return Character.isAlphabetic(candidate);
    }
}
