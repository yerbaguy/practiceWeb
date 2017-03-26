package com.yerbaguy.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.repository.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.*;

import com.yerbaguy.model.Word;


//public interface WordDAO extends CrudRepository<Word, Long> {
//public interface WordRepository extends Repository<Word, Long> {
public interface CrudRepository<Word, Long extends Serializable> {	
	
	public Word findByCount(Long wordId);

	public void save(Word word);
	

}
