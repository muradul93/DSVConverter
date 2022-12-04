package com.murad.java8practise.templatepattern;

public class Cook {
    public static void main(String[] args) {
        Sandwich  hamBurger =new HamBurger();
        hamBurger.makeSandwich();

        Sandwich  veggisub =new Veggisub();
        veggisub.makeSandwich();

    }

}
