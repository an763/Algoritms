import java.util.*;
import java.util.stream.Collectors;

public class StreamPractice {

    /*public static void main(String args[]){
        java.util.Set<Integer> mySet = new TreeSet<>();
        List<Integer> arr = Arrays.asList(1,10,2,4,6,9,3);
        arr.stream()
                .sorted((o1,o2) -> o2.intValue() - o1.intValue())
                .map(n->n*n)
                .filter(n -> n%2 == 0)
                .filter(n->n > 10)
                .forEach(System.out::println);

        arr.stream().sorted(Comparator.reverseOrder())
                .map(n->n*n)
                .filter(n -> n%2 == 0)
                .filter(n->n > 10)
                .forEach(System.out::println);



        arr.stream()
                .sorted(Comparator.comparing(Integer::intValue))
                .map(n->n*n)
                .filter(n -> n%2 == 0)
                .filter(n->n > 10)
                .forEach(System.out::println);
        List<String> str = Arrays.asList("Anurag", "Alka","Arnav", "Arav");
       Map<String,String> myMap = str.stream()
                .sorted((o1,o2) -> o1.length() - o2.length())
                .filter(o->o.length()>4)
                .map(o -> o.toUpperCase())
                .collect(Collectors.toMap(o->o, o->o));

        myMap.forEach((k,v) -> System.out.println(" key "+k +"  Value "+v));

        List<Person1> people = Arrays.asList(
                new Person1("Alice", 30),
                new Person1("Bob", 25),
                new Person1("Charlie", 35)
        );

     //   List<Person1> sorted = people.stream().sorted(Comparator.comparing(p->p.age));

        List<Person1> sorted1 = people.stream()
                .sorted(Comparator.comparingInt(Person1::getAge))
                .collect(Collectors.toList());
        people.stream().sorted((p1,p2) -> p1.getAge() - p2.getAge()).collect(Collectors.toList());

        List<Integer> intList = Arrays.asList(1,2,3,4,5,6);
        double average = intList.stream().mapToDouble(s->s.doubleValue()).average().orElse(0);

         int sum = intList.stream().filter(i -> i%2 ==0).mapToInt(i->i.intValue()).sum();
        sum = intList.stream().filter(i -> i%2 ==0).mapToInt(Integer::intValue).sum();
        sum = intList.stream().filter(i -> i%2 !=0).mapToInt(i->i.intValue()).sum();

        // remove duplicates
         List<Integer> clean = intList.stream().distinct().collect(Collectors.toList());

        List<String> strList = Arrays.asList("Anurag","Arnav","Alka","Arav");
        List<String> res = strList.stream().map(String::toUpperCase).collect(Collectors.toList());
        long count = strList.stream().filter(s->s.startsWith("R")).count();
//Map transformation: Convert a list of strings to uppercase and return as a list.
    strList = strList.stream().sorted().collect(Collectors.toList());
        strList = strList.stream().sorted((s1,s2)->s2.compareToIgnoreCase(s1)).collect(Collectors.toList());

        int max = intList.stream().mapToInt(i->i.intValue()).max().orElse(0);
// Filter and collect: Given a list of integers, filter out numbers greater than 10 and return as a list.
        List<Integer> nums = Arrays.asList(10,8,12,7,13,19,34,42,7);
        List<Integer> result = nums.stream().filter(i->i > 10).collect(Collectors.toList());
// Given a list of employees with salary information, count how many earn more than $50,000.
        double average1 = employees.stream()
                .filter(e -> e.getSalary() > 50000)
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);

//Sorting: Sort a list of strings by length, then alphabetically for equal lengths.
        List<String> strList1 = Arrays.asList("Anurag","Arnav","Alka","Arav");
        List<String> strNew = strList1.stream()
                                .sorted((s1,s2) -> {
                                    if(s1.length()==s2.length()){
                                        return s1.compareToIgnoreCase(s2);
                                    }
                                    return s1.length()-s2.length();
                                }).collect(Collectors.toList());


// GroupBy: Given a list of students with their grades, group them by grade (A, B, C, etc.) and return a map.
        List<Student> students = Arrays.asList(s1,s2,s3,s4,s5,s6,s7);

        Map<Character, List<Student>> groupedByGrade = students.stream()
                .reduce(new HashMap<>(), (map, student) -> {
                                                            map.computeIfAbsent(student.getGrade(), k -> new ArrayList<>())
                                                                    .add(student);
                                                            return map;
                                                        },
                                (map1, map2) -> {
                                    map2.forEach((key, value) ->
                                            map1.merge(key, value, (v1, v2) -> {
                                                v1.addAll(v2);
                                                return v1;
                                            })
                                    );
                                    return map1;
                                }
                );
// Collect students as per their grade
        groupedByGrade = students.stream().collect(Collectors.groupingBy(Student::getGrade));

// Collect student name per grade
        /*
        groupedByGrade = students.stream()
                .collect(Collectors
                        .groupingBy(Student::getGrade,
                                Collectors.mapping(Student::getName, Collectors.toList())));

        */
        // Returns Map<Character, String> - comma-separated names
/*        Collectors.mapping(Student::getName, Collectors.joining(", "));

// Returns Map<Character, Long> - count of names
        Collectors.mapping(Student::getName, Collectors.counting());

// Returns Map<Character, Set<String>> - unique names per grade
        Collectors.mapping(Student::getName, Collectors.toSet());

        students.stream().collect(Collectors.groupingBy(Student::getGrade));
        students.stream().
                collect(Collectors.groupingBy(Student::getGrade,Collectors.mapping(Student::getName,Collectors.toList())));

        Map<Character, Long> countByGrade = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getGrade,
                        Collectors.counting()
                ));
 //       FlatMap: Given a list of lists of integers, flatten it into a single list and remove duplicates.

        List<List<Integer>> listOfList = Arrays.asList(Arrays.asList(1,2,3,4,5,6) , Arrays.asList(11,12,13,14,5,6), Arrays.asList(1,12,32,24,53,61));
        List<Integer> resultList = listOfList.stream().flatMap(List::stream).distinct().collect(Collectors.toList());
     //   Reduce: Calculate the sum of all numbers in a list using reduce().

        List<Integer> nums1 = Arrays.asList(10,8,12,7,13,19,34,42,7);
        long result1 = nums.stream().reduce(0, (a,b) -> a+b);

 // Custom objects: Given a list of Person objects (with name, age, city), filter people over 25,
        // map to their names, and collect as a list.
    List<Person> persons = Arrays.asList(p1,p2,p3,p4,p5,p6,p7);
    List<String> personNames = persons.stream().filter(p -> p.getAge() > 25).map(Person::getName).collect(Collectors.toList());
// Multiple filters and operations: From a list of transactions, find all transactions from the last year,
// filter by amount > $100, group by category, and find the category with the highest total.
    List<Trasaction> transactions = Arrays.asList(t1,t2,t3,t4);

    Map<String, Double> map =
        transactions.stream()
                .filter(t -> t.getDate().isAfter(oneYearAgo))
                .filter(t->t.getAmount() > 100)
                .collect(Collectors.groupingBy(Trasaction::getCategory,Collectors.summingDouble(Transaction::getAmount)));
        String category = map.entrySet().stream()
                .max(Map.Entry.comparingByValue())                           //.max(((e1,e2) -> (int) (e1.getValue() - e2.getValue())))
                .map(Map.Entry::getKey)
                .orElse("No category"); //.get();

//    4th highest salarry

        double fourthHighestSalary = employees.stream()
                .map(Employee::getSalary)
                .distinct()                                    // Remove duplicates
                .sorted(Comparator.reverseOrder())            // Sort descending
                .skip(3)                                       // Skip first 3
                .findFirst()
                .orElse(0.0);

 //       Collectors: Given a list of products, use a custom collector to create a
        //       comma-separated string of product names with prices > $50.
    List<Product> products= Arrays.asList(p1,p2);
    List<String> resS = products.stream()s.joining
                            .filter(p -> p.getPrice() > 50 )
                .map(p -> p.getName() + " $ "+p.getPrice())
            .collect(Collectors.joining(", "));
    //Parallel streams: Process a large list of numbers and find the sum using parallel streams,
        // then compare performance with regular streams.
    nums.stream().mapToLong(p -> p.longValue()).sum();

    nums.parallelStream().mapToLong(Integer::longValue)
                            .reduce(0, (sum1, num) -> sum1 + num, (sum2, sum3) -> sum2+sum3;);
        List<String> strings = Arrays
                .asList("apple", "banana", "cherry", "date", "grapefruit");
        String ans = strings.stream().sorted((s1,s2) -> s2.length()-s1.length()).findFirst().orElse("Not found");

        Runnable runnable = () -> System.out.println("Hello!");
        Thread t = new Thread(runnable);
        t.start();

        List<String> strings2 = Arrays
                .asList("apple", "banana", "cherry", "date", "grapefruit");
        Comparator<String> comparator = (s1, s2) -> s1.compareToIgnoreCase(s2);
        List<String> r = strings2.stream().sorted(comparator).collect(Collectors.toList());

    }
}

class Person1 {
    String name;
    int age;

    public int getAge(){
        return age;
    }


    Person1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + "(" + age + ")";
    }


}

class Student {
    String name;
    char grade;


    public String getName() {
        return name;
    }
    public char getGrade() {
        return grade;
    }

    Student(String name, char grade) {
        this.name = name;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return name + "(" + grade + ")";
    }
*/

}
