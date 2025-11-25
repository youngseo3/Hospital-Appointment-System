package com.youngseo3.hospitalappointmentsystem.calculator;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CalculatorFactory {
    private final List<Calculator> calculators;

    public CalculatorFactory(List<Calculator> calculators) {
        this.calculators = calculators;
    }

    public Calculator getCalculator(String reason) {
        for(Calculator calc: calculators) {
            if(calc.matches(reason)) {
                return calc;
            }
        }

        throw new IllegalArgumentException("알 수 없는 진료 목적: " + reason);
    }
}
