package com.yerbaguy.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import TypedQuery;



import org.springframework.transaction.annotation.Transactional;

import com.yerbaguy.model.Word;
//import com.yerbaguy.repository.WordRepository;
import com.yerbaguy.repository.CrudRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;




import com.yerbaguy.dao.WordDAO;
import com.yerbaguy.dao.WordDAOImpl;


@Service
public class WordServiceImpl implements WordService {
	
	
	private WordDAO wordDAO;
	
	private WordDAOImpl wordDAOImpl;
	
	public void setWordDAO(WordDAO wordDAO) {
		this.wordDAO = wordDAO;
	}
	
	public void setWordDAOImpl(WordDAOImpl wordDAOImpl) {
		this.wordDAOImpl = wordDAOImpl;
	}
	
	
	
	
	@PersistenceContext
	private EntityManager entityManager;
	
	//private Query em;
	
	//@Autowired
	//WordRepository wordRepository;

	CrudRepository crudRepository;
	
	//public long countWords() {
    public long countWords() {
		
		//long count = 23423L;
		
    	Word word = new Word();
    	
    	
		//TypedQuery<Word> query = entityManager.createQuery(
		//	      "SELECT COUNT(c) FROM Country c", Word.class);
		
		Query query = entityManager.createQuery("SELECT COUNT(w) FROM Word w");
		
		long count = (Long)query.getSingleResult();
    	
		
		return count;
	}

	@Override
	public void countWords(Long wordId) {
		// TODO Auto-generated method stub
		
		//long count = 22323L;
		
		
		
		//wordDAO.count(word);
		//return count;
		//return 0;
	}

	
	//@Override
	//@Transactional
//	public void saveWords(Word word) {
		
		//this.wordDAO.save(word);
//		this.wordDAOImpl.addWord(word);
		
//	}
	
	public void save(Word word) {
		
	       crudRepository.save(word);
	}
	
}
