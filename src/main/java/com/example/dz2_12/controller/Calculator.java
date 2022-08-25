package com.example.dz2_12.controller;



import com.example.dz2_12.service.CalculatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/calculator")
public class Calculator {

    @GetMapping()
    public String hello() {
        return "Добро пожаловать в калькулятор";
    }
    private final CalculatorService calculatorService;

    public Calculator(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/plus")
    public String plus(@RequestParam (required = false) double num1,
                       @RequestParam (required = false) double num2) {
        if (Objects.isNull(num1) || Objects.isNull(num2)){
            return "Введите, пожалуйста, все параметры";
        }
        return num1 + " + " + num2 + " = " + calculatorService.plus(num1, num2);
    }
    @GetMapping("/minus")
    public String minus(@RequestParam (required = false) double num1,
                        @RequestParam (required = false) double num2) {
        if (Objects.isNull(num1) || Objects.isNull(num2)){
            return "Введите, пожалуйста, все параметры";
        }
        return num1 + " - " + num2 + " = " + calculatorService.minus(num1, num2);
    }
    @GetMapping("/multiply")
    public String multiply(@RequestParam (required = false) double num1,
                           @RequestParam (required = false) double num2) {
        if (Objects.isNull(num1) || Objects.isNull(num2)){
            return "Введите, пожалуйста, все параметры";
        }
        return num1 + " * " + num2 + " = " + calculatorService.multiply(num1, num2);
    }
    @GetMapping("/divide")
    public String divide(@RequestParam (required = false) double num1,
                         @RequestParam (required = false) double num2) {
        if (Objects.isNull(num1) || Objects.isNull(num2)){
            return "Введите, пожалуйста, все параметры";
        }
        return num1 + " / " + num2 + " = " + calculatorService.divide(num1, num2);
    }

}
