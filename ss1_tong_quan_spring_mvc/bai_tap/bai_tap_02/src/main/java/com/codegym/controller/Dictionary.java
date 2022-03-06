package com.codegym.controller;

import com.codegym.service.ITranslateService;
import com.codegym.service.TranslateServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class Dictionary {
    private ITranslateService translates = new TranslateServiceImpl();

    @GetMapping("/")
    public String home(){
        return "/home";
    }

    @GetMapping("/translate")
    public String translate (@RequestParam String english, Model model) {
        String search = translates.check(english);
        model.addAttribute("search", search);
        return "/home";
    }
}
