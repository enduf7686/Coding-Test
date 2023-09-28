import java.util.*;

public class Q17413 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();

        char[] charArray = S.toCharArray();

        boolean flag = false;
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == ' ') {
                while (!stack.empty()) {
                    sb.append(stack.pop());
                }
                sb.append(' ');
            }
            else if (charArray[i] == '<') {
                while (!stack.empty()) {
                    sb.append(stack.pop());
                }
                sb.append('<');
                flag = true;
            }
            else if (charArray[i] == '>') {
                sb.append('>');
                flag = false;
            }
            else {
                if (flag) {
                    sb.append(charArray[i]);
                } else {
                    stack.push(charArray[i]);
                }
            }
        }

        while (!stack.empty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }
}
