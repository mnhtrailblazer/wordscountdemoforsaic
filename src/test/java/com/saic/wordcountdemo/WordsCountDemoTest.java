package com.saic.wordcountdemo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.saic.wordscountdemo.WordsCountFromAFile;
import com.saic.wordscountdemo.WordsCountFromFileUsingStreams;
import com.saic.wordscountdemo.WordsCountFromFileWithoutUsingStreams;


class WordsCountDemoTest {

	@Test
	public void testFileReaderWordsCountWithoutStreamsIgnoreCase() throws IOException {
		
		boolean ignoreWordCase = true;
		
		WordsCountFromAFile wordsCountFromFileWithoutUsingStreams = new WordsCountFromFileWithoutUsingStreams();
		
		Map<String, Long> wordsCountWithoutUsingStreams = wordsCountFromFileWithoutUsingStreams.GetWordsCount(
				"SAICDemoTestData.txt", ignoreWordCase);
		
		assertEquals(14, wordsCountWithoutUsingStreams.size());
		assertEquals(2, wordsCountWithoutUsingStreams.get("saic"));
		
	}

	@Test
	public void testFileReaderWordsCountWithoutStreamsNotIgnoringCase() throws IOException {
		
		boolean ignoreWordCase = false;
		
		WordsCountFromAFile wordsCountFromFileWithoutUsingStreams = new WordsCountFromFileWithoutUsingStreams();
		
		Map<String, Long> wordsCountWithoutUsingStreams = wordsCountFromFileWithoutUsingStreams.GetWordsCount(
				"SAICDemoTestData.txt", ignoreWordCase);
		
		assertEquals(15, wordsCountWithoutUsingStreams.size());
		assertEquals(1, wordsCountWithoutUsingStreams.get("saic"));
		
	}
	
	@Test
	public void testFileReaderWordsCountUsingStreamsIgnoreCase() throws IOException {
		
		boolean ignoreWordCase = true;
		
		WordsCountFromAFile wordsCountFromFileUsingStreams = new WordsCountFromFileUsingStreams();
		
		Map<String, Long> wordsCountWithoutUsingStreams = wordsCountFromFileUsingStreams.GetWordsCount(
				"SAICDemoTestData.txt", ignoreWordCase);
		
		assertEquals(14, wordsCountWithoutUsingStreams.size());
		assertEquals(2, wordsCountWithoutUsingStreams.get("saic"));
		
	}
	
	@Test
	public void testFileReaderWordsCountUsingStreamsNotIgnoringCase() throws IOException {
		
		boolean ignoreWordCase = false;
		
		WordsCountFromAFile wordsCountFromFileUsingStreams = new WordsCountFromFileUsingStreams();
		
		Map<String, Long> wordsCountWithoutUsingStreams = wordsCountFromFileUsingStreams.GetWordsCount(
				"SAICDemoTestData.txt", ignoreWordCase);
		
		assertEquals(15, wordsCountWithoutUsingStreams.size());
		assertEquals(1, wordsCountWithoutUsingStreams.get("SAIC"));
		
	}

}
