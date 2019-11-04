package sounie;

import java.lang.reflect.Array;

/**
 * Exercise to find the second smallest value in an array.
 */
public class SecondSmallestFinder<T extends Comparable<T>> {
    private T[] items;
    private int top = -1;

    public SecondSmallestFinder(T[] items) {
        this.items = items;
    }

    public int findSecondSmallest() {
        T smallest = null;
        int smallestIndex = -1;
        T secondSmallest = null;
        int secondSmallestIndex = -1;

        for (int i = 0; i < items.length; i++) {
            if (smallest == null) {
                smallest = items[i];
                smallestIndex = i;
            } else {
                if (items[i].compareTo(smallest) < 0) {
                    secondSmallest = smallest;
                    secondSmallestIndex = smallestIndex;

                    smallest = items[i];
                    smallestIndex = i;
                } else {
                    if (secondSmallest == null || items[i].compareTo(secondSmallest) < 0) {
                        secondSmallest = items[i];
                        secondSmallestIndex = i;
                    }
                }
            }
        }

        if (secondSmallestIndex != -1) {
            return secondSmallestIndex;
        } else {
            throw new RuntimeException("Problem");
        }
    }
}
