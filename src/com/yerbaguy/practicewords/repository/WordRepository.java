package com.yerbaguy.practicewords.repository;

//import javax.persistence.ColumnResult;


import com.yerbaguy.practicewords.model.Word;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface WordRepository extends JpaRepository<Word, Long> {
	
	//@Query(value = "SELECT * FROM WORD WHERE ENGWORD = ?1", nativeQuery = true)
	
	//@Query("Select new Word(w.wordId, w.engWord) from Word w where d.engWord = ?1")
	@Query("Select wordId from Word where engWord = '?1'")
	Word findByEngWord(String engWord);

}
