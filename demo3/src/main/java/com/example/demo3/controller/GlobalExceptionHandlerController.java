package com.example.demo3.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

@ControllerAdvice
public class GlobalExceptionHandlerController {

    @ExceptionHandler(value = Exception.class)
    public String HandleException(Exception e) {
        if (e instanceof ArithmeticException) {
            return "arithmeticException";
        }
        return null;
    }
}
