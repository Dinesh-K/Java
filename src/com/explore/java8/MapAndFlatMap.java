package com.explore.java8;

import java.util.Arrays;
import java.util.List;

public class MapAndFlatMap {

	public static void main(String[] args) {
		List<String> flowers = Arrays.asList("Lotus", "Jasmine", "Rose", "Hibiscus", "Sunflower");
		
		//Map - Transforming to another form...
		flowers.stream().map(flower -> flower+ " - "+flower.length())
						.forEach(System.out::println);
		
		//Flat Map - flattens the one higher level Ex: string to char-array.
		flowers.stream().map(name  ->  name.chars())
        				.flatMap(intStream ->  intStream.mapToObj(n ->  (char)n))
        				.forEach(System.out::println); 		
	}
}
