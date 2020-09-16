package lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Person {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
            "firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", age=" + age +
            '}';
    }

    public static void main(String[] args) {
        Person p1 = new Person("Jack","Daniels",50);
        Person p2 = new Person("Sandeep","Kumar",65);
        Person p3 = new Person("Sumeet","Singh",49);
        Person p4 = new Person("Thanh","Truong",37);
        Person p5 = new Person("Jill","Anderson",25);

        List<Person> people = Arrays.asList(p1, p2, p3, p4, p5);
        Collections.sort(people,(o1,o2)->o1.getFirstName().compareTo(o2.getFirstName()));
        System.out.println(people);

        printConditional(people, o -> o.getAge() > 38);
        int a = 5;
        int b = 10;
        calculate(a,b,(t,u)-> System.out.println(a+b));
//        people.stream().collect()
    }

    public static void printConditional(List<Person> list, Predicate<Person> condition){
        for (Person person : list) {
            if(condition.test(person)){
                System.out.println(person);
            }
        }
    }

    public static void calculate(int a, int b, BiConsumer<Integer, Integer> biconsumer){
        biconsumer.accept(a,b);
    }

}
