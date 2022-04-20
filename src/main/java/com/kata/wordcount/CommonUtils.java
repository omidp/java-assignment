package com.kata.wordcount;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

public class CommonUtils {
	public static int getNumberOfWords(String line) throws IOException {
		String[] wordArr = convertLineToStrArray(line);
		
		if(!Objects.isNull(wordArr)) {
			
			return filterWords(wordArr);
		}
		
		return 0;
	}
	
	public static List<String> getFilteredWords(String line) throws IOException {
		return getFilteredWords(convertLineToStrArray(line));
	}
	
	public static List<String> getUniqueWords(List<String> oriWords) throws IOException {
		Set<String> set = new HashSet<>();
		
		if(oriWords != null) {
			for(String s : oriWords) {
				set.add(s);
			}
		}
		
		return new ArrayList<>(set);
	}
	
	private static int filterWords(String[] words) throws IOException {
		List<String> filteredWordsList = getFilteredWords(words);
		
	    
		return filteredWordsList.size();
	}
	
	private static List<String> getFilteredWords(String[] words) throws IOException {
		Path path = Paths.get("src/main/resources/stopwords.txt");
		List<String> filteredWordsList = new ArrayList<>();
		
	    List<String> stopWords = Files.readAllLines(path);
	    
	    for(int i = 0; i < words.length; i++) {
	    	String word = words[i];
	    	if(isAlpha(word) && !stopWords.contains(word)) {
	    		filteredWordsList.add(word);
	    	}
	    }
	    
	    return filteredWordsList;
	}

	private static boolean isAlpha(String word) {
		return StringUtils.isAlpha(word);
	}
	
	private static String[] convertLineToStrArray(String line) {
		if(!Objects.isNull(line) && line.trim().length() > 0) {
			line = line.trim();
						
			String trimLine = line.replaceAll("\\s+", " ");
			trimLine = trimLine.replace(".", "");
			trimLine = trimLine.replace("-", "");
			
			return trimLine.split(" ");
		}
		
		return new String[0];
	}
}
