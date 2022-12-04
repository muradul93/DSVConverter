package com.murad.java8practise.strategypattern;

import jdk.nashorn.internal.runtime.logging.Logger;

import java.util.Arrays;
import java.util.List;
@Logger
public class SampleTotalClass {

    public static int totalValues(List<Integer> values) {
        int result = 0;

        for (int e : values) {
            result += e;
        }

        return result;
    }
    public static int totalEvenValues(List<Integer> values) {
        int result = 0;

        for (int e : values) {
            if (e % 2 == 0) {
                result += e;
            }
        }

        return result;
    }
    public static int totalOddValues(List<Integer> values) {
        int result = 0;

        for (int e : values) {
            if (e % 2 != 0) {
                result += e;
            }
        }

        return result;
    }



    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//        Total all values
        System.out.println(totalValues(numbers));
//        Total even values
        System.out.println(totalEvenValues(numbers));
//        Total odd values
        System.out.println(totalOddValues(numbers));


    }


}
