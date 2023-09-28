import java.util.*;

public class Q2075 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = Integer.valueOf(sc.nextLine());

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] numbers = sc.nextLine().split("\\s");
            for (int j = 0; j < N; j++) {
                list.add(Integer.valueOf(numbers[j]));
            }
        }

        list.sort((i1, i2) -> Integer.compare(i2, i1));
        System.out.println(list.get(N - 1));
    }
}
