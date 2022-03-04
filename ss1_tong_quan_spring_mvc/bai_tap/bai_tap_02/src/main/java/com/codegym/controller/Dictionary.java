package com.codegym.controller;

import com.codegym.service.TranslateServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class Dictionary {
    private TranslateServiceImpl translates = new TranslateServiceImpl();
    Map<String, String> translateMap = translates.dictionaryMap();

    @GetMapping("/")
    public String home(){
        return "/home";
    }

    @GetMapping("/translate")
    public String translate (@RequestParam String english, Model model) {
        for (Map.Entry<String, String> entry : translateMap.entrySet()) {
            if (entry.getKey().toLowerCase().equals(english.toLowerCase())){
                model.addAttribute("vietnamese", entry.getValue());
            }else {
                model.addAttribute("massage", "Không có từ cần tìm!");
            }
        }
        return "/home";
    }
}
