package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.IBlogService;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public ModelAndView home(@PageableDefault(value = 5, sort = "dayCreate" , direction = Sort.Direction.ASC) Pageable pageable){
//        return new ModelAndView("home", "blogList", blogService.findAll(pageable));
        Page<Blog> blogs = blogService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("blogHtml/home");
        modelAndView.addObject("blogList", blogs);
        modelAndView.addObject("category", categoryService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("blogHtml/create");
        modelAndView.addObject("blog", new Blog());
        modelAndView.addObject("category", categoryService.findAll());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blog.setDayCreate(new Date(System.currentTimeMillis()));
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "thêm mới blog thành công!");
//        ModelAndView modelAndView = new ModelAndView("blogHtml/home");
//        Page<Blog> blogs = blogService.findAll(pageable);
//        modelAndView.addObject("blogList", blogs);
//        modelAndView.addObject("message", "Thêm mới Blog thành công!");
        return "redirect:/blog";
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showEdit(@PathVariable int id) {
        Blog blog = blogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("blogHtml/edit");
        modelAndView.addObject("blog", blog);
        modelAndView.addObject("category", categoryService.findAll());
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
        ModelAndView modelAndView = new ModelAndView("blogHtml/delete");
        modelAndView.addObject("blog", blog);
        modelAndView.addObject("category", categoryService.findAll());
        return modelAndView;
    }

    @PostMapping("delete")
    public String delete(Blog blog, RedirectAttributes redirectAttributes) {
        blogService.remove(blog.getId());
        redirectAttributes.addFlashAttribute("message", "Xóa blog thành công!");
        return "redirect:/blog";
    }

    @GetMapping("/{id}/view")
    public ModelAndView view(@PathVariable int id) {
        Blog blog = blogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("blogHtml/view");
        modelAndView.addObject("blog", blog);
        modelAndView.addObject("category", categoryService.findAll());
        return modelAndView;
    }
}
