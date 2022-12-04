package com.murad.java8practise.templatepattern;

public class Veggisub extends Sandwich{
    @Override
    public boolean customerWantsMeet() {
        return false;
    }

    @Override
    protected void addMeat() {

    }

    @Override
    protected void addCondiments() {
        System.out.println("onion and oil added");
    }
}
