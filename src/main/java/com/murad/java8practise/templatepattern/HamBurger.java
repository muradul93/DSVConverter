package com.murad.java8practise.templatepattern;

public class HamBurger extends Sandwich{
    @Override
    protected void addMeat() {
        System.out.println("Hamburger meet added");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Special Sauce Added.");

    }
}
