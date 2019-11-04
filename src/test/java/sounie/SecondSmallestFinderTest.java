package sounie;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SecondSmallestFinderTest {
    @Test
    public void shouldFindSecondSmallestInSmallArray() {
        SecondSmallestFinder<Integer> simple = new SecondSmallestFinder<>(new Integer[] {2, 1});

        assertEquals(0, simple.findSecondSmallest());
    }

    @Test
    public void shouldFindSecondSmallestInJumbledArray() {
        SecondSmallestFinder<Integer> jumbled = new SecondSmallestFinder<>(new Integer[] {5, 7, 1, 3, 8, 0, -1, 2});

        assertEquals(5, jumbled.findSecondSmallest());
    }

    @Test
    public void shouldFindSecondOrderedByWording() {
        SecondSmallestFinder<String> words = new SecondSmallestFinder<>(new String[] {"Giraffe", "Banana", "Zebra", "Animal", "Computer"});

        assertEquals(1, words.findSecondSmallest());
    }
}