package com.murad.java8practise;// Java program to demonstrate lambda expressions to
// implement a user defined functional interface.

import java.util.function.Consumer;
import java.util.function.Function;

@FunctionalInterface

interface Square {
	int calculate(int x);
}

class Test {
	public static void main(String args[])
	{
		int a = 5;

		// lambda expression to define the calculate method
		Square s = x -> x * x;

		// parameter passed and return type must be
		// same as defined in the prototype
		int ans = s.calculate(a);
		System.out.println(ans);

		Consumer<Integer> consumer = System.out::println;
		consumer.accept(5);

	}

}
 class consumerTest{

	public static void consumeValue(Integer value,Consumer<Integer> consumer){
		consumer.accept(value);
	}



	public static void main(String[] args) {
		Consumer<Integer> consumer = e-> System.out.println(e*2);
		Consumer<Integer> consumerplus = e-> System.out.println(e*5);

//		consumerplus.andThen(consumer);
//		consumer.accept(7);
//		consumerplus.accept(9);

		consumeValue(7,consumerplus.andThen(consumer));
	}


}

class functionTest{

	public static void consumeValue(Integer value,Consumer<Integer> consumer){
		consumer.accept(value);
	}



	public static void main(String[] args) {
		Function<Integer,Integer> doubleIt = e-> e*2;
		Function<Integer,Integer> tripleIt = e-> e*3;
		Function<Integer,String> stringIt = String::valueOf;

		System.out.println(doubleIt.apply(12));
		System.out.println(stringIt.apply(13));

		System.out.println(doubleIt.andThen(stringIt).apply(10));
		System.out.println(doubleIt.andThen(tripleIt).andThen(stringIt).apply(4));




//		consumeValue(6,consumerplus.andThen(consumer));
	}


}
