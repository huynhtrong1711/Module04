package com.codegym.controller;

import com.codegym.model.Medical;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MedicalController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("from",new Medical());
        model.addAttribute("travel", new String[] {"Tàu bay","Tàu thuyền","Ô tô","Khác"});
        return "/home";
    }

    @PostMapping("/register")
    public String register(Medical medical, Model model){
        String info = medical.toString();
        model.addAttribute("info", info);
        return "/result";
    }
}
