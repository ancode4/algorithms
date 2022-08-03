package interview_practice.java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class StreamAdvanced {
    public static void main(String[] args) {
        Person john = new Person(ThreadLocalRandom.current().nextInt(1, Integer.MAX_VALUE),"John",28);
        Person jane = new Person(ThreadLocalRandom.current().nextInt(1, Integer.MAX_VALUE),"Jane",33);
        Person eliza = new Person(ThreadLocalRandom.current().nextInt(1, Integer.MAX_VALUE),"Eliza",28);
        Person schmidt = new Person(ThreadLocalRandom.current().nextInt(1, Integer.MAX_VALUE),"Schmidt",31);
        List<Person> persons = new ArrayList<Person>(){{add(john);add(jane);add(eliza);add(schmidt);}};

        //toMap(persons);
        groupByAge(persons);
    }

    private static void toMap(List<Person> list){
        Map<Integer,Person> map = list.stream().collect(Collectors.toMap(Person::getId, p -> p));
        System.out.println(map);
    }

    private static void groupByAge(List<Person> list){
        Map<Integer,List<Person>> personByAge = list.stream()
                .collect(Collectors.groupingBy(Person::getAge));
        System.out.println(personByAge);
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
