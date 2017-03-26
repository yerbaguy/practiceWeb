package com.yerbaguy.repository;


import java.io.Serializable;

import javax.persistence.EntityManager;

import com.yerbaguy.model.Word;

//public class WordRepositoryImpl implements WordRepository {
public class CrudRepositoryImpl implements CrudRepository {

	public Word findByCount(Long wordId) {
		
		return null;
	}

	@Override
	public Object findByCount(Serializable wordId) {
		// TODO Auto-generated method stub
		return null;
	}
}
