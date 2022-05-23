package com.codegym.controller;

import com.codegym.dto.TransactionDto;
import com.codegym.model.Customer;
import com.codegym.model.Transaction;
import com.codegym.service.ICustomerService;
import com.codegym.service.ITransactionService;
import com.codegym.service.ITypeOfServiceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
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

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private ITransactionService transactionService;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ITypeOfServiceService typeOfServiceService;

    @GetMapping
    public ModelAndView list(@PageableDefault(value = 5)Pageable pageable) {
        Page<Transaction> transactions = transactionService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("transactionList", transactions);
        modelAndView.addObject("customer", customerService.findAll());
        modelAndView.addObject("tyOfService", typeOfServiceService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("transactionDto", new TransactionDto());
        modelAndView.addObject("customer", customerService.findAll());
        modelAndView.addObject("typeOfService", typeOfServiceService.findAll());
        return modelAndView;
    }

    @PostMapping("/save")
    public String createTransaction(@Validated @ModelAttribute TransactionDto transactionDto, BindingResult bindingResult, Model model) {
        new TransactionDto().validate(transactionDto, bindingResult);
        Transaction transaction = new Transaction();

        if (bindingResult.hasFieldErrors()) {
                model.addAttribute("customer", customerService.findAll());
                model.addAttribute("typeOfService", typeOfServiceService.findAll());
                return "create";
        } else {
            BeanUtils.copyProperties(transactionDto, transaction);
            transactionService.save(transaction);
            model.addAttribute("message", "Thêm mới giao dịch thành công!");
            return "redirect:/transaction";
        }
    }

    @GetMapping("/view/{id}")
    public String showView(@PathVariable int id, RedirectAttributes redirectAttributes, Model model) {
        Transaction transaction = transactionService.findById(id);
        if (transaction == null) {
            redirectAttributes.addFlashAttribute("message" , "Id của giao dịch không tồn tại!");
            return "redirect:/transaction";
        } else {
            model.addAttribute("transaction", transaction);
            model.addAttribute("customer", customerService.findAll());
            model.addAttribute("typeService", typeOfServiceService.findAll());
            return "view";
        }
    }

    @PostMapping("/delete")
    public String deleteTransaction(@RequestParam("id") Integer id, RedirectAttributes redirectAttributes, Model model) {
        Transaction transaction = transactionService.findById(id);
        if (transaction == null) {
            model.addAttribute("message" , "Id của giao dịch không tồn tại!");
            return "view";
        } else {
            transactionService.remove(id);
            redirectAttributes.addFlashAttribute("message", "Xóa giao dịch thành công!");
            return "redirect:/transaction";
        }
    }

    @GetMapping("/search")
    public ModelAndView searchCustomer(@RequestParam(name = "name", required = false) String name,
                                       @PageableDefault(value = 5, sort = "codeTransaction",
                                               direction = Sort.Direction.ASC) Pageable pageable) {
//        Page<Customer> customers = customerService.findByName(name, pageable);
//        List<Transaction> transactions = new ArrayList<>();
//        for (int i = 0; i < customers.getContent().size(); i++) {
//            transactions.addAll(customers.getContent().get(i).getTransactions());
//        }
//        Page<Transaction> transactionPage = new PageImpl<Transaction>(transactions, pageable, transactions.size());
        return new ModelAndView("list", "transactionList",transactionService.findByName(name, pageable));
    }
}
