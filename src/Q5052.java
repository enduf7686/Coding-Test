import java.util.*;

public class Q5052 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = Integer.valueOf(sc.nextLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N = Integer.valueOf(sc.nextLine());

            List<String> list = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                list.add(sc.nextLine());
            }

            list.sort((s1, s2) -> {
                char[] s1Split = s1.toCharArray();
                char[] s2Split = s2.toCharArray();

                for (int k = 0; k < Math.min(s1Split.length, s2Split.length); k++) {
                    if (!(s1Split[k] == s2Split[k])) {
                        return Integer.valueOf(s1Split[k]) - Integer.valueOf(s2Split[k]);
                    }
                }

                return s1.length() - s2.length();
            });

            Boolean answer = true;
            for (int j = 0; j < list.size() - 1; j++) {
                if (list.get(j + 1).startsWith(list.get(j))) {
                    answer = false;
                }
            }
            sb.append(answer ? "YES" : "NO").append('\n');
        }
        System.out.println(sb);
    }
}
