package com.yerbaguy.service;


import com.yerbaguy.model.Word;

public interface WordService {
	
	void countWords(Long wordId);
    //void saveWords(Word word);
    void save(Word word);
	
	

}
