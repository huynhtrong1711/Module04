package com.codegym.controller;

import com.codegym.model.Category;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/home")
    public ModelAndView home() {
        return new ModelAndView("categoryHtml/home","categoryList", categoryService.findAll());
    }

    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("categoryHtml/create");
        modelAndView.addObject("categoryList", new Category());
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Category category, RedirectAttributes redirectAttributes) {
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("message", "Thêm mới category thành công!");
        return "redirect:/category/home";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEdit(@PathVariable int id) {
        Category category = categoryService.findById(id);
        ModelAndView modelAndView = new ModelAndView("categoryHtml/edit");
        modelAndView.addObject("categoryList", category);
        return modelAndView;
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Category category, RedirectAttributes redirectAttributes) {
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("message", "Chỉnh sửa category thành công!");
        return "redirect:/category/home";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDelete(@PathVariable int id) {
        Category category = categoryService.findById(id);
        ModelAndView modelAndView = new ModelAndView("categoryHtml/delete");
        modelAndView.addObject("categoryList", category);
        return modelAndView;
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute Category category, RedirectAttributes redirectAttributes) {
        categoryService.remove(category.getId());
        redirectAttributes.addFlashAttribute("message", "Xóa category thành công!");
        return "redirect:/category/home";
    }
}
