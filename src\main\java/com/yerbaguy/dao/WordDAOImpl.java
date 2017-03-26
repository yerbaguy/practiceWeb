package com.yerbaguy.dao;



//import java.util.logging.Logger; conflicted with org.slf4j.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Repository;


import com.yerbaguy.model.Word;

@Repository
public class WordDAOImpl implements WordDAO {
	
	
	private static final Logger logger = LoggerFactory.getLogger(WordDAOImpl.class);
	
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void save(Word word) {
		
		//Session session = this.sessionFactory.openSession();
		Session session = this.sessionFactory.getCurrentSession();
		
		//Transaction tx = session.beginTransaction();
		session.persist(word);
		//tx.commit();
		//session.close();
		
		logger.info("Words saved successfully, Words details" + word);
		
	}

	public void addWord(Word word) {
		
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(word);
	}
	
	
}
