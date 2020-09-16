import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

class Person implements Comparable<Person>{
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
    }

    @Override
    public int compareTo(Person person) {
        return Integer.valueOf(this.id).compareTo(Integer.valueOf(person.getId()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return id == person.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}


public class ComparableDemo {

    public static void main(String[] args){
        Person person1 = new Person(1,"John");
        Person person2 = new Person(2,"Andy");
        Person person3 = new Person(3,"Paul");
        Person person4 = new Person(4,"Jill1");
        Person person5 = new Person(4,"Jill");

        Set<Person> set = new TreeSet();
        set.add(person1);
        set.add(person2);
        set.add(person3);
        set.add(person4);
        set.add(person5);

        for(Person person : set){
            System.out.println(person);
        }

        Map<Person, Integer> personMap = new HashMap<Person,Integer>();
        personMap.put(person1,1);
        personMap.put(person2,1);
        personMap.put(person3,1);
        personMap.put(person4,1);
        personMap.put(person4,1);

        System.out.println(personMap);

//        Collections.sort(set);
    }
}
