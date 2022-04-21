import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
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
	
	@Test
	public void sentenceFromFile() throws IOException {
		Path path = Paths.get("src/main/resources/mytext.txt");
		List<String> words = Files.readAllLines(path);
		
		assertEquals(CommonUtils.getNumberOfWords(StringUtils.join(words, " ")), 7);
	}
	
	@Test
	public void getFilteredWords() throws IOException {
		assertEquals(CommonUtils.getFilteredWords("Mary sat on a wall. Mary had a great fall").size(), 7);
	}
	
	@Test
	public void getFilteredWords_null() throws IOException {
		assertEquals(CommonUtils.getFilteredWords(null).size(), 0);
	}
	
	@Test
	public void getFilteredWords_whitespace() throws IOException {
		assertEquals(CommonUtils.getFilteredWords("   ").size(), 0);
	}
	
	@Test
	public void getUniqueWords() throws IOException {
		assertEquals(CommonUtils.getUniqueWords(CommonUtils.getFilteredWords("Mary sat on a wall. Mary had a great fall")).size(), 6);
	}
	
	
	@Test
	public void getUniqueWords_null() throws IOException {
		assertEquals(CommonUtils.getUniqueWords(null).size(), 0);
	}
	
	@Test
	public void getUniqueWords_whitespace() throws IOException {
		assertEquals(CommonUtils.getUniqueWords(new ArrayList<String>()).size(), 0);
	}
	
	@Test
	public void getFilteredWordsWithHyphen() throws IOException {
		assertNotEquals(CommonUtils.getFilteredWords("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall").size(), 11);
	}
	
	@Test
	public void getUniqueWordsWithHyphen() throws IOException {
		assertNotEquals(CommonUtils.getUniqueWords(CommonUtils.getFilteredWords("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall")).size(), 8);
	}
	
	@Test
	public void getFilteredWordsWithHyphen2() throws IOException {
		assertEquals(CommonUtils.getFilteredWords("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall").size(), 9);
	}
	
	@Test
	public void getUniqueWordsWithHyphen2() throws IOException {
		assertEquals(CommonUtils.getUniqueWords(CommonUtils.getFilteredWords("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall")).size(), 7);
	}
	
	@Test
	public void getAverageWordLength() throws IOException {
		assertEquals(CommonUtils.getAverageWordLength(CommonUtils.getFilteredWords("Mary sat on a wall. Mary had a great fall")), 3.0, 0);
	}
	
	@Test
	public void getAverageWordLength2() throws IOException {
		assertEquals(CommonUtils.getAverageWordLength(CommonUtils.getFilteredWords("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall")), 5.0, 0);
	}
	
	@Test
	public void getAverageWordLength_null() throws IOException {
		assertEquals(CommonUtils.getAverageWordLength(null), 0.0, 0);
	}
	
	@Test
	public void getAverageWordLength_empty_list() throws IOException {
		assertEquals(CommonUtils.getAverageWordLength(new ArrayList<>()), 0.0, 0);
	}
	
	@Test
	public void getAverageWordLength_list_empty_words() throws IOException {
		assertEquals(CommonUtils.getAverageWordLength(Arrays.asList("","")), 0.0, 0);
	}
}
