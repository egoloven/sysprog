package test1;

import java.io.FileReader;
import java.io.IOException;

public class Reader {

	private char[] delemiters = new char[]{' ', '\n', '(', ')', '+', '-', ',', '!', '?', '.', ':', '\"', '\''};
	private String[] words = new String[3000];

	private String[] slice(String[] array, int startIndex, int stopIndex) {
		String[] newArray = new String[stopIndex - startIndex];

		for (int i = startIndex; i < stopIndex; ++i) {
			newArray[i - startIndex] = array[i];
		}

		return newArray;
	}

	public String[] getWords() {
		return this.words;
	}

	public void readFile(String path) {

		try {
			int character, iter = 0;
			String word = "";
			FileReader reader = new FileReader(path);

			while ((character = reader.read()) != -1) {

				if (new String(this.delemiters).indexOf((char) character) != -1) {
					this.words[iter] = word;
					word = "";
					++iter;
					continue;
				}
				word += (char) character;
			}
			this.words[iter] = word;
			this.words = slice(this.words, 0, iter + 1);

			reader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
