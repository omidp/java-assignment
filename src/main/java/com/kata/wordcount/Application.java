package com.kata.wordcount;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.apache.commons.lang3.StringUtils;


public class Application {
	public static void main(String[] args) throws IOException {
		Path path = Paths.get("src/main/resources/mytext.txt");
		List<String> words = Files.readAllLines(path);

		List<String> filteredWords = CommonUtils.getFilteredWords(StringUtils.join(words, " "));
		List<String> uniqueWords = CommonUtils.getUniqueWords(filteredWords);
		
				
		System.out.println("Number of words: " + filteredWords.size() + ", unique: " + uniqueWords.size() 
		+ "; average word length: " + CommonUtils.getAverageWordLength(filteredWords) + " characters");
	}
}
