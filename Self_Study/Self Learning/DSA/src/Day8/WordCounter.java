package Day8;

import java.util.HashMap;
import java.util.Map;

public class WordCounter {
    public static void countWords(String input) {
        // Convert to lowercase and split by whitespace/punctuation
        String[] words = input.toLowerCase().split("\\W+");
        
        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            if (word.isEmpty()) continue;
            // If word exists, increment count, else set to 1
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // Display results
        System.out.println("Word Frequencies:");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        String line = "Data structures are great. Learning data structures is fun!";
        countWords(line);
    }
}
