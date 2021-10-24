package test1;
import java.util.*;
import java.util.Map.Entry;

public class Main {

	private static char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u', 'y', 'A', 'E', 'I', 'O', 'U', 'Y'}; 

	private static double countPers(String word) {
		int counter = 0;

		for(int i = 0; i < word.length(); ++i) {
			if(new String(vowels).indexOf(word.charAt(i)) != -1) {
				++counter;
			}
		}
		return (double) counter / word.length();
	}

	public static void main(String[] args) {
		Map<String, Double> map = new HashMap<String, Double>();

		Reader reader = new Reader();
		reader.readFile("/Users/whisper-/Documents/java/test1/src/files/input.txt");
		String[] words = reader.getWords();

		for(String item : words) {
			if(item.length() == 0) {
				continue;
			}

			String word;

			if(item.length() > 30) {
				word = item.substring(0, 30);
			} else {
				word = item;
			}

			map.put(word, countPers(word));
		}

		List<Entry<String, Double>> list = new ArrayList<>(map.entrySet());
		list.sort(Entry.comparingByValue());
		list.forEach(System.out::println);
	}
}
