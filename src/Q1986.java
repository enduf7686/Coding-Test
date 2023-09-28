import java.util.*;

public class Q1986 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();

        List<Location> queenLocation = new ArrayList<>();
        List<Location> knightLocation = new ArrayList<>();
        List<Location> pawnLocation = new ArrayList<>();

        int queen = sc.nextInt();
        for (int i = 0; i < queen; i++) {
            queenLocation.add(new Location(sc.nextInt(), sc.nextInt()));
        }
        sc.nextLine();

        int knight = sc.nextInt();
        for (int i = 0; i < knight; i++) {
            knightLocation.add(new Location(sc.nextInt(), sc.nextInt()));
        }
        sc.nextLine();

        int pawn = sc.nextInt();
        for (int i = 0; i < pawn; i++) {
            pawnLocation.add(new Location(sc.nextInt(), sc.nextInt()));
        }

        int[][] map = new int[N][M];
        boolean[][] dangerMap = new boolean[N][M];
        for (int i = 0; i < queenLocation.size(); i++) {
            int x = queenLocation.get(i).getX() - 1;
            int y = queenLocation.get(i).getY() - 1;
            map[y][x] = 1;
            dangerMap[y][x] = true;
        }

        for (int i = 0; i < knightLocation.size(); i++) {
            int x = knightLocation.get(i).getX() - 1;
            int y = knightLocation.get(i).getY() - 1;
            map[y][x] = 2;
            dangerMap[y][x] = true;
        }

        for (int i = 0; i < pawnLocation.size(); i++) {
            int x = pawnLocation.get(i).getX() - 1;
            int y = pawnLocation.get(i).getY() - 1;
            map[y][x] = 3;
            dangerMap[y][x] = true;
        }

        int[] dx = {-1, 1, 2, 2, 1, -1, -2, -2};
        int[] dy = {2, 2, 1, -1, -2, -2, -1, 1};

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if (map[y][x] != 0) {
                    if (map[y][x] == 1) {
                        int X = x;
                        int Y = y;

                        while (X >= 1) {
                            if (map[Y][X - 1] == 0) {
                                dangerMap[Y][--X] = true;
                            } else {
                                break;
                            }
                        }

                        X = x;
                        Y = y;
                        while (X < M - 1) {
                            if (map[Y][X + 1] == 0) {
                                dangerMap[Y][++X] = true;
                            } else {
                                break;
                            }
                        }

                        X = x;
                        Y = y;
                        while (Y >= 1) {
                            if (map[Y - 1][X] == 0) {
                                dangerMap[--Y][X] = true;
                            } else {
                                break;
                            }
                        }

                        X = x;
                        Y = y;
                        while (Y < N - 1) {
                            if (map[Y + 1][X] == 0) {
                                dangerMap[++Y][X] = true;
                            } else {
                                break;
                            }
                        }

                        X = x;
                        Y = y;
                        while (X >= 1 && Y >= 1) {
                            if (map[Y - 1][X - 1] == 0) {
                                dangerMap[--Y][--X] = true;
                            } else {
                                break;
                            }
                        }

                        X = x;
                        Y = y;
                        while (X < M - 1 && Y < N - 1) {
                            if (map[Y + 1][X + 1] == 0) {
                                dangerMap[++Y][++X] = true;
                            } else {
                                break;
                            }
                        }

                        X = x;
                        Y = y;
                        while (X < M - 1 && Y >= 1) {
                            if (map[Y - 1][X + 1] == 0) {
                                dangerMap[--Y][++X] = true;
                            } else {
                                break;
                            }
                        }

                        X = x;
                        Y = y;
                        while (X >= 1 && Y < N - 1) {
                            if (map[Y + 1][X - 1] == 0) {
                                dangerMap[++Y][--X] = true;
                            } else {
                                break;
                            }
                        }
                    }

                    if (map[y][x] == 2) {
                        for (int i = 0; i < 8; i++) {
                            int X = x + dx[i];
                            int Y = y + dy[i];

                            if (X < 0 || X >= M || Y < 0 || Y >= N || map[Y][X] != 0) {
                                continue;
                            }

                            dangerMap[Y][X] = true;
                        }
                    }
                }
            }
        }

        int answer = 0;
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if (!dangerMap[y][x]) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

    static class Location {

        private int x;
        private int y;

        public Location(int y, int x) {
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
