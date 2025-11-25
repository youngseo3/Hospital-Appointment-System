package com.youngseo3.hospitalappointmentsystem.calculator;

import org.springframework.stereotype.Component;

@Component
public class HealthCheckupCalculator implements Calculator {
    @Override
    public int calculate() {
        return 10000;
    }

    @Override
    public boolean matches(String reason) {
        return "일반 검진".equals(reason);
    }
}
