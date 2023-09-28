import java.util.*;

public class Q1541 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expression = sc.nextLine();

        String[] splitExpression = expression.split("-");
        int[] numbers = new int[splitExpression.length];
        for (int i = 0; i < splitExpression.length; i++) {
            int sum = 0;
            String[] plus = splitExpression[i].split("\\+");
            for (int j = 0; j < plus.length; j++) {
                sum += Integer.valueOf(plus[j]);
            }
            numbers[i] = sum;
        }

        int answer = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            answer -= numbers[i];
        }
        System.out.println(answer);
    }
}
