import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import com.kata.wordcount.CommonUtils;

public class ApplicationTest {

	@Test
	public void numberOfWordsAreCorrect() throws IOException {
		assertEquals(CommonUtils.getNumberOfWords("This is a sentence"), 4);
	}
	
	@Test
	public void aWord() throws IOException {
		assertEquals(CommonUtils.getNumberOfWords("Hello"), 1);
	}
	
	@Test
	public void noWordsEntered() throws IOException {
		assertEquals(CommonUtils.getNumberOfWords(""), 0);
	}
	
	@Test
	public void nullValueEntered() throws IOException {
		assertEquals(CommonUtils.getNumberOfWords(null), 0);
	}
	
	@Test
	public void whiteSpaceValueEntered() throws IOException {
		assertEquals(CommonUtils.getNumberOfWords("   "), 0);
	}
	
	@Test
	public void sentenceWithWhiteSpaceValueEntered() throws IOException {
		assertEquals(CommonUtils.getNumberOfWords("This is    gap   sentence"), 4);
	}
	
	@Test
	public void initialSentenceWithWhiteSpaceValueEntered() throws IOException {
		assertEquals(CommonUtils.getNumberOfWords("   This is    gap   sentence"), 4);
	}
	
	@Test
	public void trailingSentenceWithWhiteSpaceValueEntered() throws IOException {
		assertEquals(CommonUtils.getNumberOfWords("This is    gap   sentence    "), 4);
	}
	
	@Test
	public void wordsWithNumerics() throws IOException {
		assertEquals(CommonUtils.getNumberOfWords("This is sentence with numeric 123"), 5);
	}
	
	@Test
	public void wordsWithAlphaNumerics() throws IOException {
		assertEquals(CommonUtils.getNumberOfWords("This is sentence with ab1c alphanumeric"), 5);
	}
	
	@Test
	public void sentenceWithStopWords() throws IOException {
		assertEquals(CommonUtils.getNumberOfWords("Mary had a little lamb"), 4);
	}
	
	@Test
	public void sentenceWithStopWords2() throws IOException {
		assertEquals(CommonUtils.getNumberOfWords("John says hello"), 2);
	}
}
