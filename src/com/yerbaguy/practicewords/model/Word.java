package com.yerbaguy.practicewords.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;



@Entity
@Table(name = "Word")
@NamedNativeQueries({
		
		@NamedNativeQuery(name="Word.findIdByEngWord", query="SELECT wordid FROM Word WHERE engWord = ?", resultClass=Word.class),
		@NamedNativeQuery(name="Word.countWords", query="SELECT COUNT(*) FROM Word", resultClass=Word.class),
		@NamedNativeQuery(name="Word.getWord", query="SELECT plWord from Word WHERE wordid = ?", resultClass=Word.class),
		@NamedNativeQuery(name="Word.findWord", query="SELECT wordid from Word WHERE engWord = ?", resultClass=Word.class)
})
public class Word {
	
	@Id
//	@Column(name = "wordid", insertable = false, updatable = false)
	@Column(insertable = false, updatable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	//private Long wordid;
	private int wordid;
	@Column(name = "engword")
	private String engWord;
	@Column(name = "plword")
	private String plWord;
	
	public Word() {
		
	}
	
	public Word(String engWord, String plWord) {
		this.engWord = engWord;
		this.plWord = plWord;
	}
	
	
	
	
	
	public void setWordId(int wordid) {
		this.wordid = wordid;
	}
	
	public int getWordId() {
		return this.wordid;
	}
	
	public void setEngWord(String engWord) {
		this.engWord = engWord;
	}
	
	public String getEngWord() {
		return this.engWord;
	}
	
	public void setPlWord(String plWord) {
		this.plWord = plWord;
	}
	
	public String getPlWord() {
		return this.plWord;
	}
	
	

}
