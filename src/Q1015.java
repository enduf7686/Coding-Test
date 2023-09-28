import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q1015 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.valueOf(sc.nextLine());

        List<Integer> list = new ArrayList<>();
        int[] answer = new int[N];

        for (int i = 0; i < N; i++) {
            list.add(Integer.valueOf(sc.next()));
        }

        int sequence = 0;
        for (int i = 0; i <= 1000; i++) {
            for (int j = 0; j < N; j++) {
                if (list.get(j) == i) {
                    answer[j] = sequence;
                    sequence++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);
    }
}
