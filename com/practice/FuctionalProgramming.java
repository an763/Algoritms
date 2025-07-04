package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntToDoubleFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class FuctionalProgramming {
	

	
	public static void sortMap() throws Exception{
		
		Map<String, Integer> unsortedMap = new HashMap<>();
		unsortedMap.put("java", 66);
		unsortedMap.put("scala", 55);
		unsortedMap.put("python", 44);
		unsortedMap.put("c++", 33);



		Map<String, Integer> sortedMap	= unsortedMap.entrySet()
														.stream()
														.sorted((Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) ->
																e1.getValue().compareTo(e2.getValue()))
														.collect(Collectors.toMap(
																(Map.Entry<String, Integer> e) ->e.getKey(),
																(Map.Entry<String, Integer> e) -> e.getValue(),
																                (oldVal,newVal) -> oldVal, ()->new LinkedHashMap()));



		
		
		
		 sortedMap.forEach((k, v) -> System.out.println(k + " -> " + v));
		
		 ExecutorService executorService = Executors.newFixedThreadPool(5);
		executorService.submit(() -> {
			System.out.println("test");
		 });
		 
	//	 System.out.println( futureResult.get());
	//	 executorService.shutdownNow();
		
		PriorityQueue<Integer> priorityQueueDesc = new PriorityQueue<>((a, b) -> b.compareTo(a));
		
		
	}
	
	
	public static void main(String args[]) throws Exception {
		sortMap();
		Predicate<String> p1 = s-> s.length() > 2;
		System.out.println("The out of Pred is "+ p1.test("Anurag"));
		
		Function<String, String> f1 = s-> s.toUpperCase();
		Function<String, String> f2 = s-> s.substring(3);
		
		Person p = new Person();
		p.setAge(18);
		p.setName("Arnav");
		
		Consumer<Person> c1 = person->{

										person.setAge(21);
										System.out.println("The age set to 21");
								};
		
		Consumer<Person> c2 = person->{

				if(person.getAge() == 21)
					System.out.println("The age is already  21");
				};
		System.out.println("The out of function is "+ f1.apply("Anurag"));
		System.out.println("The out of function is "+ f1.andThen(f2).apply("Anurag"));
		
		c1.andThen(c2).accept(p);
		
		IntToDoubleFunction f = i -> Math.sqrt(i);
		
		System.out.println("The out of function IntToDoubleFunction is "+ f.applyAsDouble(5));
		
		IntBinaryOperator iOp = (a,b)->(a+b) ;
		
		System.out.println("The out of function IntBinaryOperator is "+ iOp.applyAsInt(2, 3));
		
		String str = "anurag";

		Supplier<String> methodRef = str::toUpperCase;

        System.out.println(methodRef.get()); 
        
        
        Map<String, Integer> map = new HashMap<>();
        
		map.put("java", 45);
		map.put("python", 50);
		map.put("c++", 40);
		map.put("nodejs", 35);
		
		
		List<Map.Entry<String, Integer>> myCollection = new ArrayList<>();
 		for(Map.Entry<String, Integer> entity : map.entrySet()) {
 			myCollection.add(entity);
		}
		Collections.sort(myCollection, (e1,e2)->(e1.getValue().compareTo(e2.getValue())));
		Map<String, Integer> sortedMap = new LinkedHashMap<>();
		for(Map.Entry<String, Integer> entity : myCollection) {
			sortedMap.put(entity.getKey(), entity.getValue());
		}
		for(Map.Entry<String, Integer> entity : sortedMap.entrySet()) {
			System.out.println("entity key "+entity.getKey() +"== entity value"+entity.getValue());
		}
		
		List<Map.Entry<String, Integer>> entity = map.entrySet().stream().sorted((e1,e2)->(e1.getValue().compareTo(e2.getValue()))).collect(Collectors.toList());
		Map<String, Integer> newsortedMap = new LinkedHashMap<>();
		for(Map.Entry<String, Integer> entity1 : myCollection) {
			newsortedMap.put(entity1.getKey(), entity1.getValue());
		}
		for(Map.Entry<String, Integer> entity2 : newsortedMap.entrySet()) {
			System.out.println("entity key "+entity2.getKey() +"== entity value"+entity2.getValue());
		}
		
		
		Map<String, Integer> mysortedMap = map.entrySet()
				.stream().sorted((e1,e2)->(e2.getValue().compareTo(e1.getValue()))) // Sort by value (desc)
				.collect(
						Collectors.toMap(Map.Entry::getKey,
										Map.Entry::getValue, 
										(oldValue, newValue) -> oldValue,
										LinkedHashMap::new));
		
		for(Map.Entry<String, Integer> entity2 : mysortedMap.entrySet()) {
			System.out.println("entity key "+entity2.getKey() +"== entity value"+entity2.getValue());
		}
		
		System.out.println(Arrays.stream(new int[] {1,2,3,4,5})
				.map(x->x*x)
				.average().getAsDouble());
		
		Arrays.stream(new String[]{"Anu","Alka","Arnav","Arav"}).filter(x->x.startsWith("Ar")).map(x->x+" Misra").forEach(System.out::println);
		
		List<String> list = Arrays.asList("abc1", "abc2", "abc3");
		list.stream().skip(1).forEach(System.out::println);
		long size = list.stream().skip(1)
		  .map(element -> element.substring(0, 3)).sorted().count();
		System.out.println("size ==> "+size);
		
		List<Integer> list1 = Stream.of(1,2,3,4,5,6,7,8).collect(Collectors.toList());
		
	}

}


class Person{
	
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	
}
