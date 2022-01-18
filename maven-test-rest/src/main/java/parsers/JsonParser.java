package parsers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import models.Word;


public class JsonParser {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(JsonParser.class);
	
	public static Word[] jsonToWordsList(String wordsJson) {
		
		ObjectMapper mapper = new ObjectMapper();
		Word[] wordsArray = new Word[7];
		try {
			wordsArray = mapper.readValue(wordsJson, Word[].class);
		} catch (JsonProcessingException e) {
			LOGGER.error("Probleme de mapping du contenu JSON", e);
		}
		
		return wordsArray;
	}
}
