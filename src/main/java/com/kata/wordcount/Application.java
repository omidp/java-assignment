package com.kata.wordcount;

import java.util.Objects;
import java.util.Scanner;

public class Application {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter text:");
			
			
			System.out.println("Number of words: " + getNumberOfWords(sc.nextLine()));
		}  
	}

	public static int getNumberOfWords(String line) {
		if(!Objects.isNull(line) && line.trim().length() > 0) {
			line = line.trim();
			
			String trimLine = line.replaceAll("\\s+", " ");

			String[] strArray = trimLine.split(" ");
			
			return strArray.length;
		}
		
		return 0;
	}
}
