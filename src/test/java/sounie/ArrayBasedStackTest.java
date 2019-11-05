package sounie;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayBasedStackTest {
    @Test
    public void shouldPushWhenCapacityAvailable() {
        ArrayBasedStack<String> stack = new ArrayBasedStack(String.class, 1);
        stack.push("Hello world");

        assertNotNull(stack, "Expected stack to exist");
    }

    @Test
    public void shouldBarfWhenPushAttemptBeyondCapacity() {
        ArrayBasedStack<String> stack = new ArrayBasedStack(String.class, 1);

        stack.push("Hello");

        Exception exception = assertThrows(IllegalStateException.class, () -> stack.push("Goodbye"));
    }

    @Test
    public void shouldAllowPushAndPop() {
        ArrayBasedStack<String> stack = new ArrayBasedStack(String.class, 1);

        stack.push("Hello");

        String result = stack.pop();

        assertEquals("Hello", result);
    }

    @Test
    public void shouldBarfOnExcessivePopping() {
        ArrayBasedStack<String> stack = new ArrayBasedStack<>(String.class, 1);

        Exception exception = assertThrows(IllegalStateException.class, () -> stack.pop());

        assertEquals("Stack empty", exception.getMessage());
    }
}