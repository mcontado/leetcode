package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class RetrieveMostFrequencyUsedWord {

	public static List<String> retrieveMostFrequentWord(String text, List<String> excludedWords) {
		List<String> result = new ArrayList<>();

		HashMap<String, Integer> map = new HashMap<>();
		String[] strArr = text.toLowerCase().replaceAll("\\W", " ").split("\\s+");
		
		for (String word : strArr) {
			if (!excludedWords.contains(word)) {
				map.put(word, map.getOrDefault(word, 0) + 1);
			}
		}
		
		// Get the highest occurence
		Integer highestOccurence = 1;
		for (Entry<String, Integer> entry: map.entrySet()) {
			if (entry.getValue() > highestOccurence) {
				highestOccurence = entry.getValue();
			}
		}
		
		// Check for the value with the highest occurence then add it to the result list.
		for (Entry<String, Integer> entry: map.entrySet()) {
			if (entry.getValue() == highestOccurence) {
				result.add(entry.getKey());
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		String text = "Rose is a flower red rose are flower";
		List<String> excludedWords = Arrays.asList("is", "are", "a");
		
		System.out.println(retrieveMostFrequentWord(text, excludedWords).toString());
		
		String text1 = "Jack and Jill went to the market to buy bread and cheese. Cheese is Jack's and Jill's favorite food.";
		List<String> excludedWords1 = Arrays.asList("and", "he", "the", "to", "is");
		
		System.out.println(retrieveMostFrequentWord(text1, excludedWords1));

	}

}
