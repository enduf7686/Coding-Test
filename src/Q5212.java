import java.util.*;

public class Q5212 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int R = sc.nextInt();
        int C = sc.nextInt();
        sc.nextLine();

        char[][] map = new char[R][C];
        for (int i = 0; i < R; i++) {
            map[i] = sc.nextLine().toCharArray();
        }

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        boolean[][] dangerMap = new boolean[R][C];
        for (int y = 0; y < R; y++) {
            for (int x = 0; x < C; x++) {
                if (map[y][x] == '.') {
                    dangerMap[y][x] = false;
                } else {
                    dangerMap[y][x] = true;
                }
            }
        }

        for (int y = 0; y < R; y++) {
            for (int x = 0; x < C; x++) {
                if (dangerMap[y][x]) {
                    int danger = 0;
                    for (int i = 0; i < 4; i++) {

                        int X = x + dx[i];
                        int Y = y + dy[i];
                        if (Y < 0 || Y >= R || X < 0 || X >= C || map[Y][X] == '.') {
                            danger += 1;
                        }
                    }

                    if (danger >= 3) {
                        dangerMap[y][x] = false;
                    }
                }
            }
        }

        int minX = C;
        int maxX = 0;
        int minY = R;
        int maxY = 0;
        for (int y = 0; y < R; y++) {
            for (int x = 0; x < C; x++) {
                if (dangerMap[y][x]) {
                    minX = Math.min(x, minX);
                    maxX = Math.max(x, maxX);
                    minY = Math.min(y, minY);
                    maxY = Math.max(y, maxY);
                }
            }
        }

        for (int y = minY; y <= maxY; y++) {
            for (int x = minX; x <= maxX; x++) {
                if (dangerMap[y][x]) {
                    System.out.print("X");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }
}
