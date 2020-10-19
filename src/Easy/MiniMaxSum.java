package Easy;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MiniMaxSum {

    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {
        int minIndex = 0;
        int maxIndex = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[minIndex]) {
                minIndex = i;
            }

            if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }

        long maxSum = 0, minSum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i != minIndex) maxSum += arr[i];

            if (i != maxIndex) minSum += arr[i];
        }

        System.out.println(minSum + " " + maxSum);

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}
//https://www.hackerrank.com/challenges/mini-max-sum/problem