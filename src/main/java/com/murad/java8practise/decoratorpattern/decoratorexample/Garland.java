package com.murad.java8practise.decoratorpattern.decoratorexample;

public class Garland extends TreeDecorator {
    Garland(ChristmasTree christmasTree) {
        super(christmasTree);
    }

    public String decorate() {
        return super.decorate() + decorateWithGarland();
    }

    private String decorateWithGarland() {

        return " with Garland";
    }
}