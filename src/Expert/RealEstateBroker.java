package Expert;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


public class RealEstateBroker {

    /*
     * Complete the realEstateBroker function below.
     */

    static int[][] houseByPrice;

    static int max = Integer.MIN_VALUE;

    static int realEstateBroker(int[][] clients, int[][] houses) {
        //sort houses -> by price and by area

        houseByPrice = sortByPrice(houses.clone());
        combination(clients, new boolean[houseByPrice.length], 0, 0);

        return max;
    }

    static void combination(int[][] clients, boolean[] occupied, int index, int occupiedCount) {
        if (index == clients.length) {
            if (max < occupiedCount) {
                max = occupiedCount;
            }
            return;
        }

        for (int j = index; j < clients.length; j++) {

            for (int i = 0; i < houseByPrice.length; i++) {
                if (clients[j][1] < houseByPrice[i][1]) continue;

                if (!occupied[i] && clients[j][0] <= houseByPrice[i][0]) {
                    occupied[i] = true;
                    combination(clients, occupied, j + 1, occupiedCount + 1);
                    occupied[i] = false;
                }
            }
        }
        if (max < occupiedCount) {
            max = occupiedCount;
        }
    }

    static int[][] sortByPrice(int[][] houses) {
        Arrays.sort(houses, Comparator.comparingInt(a -> a[1]));

        return houses;
    }

//    static void print2DArray (int[][] array) {
//        for (int i = 0; i < 3; i++) {
//            System.out.print(array[i][0] + " " + array[i][1]);
//            System.out.println();
//        }
//    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0].trim());

        int m = Integer.parseInt(nm[1].trim());

        int[][] clients = new int[n][2];

        for (int clientsRowItr = 0; clientsRowItr < n; clientsRowItr++) {
            String[] clientsRowItems = scanner.nextLine().split(" ");

            for (int clientsColumnItr = 0; clientsColumnItr < 2; clientsColumnItr++) {
                int clientsItem = Integer.parseInt(clientsRowItems[clientsColumnItr].trim());
                clients[clientsRowItr][clientsColumnItr] = clientsItem;
            }
        }

        int[][] houses = new int[m][2];

        for (int housesRowItr = 0; housesRowItr < m; housesRowItr++) {
            String[] housesRowItems = scanner.nextLine().split(" ");

            for (int housesColumnItr = 0; housesColumnItr < 2; housesColumnItr++) {
                int housesItem = Integer.parseInt(housesRowItems[housesColumnItr].trim());
                houses[housesRowItr][housesColumnItr] = housesItem;
            }
        }

//        int n, m;
//        n = 3;
//        m = 3;
//        int[][] clients = {{5, 110}, {9, 500}, {20, 400}};
//        int[][] houses = {{10, 100}, {2, 200}, {30, 300}};


        int result = realEstateBroker(clients, houses);
        System.out.println(result);
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
    }
}
