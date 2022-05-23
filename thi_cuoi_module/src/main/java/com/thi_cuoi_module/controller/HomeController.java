package com.thi_cuoi_module.controller;

import com.thi_cuoi_module.dto.ProductDto;
import com.thi_cuoi_module.model.Product;
import com.thi_cuoi_module.service.IProductService;
import com.thi_cuoi_module.service.IProductTypeService;
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

import javax.validation.constraints.Pattern;

@Controller
@RequestMapping("/product")
public class HomeController {


    @Autowired
    private IProductService productService;

    @Autowired
    private IProductTypeService productTypeService;

    @GetMapping
    public ModelAndView home(@PageableDefault(value = 5) Pageable pageable) {
        Page<Product> products = productService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("productList", products);
        modelAndView.addObject("productType", productTypeService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("productDto",new ProductDto());
        modelAndView.addObject("productType", productTypeService.findAll());
        return modelAndView;
    }

    @PostMapping("/save")
    public String create(@Validated @ModelAttribute ProductDto productDto, BindingResult bindingResult, Model model) {
        Product product = new Product();
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("productType", productTypeService.findAll());
            return "create";
        } else {
            BeanUtils.copyProperties(productDto, product);
            productService.save(product);
            model.addAttribute("message", "Thêm mới sản phẩm thành công!");
            return "redirect:/product";
        }
    }

    @PostMapping("/delete")
    public String deleteProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.remove(product.getIdProduct());
        redirectAttributes.addFlashAttribute("message", "Xóa sản phẩm thành công!");
        return "redirect:/product";
    }

    @GetMapping("/search")
    public String searchByName(@RequestParam(name = "name", required = false) String name, Model model,
                               @PageableDefault(value = 5) Pageable pageable) {
        model.addAttribute("productList",productService.findByName(name, pageable));
        return "/list";
    }

}
