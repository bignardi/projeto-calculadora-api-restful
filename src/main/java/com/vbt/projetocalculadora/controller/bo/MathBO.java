package com.vbt.projetocalculadora.controller.bo;

import com.vbt.projetocalculadora.util.MathOperations;
import com.vbt.projetocalculadora.exception.MathOperationException;

public class MathBO {

    private MathOperations mathOperations = new MathOperations();

    // Sum
    public Double sum(String numberOne, String numberTwo) {
        if (!mathOperations.isNumeric(numberOne) || !mathOperations.isNumeric(numberTwo)) {
            throw new MathOperationException("Por favor, insira um valor numérico.");
        } else {
            return mathOperations.convertToDouble(numberOne) + mathOperations.convertToDouble(numberTwo);
        }
    }

    // Subtraction
    public Double subtraction(String numberOne, String numberTwo) {
        if (!mathOperations.isNumeric(numberOne) || !mathOperations.isNumeric(numberTwo)) {
            throw new MathOperationException("Por favor, insira um valor numérico.");
        } else {
            return mathOperations.convertToDouble(numberOne) - mathOperations.convertToDouble(numberTwo);
        }
    }

    // Multiplication
    public Double multiplication(String numberOne, String numberTwo) {
        if (!mathOperations.isNumeric(numberOne) || !mathOperations.isNumeric(numberTwo)) {
            throw new MathOperationException("Por favor, insira um valor numérico.");
        } else {
            return mathOperations.convertToDouble(numberOne) * mathOperations.convertToDouble(numberTwo);
        }
    }

    // Division
    public Double division(String numberOne, String numberTwo) {
        if (!mathOperations.isNumeric(numberOne) || !mathOperations.isNumeric(numberTwo)) {
            throw new MathOperationException("Por favor, insira um valor numérico.");
        } else {
            return mathOperations.convertToDouble(numberOne) / mathOperations.convertToDouble(numberTwo);
        }
    }

    // Module
    public Double module(String numberOne, String numberTwo) {
        if (!mathOperations.isNumeric(numberOne) || !mathOperations.isNumeric(numberTwo)) {
            throw new MathOperationException("Por favor, insira um valor numérico.");
        } else {
            return mathOperations.convertToDouble(numberOne) % mathOperations.convertToDouble(numberTwo);
        }
    }

    // Average
    public Double average(String numberOne, String numberTwo) {
        if (!mathOperations.isNumeric(numberOne) || !mathOperations.isNumeric(numberTwo)) {
            throw new MathOperationException("Por favor, insira um valor numérico.");
        } else {
            return (mathOperations.convertToDouble(numberOne) * mathOperations.convertToDouble(numberTwo)) / 2;
        }
    }

    // Square root
    public Double squareRoot(String numberOne) {
        if (!mathOperations.isNumeric(numberOne)) {
            throw new MathOperationException("Por favor, insira um valor numérico.");
        } else {
            return Math.sqrt(mathOperations.convertToDouble(numberOne));
        }
    }

}
