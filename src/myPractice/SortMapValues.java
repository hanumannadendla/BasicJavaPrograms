package myPractice;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortMapValues {

	public static void main(String[] args) {
		Map<String,Integer>s=new HashMap<String, Integer>();
		s.put("test1",7);
		s.put("test5", 3);
		s.put("test2", 1);

		s.put("test3", 1);
		s.put("test8", 9);
		
		sortmap11(s);
		
		//1st way
		sortmap(s);//1st way
		sortmap1(s);
		
		//2nd way
		Map<String,Integer>fi=new LinkedHashMap<String, Integer>();
		
		int i= s.size();
		for(int t=0;t<i;t++) {
			String temp="";
			Integer value=1000;
		for(String k:s.keySet()) {
			if(s.get(k)<value) {
				value=s.get(k);
				temp=k;
			}
			
		}
		s.remove(temp);
		fi.put(temp, value);
		}
		System.out.println(fi);
		
		
	}
	
	public static void sortmap(Map<String, Integer>map) {
		Map<String, Integer> result = map.entrySet()
				  .stream()
				  .sorted(Map.Entry.comparingByValue())
				  .collect(Collectors.toMap(
				    Map.Entry::getKey, 
				    Map.Entry::getValue, 
				    (oldValue, newValue) -> oldValue, LinkedHashMap::new));
		System.out.println(result);
	}

	public static void sortmap1(Map<String, Integer>map) {
		map.entrySet()
		  .stream()
		  .sorted(Map.Entry.comparingByValue())
		  .forEach(System.out::println);
	}
	public static void sortmap11(Map<String, Integer>map) {
		Stream<Entry<String,Integer>>m=map.entrySet()
		  .stream()
		  .sorted(Map.Entry.comparingByValue());
		
		Iterator<Entry<String,Integer>>s=m.iterator();
		while(s.hasNext()) {
			Entry<String,Integer>k=s.next();
			System.out.println(k.getKey()+"  "+k.getValue());
		}
		 
	}



}
