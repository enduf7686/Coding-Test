import java.util.*;

public class Q10814 {

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        sc.nextLine();

        for (int i = 0; i < N; i++) {
            String person = sc.nextLine();
            int age = Integer.valueOf(person.split("\\s")[0]);
            String name = person.split("\\s")[1];
            people.add(new Person(i, age, name));
        }

        people.sort((p1, p2) -> p1.getAge() > p2.getAge() ? p1.getAge() - p2.getAge(): (p1.getAge() == p2.getAge() ? p1.getSequence() - p2.getSequence(): p1.getAge() - p2.getAge()));
        people.stream().forEach((p) -> System.out.println(p.getAge() + " " + p.getName()));
    }

    public static class Person {

        private int sequence;
        private int age;
        private String name;

        public Person(int sequence, int age, String name) {
            this.sequence = sequence;
            this.age = age;
            this.name = name;
        }

        public int getSequence() {
            return sequence;
        }

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }
    }
}
