import java.util.*;

public class Q1427 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String numberString = sc.nextLine();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numberString.length(); i++) {
            list.add(Integer.valueOf(numberString.split("")[i]));
        }

        list.sort((n1, n2) -> n2 - n1);

        StringBuilder sb = new StringBuilder();
        list.stream().forEach(n -> sb.append(n));
        System.out.println(sb);
    }
}
