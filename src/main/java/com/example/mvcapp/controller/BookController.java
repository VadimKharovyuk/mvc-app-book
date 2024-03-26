package com.example.mvcapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/books")
public class BookController {
    @GetMapping
    public String getBookPage(@RequestParam (required = false ,name = "login") String login ,
                              @RequestParam (required = false ) String email ,
                              Model model){
        model.addAttribute("userLogin" ,login);


        return "book_page";

    }
}
