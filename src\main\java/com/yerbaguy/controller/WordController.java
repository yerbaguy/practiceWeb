package com.yerbaguy.controller;



import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mysql.jdbc.ResultSetRow;

import com.yerbaguy.model.Word;


import com.yerbaguy.service.WordService;
import com.yerbaguy.service.WordServiceImpl;

import com.yerbaguy.dao.WordDAOImpl;


@Controller
public class WordController {
	
	
	//@RequestMapping(value = "/index", method = RequestMethod.GET)
	//public String index(Model model) {
		
	//	return "index";
	//}
	
	

	
	@Autowired
	private WordServiceImpl wordServiceImpl;
	
	@Autowired
	private WordService wordService;
	
	//@Autowired
	private WordDAOImpl wordDAOImpl;
	
	//@Autowired
	//private ResultSetRow resultSetRow;
	
	
	@RequestMapping(value = "/addwords", method = RequestMethod.GET)
	public String addWords(Model model) {
		
		model.addAttribute("wordsForm", new Word());
		
		return "addwords";
	}
	
	@RequestMapping(value = "/addwords", method = RequestMethod.POST)
	public String addwords(@ModelAttribute("wordsForm") Word wordsForm, BindingResult bindingResult, HttpServletRequest request) {
		
		 Word word = new Word();
		
	     String engWord = "";
	     String plWord = "";
	     
	     engWord = request.getParameter("engWord");
	     plWord = request.getParameter("plWord");
	     
	     System.out.println(engWord);
	     System.out.println(plWord);
	     
	     //word.setEngWord(resultSetRow.);
	     
	     word.setEngWord(engWord);
	     word.setPlWord(plWord);
	     
	     //word.setEngWo);
	     
	    
	     
	     
	     //System.out.println("English word is about to be added:" + word.getEngWord());
	     System.out.println("English word is about to be added:" + wordsForm);
	     //System.out.println("Polish word is about to be added" + word.getPlWord());
	     
	     
	     //wordServiceImpl.saveWords(word);
//	     wordServiceImpl.save(wordsForm);
	     wordService.save(wordsForm);
	     
	     //this.wordService.saveWords(word);
	    
	     
	     //wordDAOImpl.save(word);
		
		
		return "addwords";
	}
	
	
	
	
	@RequestMapping(value = "/words", method = RequestMethod.GET)
	public String words(Model model) {
		
		model.addAttribute("wordForm", new Word());
		
		return "words";
	}
	
	
	@RequestMapping(value = "/words", method = RequestMethod.POST)
	public String words(@ModelAttribute("wordForm") Word wordForm, BindingResult bidingResult, Model model, HttpServletRequest request) {
		
		
		String buttonSubmit = "";
		
//		long count = wordDAO.count();
		
		buttonSubmit = request.getParameter("pulled");
		
		if ("pulled".equals(buttonSubmit)) {
			System.out.println("Clicked");
			//System.out.println(wordDAOImpl.count());
			System.out.println(wordServiceImpl.countWords());
		}
		
		
		
		
		
		
		return "words";
	}
	
	
	
	
	@RequestMapping(value = {"/","/index"}, method = RequestMethod.GET)
	public String index(Model model) {
		
		return "index";
	}

}
