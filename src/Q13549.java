import java.util.*;

public class Q13549 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] map = new int[100001];
        boolean[] checkMap = new boolean[100001];

        int[] dx = {1, -1, 2};

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        checkMap[N] = true;
        while (!queue.isEmpty()) {
            int pos = queue.poll();

            for (int i = 0; i < 3; i++) {
                int Pos = pos;
                if (i == 2) {
                    Pos *= dx[i];
                } else {
                    Pos += dx[i];
                }

                if (Pos < 0 || Pos >= map.length) {
                    continue;
                }

                if (i == 2) {
                    if (checkMap[Pos]) {
                        map[Pos] = Math.min(map[Pos], map[pos]);
                    } else {
                        map[Pos] = map[pos];
                        queue.offer(Pos);
                        checkMap[Pos] = true;
                    }
                } else {
                    if (checkMap[Pos]) {
                        map[Pos] = Math.min(map[Pos], map[pos] + 1);
                    } else {
                        map[Pos] = map[pos] + 1;
                        queue.offer(Pos);
                        checkMap[Pos] = true;
                    }
                }
            }
        }

        System.out.println(map[K]);
    }
}
