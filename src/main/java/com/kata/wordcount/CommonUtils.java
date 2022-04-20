package com.kata.wordcount;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;

public class CommonUtils {
	public static int getNumberOfWords(String line) throws IOException {
		if(!Objects.isNull(line) && line.trim().length() > 0) {
			line = line.trim();
						
			String trimLine = line.replaceAll("\\s+", " ");
			
			return filterWords(trimLine.split(" "));
		}
		
		return 0;
	}
	
	private static int filterWords(String[] words) throws IOException {
		Path path = Paths.get("src/main/resources/stopwords.txt");
		List<String> filteredWordsList = new ArrayList<>();
		
	    List<String> stopWords = Files.readAllLines(path);
	    
	    for(int i = 0; i < words.length; i++) {
	    	String word = words[i];
	    	if(isAlpha(word) && !stopWords.contains(word)) {
	    		filteredWordsList.add(word);
	    	}
	    }
	    
		return filteredWordsList.size();
	}

	private static boolean isAlpha(String word) {
		return StringUtils.isAlpha(word);
	}
}
