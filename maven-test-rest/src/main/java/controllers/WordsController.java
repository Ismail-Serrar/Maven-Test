package controllers;


import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import models.Word;
import models.WordsList;
import services.WordsService;

@RestController
public class WordsController {

	@GetMapping("/getWords")
	public WordsList getWords(HttpServletRequest request) {
		WordsList wordsList = WordsService.getWordsFromJsonFile();
		request.getSession().setAttribute("SESSION_WORDS", wordsList);
		return wordsList;
	}
	
	@GetMapping("/getWord")
	public Word getWord(@RequestParam(required = true) String id, HttpServletRequest request) {
		
		WordsList wordsList = (WordsList) request.getSession().getAttribute("SESSION_WORDS");
		return WordsService.getWordFromSession(id, wordsList);
		
	}
	
	@GetMapping("/destroySession")
	public String destroySession(HttpServletRequest request) {
		request.getSession().invalidate();
		return "Session destroyed";
	}
	
	@PostMapping("/addWord")
	public WordsList addWord(@RequestParam(required = true) String id,
						   @RequestParam(required = true) String label,
						   @RequestParam(required = true) String date, HttpServletRequest request) {
		WordsList wordsList = (WordsList) request.getSession().getAttribute("SESSION_WORDS");
		wordsList = WordsService.addWordToSession(id, label, date, wordsList);
		request.getSession().setAttribute("SESSION_WORDS", wordsList);
		return wordsList;
	}
	
	@PutMapping("/updateWord")
	public WordsList updateWord(@RequestParam(required = true) String id, 
						   @RequestParam(required = true) String label,
						   @RequestParam(required = true) String date, HttpServletRequest request) {
		WordsList wordsList = (WordsList) request.getSession().getAttribute("SESSION_WORDS");
		wordsList = WordsService.updateWordInSession(id, label, date, wordsList);
		request.getSession().setAttribute("SESSION_WORDS", wordsList);
		return wordsList;
	}
	
	@DeleteMapping("/deleteWord")
	public WordsList deleteWord(@RequestParam(required = true) String id, HttpServletRequest request) {
		WordsList wordsList = (WordsList) request.getSession().getAttribute("SESSION_WORDS");
		wordsList = WordsService.deleteWordFromSession(id, wordsList);
		request.getSession().setAttribute("SESSION_WORDS", wordsList);
		return wordsList;
	}
	
}










