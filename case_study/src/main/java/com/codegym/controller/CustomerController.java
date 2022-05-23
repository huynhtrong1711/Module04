package com.codegym.controller;

import com.codegym.dto.CustomerDto;
import com.codegym.model.customer.Customer;
import com.codegym.service.customer.ICustomerService;
import com.codegym.service.customer.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping({"/customer"} )
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ICustomerTypeService customerTypeService;



    @GetMapping
    public ModelAndView homeCustomer(@PageableDefault(value = 5, sort = "customerName", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Customer> customers = customerService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("customer/list");
        modelAndView.addObject("customerList", customers);
        modelAndView.addObject("customerType", customerTypeService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("customer/create");
        modelAndView.addObject("customerDto", new CustomerDto());
        modelAndView.addObject("customerType", customerTypeService.findAll());
        return modelAndView;
    }

    @PostMapping("/save")
    public String createCustomer(@Validated @ModelAttribute CustomerDto customerDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("customerType", customerTypeService.findAll());
            return "customer/create";
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto,customer);
            customerService.save(customer);
            model.addAttribute("message", "Thêm mới khách hàng " + customer.getCustomerName() + " thành công!");
            return "redirect:/customer";
        }
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEdit(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("customer/edit");
        modelAndView.addObject("customerType", customerTypeService.findAll());
        Customer customer = customerService.findById(id);
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer, customerDto);
        modelAndView.addObject("customerDto",customerDto);
        return modelAndView;
    }

    @PostMapping("/edit")
    public String editCustomer(@Validated @ModelAttribute CustomerDto customerDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("customerType", customerTypeService.findAll());
            return "customer/create";
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto,customer);
            customerService.save(customer);
            model.addAttribute("message", "Chỉnh sửa thông tin khách hàng " + customer.getCustomerName() + " thành công!");
            return "redirect:/customer";
        }
    }

    @PostMapping("/delete")
    public String deleteCustomer( RedirectAttributes redirectAttributes,@RequestParam int id) {
        customerService.remove(id);
        redirectAttributes.addFlashAttribute("message", "Xóa thành công!");
        return "redirect:/customer";
    }

    @GetMapping("/search")
    public String searchCustomer(@RequestParam(name = "name", required = false) String name, Model model, @PageableDefault(value = 5, sort = "customerName", direction = Sort.Direction.ASC) Pageable pageable) {
        model.addAttribute("customerList", customerService.findByName(name, pageable));
        return "/customer/list";
    }
 }
