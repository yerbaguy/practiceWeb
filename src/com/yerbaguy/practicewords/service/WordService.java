package com.yerbaguy.practicewords.service;

import com.yerbaguy.practicewords.model.Word;

public interface WordService {
	
	void save(Word word);
	void countWords(Long wordId);

}
