package models;

import java.util.ArrayList;
import java.util.List;

public class WordsList {

	private List<Word> words = new ArrayList<>();

	public WordsList(List<Word> words) {
		super();
		this.words = words;
	}
	
	public WordsList() {
		super();
	}

	public List<Word> getWords() {
		return words;
	}

	public void setWords(List<Word> words) {
		this.words = words;
	}

	public void addWord(Word newWord) {
		List<Word> newWords = new ArrayList<>();
		for(Word word : words) {
			newWords.add(word);
		}
		newWords.add(newWord);
		words = newWords;
	}

	public Word getWord(String id) {
		for (Word word : words) {
			if (word.getId() == Long.parseLong(id)) {
				return word;
			}
		}
		return null;
	}

	public Word updateWord(String id, String label, String date) {
		for(int i=0; i<words.size(); i++) {
			if(words.get(i).getId() == Long.parseLong(id)) {
				words.get(i).setLabel(label);
				words.get(i).setDate(date);
				return words.get(i);
			}
		}
		return null;
	}

	public Word deleteWord(String id) {
		for(int i=0; i<words.size(); i++) {
			if(words.get(i).getId() == Long.parseLong(id)) {
				return words.remove(i);
			}
		}
		return null;
	}
	
	
}
