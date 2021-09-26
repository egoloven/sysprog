package test1;

import java.io.FileReader;
import java.io.IOException;

public class Main {
	static String name = "Eugene";

	public static void main(String[] args) {
		try {
			FileReader reader = new FileReader("/Users/whisper-/Documents/java/test1/src/files/input.txt");
            int character;
 
            while ((character = reader.read()) != -1) {
                System.out.print((char) character);
            }
            reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
