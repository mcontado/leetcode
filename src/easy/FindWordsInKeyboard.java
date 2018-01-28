package easy;

import java.util.Arrays;
import java.util.stream.Stream;

public class FindWordsInKeyboard {
	public static String[] findWords(String[] words) {
		final String regex = "[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*";
		return Stream.of(words)
				.filter(word -> word.toLowerCase().matches(regex))
				.toArray(String[]::new);
	}
	
	public static void main(String[] args) {
		String[] words = {"Hello", "Alaska", "Dad", "Peace"};
		System.out.println(Arrays.asList(findWords(words)));
	}
}
