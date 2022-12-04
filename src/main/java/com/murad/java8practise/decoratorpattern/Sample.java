package com.murad.java8practise.decoratorpattern;

import java.util.function.Function;

public class Sample {

    public static void doWork(int value, Function<Integer, Integer> function) {
        System.out.println(function.apply(value));
    }

    public static void main(String[] args) {

        Function<Integer, Integer> increment = e -> e + 1;
        Function<Integer, Integer> doubleIt = e -> e * 2;

        doWork(5, increment);
        doWork(5, doubleIt);
        doWork(5, e -> e * 3);

//        increment and doubleIt in traditional approach
        int temp = increment.apply(5);
        System.out.println(doubleIt.apply(temp));

//        increment and doubleIt using lambda
        doWork(5,increment.andThen(doubleIt));


    }
}
