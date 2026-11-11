import java.io.PrintWriter;
import java.util.ArrayList;

public class Recursion {

    public static long factorialR(long value) {
        if (value == 0) {
            return 1;
        }
        return value * factorialR(value - 1);

    }

    public static boolean palindromeR(String str, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (Character.toLowerCase(str.charAt(start)) == Character.toLowerCase(str.charAt(end))) {
            ++start;
            --end;
            return palindromeR(str, start, end);

        }
        return false;
    }

    public static void reverseStringR(PrintWriter outputWriter, String str) {
        if (str.length() < 1) {
            return;
        }
        reverseStringR(outputWriter, str.substring(1, str.length()));
        outputWriter.print(str.substring(0, 1));
    }

    public static boolean isPrimeR(int value, int n) {
        if (value < 2) {
            return false;
        }
        if (n > value / n) {
            return true;
        }
        if (value % n == 0) {
            return false;
        }
        return isPrimeR(value, n + 1);
    }

    public static int sumR(PrintWriter outputWriter, ArrayList<Integer> nums, int pos) {
        if (pos >= nums.size()) {
            if (pos == 0) {
                outputWriter.println("The Sum of " + nums + " is: 0");
            }
            return 0;
        }
        int sum = nums.get(pos) + sumR(outputWriter, nums, pos + 1);
        return sum;
    }

}
