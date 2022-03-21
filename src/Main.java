import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
	
	public static void main(String args[]) {
		
		// Creating a list
		List<String> list = new ArrayList<String>(Arrays.asList("Java","Java Script","C","Python"));
		
		// getting a filtered list, imperative way
		List<String> filteredList = new ArrayList<String>();
		for(String s:list) {
			if(s.startsWith("J")) {
				filteredList.add(s);
			}
		}
		
		System.out.println("Filtered List :"+filteredList);
		
		// getting filtered list with stream
		String filteredList1 = list.stream().filter(s->s.startsWith("J")).collect(Collectors.joining(", "));
		System.out.println("Filtered concatenated list :"+filteredList1);
		
		//example of Lambda expressions, implementation of MyInterface
		MyInterface i = ()->System.out.println("Hello World!");
		i.sayHello();
		
		//intermediate operation map()
		List<String> listUpper = list.stream().map(s->s.toUpperCase()).collect(Collectors.toList());
		System.out.println("List in upper case :"+listUpper);
		
		//multiple intermediate operations map() and limit()
		List<String> limitedList = list.stream().map(s->s.toUpperCase()).limit(3).collect(Collectors.toList());
		System.out.println("limitedList :"+limitedList);
		
		List<String> sortedList = list.stream().sorted((s1,s2)->s1.compareTo(s2)).collect(Collectors.toList());
		System.out.println("Sorted List :"+sortedList);
		
		long count = list.stream().filter(s->s.startsWith("J")).count();
		long distinct = list.stream().distinct().count();
		System.out.println("distinct :"+distinct);
		
		boolean match = list.stream().anyMatch(x->x.equals("Java"));
		System.out.println("match "+ match);
		
		Optional<String> reduced = list.stream().reduce((a,b)->a+","+b);
		String reduced1 = list.stream().reduce("",(a,b)->a+","+b);
				System.out.println("reduced :"+reduced.get());
				
				Optional<String> first = list.stream().filter(s->s.startsWith("J")).peek(s1->System.out.println("Peeking :"+s1)).findFirst();
				System.out.println("first :"+first.get());
	}

}
