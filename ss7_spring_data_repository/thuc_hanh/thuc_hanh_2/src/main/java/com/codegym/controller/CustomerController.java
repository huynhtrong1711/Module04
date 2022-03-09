package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.ICustomerService;
import com.codegym.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("customers")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IProvinceService provinceService;

    @GetMapping("/home")
    public ModelAndView home(@PageableDefault(value = 5, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
//        return new ModelAndView("home", "customer", customerService.findAll(pageable));
        Page<Customer> customer = customerService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("customer/home");
        modelAndView.addObject("customer", customer);
        modelAndView.addObject("province", provinceService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("customer/create");
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("provinces", provinceService.findAll());
        return modelAndView;
    }

    @PostMapping("/create")
    public String saveCustomer(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Thêm mới thành công!");
        return "redirect:/customers/home";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable int id) {
        Customer customer = customerService.findById(id);
        ModelAndView modelAndView = new ModelAndView("customer/edit");
        modelAndView.addObject("customer", customer);
        modelAndView.addObject("provinceList", provinceService.findAll());
        return modelAndView;
    }

    @PostMapping("/edit")
    public String updateCustomer(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Chỉnh sửa thành công!");
        return "redirect:/customers/home";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDelete(@PathVariable int id) {
        Customer customer = customerService.findById(id);
        ModelAndView modelAndView = new ModelAndView("customer/delete");
        modelAndView.addObject("customer", customer);
        modelAndView.addObject("provinceList", provinceService.findAll());
        return modelAndView;
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
        customerService.remove(customer.getId());
        redirectAttributes.addFlashAttribute("message", "Xóa thành công!");
        return "redirect:/customers/home";
    }

    @GetMapping("/search")
    public ModelAndView searchByName(
            @RequestParam("result") String keyword, Pageable pageable) {
        Page<Customer> customer = customerService.searchByName(keyword, pageable);
        ModelAndView modelAndView = new ModelAndView("customer/home");
        modelAndView.addObject("customer", customer);
        modelAndView.addObject("province", provinceService.findAll());
        return modelAndView;
    }

}
