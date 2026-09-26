package com.practice;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.time.Instant;

public class MapSorting {

	public static void main() {
		Map<String, Integer> testMap = new HashMap<>();
		testMap.put("Anu", 53);
		testMap.put("Alka", 51);
		testMap.put("Arnav", 23);
		testMap.put("Arav", 18);

		Map<String, Integer> sortedMap = testMap.entrySet()
										.stream()
										.sorted(Map.Entry.comparingByValue())
										.collect(Collectors
												 .toMap(Map.Entry::getKey, Map.Entry::getValue,
														 (e1, e2) -> e1, LinkedHashMap::new)
												);

		// Printing the sorted map
		sortedMap.forEach((key, value) -> System.out.println(key + " : " + value));
		
		newFunction();
	}

	public static void main(String args[]) {
		Map<String, Integer> testMap = new HashMap<>();
		testMap.putIfAbsent("python", 85);
		testMap.putIfAbsent("java", 72);
		testMap.putIfAbsent("Scala", 48);
		testMap.putIfAbsent("Ruby", 60);
		System.out.println("Start ==>> " + Instant.now().getEpochSecond());

		Set<Entry<String,Integer>> myEntry = testMap.entrySet();
		List<Entry<String,Integer>> myList = new ArrayList<>(myEntry);
		myList.stream()
				.sorted((a,b)-> Integer.compare(b.getValue(),a.getValue()))
				.forEach(System.out::println);

		//myList.sort(Comparator.comparing(Map.Entry<String,Integer>::getValue).reversed());

		System.out.println("Start ==>> End" + Instant.now().getEpochSecond());
		Stack<Character> stack = new Stack<>();
		char c = 'a';
		switch(c) {
			case '{': case '[' : case '(' :
				stack.push(c);
				break;
			case '}':
				if(stack.isEmpty() || stack.pop() != '{') //return false;
				break;


		}








		
		

		Map<String, Integer> sortedMap = testMap.entrySet()
												.stream().sorted(Entry.comparingByValue()) // Sort by value (ascending)
												.collect(
														Collectors.toMap(Entry::getKey,
																		Entry::getValue, 
																		(oldValue, newValue) -> oldValue,
																		LinkedHashMap::new));

		// Print the sorted map
		sortedMap.forEach((key, value) -> System.out.println(key + ": " + value));
		System.out.println("End ==>> " + Instant.now().getEpochSecond());

		List<Entry<String, Integer>> entryList = new ArrayList<>();
		System.out.println("Start ==>> " + Instant.now().getEpochSecond());
		for (Entry<String, Integer> entrySet : testMap.entrySet()) {
			entryList.add(entrySet);
		}
		Collections.sort(entryList,(o1, o2) -> (o1.getValue() - o2.getValue()));
		
		entryList.sort((o1, o2) -> (o1.getValue() - o2.getValue()));

		LinkedHashMap<String, Integer> lMap = new LinkedHashMap<>();
		for (Entry<String, Integer> entryNum : entryList) {
			lMap.put(entryNum.getKey(), entryNum.getValue());
		}

		for (Entry<String, Integer> lmapEntry : lMap.entrySet()) {
			System.out
					.println("The element key  " + lmapEntry.getKey() + " The element value  " + lmapEntry.getValue());
		}
		System.out.println("End ==>> " + Instant.now().getEpochSecond());

		List<List<String>> listOfLists = Arrays.asList(Arrays.asList("Anurag", "Misra"), Arrays.asList("Alka", "Misra"),
				Arrays.asList("Arnav", "Misra"), Arrays.asList("Arav", "Misra"));
		listOfLists.stream().flatMap(list -> list.stream()).forEach(s -> System.out.print(s + " "));

	}
	
	private static void newFunction() {
		Map<String , Integer> myMap = new HashMap<>();
		myMap.put("Java", 50);
		myMap.put("Scala", 48);
		myMap.put("Python", 46);
		myMap.put("Ruby", 44);
		
		
		
		 List<Map.Entry<String, Integer>> myEntry = myMap.entrySet().stream().collect(Collectors.toList());
		 myEntry.sort((o1, o2) -> o1.getValue() - o2.getValue());
		 List<Integer> myEntry2 = myEntry.stream().map(o -> o.getValue()*2).collect(Collectors.toList());
		 
		 myEntry2.forEach(o -> System.out.println(" val "+o));
		 
		 Map<String , Integer> sortedMap = new LinkedHashMap<>();
		 
		 myEntry.forEach(o -> sortedMap.put(o.getKey(), o.getValue()));
		 
		 
		 sortedMap.forEach((k,v) -> System.out.println("key "+k +" val "+v ));
		 		
		 sortedMap.entrySet().forEach(o -> System.out.println("key "+o.getKey() +" val "+o.getValue() ));
		 
		 
		
		
	}

	public boolean findRobot(String input){
		String str = input;
		int[] start = {0,0};
		for(int i = 0; i< str.length(); i++){
			char ch = str.charAt(i);
			switch (ch){
				case 'U':
					start[0] = start[0] -1;
					break;
				case 'D' :
					start[0] = start[0] + 1;
					break;
				case 'R':
					start[1] = start[1] + 1;
					break;
				case 'L':
					start[1] = start[1] -1;
					break;
				default:
					break;
			}
		}
		return false;
	}
	
	

}
