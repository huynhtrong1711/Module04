package com.codegym.controller;

import com.codegym.model.Book;
import com.codegym.model.CodeBorrowed;
import com.codegym.service.IBookService;
import com.codegym.service.ICodeBorrowedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private IBookService bookService;

    @Autowired
    private ICodeBorrowedService codeBorrowedService;

    @GetMapping("/list")
    public ModelAndView showList(@PageableDefault(value = 5, sort = "nameBook", direction = Sort.Direction.ASC)Pageable pageable) {
        Page<Book> books = bookService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("books", books);
        return modelAndView;
    }

    @GetMapping("/home")
    public ModelAndView showHome(@PageableDefault(value = 5, sort = "nameBook", direction = Sort.Direction.ASC)Pageable pageable) {
        Page<Book> books = bookService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("home");
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

    @GetMapping("/borrow/{id}")
    private String showBorrow(@PathVariable int id, Model model) {
        Book book = bookService.findById(id);
        int numberOfBook = book.getNumberOfBooks();
        book.setNumberOfBooks(numberOfBook - 1);
        bookService.save(book);
        int code = (int) Math.floor((Math.random()*89999) + 10000);
        String codeRandom = String.valueOf(code);
        model.addAttribute("code", codeRandom);
        CodeBorrowed codeBorrowed = new CodeBorrowed();
        codeBorrowed.setCodeBorrow(codeRandom);
        codeBorrowed.setBook(book);
        codeBorrowedService.save(codeBorrowed);
        return "borrow";
    }

    @GetMapping("/{id}/return")
    public ModelAndView showReturn() {
       return new ModelAndView("return", "codeBorrow", new CodeBorrowed());
    }

    @PostMapping("/return")
    public String returnBook(@RequestParam String codeBorrow, RedirectAttributes redirectAttributes) {
        CodeBorrowed codeBorrowed = codeBorrowedService.findByCode(codeBorrow);
        Book book = bookService.findById(codeBorrowed.getBook().getId());
        book.setNumberOfBooks(book.getNumberOfBooks() + 1);
        bookService.save(book);
        codeBorrowedService.remove(codeBorrowed.getId());
        redirectAttributes.addFlashAttribute("message", "Trả sách thành công!");
        return "redirect:/book/home";
    }
}
