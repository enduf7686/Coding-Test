import java.util.*;

public class Q2583 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[][] map = new int[M][N];
        for (int i = 0; i < K; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            for (int y = y1; y < y2; y++) {
                for (int x = x1; x < x2; x++) {
                    map[y][x] = 1;
                }
            }
        }

        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};

        Queue<Position> queue = new LinkedList<>();
        List<Integer> answerList = new ArrayList<>();
        for (int y = 0; y < M; y++) {
            for (int x = 0; x < N; x++) {
                if (map[y][x] == 0) {
                    queue.offer(new Position(x, y));
                    map[y][x] = 1;

                    int answer = 1;
                    while (!queue.isEmpty()) {
                        Position pos = queue.poll();

                        for (int i = 0; i < 4; i++) {
                            int X = pos.getX() + dx[i];
                            int Y = pos.getY() + dy[i];

                            if (X < 0 || X >= N || Y < 0 || Y >= M || map[Y][X] == 1) {
                                continue;
                            }

                            queue.offer(new Position(X, Y));
                            map[Y][X] = 1;
                            answer++;
                        }
                    }

                    answerList.add(answer);
                }
            }
        }

        answerList.sort(Integer::compare);

        System.out.println(answerList.size());
        for (int i = 0; i < answerList.size(); i++) {
            System.out.print(answerList.get(i) + " ");
        }
    }

    static class Position {

        private int x;
        private int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
