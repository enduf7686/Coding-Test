import java.util.*;

public class Q1715 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = Integer.valueOf(sc.nextLine());

        Queue<Integer> cards = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            cards.offer(Integer.valueOf(sc.nextLine()));
        }

        int sum = 0;
        while (cards.size() > 1) {
            int shuffle = cards.poll() + cards.poll();
            cards.offer(shuffle);
            sum += shuffle;
        }

        System.out.println(sum);
    }
}
