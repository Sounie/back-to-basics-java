package sounie;

import java.io.*;

public class PrimitivesOnlyBraceBalanceChecker {
    private char[] primitiveStack = new char[16];

    private char[][] openClosePairs = new char[3][2];

    private int size = 0;
    private int failedPosition = 0;

    public PrimitivesOnlyBraceBalanceChecker() {
        this.openClosePairs[0] = new char[]{'{', '}'};
        this.openClosePairs[1] = new char[]{'(', ')'};
        this.openClosePairs[2] = new char[]{'[', ']'};
    }

    public int getFailedPosition() {
        return failedPosition;
    };

    public boolean isBalanced(InputStream input) throws IOException {
        try (Reader reader = new BufferedReader(new InputStreamReader(input))) {
            int intChar;
            while ((intChar = reader.read()) != -1) {
                failedPosition++;
                char currentChar = (char) intChar;
                for (int x = 0; x < openClosePairs.length; x++) {
                    if (openClosePairs[x][0] == currentChar) {
                        if (size == primitiveStack.length) {
                            resizeStack();
                        }
                        primitiveStack[size] = currentChar;
                        size++;
                        break;
                    } else if (openClosePairs[x][1] == currentChar) {
                        if (size > 0) {
                            // Check top of stack
                            if (primitiveStack[size - 1] == openClosePairs[x][0]) {
                                primitiveStack[size - 1] = '\u0000';
                                size--;
                                break;
                            }
                        }

                        return false;
                    }
                }
            }
        }

        return size == 0;
    }

    private void resizeStack() {
        char[] newPrimitiveStack = new char[primitiveStack.length * 2];
        System.arraycopy(primitiveStack, 0, newPrimitiveStack, 0, primitiveStack.length);

        primitiveStack = newPrimitiveStack;
    }
}
