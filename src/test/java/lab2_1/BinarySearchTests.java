package lab2_1;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

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
        assertThat(searchResult.isFound(), is(equalTo(true)));
        assertThat(elementToFind, is(equalTo(tabOfLengthOne[searchResult.getPosition()])));
    }

    @Test
    public void shouldSayThatElementIsNotFoundInTabOfLengthZeroAndReturnIndexMinusOne() {
        int elementToFind = 1;
        SearchResult searchResult = BinarySearch.search(elementToFind, tabOfLengthOne);
        assertThat(searchResult.isFound(), is(equalTo(false)));
        assertThat(searchResult.getPosition(), is(equalTo(-1)));
    }

    @Test
    public void shouldSayThatElementIsFoundAndIsInPositionOfIndexZeroInBiggerTab() {
        int elementToFind = biggerTab[0];
        SearchResult searchResult = BinarySearch.search(elementToFind, biggerTab);
        assertThat(searchResult.isFound(), is(equalTo(true)));
        assertThat(elementToFind, is(equalTo(biggerTab[searchResult.getPosition()])));
    }

    @Test
    public void shouldSayThatElementIsFoundAndIsInLastPositionInBiggerTab() {
        int elementToFind = biggerTab[biggerTab.length - 1];
        SearchResult searchResult = BinarySearch.search(elementToFind, biggerTab);
        assertThat(searchResult.isFound(), is(equalTo(true)));
        assertThat(elementToFind, is(equalTo(biggerTab[searchResult.getPosition()])));
    }

    @Test
    public void shouldSayThatElementIsFoundAndIsInMiddlePositionInBiggerTab() {
        int elementToFind = biggerTab[(biggerTab.length - 1) / 2];
        SearchResult searchResult = BinarySearch.search(elementToFind, biggerTab);
        assertThat(searchResult.isFound(), is(equalTo(true)));
        assertThat(elementToFind, is(equalTo(biggerTab[searchResult.getPosition()])));
    }

    @Test
    public void shouldSayThatElementIsNotFoundInBiggerTabAndReturnMinusOne() {
        int elementToFind = -1;
        SearchResult searchResult = BinarySearch.search(elementToFind, biggerTab);
        assertThat(searchResult.isFound(), is(equalTo(false)));
        assertThat(searchResult.getPosition(), is(equalTo(-1)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrownIllegalArgumentExceptionOnWrongParameters() {
        BinarySearch.search(0, new int[0]);
    }

}
