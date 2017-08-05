import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PlayGame {


    static int[] numbers;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer examples = sc.nextInt();

        for (int i = 0; i < examples; i++) {
            Integer numbersCount = sc.nextInt();
            numbers = new int[numbersCount];
            for (int n = 0; n < numbersCount; n++) {
                numbers[n] = (sc.nextInt());
            }
            int max = Collections.max(IntStream.of(numbers).boxed().collect(Collectors.toList()));
            if (max < 0) {
                System.out.println(max + " " + max);
            } else {
                System.out.println(dp(0, 0, Integer.MIN_VALUE) + " " + sumPositive());
            }

        }
    }

    static int sumPositive() {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > 0) {
                sum = sum + numbers[i];
            }
        }
        return sum;
    }

    static int dp(int elem, int sum, int best) {
        if (best < sum) {
            best = sum;
        }
        if (elem == numbers.length) {
            return sum;
        }
        if (sum + numbers[elem] > numbers[elem]) {
            return Math.max(best, dp(elem + 1, sum + numbers[elem], best));
        } else {
            return Math.max(best, dp(elem + 1, numbers[elem], best));
        }
    }
}


