import java.util.*;

public class Q2108 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.valueOf(sc.nextLine());

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(Integer.valueOf(sc.nextLine()));
        }

        list.sort(Integer::compare);

        int[] count = new int[8001];
        for (int i : list) {
            count[i + 4000]++;
        }

        int max = 0;
        for (int i : count) {
            if (max < i) {
                max = i;
            }
        }

        List<Integer> maxList = new ArrayList<>();
        for (int i = 0; i < count.length; i++) {
            if (count[i] == max) maxList.add(i);
        }
        maxList.sort(Integer::compare);

        System.out.println((int) Math.rint(list.stream().mapToInt(i -> i).average().orElse(0)));

        System.out.println(list.get((int) list.size()/ 2));

        if (maxList.size() == 1) {
            System.out.println(maxList.get(0) - 4000);
        } else {
            System.out.println(maxList.get(1) - 4000);
        }

        System.out.println(list.stream().mapToInt(i -> i).max().orElse(0) - list.stream().mapToInt(i -> i).min().orElse(0));
    }
}
