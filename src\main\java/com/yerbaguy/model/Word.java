package com.yerbaguy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Word {
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int wordId;
	@Column
	private String engWord;
	@Column
	private String plWord;
	
	public void setWordId(int wordId) {
		this.wordId = wordId;
	}
	
	public int getWordId() {
		return this.wordId;
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
