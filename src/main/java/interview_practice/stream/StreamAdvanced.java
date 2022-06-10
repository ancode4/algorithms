package interview_practice.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class StreamAdvanced {
    public static void main(String[] args) {
        Person john = new Person(ThreadLocalRandom.current().nextInt(1, Integer.MAX_VALUE),"John",28);
        Person jane = new Person(ThreadLocalRandom.current().nextInt(1, Integer.MAX_VALUE),"Jane",33);
        List<Person> persons = new ArrayList<Person>(){{add(john);add(jane);}};

        groupingBy(persons);
    }

    private static void groupingBy(List<Person> list){
        Map<Integer,Person> map = list.stream().collect(Collectors.toMap(p -> p.getId(), p -> p));
        System.out.println(map);
    }

    private static class Person {
        public Person(int id, String name, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "ID: "+id + "; Name: "+name+"; Age: "+age;
        }

        private String name;
        private int id;
        private int age;
    }
}
