import java.util.*;

public class Q2750 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        int N = Integer.valueOf(sc.nextLine());

        for (int i = 0; i < N; i++) {
            list.add(Integer.valueOf(sc.nextLine()));
        }

        list.sort(Integer::compare);
        list.stream().forEach((i) -> System.out.println(i));
    }
}
