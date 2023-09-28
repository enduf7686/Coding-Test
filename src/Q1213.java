import java.util.*;

public class Q1213 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);

        Map<Character, Integer> map = new TreeMap<>();
        for (char c : charArray) {
            if (map.get(c) == null) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }

        long count = map.keySet().stream()
                .filter(key -> (map.get(key) % 2) != 0)
                .count();

        if (count > 1) {
            System.out.println("I'm Sorry Hansoo");
        } else {
            int sequence = 0;
            char[] chars = new char[s.length()];
            for (char key : map.keySet()) {
                if (map.get(key) % 2 == 0) {
                    while (map.get(key) > 0) {
                        chars[sequence] = key;
                        chars[chars.length - sequence - 1] = key;
                        map.put(key, map.get(key) - 2);
                        sequence++;
                    }
                } else {
                    while (map.get(key) > 1) {
                        chars[sequence] = key;
                        chars[chars.length - sequence - 1] = key;
                        map.put(key, map.get(key) - 2);
                        sequence++;
                    }
                }
            }

            for (char key : map.keySet()) {
                if (map.get(key) != 0) {
                    while (map.get(key) > 0) {
                        chars[sequence] = key;
                        map.put(key, map.get(key) - 1);
                        sequence++;
                    }
                }
            }
            System.out.println(chars);
        }
    }
}
