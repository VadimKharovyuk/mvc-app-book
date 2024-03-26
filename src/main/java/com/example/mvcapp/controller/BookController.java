package com.example.mvcapp.controller;

import com.example.mvcapp.model.Book;
import com.example.mvcapp.service.BookService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService ;
    @GetMapping
    public String getBookPage(@RequestParam (required = false ,name = "login") String login ,
                              @RequestParam (required = false ) String email ,
                              Model model){
        model.addAttribute("userLogin" ,login);

        List<Book>  books=bookService.getAllBooksByLogin(login);
        model.addAttribute("userBook",books);


        return "book_page";

    }
}
