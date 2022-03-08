package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

//    @GetMapping("customers")
//    public ModelAndView  home() {
//        List<Customer> customers = customerService.findAll();
//        ModelAndView modelAndView = new ModelAndView("list");
//        modelAndView.addObject("customers", customers);
//        return modelAndView;
//    }

    @GetMapping("customer")
    public ModelAndView  create() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/create")
    public String showCreateForm(Customer customer, RedirectAttributes redirectAttributes) {
        customerService.insertWithStoredProcedure(customer);
        redirectAttributes.addFlashAttribute("message", "thêm mới thành công!");
        return "redirect:/customer";
    }

}
