package com.murad.java8practise.decoratorpattern;


import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

class Camera {
    Function<Color, Color> filter;

    public Camera(Function<Color, Color>... filters) {
        setFilters(filters);
    }

    //    "..." can take variable arguments
    private void setFilters(Function<Color, Color>... filters) {

        filter = Stream.of(filters)
                .reduce(
                        Function.identity(),
                        Function::andThen);
    }


    public Color snap(Color color) {
        return filter.apply(color);
    }
}

public class DecoratorTest {
    public static void printSnap(Camera camera) {

        System.out.println(camera.snap(new Color(125, 125, 125)));
    }

    public static void main(String[] args) {
        printSnap(new Camera());
        printSnap(new Camera(Color -> Color.brighter()));
        printSnap(new Camera(Color::darker));
        printSnap(new Camera(Color::darker, Color::brighter));
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

    }
}
//        filter = Stream.of(filters)
//                .reduce(
//                        color -> color,
//                        (theFilter, aFilter) ->
//                                theFilter.andThen(aFilter));