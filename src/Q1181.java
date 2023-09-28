import java.util.*;

public class Q1181 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.valueOf(sc.nextLine());

        Set<String> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            set.add(sc.nextLine());
        }

        List<String> list = new ArrayList<>(set);

        list.sort((s1, s2) -> s1.length() > s2.length() ? s1.length() - s2.length() : (s1.length() == s2.length() ? s1.compareTo(s2) : s1.length() - s2.length()));
        list.stream().forEach(s -> System.out.println(s));
    }
}
