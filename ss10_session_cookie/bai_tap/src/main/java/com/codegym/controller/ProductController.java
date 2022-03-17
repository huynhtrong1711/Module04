package com.codegym.controller;

import com.codegym.model.Cart;
import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("productList", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Integer id, @ModelAttribute Cart cart, @RequestParam("action") String action) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error.404";
        }
        if (action.equals("show")) {
            cart.addProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        cart.addProduct(productOptional.get());
        return "redirect:/product/shop";
    }

    @GetMapping("/remove/{id}")
    public String removeCart(@PathVariable Integer id, @ModelAttribute Cart cart, @RequestParam("action") String action) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error.404";
        }
        if (action.equals("show")) {
            cart.remove(productOptional.get());
            return "redirect:/shopping-cart";
        }
        cart.addProduct(productOptional.get());
        return "redirect:/shop";
    }

    @GetMapping("/detail/{id}")
    public ModelAndView showDetail(@PathVariable Integer id) {
        Optional<Product> readDetail = productService.findById(id);
        return new ModelAndView("detail","readDetail",readDetail);
    }


}
