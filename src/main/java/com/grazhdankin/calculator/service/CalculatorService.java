package com.grazhdankin.calculator.service;

import java.util.Arrays;
import java.util.List;

import com.grazhdankin.calculator.util.NumeralUtils;

public class CalculatorService {

    public static String calculate(String input) {
        List<String> inputList = Arrays.asList(input.trim().split(" "));

        if (inputList.isEmpty() || inputList.size() > 3) {
            throw new IllegalArgumentException("Invalid input format: '" + input + "'!");
        }

        String firstOperand = inputList.get(0);
        String operator = inputList.get(1);
        String secondOperand = inputList.get(2);

        if (!((NumeralUtils.isPositiveArabic(firstOperand) && NumeralUtils.isPositiveArabic(secondOperand))
                || (NumeralUtils.isRoman(firstOperand) && NumeralUtils.isRoman(secondOperand)))) {
            throw new IllegalArgumentException("Invalid input format: '" + input + "'!");
        }

        boolean isInputRoman = NumeralUtils.isRoman(firstOperand);
        int firstOperandInt, secondOperandInt;
        if (isInputRoman) {
            firstOperandInt = NumeralUtils.convertRomanToArabic(firstOperand);
            secondOperandInt = NumeralUtils.convertRomanToArabic(secondOperand);
        } else {
            firstOperandInt = Integer.parseInt(firstOperand);
            secondOperandInt = Integer.parseInt(secondOperand);
        }

        int resultInt = switch (operator) {
            case "+" -> firstOperandInt + secondOperandInt;
            case "-" -> firstOperandInt - secondOperandInt;
            case "*" -> firstOperandInt * secondOperandInt;
            case "/" -> firstOperandInt / secondOperandInt;
            default -> throw new IllegalArgumentException("Invalid operator: '" + operator + "'!");
        };

        return (isInputRoman) ? NumeralUtils.convertArabicToRoman(resultInt) : String.valueOf(resultInt);
    }
}
