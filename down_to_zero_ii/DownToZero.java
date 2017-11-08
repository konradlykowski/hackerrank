import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class DownToZero {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int Q = in.nextInt();
        for (int a0 = 0; a0 < Q; a0++) {
            int N = in.nextInt();
            System.out.println(dp(N));
        }
    }

    static int[] minMoves = new int[1000001];

    private static int dp(int n) {
        if (n <= 3) return n;
        if (minMoves[n] > 0) return minMoves[n];

        int result = Integer.MAX_VALUE;
        for (int a = (int) Math.sqrt(n); a >= 2; a--) {
            int b = n / a;
            if (a * b == n && b != 1) {
                result = Math.min(result, 1 + dp(Math.max(a, b)));
            }
        }
        int res = Math.min(result, 1 + dp(n - 1));
        minMoves[n] = res;
        return res;
    }
}
