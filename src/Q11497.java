import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q11497 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = Integer.valueOf(sc.nextLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N = Integer.valueOf(sc.nextLine());

            int[] numArray = new int[N];
            for (int j = 0; j < N; j++) {
                numArray[j] = sc.nextInt();
            }
            Arrays.sort(numArray);

            int[] answerList = new int[N];

            int rightIndex = 0;
            int leftIndex = N - 1;
            for (int j = 0; j < N; j++) {
                if (j % 2 == 0) {
                    answerList[rightIndex++] = numArray[j];
                } else {
                    answerList[leftIndex--] = numArray[j];
                }
            }

            int max = 0;
            for (int j = 0; j < answerList.length - 1; j++) {
                max = Math.max(max, Math.abs(answerList[j] - answerList[j + 1]));
            }
            max = Math.max(max, Math.abs(answerList[0] - answerList[N - 1]));

            sb.append(max).append('\n');
            sc.nextLine();
        }

        System.out.println(sb);
    }
}
