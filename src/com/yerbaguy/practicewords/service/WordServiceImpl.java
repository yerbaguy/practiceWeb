package com.yerbaguy.practicewords.service;



import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;

import com.yerbaguy.practicewords.model.Word;
import com.yerbaguy.practicewords.repository.WordRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class WordServiceImpl implements WordService {
	
	@Autowired
	private WordRepository wordRepository;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	private Query em;
	
	//private PreparedStatement preparedStatement = null;
	
	@Override
	public void save(Word word) {
		wordRepository.save(word);
	}
	
	
	public long countWords() {
		Word word = new Word();
		
		Query query = entityManager.createQuery("SELECT COUNT(w) FROM Word w");
		long count = (long)query.getSingleResult();
		
		return count;
	}
	
	@Override
	public void countWords(Long wordId) {
	
	}
	
	public int getRandom() {
		
		Random random = new Random();
		int number = random.nextInt((int)this.countWords());
		
		
		
		
		return number; 
	}
	
	public String getWord() {
		
		int random = this.getRandom();
		
		Query query = entityManager.createNativeQuery("Select plWord from Word Where wordId = " + random);
	    String wordd = (String)query.getSingleResult();
		
		return wordd;
	}
	
	//public int findWord(String engWord) {
	public Word findWord(String engWord) {
		
		Word word = new Word();
		
		String engword = "";
		engword = engWord;
		
		//Query query = entityManager.createNativeQuery("Select wordId from Word Where engWord = " + engWord);
		
		//Query query = entityManager.createQuery("Select C.wordId from Word C where C.engWord = " + engWord);
		
		Query query = entityManager.createQuery("Select c.wordId from Word c where c.engWord = " + engWord);
		
		//int wordid = (Integer)query.getSingleResult();
		
		word = (Word)query.getSingleResult();
		
		//int wordid = 1;
		
		//return wordid;
		return word;
	}

}
