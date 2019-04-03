package lab2_1;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import edu.iis.mto.bsearch.BinarySearch;
import edu.iis.mto.bsearch.SearchResult;

public class BinarySearchTests {

    @Test
    public void shouldSayThatElementIsFoundAndIsInPositionOfIndexZeroInTabOfLengthZero() {
        int elementToFind = 0;
        int[] sequence = {0};
        SearchResult searchResult = BinarySearch.search(elementToFind, sequence);
        assertThat(searchResult.isFound(), is(equalTo(true)));
        assertThat(elementToFind, is(equalTo(sequence[searchResult.getPosition()])));
    }

    @Test
    public void shouldSayThatElementIsNotFoundInTabOfLengthZeroAndReturnIndexMinusOne() {
        int elementToFind = 1;
        int[] sequence = {0};
        SearchResult searchResult = BinarySearch.search(elementToFind, sequence);
        assertThat(searchResult.isFound(), is(equalTo(false)));
        assertThat(searchResult.getPosition(), is(equalTo(-1)));
    }

    @Test
    public void shouldSayThatElementIsFoundAndIsInPositionOfIndexZeroInsequence() {
        int elementToFind = 0;
        int[] sequence = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        SearchResult searchResult = BinarySearch.search(elementToFind, sequence);
        assertThat(searchResult.isFound(), is(equalTo(true)));
        assertThat(elementToFind, is(equalTo(sequence[searchResult.getPosition()])));
    }

    @Test
    public void shouldSayThatElementIsFoundAndIsInLastPositionInsequence() {
        int[] sequence = {3, 53, 1124, 214124, 523124};
        int elementToFind = sequence[sequence.length - 1];
        SearchResult searchResult = BinarySearch.search(elementToFind, sequence);
        assertThat(searchResult.isFound(), is(equalTo(true)));
        assertThat(elementToFind, is(equalTo(sequence[searchResult.getPosition()])));
    }

    @Test
    public void shouldSayThatElementIsFoundAndIsInMiddlePositionInsequence() {
        int[] sequence = {0, 12, 123, 235, 574, 1245, 12436, 123333, 981725, 127842784, 1278427841};
        int elementToFind = sequence[(sequence.length - 1) / 2];
        SearchResult searchResult = BinarySearch.search(elementToFind, sequence);
        assertThat(searchResult.isFound(), is(equalTo(true)));
        assertThat(elementToFind, is(equalTo(sequence[searchResult.getPosition()])));
    }

    @Test
    public void shouldSayThatElementIsNotFoundInsequenceAndReturnMinusOne() {
        int elementToFind = -1;
        int[] sequence = {0, 1, 54, 76, 124, 6457, 1243436, 21986};
        SearchResult searchResult = BinarySearch.search(elementToFind, sequence);
        assertThat(searchResult.isFound(), is(equalTo(false)));
        assertThat(searchResult.getPosition(), is(equalTo(-1)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrownIllegalArgumentExceptionOnWrongParameters() {
        BinarySearch.search(0, new int[0]);
    }

}
