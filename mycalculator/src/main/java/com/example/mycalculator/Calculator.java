package com.example.mycalculator;


public class Calculator implements ICalculator {

    @Override
    public double plus(double a, double b) {
        return a+b;
    }

    @Override
    public double minus(double a, double b) {
        return a-b;
    }

    @Override
    public double multiply(double a, double b) {
        return a*b;
    }

    @Override
    public double div(double a, double b) {
        if (b!=0) {
            return a/b;}
        else {
            System.out.println("/0");
            return 0;}
    }

}