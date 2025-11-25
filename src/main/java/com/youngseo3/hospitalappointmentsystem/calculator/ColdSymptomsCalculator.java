package com.youngseo3.hospitalappointmentsystem.calculator;

import org.springframework.stereotype.Component;

@Component
public class ColdSymptomsCalculator implements Calculator {
    @Override
    public int calculate() {
        return 15000;
    }

    @Override
    public boolean matches(String reason) {
        return "감기 증상".equals(reason);
    }
}
