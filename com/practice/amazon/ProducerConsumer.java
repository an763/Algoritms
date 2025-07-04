package com.practice.amazon;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.function.BiFunction;

public class ProducerConsumer {
	
	
	public static void main(String args[]) {
		
		producerConsumer();
	//	sortMapByValue();
	
		
	}
	
	public static void producerConsumer() {
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);
		Thread producer = new Thread(()-> {
												for(int i=0; i< 10; i++) {
													try {
														System.out.println("Going to put in queue "+i);
														queue.put(i);
														System.out.println("Put completed for "+i);
													} catch (InterruptedException e) {
														e.printStackTrace();
													}
												}
										}
										);
		Thread consumer = new Thread(()-> {
			for(int i=0; i< 10; i++) {
				try {		
					System.out.println("take start for "+i);
					queue.take();
					System.out.println("take complete for "+i);
				} catch (InterruptedException e) {
					e.printStackTrace();
					Thread.currentThread().interrupted();
					break;
				}
			}
		});
		
		consumer.start();
		producer.start();
		
	Thread thread = new Thread(new Runnable() {
		@Override
		public void run() {
			System.out.printf("I am run inside thread");
		}
		});
		thread.start();
	Thread thr = new Thread(()->System.out.println("I am blank inside thread"));
		thr.start();
	}
	
	public static void sortMapByValue() {
		Map<String , Integer> unsortedMap = new HashMap<>();
		unsortedMap.putIfAbsent("Anurag", 52);
		unsortedMap.putIfAbsent("Alka", 50);
		unsortedMap.putIfAbsent("Arnav", 23);
		unsortedMap.putIfAbsent("Arav", 18);
		
		
		
        BiFunction<String, Integer, Integer> updateFunction = (k, v) -> {
        																	v = v+10 ;
        																	return v;
        																 };
        
        unsortedMap.forEach((k,v) ->
        								{
        									Integer newVal = updateFunction.apply(k, v);
        									unsortedMap.put(k, newVal);
        									System.out.println("key "+k +"   value "+unsortedMap.get(k));
        								});
		
		for(Map.Entry<String, Integer> entrySet : unsortedMap.entrySet()) {
			System.out.println("---->>> "+unsortedMap.compute(entrySet.getKey(), (k,v)-> (k.equalsIgnoreCase("Anurag") ? v = 100 : v)));
		}
		
		Collection<Integer> collect = unsortedMap.values();
		Iterator itr = collect.iterator();
		while(itr.hasNext()) {
			System.out.println("---- "+itr.next());
		}
		
		List<Map.Entry<String, Integer>> mapList = new ArrayList<>();
		
		
		
		for(Map.Entry<String, Integer> entry : unsortedMap.entrySet()) {
			mapList.add(entry);
		}
		
		mapList.sort(new MapValueSorter());
		
		Map<String, Integer> sortedMap = new LinkedHashMap<>();
		
		for(Map.Entry<String, Integer> entry : mapList) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		System.out.println("Going to print sorted map");
		for(Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
			System.out.println(entry.getKey() +" -- "+entry.getValue());
		}
		
		
	}
}

class MapValueSorter implements Comparator<Map.Entry<String, Integer>>{

	@Override
	public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
		if(o1.getValue() > o2.getValue()) {
			return -1;
		}else if(o1.getValue() < o2.getValue()) {
			return 1;
		}
		return 0;
	}
	
}


class MapValueSorterUsingComparable implements Comparable<Map.Entry<String, Integer>>{

	@Override
	public int compareTo(Entry<String, Integer> o) {
		// TODO Auto-generated method stub
		return 0;
	}
}

