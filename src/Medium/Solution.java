package Medium;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'organizingContainers' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts 2D_INTEGER_ARRAY container as parameter.
     */

    public static String organizingContainers(List<List<Integer>> container) {
        int[][] arr = new int[container.size()][container.size()];

        int i = 0;
        int j;
        for (List<Integer> list : container) {
            j = 0;
            for (Integer item: list) {
                arr[i][j] = item;
                j++;
            }
            i++;
        }

        int tempTotalRow;
        int tempTotalColumn;

        for(int a = 0; a < container.size(); a++) {
            tempTotalColumn = 0;
            tempTotalRow = 0;
            for (int b = 0; b < container.size(); b++) {

                tempTotalRow += arr[a][b];
                tempTotalColumn += arr[b][a];
            }

            if (tempTotalColumn != tempTotalRow) {

                return "Impossible";
            }
        }
        return "Possible";
    }

    public static void print(int[][] arr, int size) {

        for(int a = 0; a < size; a++) {
            for (int b = 0; b < size; b++) {
                System.out.print(arr[a][b]);
            }
            System.out.println();
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<List<Integer>> container = new ArrayList<>();

                IntStream.range(0, n).forEach(i -> {
                    try {
                        container.add(
                                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                        .map(Integer::parseInt)
                                        .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                String result = Result.organizingContainers(container);
                System.out.println(result);
//                bufferedWriter.write(result);
//                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
//        bufferedWriter.close();
    }
}
