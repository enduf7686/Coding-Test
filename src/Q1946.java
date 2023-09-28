import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q1946 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.valueOf(sc.nextLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N = Integer.valueOf(sc.nextLine());

            List<Person> people = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                String[] person = sc.nextLine().split("\\s");
                people.add(new Person(Integer.valueOf(person[0]), Integer.valueOf(person[1])));
            }

            people.sort((p1, p2) -> p1.getDocumentGrade() - p2.getDocumentGrade());

            int answer = N;
            int interviewGrade = people.get(0).getInterviewGrade();
            for (int j = 0; j < people.size() - 1; j++) {
                if (interviewGrade > people.get(j + 1).getInterviewGrade()) {
                    interviewGrade = people.get(j + 1).getInterviewGrade();
                } else {
                    answer--;
                }
            }
            sb.append(answer).append('\n');
        }
        System.out.println(sb);
    }

    static class Person {

        private int documentGrade;
        private int interviewGrade;

        public Person(int documentGrade, int interviewGrade) {
            this.documentGrade = documentGrade;
            this.interviewGrade = interviewGrade;
        }

        public int getDocumentGrade() {
            return documentGrade;
        }

        public int getInterviewGrade() {
            return interviewGrade;
        }
    }
}


