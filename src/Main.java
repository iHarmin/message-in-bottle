import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int[][] menu = new int[N][5];

        for(int i = 0; i < menu.length; i++) {
            String name = in.next();
            int shu = in.next();
            int p6 = in.next();
            int p12 = in.next();
            int p18 = in.next();

            menu[i][0] = name;

        }

    }
}
