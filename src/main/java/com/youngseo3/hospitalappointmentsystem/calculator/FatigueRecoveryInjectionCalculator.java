package com.youngseo3.hospitalappointmentsystem.calculator;

import org.springframework.stereotype.Component;

@Component
public class FatigueRecoveryInjectionCalculator implements Calculator {
    @Override
    public int calculate()  {
        return 25000;
    }

    @Override
    public boolean matches(String reason) {
        return "피로 회복 주사".equals(reason);
    }
}
