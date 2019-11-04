package sounie;

import java.lang.reflect.Array;

public class ArrayBasedStack<T> {
    private T[] data;

    private int topIndex;
    private boolean empty;

    public ArrayBasedStack(Class<T> type, int capacity) {
        data = (T[])Array.newInstance(type, capacity);
        empty = true;
        topIndex = -1;
    }

    public void push(T item) {
        if (data.length > topIndex + 1) {
            topIndex += 1;
            data[topIndex] = item;

            empty = false;
        } else {
            throw new IllegalStateException("Stack full");
        }
    }

    public T pop() {
        if (!empty) {
            T item = data[topIndex];
            data[topIndex] = null;
            topIndex--;
            if (topIndex < 0) {
                empty = true;
            }

            return item;
        } else {
            throw new IllegalStateException("Stack empty");
        }
    }
}
