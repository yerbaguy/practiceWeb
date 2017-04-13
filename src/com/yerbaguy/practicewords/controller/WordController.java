package com.yerbaguy.practicewords.controller;



import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yerbaguy.practicewords.model.Word;

import com.yerbaguy.practicewords.service.WordService;
import com.yerbaguy.practicewords.service.WordServiceImpl;

import com.yerbaguy.practicewords.repository.WordRepository;


@Controller
public class WordController {
	
	
	//@RequestMapping(value = "/index", method = RequestMethod.GET)
	//public String index(Model model) {
		
	//	return "index";
	//}
	
	
	@Autowired
	private WordService wordService;
	
	@Autowired
	private WordServiceImpl wordServiceImpl;
	
	
	private WordRepository wordRepository;
	
	
	@RequestMapping(value = "/words", method = RequestMethod.GET)
	public String words(Model model) {
		
		model.addAttribute("wordForm", new Word());
		
		return "words";
	}
	
	
	@RequestMapping(value = "/words", method = RequestMethod.POST)
	public String words(@ModelAttribute("wordForm") Word wordForm, BindingResult bidingResult, Model model, HttpServletRequest request) {
		
		Word word = new Word();
		
		String buttonSubmit = "";
		String buttonSubmit_1 = "";
		String engWord = "";
		
		buttonSubmit = request.getParameter("pulled");
		
		buttonSubmit_1 = request.getParameter("pulled_1");
		
		if ("pulled".equals(buttonSubmit)) {
			System.out.println("Clicked");
			//System.out.println(wordServiceImpl.countWord());
			System.out.println(wordServiceImpl.countWords());
			System.out.println(wordServiceImpl.getWord());
		}	
		
		if ("pulled_1".equals(buttonSubmit_1)) {
			System.out.println("Clicked_1");
			
			engWord = request.getParameter("engWord");
			System.out.println(engWord);
			System.out.println(wordServiceImpl.findWord(engWord));
			System.out.println(wordRepository.findByEngWord(engWord));
		}
		
		return "words";
	}
	
	
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
	     
	    
	     
	     
	     System.out.println(word.getEngWord());
	     System.out.println(word.getPlWord());
	     
	    // wordServiceImpl.saveWords(word);
	     //this.wordService.saveWords(word);
	     wordService.save(wordsForm);
	    
	    
	     
	     //wordDAOImpl.save(word);
		
		
		return "addwords";
	}
	
	
	
	
	@RequestMapping(value = {"/","/index"}, method = RequestMethod.GET)
	public String index(Model model) {
		
		return "index";
	}

}
