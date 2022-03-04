package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SandwichController {

    @GetMapping("/")
    public String home(){
        return"/home";
    }

    @PostMapping("/sandwich")
    public ModelAndView sandwich(@RequestParam(required = false, defaultValue = "a") String[] condiments) {
        ModelAndView modelAndView;
        if (!condiments[0].equals("a")){
            modelAndView = new ModelAndView("/home", "list", condiments);
        }else {
            modelAndView = new ModelAndView("/home", "list", "Hãy chọn topping đi nào!");
        }

        return modelAndView;
    }
}
