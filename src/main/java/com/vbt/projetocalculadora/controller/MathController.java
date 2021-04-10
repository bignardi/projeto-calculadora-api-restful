package com.vbt.projetocalculadora.controller;

import com.vbt.projetocalculadora.controller.bo.MathBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vbt.projetocalculadora.exception.MathOperationException;

@RestController
public class MathController {

    private final MathBO mathBO = new MathBO();

    // Sum
    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)
            throws Exception {
        return mathBO.sum(numberOne, numberTwo);
    }

    // Subtraction
    @RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double subtraction(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)
            throws Exception {
        return mathBO.subtraction(numberOne, numberTwo);
    }

    // Multiplication
    @RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double multiplication(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)
            throws Exception {
        return mathBO.multiplication(numberOne, numberTwo);
    }

    // Division
    @RequestMapping(value = "/division/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double division(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)
            throws Exception {
        return mathBO.division(numberOne, numberTwo);
    }

    // Module
    @RequestMapping(value = "/module/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double module(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)
            throws Exception {
        return mathBO.module(numberOne, numberTwo);
    }

    // Average
    @RequestMapping(value = "/average/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double average(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)
            throws Exception {
        return mathBO.average(numberOne, numberTwo);
    }

    // Square root
    @RequestMapping(value = "/squareroot/{numberOne}", method = RequestMethod.GET)
    public Double squareRoot(@PathVariable("numberOne") String numberOne)
            throws Exception {
        return mathBO.squareRoot(numberOne);
    }

}
