package lab2_1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import edu.iis.mto.bsearch.BinarySearch;
import edu.iis.mto.bsearch.SearchResult;

public class BinarySearchTests {

    private final int[] tabOfLengthOne = {0};

    @Test
    public void shouldSayThatElementIsFoundAndIsInPositionOfIndexZeroInTabOfLengthZero() {
        int elementToFind = 0;
        SearchResult searchResult = BinarySearch.search(elementToFind, tabOfLengthOne);
        assertTrue(searchResult.isFound());
        assertEquals(elementToFind, tabOfLengthOne[searchResult.getPosition()]);
    }

    @Test
    public void shouldSayThatElementIsNotFoundAndReturnIndexMinusOneInTabOfLengthZero() {
        int elementToFind = 1;
        SearchResult searchResult = BinarySearch.search(elementToFind, tabOfLengthOne);
        assertFalse(searchResult.isFound());
        assertEquals(-1, searchResult.getPosition());
    }
}