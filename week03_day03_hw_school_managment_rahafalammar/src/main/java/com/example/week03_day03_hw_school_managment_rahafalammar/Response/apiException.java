package com.example.week03_day03_hw_school_managment_rahafalammar.Response;

public class apiException extends RuntimeException{
    public apiException(String message) {
        super(message);
    }
}
