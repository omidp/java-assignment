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

		System.out.println("Number of words: " + CommonUtils.getNumberOfWords(StringUtils.join(words, " ")));
	}
}
