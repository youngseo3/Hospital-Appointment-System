package com.youngseo3.hospitalappointmentsystem.global;

import lombok.Getter;

@Getter
public class ApiResponse<T> {
    private final boolean success;
    private final T data;
    private final String error;

    public ApiResponse(boolean success, T data, String error) {
        this.success = success;
        this.data = data;
        this.error = error;
    }

    public static <T> ApiResponse<T> onSuccess(T data) {
        return new ApiResponse<>(true, data, null);
    }

    public static <T> ApiResponse<T> onFailure(String error) {
        return new ApiResponse<>(false, null, error);
    }
}
