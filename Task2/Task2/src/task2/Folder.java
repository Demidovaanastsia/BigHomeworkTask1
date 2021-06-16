package task2;

import java.io.File; // чтения из папки  смен

public class Folder {
	public void listFilesForFolder(File folder) {
		int i = 1;
		for (File fileEntry : folder.listFiles()) {

			System.out.println(i + ") " + fileEntry.getName());
			i++;

		}
	}
}
