package module_2.no16_file_io.practice.p2;

import java.util.List;

public class FindMaxValue {
    public static int findMax(List<Integer> numbers) {
        int max = numbers.get(0);
        for (int i = 0; i < numbers.size(); i++) {
            if (max < numbers.get(i)) {
                max = numbers.get(i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        List<Integer> numbers = readAndWriteFile.readFile("src/module_2/no16_file_io/practice/p2/numbers.txt");
        int maxValue = findMax(numbers);
        readAndWriteFile.writeFile("src/module_2/no16_file_io/practice/p2/result.txt", maxValue);
    }
}