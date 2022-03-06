package com.codegym.service;

import org.springframework.stereotype.Service;

@Service
public class CalculateServiceImpl implements ICalculateService{
    @Override
    public String calculate(double numberOne, double numberTwo, String number) {
        String result = "";
        switch (number) {
            case "Addition (+)" :
                result = numberOne + numberTwo + "";
                break;
            case "Subtraction (-)" :
                result = numberOne - numberTwo + "";
                break;
            case "Multiplication (*)" :
                result = numberOne * numberTwo +"";
                break;
            case "Division (/)" :
                if (numberTwo == 0) {
                    return "Chia cho 0 sữ là vô nghĩa!";
                } else {
                    result = numberOne / numberTwo + "";
                    break;
                }
        }
        return result;
    }
}
