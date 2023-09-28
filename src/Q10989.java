import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Q10989 {

    public static void main(String[] args) throws IOException {
        int[] counting = new int[10001];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());

        for (int i = 0; i < N; i++) {
            counting[Integer.valueOf(br.readLine())]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < counting.length; i++) {
            for (int j = 0; j < counting[i]; j++) {
                sb.append(i).append('\n');
            }
        }

        System.out.println(sb);
    }
}
