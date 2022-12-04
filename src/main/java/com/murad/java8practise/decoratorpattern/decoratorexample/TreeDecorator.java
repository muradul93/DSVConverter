package com.murad.java8practise.decoratorpattern.decoratorexample;

public abstract class TreeDecorator implements ChristmasTree {
    private ChristmasTree tree;
    
//     standard constructors
    TreeDecorator(ChristmasTree christmasTree){
        this.tree=christmasTree;
    }

    @Override
    public String decorate() {
        return tree.decorate();
    }
}