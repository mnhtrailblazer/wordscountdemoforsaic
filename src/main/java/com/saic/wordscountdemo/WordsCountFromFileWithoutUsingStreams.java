package com.saic.wordscountdemo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class WordsCountFromFileWithoutUsingStreams implements WordsCountFromAFile {

	@Override
	public Map<String, Long> GetWordsCount(String fileName, boolean ignoreWordCase) throws IOException {

		try (FileReader file = new FileReader(fileName); BufferedReader bufferedReader = new BufferedReader(file)) {

			Map<String, Long> wordsCountTreeMap = new TreeMap<String, Long>();
			String line;

			while ((line = bufferedReader.readLine()) != null) {
				String words[] = line.split(" ");
				for (String word : words) {
					if (ignoreWordCase)
						word = word.toLowerCase();
					if (!wordsCountTreeMap.containsKey(word)) {
						wordsCountTreeMap.put(word, 1L);
					} else {
						wordsCountTreeMap.put(word, (wordsCountTreeMap.get(word) + 1L));
					}
				}
			}

			bufferedReader.close();

			return wordsCountTreeMap;
		}

	}

}
