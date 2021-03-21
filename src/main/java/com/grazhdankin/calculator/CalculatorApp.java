package com.grazhdankin.calculator;

import java.util.Scanner;

import com.grazhdankin.calculator.service.CalculatorService;

public class CalculatorApp {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(CalculatorService.calculate(in.nextLine()));
    }
}
