package kame.spring.chap03.core;

import java.util.ArrayList;
import java.util.List;

public class SearchService {

	private String[] sentences = {
			"This is a pencil.",
			"I am a boy",
			"You are a girl"
	};
	
	public List<String> search(String query) {
		List<String> results = new ArrayList<String>();
		for (String sentence : sentences) {
			if (sentence.contains(query)) {
				results.add(sentence);
			}
		}
		return results;
	}
}
