import java.util.*;

public class Q1431 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.valueOf(sc.nextLine());

        List<String> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(sc.nextLine());
        }

        list.sort((s1, s2) -> {
            if (s1.length() == s2.length()) {
                char[] charArray1 = s1.toCharArray();
                char[] charArray2 = s2.toCharArray();

                int sum1 = 0;
                int sum2 = 0;

                for (int i = 0; i < charArray1.length; i++) {
                    if (charArray1[i] >= '0' && charArray1[i] <= '9') {
                        sum1 += charArray1[i] - 48;
                    }
                    if (charArray2[i] >= '1' && charArray2[i] <= '9') {
                        sum2 += charArray2[i] - 48;
                    }
                }

                if (sum1 == sum2) {
                    for (int i = 0; i < charArray1.length; i++) {
                        if (charArray1[i] != charArray2[i]) {
                            return charArray1[i] - charArray2[i];
                        }
                    }
                }

                return sum1 - sum2;
            }

            return s1.length() - s2.length();
        });

        for (String s : list) {
            System.out.println(s);
        }
    }
}
