package com.murad.java8practise.strategypattern;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class StrategyPatternWithLambda {


    public static int totalValues(List<Integer> values, Predicate<Integer> selector) {

        return values.stream()
                .filter(selector)
                .mapToInt(e -> e)
                .sum();
    }


    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

//        Total even values
//        System.out.println(totalValues(numbers, e -> e % 2 == 0));
//        Total odd values
//        System.out.println(totalValues(numbers, e -> e % 2 != 0));

//        Total all values
        System.out.println(totalValues(numbers, e -> true));
//        Total even values
        System.out.println(totalValues(numbers, e->OddEvenUtil.isEven(e)));
//        Total odd values
        System.out.println(totalValues(numbers, OddEvenUtil::isOdd));


    }


}

class OddEvenUtil {

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static boolean isOdd(int number) {
        return number % 2 != 0;
    }

}
