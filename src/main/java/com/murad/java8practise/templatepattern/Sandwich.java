package com.murad.java8practise.templatepattern;

public abstract class Sandwich {

    final void makeSandwich() {

        System.out.println("----------new order---------");
        cutBun();
        if (customerWantsMeet()) {
            addMeat();
        }
        addVegetable();
        if (customerWantsCondiments()) {
            addCondiments();
        }
        wrap();


    }


    protected abstract void addMeat();

    protected abstract void addCondiments();

    private void cutBun() {
        System.out.println("Cut the Bun");
    }

    private void addVegetable() {
        System.out.println("Vegetables Added");
    }

    private void wrap() {
        System.out.println("Sandwich wrapped");
    }

    public boolean customerWantsCondiments() {
        return true;
    }

    public boolean customerWantsMeet(){
        return true;
    }

}
