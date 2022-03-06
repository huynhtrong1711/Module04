package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.CustomerServiceImpl;
import com.codegym.service.ICustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    private final ICustomerService iCustomerService = new CustomerServiceImpl();

    @GetMapping("")
    public String index(Model model) {
        List<Customer> customerList = iCustomerService.findAll();
        model.addAttribute("customers", customerList);
        return "/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("customer", new Customer());
        return "/create";
    }

    @PostMapping("/save")
    public String save(Customer customer, RedirectAttributes redirectAttributes) {
        customer.setId((int) (Math.random() * 1000));
        iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Bạn đã thêm mới khách hàng: " + customer.getName() + " thành công");
        return "redirect:/customer";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("customer", iCustomerService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(Customer customer) {
        iCustomerService.update(customer.getId(), customer);
        return "redirect:/customer";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("customer", iCustomerService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String remove(Customer customer, RedirectAttributes redirectAttributes) {
        iCustomerService.remove(customer.getId());
        redirectAttributes.addFlashAttribute("message","Bạn đã xóa khách hàng: " + customer.getName() + " thành công" );
        return "redirect:/customer";
    }

    @GetMapping("/{id}/view")
    public String views(@PathVariable int id,Model model) {
        model.addAttribute("customer",iCustomerService.findById(id));
        return "/view";
    }
}
