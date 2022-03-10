package com.codegym.controller;

import com.codegym.dto.UserDto;
import com.codegym.model.User;
import com.codegym.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/list")
    public ModelAndView showList() {
        List<User> userDtoList = userService.findAll();
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("userDtoList", userDtoList);
        return modelAndView;
    }

    @GetMapping("/create")
    public String home(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "create";
    }

    @PostMapping("/create")
    public String validate(@Validated @ModelAttribute UserDto userDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            return "/create";
        } else {
            User user = new User();
            BeanUtils.copyProperties(userDto, user);
            userService.save(user);
            redirectAttributes.addFlashAttribute("message", "Thêm mới một user thành công");
            return "redirect:/list";
        }
    }


}
