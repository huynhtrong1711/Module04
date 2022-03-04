package com.codegym.controller;

import com.codegym.model.Settings;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SettingsController {

    @GetMapping("/home")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("/home", "settings", new Settings());
        return modelAndView;
    }

    @PostMapping("/submit")
    public String setting(@ModelAttribute("settings") Settings settings, Model model) {
        model.addAttribute("languages", settings.getLanguages());
        model.addAttribute("size", settings.getSize());
        model.addAttribute("spansFilter", settings.getSpansFilter());
        model.addAttribute("signature", settings.getSignature());
        return "/result";
    }
}
