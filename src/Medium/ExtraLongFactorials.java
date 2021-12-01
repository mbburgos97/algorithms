package Medium;

import java.io.*;
import java.math.*;

import static java.util.stream.Collectors.joining;

class Result2 {

    /*
     * Complete the 'extraLongFactorials' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void extraLongFactorials(int n) {
        System.out.println(factorial(BigInteger.valueOf(n)));

    }

    public static BigInteger factorial(BigInteger n) {
        if (n.equals(BigInteger.ZERO)) return BigInteger.ONE;
        return n.multiply(factorial(n.subtract(BigInteger.ONE)));
    }

}

public class ExtraLongFactorials {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        Result2.extraLongFactorials(n);

        bufferedReader.close();
    }
}
