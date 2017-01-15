import java.util.Scanner;

public class Camelcase {

    public static void main(String[] args) {
        System.out.println((new Scanner(System.in)).next().split("\\p{Upper}").length);
    }
}

