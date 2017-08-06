import java.util.Scanner;

public class Candies {

    static int[] children;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer number = sc.nextInt();

        children = new int[number];
        int[] candies = new int[number];
        for (int i = 0; i < number; i++) {
            children[i] = sc.nextInt();
            candies[i] = 0;
        }
        System.out.println(dp(0, candies, 0));
    }

    static int dp(int i, int[] candies, int candiesSum) {
        if (i == children.length) {
            return candiesSum;
        }
        int bestMin = Integer.MAX_VALUE;
        int start = 1;
        if (i > 0 && children[i] > children[i - 1])
            start = candies[i - 1] + 1;
        for (int candle = start; candle < candies.length; candle++) {
            candies[i] = candle;
            if (i > 0 && children[i] > children[i - 1] && candies[i] <= candies[i - 1]) {
                continue;
            }
            if (i > 0 && children[i] < children[i - 1] && candies[i] >= candies[i - 1]) {
                return Integer.MAX_VALUE;
            }

            bestMin = Math.min(bestMin, dp(i + 1, candies, candiesSum + candle));
            if (bestMin != Integer.MAX_VALUE) {
                break;
            }
        }
        return bestMin;
    }
}

