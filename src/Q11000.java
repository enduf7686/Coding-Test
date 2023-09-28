import java.util.*;

public class Q11000 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.valueOf(sc.nextLine());

        List<Lecture> lectures = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] times = sc.nextLine().split("\\s");
            lectures.add(new Lecture(Integer.valueOf(times[0]), Integer.valueOf(times[1])));
        }
        lectures.sort((l1, l2) -> l1.getStart() == l2.getStart() ? l1.getEnd() - l2.getEnd() : l1.getStart() - l2.getStart());

        Queue<Integer> queue = new PriorityQueue<>();
        queue.offer(lectures.get(0).getEnd());

        for (int i = 1; i < N; i++) {
            if (queue.peek() <= lectures.get(i).getStart()) {
                queue.poll();
            }
            queue.offer(lectures.get(i).getEnd());
        }
        System.out.println(queue.size());
    }

    static class Lecture {

        private int start;
        private int end;

        public Lecture(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public int getLength() {
            return end - start;
        }
    }
}
