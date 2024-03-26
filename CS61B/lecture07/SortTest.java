import org.junit.Test;
import static org.junit.Assert.*; // simplify code

public class SortTest {
    @Test
    public void testSort() {
        String[] input = {"i", "have", "an", "egg"};
        String[] expected = {"an", "egg", "have", "i"};

        Sort.sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testFindSmallest() {
        String[] input = {"i", "have", "an", "egg"};
        int expected = 2;

        int actual = Sort.findSmallest(input, 0);
        assertEquals(expected, actual);

        
        String[] input2 = {"there", "are", "many", "pigs"};
        int expected2 = 2;

        int actual2 = Sort.findSmallest(input2, 2);
        assertEquals(expected2, actual2);
    }

    @org.junit.Test
    public void testSwap() {
        String[] input = {"i", "have", "an", "egg"};
        String[] expected = {"egg", "have", "an", "i"};

        Sort.swap(input, 0, 3);
        org.junit.Assert.assertArrayEquals(expected, input);
    }
}
