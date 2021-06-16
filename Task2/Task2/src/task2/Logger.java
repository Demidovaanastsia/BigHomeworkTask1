package task2;

import java.util.Date;

public class Logger {
	private TxtWorker rw = new TxtWorker();
	private String path = "Task2/src/txtFiles/Logger";

	public void INFO(String text) throws Exception {
		Date dateNow = new Date();
		String outputText = dateNow + " INFO: " + text + "\n";
		rw.Write("Logs.txt", outputText, true, path);
	}

	public void WARNING(String text) throws Exception {
		Date dateNow = new Date();
		String outputText = dateNow + " WARN: " + text + "\n";
		rw.Write("Logs.txt", outputText, true, path);
	}

	public void DEBUG(String text) throws Exception {
		Date dateNow = new Date();
		String outputText = dateNow + " DEBUG: " + text + "\n";
		rw.Write("Logs.txt", outputText, true, path);
	}
}
