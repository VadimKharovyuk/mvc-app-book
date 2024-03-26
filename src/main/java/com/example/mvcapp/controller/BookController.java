package com.example.mvcapp.controller;

import com.example.mvcapp.model.Book;
import com.example.mvcapp.service.BookService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService ;
    @GetMapping
    public String getBookPage(@RequestParam (required = false ,name = "login") String login ,
                              @RequestParam (required = false ) String email ,
                              Model model, HttpServletRequest request){
        HttpSession session =request.getSession();
        if (login!=null && !login.isEmpty()){
            session.setAttribute("userLogin",login);
        }
        String userLogin = (String) session.getAttribute("userLogin");

        model.addAttribute("userLogin" ,userLogin);

        List<Book>  books=bookService.getAllBooksByLogin(login);
        model.addAttribute("userBook",books);


        return "book_page";

    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("newBook",new Book());
        return "createBook";
    }

    @PostMapping("/createBook")
    public String saveBook(@ModelAttribute Book book){
        bookService.save(book);
        return "redirect:/books";
    }
}
