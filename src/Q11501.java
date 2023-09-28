import java.util.*;

public class Q11501 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();

            int[] list = new int[N];
            for (int i = 0; i < N; i++) {
                list[i] = sc.nextInt();
            }

            int max = 0;
            long answer = 0;
            for (int i = N - 1; i >= 0; i--) {
                if (max < list[i]) {
                    max = list[i];
                } else {
                    answer += (max - list[i]);
                }
            }

            sb.append(answer).append('\n');
        }

        System.out.println(sb);
    }
}
