package Day_08;


import java.util.LinkedHashMap;
import java.util.Map;

public class WordCounter {
	public Map<String, Integer> countWords(String line) {
		Map<String, Integer> map = new LinkedHashMap<>();
		String[] words = line.toLowerCase().split("\\W+");

		for(String word : words) {
			if(word.length() == 0)
				continue;
			map.put(word, map.getOrDefault(word, 0) + 1);
		}
		return map;
	}
}
