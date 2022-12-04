package com.murad.java8practise.strategypattern.traditional;

public class TraditionalStrategyPattern {


    public static void main(String[] args) {
        Pay saleType = new SalesBonus();
        Employee sales = new SalesEmployee(10000, saleType);
        System.out.println("Sale employee : " + sales.getPayAmount());


        Employee manager = new ManagerEmployee(15000);
        manager.setPayType(new NoBonus());
        System.out.println("manager employee : " + manager.getPayAmount());


        Employee bestSalesEmployee = new SalesEmployee(10000);
        bestSalesEmployee.setPayType(new BestSalesBonus());
        System.out.println("Best Sale employee : " + bestSalesEmployee.getPayAmount());


    }
}

class Employee {

    protected double salary = 0.0;
    public Pay payType = new NoBonus();


    public Employee(double salary) {
        this.salary = salary;
    }

    public Employee(double salary, Pay payType) {
        this.salary = salary;
        this.payType = payType;
    }


    public void setSalary(double salary) {
        this.salary = salary;
    }


    public void setPayType(Pay payType) {
        this.payType = payType;
    }

    double getPayAmount() {
        return this.payType.getPay(this.salary);

    }
}

class SalesEmployee extends Employee {
    public SalesEmployee(double salary) {
        super(salary);
    }

    public SalesEmployee(double salary, Pay payType) {
        super(salary, payType);
    }
}

class ManagerEmployee extends Employee {

    public ManagerEmployee(double salary, Pay payType) {
        super(salary, payType);
    }

    public ManagerEmployee(double salary) {
        super(salary);
    }
}


