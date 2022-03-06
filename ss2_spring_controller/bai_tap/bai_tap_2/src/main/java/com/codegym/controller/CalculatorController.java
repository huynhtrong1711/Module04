package com.codegym.controller;

import com.codegym.service.CalculateServiceImpl;
import com.codegym.service.ICalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {

    @Autowired
    private  ICalculateService iCalculateService;

    @GetMapping("/")
    public String home() {
        return "/home";
    }

    @PostMapping("/home")
    public String Calculation(@RequestParam double numberOne, @RequestParam double numberTwo, @RequestParam String button,
                                    Model model) {
        String result = iCalculateService.calculate(numberOne,numberTwo, button);
        model.addAttribute("result", result);
        return "/home";
    }
}
