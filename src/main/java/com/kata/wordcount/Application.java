package com.kata.wordcount;

import java.io.IOException;
import java.util.Scanner;

public class Application {
	public static void main(String[] args) throws IOException {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter text:");
			
			
			System.out.println("Number of words: " + CommonUtils.getNumberOfWords(sc.nextLine()));
		}  
	}
}
