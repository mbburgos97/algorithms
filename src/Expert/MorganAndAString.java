package Expert;

import java.io.*;
import java.util.stream.IntStream;

public class MorganAndAString {
    /*
     * Complete the 'morganAndString' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING a
     *  2. STRING b
     */

    public static String morganAndString(String a, String b) {
        StringBuilder result = new StringBuilder();
        int indexA = 0;
        int indexB = 0;
//        String tempA;
//        String tempB;
//
//        while (indexA < a.length() || indexB < b.length()) {
//            tempA = a.substring(indexA);
//            tempB = b.substring(indexB);
//
//            if (tempA.equals("")) {
//                result.append(tempB);
//                indexB = b.length();
//                continue;
//            }
//
//            if (tempB.equals("")) {
//                result.append(tempA);
//                indexA = a.length();
//                continue;
//            }
//
//            int compareResult = tempA.compareTo(tempB);
//
//            if (compareResult <= 0) {
//                result.append(a.charAt(indexA));
//                indexA++;
//            } else {
//                result.append(b.charAt(indexB));
//                indexB++;
//            }
//        }
//        return result.toString();


        while (true) {
            if (result.length() == a.length() + b.length()) return result.toString();

            if (indexB == b.length()) {
                result.append(a.substring(indexA));
                indexA = a.length();
                continue;
            }

            if (indexA == a.length()) {
                result.append(b.substring(indexB));
                indexB = b.length();
                continue;
            }

            if (a.charAt(indexA) == b.charAt(indexB)) {
                int increment = 1;
                while (true) {
                    if (indexA + increment >= a.length()) {
                        result.append(a.substring(indexA));
                        indexA = a.length();
                        break;
                    } else if (indexB + increment >= b.length()) {
                        result.append(b.substring(indexB));
                        indexB = b.length();
                        break;
                    } else {
                        if (a.charAt(indexA + increment) < b.charAt(indexB + increment)) {
                            result.append(a.charAt(indexA));
                            indexA++;
                            break;
                        } else if (a.charAt(indexA + increment) > b.charAt(indexB + increment)) {
                            result.append(b.charAt(indexB));
                            indexB++;
                            break;
                        } else increment++;
                    }
                }
                continue;
            }

            if (a.charAt(indexA) < b.charAt(indexB)) {
                result.append(a.charAt(indexA));
                indexA++;
            } else if (a.charAt(indexA) > b.charAt(indexB)) {
                result.append(b.charAt(indexB));
                indexB++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int t = Integer.parseInt(bufferedReader.readLine().trim());
//
//        IntStream.range(0, t).forEach(tItr -> {
//            try {
//                String a = bufferedReader.readLine();
//
//                String b = bufferedReader.readLine();
//
//                String result = MorganAndAString.morganAndString(a, b);
//
//                bufferedWriter.write(result);
//                bufferedWriter.newLine();
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        });
//
//        bufferedReader.close();
//        bufferedWriter.close();
        String result = MorganAndAString.morganAndString("DAD", "DAD");
        System.out.println(result);
        String result2 = MorganAndAString.morganAndString("JACK", "DANIEL");
        System.out.println(result2);

    }
}
