package task2;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
// Класс для записаи и чтения документа
public class TxtWorker {

	public String Read(String name, String path) throws Exception {
		String text = "";

		File file = new File(path, name);
		FileReader fr = new FileReader(file);
		Scanner scan = new Scanner(fr);

		while (scan.hasNextLine()) {
			text += scan.nextLine();
		}
		fr.close();
		scan.close();

		return text;
	}

	public void Write(String name, String text, boolean tf, String path) throws Exception {
		File file = new File(path, name);
		FileWriter fw = new FileWriter(file, tf);

		fw.write(text);
		fw.close();
	}
}
