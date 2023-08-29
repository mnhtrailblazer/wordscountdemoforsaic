package com.saic.wordscountdemo;

import java.io.IOException;
import java.util.Map;

public interface WordsCountFromAFile {
	
	public Map<String, Long> GetWordsCount(String fileName, boolean ignoreWordCase) throws IOException ;
}	
