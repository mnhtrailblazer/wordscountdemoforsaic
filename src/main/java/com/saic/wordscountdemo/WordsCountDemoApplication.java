package com.saic.wordscountdemo;

import java.io.IOException;
import java.util.Map;
import java.util.logging.Logger;

public class WordsCountDemoApplication {
	
	private static Logger logger = Logger.getLogger(WordsCountDemoApplication.class.getName());

	public static void main(String[] args) throws IOException {

		boolean ignoreWordCase = false;
        String filename = "SAICDemoData.txt";
		
		if (args.length == 0 || args[0] == null || args[0].trim().isEmpty()) {	        
	        logger.warning("Warning!!! You did not provide filename with path as an argument to this program, so using the default data file.");
		}else { 
	    	filename = args[0];
		}
	       
		// 1. Calling GetWordsCountFromFileWithoutUsingStreams
		
		WordsCountFromAFile wordsCountFromFileWithoutUsingStreams = new WordsCountFromFileWithoutUsingStreams();
		
		Map<String, Long> wordsCountWithoutUsingStreams = wordsCountFromFileWithoutUsingStreams.GetWordsCount(
				filename , ignoreWordCase);

		System.out.println("Word, No. of occurences");
		for (Map.Entry<String, Long> word : wordsCountWithoutUsingStreams.entrySet()) {
			System.out.println(word.getKey() + ", " + word.getValue());		
		}
		
		System.out.println("===========================================[Another Way using Using Streams and Labmda]");
		// 2. Calling GetWordsCountFromFileUsingStreams
		
		WordsCountFromAFile wordsCountFromFileUsingStreams = new WordsCountFromFileUsingStreams();

		Map<String, Long> wordsCountUsingStreams = wordsCountFromFileUsingStreams.GetWordsCount(
				filename, ignoreWordCase);

		System.out.println("Word, No. of occurences");
		for (Map.Entry<String, Long> word : wordsCountUsingStreams.entrySet()) {
			System.out.println(word.getKey() + ", " + word.getValue());
		}
	}

}
