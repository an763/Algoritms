import java.util.*;

public class GeneralStuff {


    public static void main(String args[]){
        MyLambda compare = (s1, s2) ->  s1.compareToIgnoreCase(s2);

        List<Person> persons = Arrays.asList(new Person("Anurag", "Mis",53),
                    new Person("Alka", "Mis",53),
                    new Person("Arnav", "Mis",53),
                    new Person("Arav", "Mis",53));

        printAll(persons);
        Collections.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getFirstName().compareToIgnoreCase(o2.getFirstName());
            }
        });

        Collections.sort(persons,(Person o1,Person o2) ->  o1.getFirstName().compareToIgnoreCase(o2.getFirstName()));
        printAll(persons);
    }

    public static void printAll(List<Person> persons){
        for(Person person : persons)
            System.out.println(person);
    }
}

interface MyLambda{
    int compare(String s1, String s2);
}

class Person{
    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    private String firstName;
   private String lastName;
   private int age;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
}
