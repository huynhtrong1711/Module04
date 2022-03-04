package com.codegym.controller;

import com.codegym.service.CalculateServiceImpl;
import com.codegym.service.ICalculateService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {
    private final ICalculateService iCalculateService = new CalculateServiceImpl();

    @GetMapping("/")
    public String home() {
        return "/home";
    }

    @PostMapping("/home")
    public String Calculation(@RequestParam double numberOne, @RequestParam double numberTwo, @RequestParam String button,
                                    Model model) {
        double result = 0;
        switch (button) {
            case "Addition":
                result = iCalculateService.addition(numberOne, numberTwo);
                break;
            case "Subtraction" :
                result =iCalculateService.subtraction(numberOne, numberTwo);
                break;
            case "Multiplication" :
                result = iCalculateService.multiplication(numberOne,numberTwo);
                break;
            case "Division" :
                if (numberTwo == 0) {
                    model.addAttribute("message", "Chia cho 0 sữ là vô nghĩa!");
                } else {
                    result = iCalculateService.division(numberOne, numberTwo);
                }
                break;
        }
        model.addAttribute("result",result);
        model.addAttribute("button", button);
        return "/home";
    }
}
