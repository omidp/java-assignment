import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.kata.wordcount.Application;

public class ApplicationTest {

	@Test
	public void numberOfWordsAreCorrect() {
		assertEquals(Application.getNumberOfWords("This is a sentence"), 4);
	}
	
	@Test
	public void aWord() {
		assertEquals(Application.getNumberOfWords("Hello"), 1);
	}
	
	@Test
	public void noWordsEntered() {
		assertEquals(Application.getNumberOfWords(""), 0);
	}
	
	@Test
	public void nullValueEntered() {
		assertEquals(Application.getNumberOfWords(null), 0);
	}
	
	@Test
	public void whiteSpaceValueEntered() {
		assertEquals(Application.getNumberOfWords("   "), 0);
	}
	
	@Test
	public void sentenceWithWhiteSpaceValueEntered() {
		assertEquals(Application.getNumberOfWords("This is    gap   sentence"), 4);
	}
	
	@Test
	public void initialSentenceWithWhiteSpaceValueEntered() {
		assertEquals(Application.getNumberOfWords("   This is    gap   sentence"), 4);
	}
	
	@Test
	public void trailingSentenceWithWhiteSpaceValueEntered() {
		assertEquals(Application.getNumberOfWords("This is    gap   sentence    "), 4);
	}
}
