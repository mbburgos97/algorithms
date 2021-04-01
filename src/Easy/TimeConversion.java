package Easy;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class TimeConversion {

    static String timeConversion(String s) {
        char a = s.charAt(s.length() - 2);
        String hour = s.substring(0, 2);
        Integer hourInt = Integer.parseInt(hour);

        if (a == 'P' && hourInt != 12) {
            hourInt += 12;
            String hourStr = hourInt.toString();
            return hourStr + s.substring(2, 8);
        } else if(a == 'A' && hourInt == 12) {
            return "00" + s.substring(2, 8);
        } else {
            return hour + s.substring(2, 8);
        }
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}
//https://www.hackerrank.com/challenges/time-conversion/problem
