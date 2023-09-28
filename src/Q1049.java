import java.util.*;

public class Q1049 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String NM = sc.nextLine();
        int N = Integer.valueOf(NM.split("\\s")[0]);
        int M = Integer.valueOf(NM.split("\\s")[1]);

        int[] packagePrice = new int[M];
        int[] singlePrice = new int[M];
        for (int i = 0; i < M; i++) {
            String prices = sc.nextLine();
            packagePrice[i] = Integer.valueOf(prices.split("\\s")[0]);
            singlePrice[i] = Integer.valueOf(prices.split("\\s")[1]);
        }
        Arrays.sort(packagePrice);
        int minPackagePrice = packagePrice[0];

        Arrays.sort(singlePrice);
        int minSinglePrice = singlePrice[0];

        int answer = 0;

        while (N >= 6) {
            answer += Math.min(minPackagePrice, minSinglePrice * 6);
            N -= 6;
        }
        answer += Math.min(minPackagePrice, minSinglePrice * N);

        System.out.println(answer);
    }
}
