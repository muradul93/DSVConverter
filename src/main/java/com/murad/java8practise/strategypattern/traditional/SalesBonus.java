package com.murad.java8practise.strategypattern.traditional;

public class SalesBonus implements Pay {
    @Override
    public double getPay(double salary) {

        return salary+salary*0.20;
    }
}
