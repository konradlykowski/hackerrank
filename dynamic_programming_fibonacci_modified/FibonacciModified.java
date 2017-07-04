import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciModified {

    static int FIRST_ELEMENT;
    static int SEC_ELEMENT;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FIRST_ELEMENT = sc.nextInt();
        SEC_ELEMENT = sc.nextInt();
        int n = sc.nextInt();
        System.out.println(dp(n, new BigInteger[n + 1]));
    }


    static BigInteger dp(int n, BigInteger[] memo) {
        if (n == 1) {
            return new BigInteger(String.valueOf(FIRST_ELEMENT));
        }
        if (n == 2) {
            return new BigInteger(String.valueOf(SEC_ELEMENT));
        }
        if (memo[n] != null) {
            return memo[n];
        }
        return memo[n] = dp(n - 2, memo).add(dp(n - 1, memo).pow(2));
    }
}

