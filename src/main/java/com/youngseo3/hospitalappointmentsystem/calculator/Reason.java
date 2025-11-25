package com.youngseo3.hospitalappointmentsystem.calculator;

import lombok.Getter;

@Getter
public enum Reason {
    HEALTH_CHECKUP("일반 검진", new HealthCheckupCalculator()),
    COLD_SYMPTOMS("감기 증상", new ColdSymptomsCalculator()),
    FATIGUE_RECOVERY_INJECTION("피로 회복 주사", new FatigueRecoveryInjectionCalculator());

    private final String content;
    private final Calculator calculator;

    Reason(String content, Calculator calculator) {
        this.content = content;
        this.calculator = calculator;
    }

    public static Reason fromContent(String content) {
        for (Reason reason : values()) {
            if (reason.content.equals(content)) {
                return reason;
            }
        }

        throw new IllegalArgumentException("알 수 없는 진료 목적: " + content);
    }
}
