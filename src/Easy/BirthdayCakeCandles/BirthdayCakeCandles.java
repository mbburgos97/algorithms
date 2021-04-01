package Easy.BirthdayCakeCandles;

import java.io.*;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class BirthdayCakeCandles {
    /*
     * Complete the 'birthdayCakeCandles' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY candles as parameter.
     */

    public static int birthdayCakeCandles(List<Integer> candles) {
        int max = 0;
        Integer[] candlesInt = candles.toArray(new Integer[candles.size()]);
        for (int i = 1; i < candles.size(); i++) {
            if (candlesInt[i] > candlesInt[max]) {
                max = i;
            }
        }
        int count = 0;
        for (int i = 0; i < candles.size(); i++) {
            if (candlesInt[i].equals(candlesInt[max])) count++;
        }
        return count;
    }

}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int candlesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> candles = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = BirthdayCakeCandles.birthdayCakeCandles(candles);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

//https://www.hackerrank.com/challenges/birthday-cake-candles/problem