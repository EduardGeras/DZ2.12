package com.example.dz2_12.service;

import com.example.dz2_12.exception.DivideByZeroException;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService{

    public double plus(double num1, double num2) {
        return num1 + num2;
    }
    public double minus(double num1, double num2) {
        return num1 - num2;
    }
    public double multiply(double num1, double num2) {
        return num1 * num2;
    }
    public double divide(double num1, double num2) {
        if (num2 == 0) {
            throw new DivideByZeroException ("На нуль делить нельзя!!!");
        }
        return num1 / num2;
    }
}
