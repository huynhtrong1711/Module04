package com.codegym.bai_tap_1.controller;

import com.codegym.bai_tap_1.model.Blog;
import com.codegym.bai_tap_1.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public ModelAndView home(){
        return new ModelAndView("home", "blogList", blogService.findAll());
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("blog", new Blog());
        return "create";
    }

    @PostMapping("/save")
    public ModelAndView save(Blog blog) {
        blog.setDayCreate(new Date(System.currentTimeMillis()));
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("home");
        List<Blog> blogs = blogService.findAll();
        modelAndView.addObject("blogList", blogs);
        modelAndView.addObject("message", "Thêm mới Blog thành công!");
        return modelAndView;
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showEdit(@PathVariable int id) {
        Blog blog = blogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("blog", blog);
        return modelAndView;
    }

    @PostMapping("edit")
    public String update(Blog blog, RedirectAttributes redirectAttributes){
        blog.setDayCreate(new Date(System.currentTimeMillis()));
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "chỉnh sửa blog thành công");
        return "redirect:/blog";
    }

    @GetMapping("/{id}/delete")
    public ModelAndView showDelete(@PathVariable int id) {
        Blog blog = blogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("delete");
        modelAndView.addObject("blog", blog);
        return modelAndView;
    }

    @PostMapping("delete")
    public String delete(Blog blog, RedirectAttributes redirectAttributes) {
        blogService.remove(blog.getId());
        redirectAttributes.addFlashAttribute("message", "Xóa blog thành công!");
        return "redirect:/blog";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "/view";
    }
}
