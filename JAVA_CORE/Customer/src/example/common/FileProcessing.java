package example.common;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileProcessing {
	public static List<String> readFile(String path) {
		List<String> listLine = new ArrayList<>();
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
			String line;
			int count = 0;
			while ((line = bufferedReader.readLine()) != null) {
				if (count > 0)
					listLine.add(line);
				count++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listLine;
	}
}
