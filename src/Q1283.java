import java.util.*;

public class Q1283 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        String[] utils = new String[N];
        for (int i = 0; i < N; i++) {
            utils[i] = sc.nextLine();
        }

        StringBuilder sb = new StringBuilder();
        List<Character> shorts = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            boolean search = false;

            StringBuilder subSb = new StringBuilder(utils[i]);
            String[] split = utils[i].split("\\s");
            int splitLength = split.length;
            for (int j = 0; j < splitLength; j++) {
                String lowerSplit = split[j].toLowerCase();
                String upperSplit = split[j].toUpperCase();
                char lc = lowerSplit.toCharArray()[0];
                char uc = upperSplit.toCharArray()[0];
                if (!shorts.contains(lc) && !shorts.contains(uc)) {
                    shorts.add(split[j].toCharArray()[0]);
                    search = true;
                    int index = 0;
                    for (int k = 0; k < j; k++) {
                        index += (split[k].length() + 1);
                    }
                    subSb.insert(index, "[");
                    subSb.insert(index + 2, "]");
                    break;
                }
            }

            if (!search) {
                for (int j = 0; j < splitLength; j++) {
                    for (int k = 1; k < split[j].length(); k++) {
                        String lowerSplit = split[j].toLowerCase();
                        String upperSplit = split[j].toUpperCase();
                        char lc = lowerSplit.toCharArray()[k];
                        char uc = upperSplit.toCharArray()[k];
                        if (!shorts.contains(lc) && !shorts.contains(uc)) {
                            shorts.add(split[j].toCharArray()[k]);
                            search = true;
                            int index = 0;
                            for (int l = 0; l < j; l++) {
                                index += (split[l].length() + 1);
                            }
                            subSb.insert(index + k, "[");
                            subSb.insert(index + k + 2, "]");
                            break;
                        }
                    }
                    if (search) {
                        break;
                    }
                }
            }

            if (!search) {
                shorts.add('\0');
            }

            sb.append(subSb).append('\n');
        }

        System.out.println(sb);
    }
}
