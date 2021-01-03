package main;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

	public static List<String> createFizzBuzzList(int size) {
		
		List<String> list = new ArrayList<String>(size);
		for(int i=1; i<=size; i++) {
			if(i%3==0) {
				list.add("Fizz");
			}
			else {
				list.add(Integer.toString(i));
			}
		}
		
		return list;
	}

}
