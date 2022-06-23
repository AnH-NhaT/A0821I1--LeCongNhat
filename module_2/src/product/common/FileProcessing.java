package product.common;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileProcessing {

    private static void createFileIfNotExists(String path) {
        try {
            File file = new File(path);
            if (!file.exists())
                file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeFile(String path, String line, String firstLine) {

        createFileIfNotExists(path);

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true))) {
            File file = new File(path);
            if (file.length() == 0) {
                bufferedWriter.write(firstLine);
                bufferedWriter.newLine();
            }
            bufferedWriter.write(line);
            bufferedWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static List<String> readFile(String path) {

        createFileIfNotExists(path);
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

    public static void emptyFile(String path) {
        try {
            PrintWriter writer = new PrintWriter(path);
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
