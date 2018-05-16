package coinchangeproblem;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by konrad.lykowski on 2018/05/13.
 */
public class CoinChange {


    static HashMap<Pair<Long, Long>, Long> arr = new HashMap();

    static long getWays(long n, long[] c, long last) {
        if (arr.containsKey(new Pair<Long, Long>(n, last))) {
            return arr.get(new Pair<Long, Long>(n, last));
        }
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        long sum = 0;
        for (long coin : c) {
            if (last >= coin)
                sum = sum + getWays(n - coin, c, coin);
        }
        arr.put(new Pair<Long, Long>(n, last), sum);
        return sum;
    }


}
