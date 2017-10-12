import java.util.HashMap;
import java.util.Scanner;

public class Solution {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<String, Integer> worldCount = getStringIntegerHashMap(sc, n);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String current = sc.next();
            if (worldCount.get(current) != null) {
                System.out.println(worldCount.get(current));
            } else {
                System.out.println("0");
            }
        }
    }

    private static HashMap<String, Integer> getStringIntegerHashMap(Scanner sc, int n) {
        HashMap<String, Integer> worldCount = new HashMap();
        for (int i = 0; i < n; i++) {
            String current = sc.next();
            if (worldCount.get(current) == null) {
                worldCount.put(current, 1);
            } else {
                worldCount.put(current, worldCount.get(current) + 1);
            }
        }
        return worldCount;
    }

}
