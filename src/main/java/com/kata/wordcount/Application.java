package com.kata.wordcount;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;


public class Application {
	public static void main(String[] args) throws IOException {
		boolean isIndex = false;
		
		try (Scanner sc = new Scanner(System.in)) {
			Path path = Paths.get("src/main/resources/dictionary.txt");

			while(true) {
				System.out.println("Enter text:");
				String input = sc.nextLine();
				
				if(!StringUtils.isBlank(input)) {
					List<String> filteredWords = CommonUtils.getFilteredWords(input);
					List<String> uniqueWords = CommonUtils.getUniqueWords(filteredWords);


					System.out.println("Number of words: " + filteredWords.size() + ", unique: " + uniqueWords.size() 
					+ "; average word length: " + CommonUtils.getAverageWordLength(filteredWords) + " characters");

					if(isIndex && Files.exists(path)) {
						System.out.println("here:");
						List<String> dictWords = Files.readAllLines(path);
						Map<String, Object> updatedMap = CommonUtils.markUnknownWords(filteredWords, dictWords);
						
					
						List<String> updatedFilteredWords = (List<String>) updatedMap.get("filteredWords");
						
						System.out.println("Index (unknown: " + updatedMap.get("count") + "): ");
						for(String str : updatedFilteredWords) {
							System.out.println(str);
						}
					}
				}else {
					break;
				}
			}
		}
	}
}
