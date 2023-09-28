import java.util.*;

public class Q1339 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.valueOf(sc.nextLine());

        List<String> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringBuilder sb = new StringBuilder(sc.nextLine());
            list.add(sb.reverse().toString());
        }

        Map<Character, Integer> scoreMap = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            String numbers = list.get(i);
            char[] number = numbers.toCharArray();

            for (int j = 0; j < number.length; j++) {
                int score = (int) Math.pow(10, j);
                if (scoreMap.get(number[j]) == null) {
                    scoreMap.put(number[j], score);
                } else {
                    scoreMap.put(number[j], scoreMap.get(number[j]) + score);
                }
            }
        }

        Queue<Character> pq = new PriorityQueue<>((c1, c2) -> scoreMap.get(c2) - scoreMap.get(c1));

        for (char c : scoreMap.keySet()) {
            pq.offer(c);
        }
        Map<Character, Integer> numberMap = new HashMap<>();

        int changeNum = 9;
        while (!pq.isEmpty()) {
            numberMap.put(pq.poll(), changeNum);
            changeNum--;
        }

        int sum = 0;
        for (char c : scoreMap.keySet()) {
            sum += scoreMap.get(c) * numberMap.get(c);
        }

        System.out.println(sum);
    }
}
