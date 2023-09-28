import java.util.*;

public class Q2812 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        sc.nextLine();

        String[] numbers = sc.next().split("");

        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.valueOf(numbers[0]));

        for (int i = 1; i < numbers.length; i++) {
            while (!stack.isEmpty()) {
                if (K == 0) break;
                if (stack.peek() < Integer.valueOf(numbers[i])) {
                    stack.pop();
                    K--;
                } else {
                    break;
                }
            }
            stack.push(Integer.valueOf(numbers[i]));
        }

        List<Integer> list = new ArrayList<>(stack);
        StringBuilder sb = new StringBuilder();
        list.stream().forEach(num -> sb.append(num));
        System.out.println(sb.substring(0, sb.length() - K));
    }
}
