import java.util.*;
import java.util.stream.Collectors;

public class Q18870 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = Integer.valueOf(sc.nextLine());

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(sc.nextInt());
        }

        List<Integer> sortingMapKey = list.stream()
                .distinct()
                .sorted(Integer::compare)
                .collect(Collectors.toList());

        Map<Integer, Integer> map = new HashMap<>();

        int sequence = 0;
        for (int i = 0; i < sortingMapKey.size(); i++) {
            map.put(sortingMapKey.get(i), sequence++);
        }

        StringBuilder sb = new StringBuilder();
        for (int num : list) {
            sb.append(map.get(num)).append(" ");
        }

        System.out.println(sb);
    }
}
