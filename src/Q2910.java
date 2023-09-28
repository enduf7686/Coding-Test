import java.util.*;

public class Q2910 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int C = sc.nextInt();

        sc.nextLine();

        Map<Integer, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            if (map.get(num) != null) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        List<Integer> keyList = new ArrayList<>(map.keySet());
        System.out.println("map = " + map);
        System.out.println("keyList = " + keyList);
        keyList.sort((k1, k2) -> map.get(k2) - map.get(k1));

        keyList.stream()
                .forEach(k -> {
                    for(int i =0; i < map.get(k); i++) {
                        System.out.print(k + " ");
                    }
                });
    }
}
