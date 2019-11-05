package sounie;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveDuplicatesFromArrayTest {
    @Test
    public void noDuplicates() {
        String[] foo = new String[] {"foo"};

        RemoveDuplicatesFromArray<String> duplicatesRemover = new RemoveDuplicatesFromArray<>();

        String[] result = duplicatesRemover.removeDuplicates(foo);

        assertEquals(1, result.length);
        assertArrayEquals(foo, result);
    }

    @Test
    public void shouldRemoveOneDuplicate() {
        String[] doubleFoo = new String[] {"foo", "foo"};

        RemoveDuplicatesFromArray<String> duplicatesRemover = new RemoveDuplicatesFromArray<>();

        String[] result = duplicatesRemover.removeDuplicates(doubleFoo);

        assertEquals(1, result.length);
        assertEquals("foo", result[0]);
    }

    @Test
    public void shouldRemoveMultipleDuplicate() {
        String[] duplicateAtEndAndMiddle = new String[] { "A", "unique", "B", "giraffe", "B", "A"};

        RemoveDuplicatesFromArray<String> duplicatesRemover = new RemoveDuplicatesFromArray<>();

        String[] result = duplicatesRemover.removeDuplicates(duplicateAtEndAndMiddle);

        assertEquals(4, result.length);
        assertArrayEquals(new String[] {"A", "unique", "B", "giraffe"}, result);
    }
}