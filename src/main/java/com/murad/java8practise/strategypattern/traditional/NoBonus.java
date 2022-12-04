package com.murad.java8practise.strategypattern.traditional;

public class NoBonus implements Pay {
    @Override
    public double getPay(double salary) {
        return salary;
    }
}
