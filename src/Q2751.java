import java.util.*;

public class Q2751 {

    public static void main(String[] args) {
        boolean[] counting = new boolean[2000001];

        Scanner sc = new Scanner(System.in);
        int N = Integer.valueOf(sc.nextLine());

        for (int i = 0; i < N; i++) {
            counting[Integer.valueOf(sc.nextLine()) + 1000000] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < counting.length; i++) {
            if (counting[i]) sb.append(i - 1000000).append('\n');
        }

        System.out.println(sb);
    }
}
