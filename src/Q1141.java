import java.util.*;

public class Q1141 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.valueOf(sc.nextLine());

        List<String> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(sc.nextLine());
        }

        list.sort((s1, s2) -> {
            char[] charArray1 = s1.toCharArray();
            char[] charArray2 = s2.toCharArray();

            for (int i = 0; i < Math.min(charArray1.length, charArray2.length); i++) {
                if (charArray1[i] != charArray2[i]) {
                    return charArray1[i] - charArray2[i];
                }
            }

            return charArray1.length - charArray2.length;
        });

        int index = 0;
        while (index < list.size() - 1) {
            if (list.get(index + 1).startsWith(list.get(index))) {
                list.remove(index);
            } else {
                index++;
            }
        }

        System.out.println(list.size());
    }
}
