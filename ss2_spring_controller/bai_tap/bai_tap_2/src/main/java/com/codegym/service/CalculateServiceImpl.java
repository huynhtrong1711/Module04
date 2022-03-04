package com.codegym.service;

public class CalculateServiceImpl implements ICalculateService{
    @Override
    public double addition(double numberOne, double numberTwo) {
        return numberOne + numberTwo;
    }

    @Override
    public double subtraction(double numberOne, double numberTwo) {
        return numberOne - numberTwo;
    }

    @Override
    public double multiplication(double numberOne, double numberTwo) {
        return numberOne * numberTwo;
    }

    @Override
    public double division(double numberOne, double numberTwo) {
        return numberOne / numberTwo;
    }
}
