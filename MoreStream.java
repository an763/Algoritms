import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class MoreStream {

        public static void main(String[] args) {
            List<Person> people = List.of(
                    new Person("Anurag", Gender.MALE),
                    new Person("Arnav", Gender.MALE),
                    new Person("Alka", Gender.FEMALE),
                    new Person("Arav", Gender.MALE)
            );

            Predicate<Person> personPredicate = person -> person.gender == Gender.FEMALE;

            people.stream()
                    .filter(personPredicate)
                    .forEach(person -> System.out.println(person.name));
                  //  .toList();

            Function<Integer,Integer> incByOne = i -> i + 1;

            int count = incByOne.apply(4);
            System.out.println(count);


        }




    static class Person{

                private final String name;
                private final Gender gender;

                Person(String name, Gender gender){
                    this.name = name;
                    this.gender = gender;
                }
        }
        enum Gender{
            MALE, FEMALE
        }
}
