package com.saic.wordscountdemo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WordsCountFromFileUsingStreams implements WordsCountFromAFile {

	@Override
	public Map<String, Long> GetWordsCount(String fileName, boolean ignoreWordCase) throws IOException {
		
		Map<String, Long> wordsCountMap = Files.lines(Paths.get(fileName))
				.flatMap(line -> Arrays.stream(line.split(" ")))
				.collect(Collectors.groupingBy(ignoreWordCase ? String::toLowerCase : Function.identity(), TreeMap::new, Collectors.counting()));

		return wordsCountMap;
	}

}
