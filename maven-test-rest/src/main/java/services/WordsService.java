package services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import clients.WordsClient;
import models.Word;
import models.WordsList;
import parsers.JsonParser;

@Service
public class WordsService {

	public static WordsList getWordsFromJsonFile() {
		String wordsJson = WordsClient.getWordsFromJsonFile();
		Word[] wordsArray = JsonParser.jsonToWordsList(wordsJson);
		List<Word> wordsList = Arrays.asList(wordsArray);
		return new WordsList(wordsList);
	}

	public static Word getWordFromSession(String id, WordsList wordsListSession) {
		for (Word word : wordsListSession.getWords()) {
			if (word.getId() == Long.parseLong(id)) {
				return word;
			}
		}
		return null;
	}

	public static WordsList addWordToSession(String id, String label, String date, WordsList wordsListSession) {
		wordsListSession.addWord(new Word(Long.parseLong(id), label, date));
		return wordsListSession;
	}

	public static WordsList updateWordInSession(String id, String label, String date, WordsList wordsListSession) {
		wordsListSession.updateWord(id, label, date);
		return wordsListSession;
	}

	public static WordsList deleteWordFromSession(String id, WordsList wordsListSession) {
		wordsListSession.deleteWord(id);
		return wordsListSession;
	}

}




