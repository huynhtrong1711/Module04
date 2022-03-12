package com.codegym.controller;

import com.codegym.model.Book;
import com.codegym.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private IBookService bookService;

    @GetMapping("/list")
    public ModelAndView showList(@PageableDefault(value = 5, sort = "nameBook", direction = Sort.Direction.ASC)Pageable pageable) {
        Page<Book> books = bookService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("books", books);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("book", new Book());
        return modelAndView;
    }

    @PostMapping("/save")
    public String createBook(@ModelAttribute Book book, RedirectAttributes redirectAttributes) {
        bookService.save(book);
        redirectAttributes.addFlashAttribute("books", "Thêm mới sách: " + book.getNameBook() + " thành công!");
        return "redirect:/book/list";
    }

}
