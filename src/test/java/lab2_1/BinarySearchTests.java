package lab2_1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import edu.iis.mto.bsearch.BinarySearch;
import edu.iis.mto.bsearch.SearchResult;

public class BinarySearchTests {

    private final int[] tabOfLengthOne = {0};
    private final int[] biggerTab = {0, 1, 2, 3, 4, 5, 6, 7, 8};

    @Test
    public void shouldSayThatElementIsFoundAndIsInPositionOfIndexZeroInTabOfLengthZero() {
        int elementToFind = 0;
        SearchResult searchResult = BinarySearch.search(elementToFind, tabOfLengthOne);
        assertTrue(searchResult.isFound());
        assertEquals(elementToFind, tabOfLengthOne[searchResult.getPosition()]);
    }

    @Test
    public void shouldSayThatElementIsNotFoundInTabOfLengthZeroAndReturnIndexMinusOne() {
        int elementToFind = 1;
        SearchResult searchResult = BinarySearch.search(elementToFind, tabOfLengthOne);
        assertFalse(searchResult.isFound());
        assertEquals(-1, searchResult.getPosition());
    }

    @Test
    public void shouldSayThatElementIsFoundAndIsInPositionOfIndexZeroInBiggerTab() {
        int elementToFind = biggerTab[0];
        SearchResult searchResult = BinarySearch.search(elementToFind, biggerTab);
        assertTrue(searchResult.isFound());
        assertEquals(elementToFind, biggerTab[searchResult.getPosition()]);
    }

    @Test
    public void shouldSayThatElementIsFoundAndIsInLastPositionInBiggerTab() {
        int elementToFind = biggerTab[biggerTab.length - 1];
        SearchResult searchResult = BinarySearch.search(elementToFind, biggerTab);
        assertTrue(searchResult.isFound());
        assertEquals(elementToFind, biggerTab[searchResult.getPosition()]);
    }

    @Test
    public void shouldSayThatElementIsFoundAndIsInMiddlePositionInBiggerTab() {
        int elementToFind = biggerTab[(biggerTab.length - 1) / 2];
        SearchResult searchResult = BinarySearch.search(elementToFind, biggerTab);
        assertTrue(searchResult.isFound());
        assertEquals(elementToFind, biggerTab[searchResult.getPosition()]);
    }

    @Test
    public void shouldSayThatElementIsNotFoundInBiggerTabAndReturnMinusOne() {
        int elementToFind = -1;
        SearchResult searchResult = BinarySearch.search(elementToFind, biggerTab);
        assertFalse(searchResult.isFound());
        assertEquals(-1, searchResult.getPosition());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrownIllegalArgumentExceptionOnWrongParameters() {
        BinarySearch.search(0, new int[0]);
    }

}
