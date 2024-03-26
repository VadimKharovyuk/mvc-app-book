package com.example.mvcapp.service;

import com.example.mvcapp.model.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private static List<Book> books ;
    static {
        books = new ArrayList<>();
        books.add(new Book("Vadim" ,1925));
        books.add(new Book("Alex" ,1960));
        books.add(new Book("Nika" ,1951));
    }

    public List<Book> getAllBooksByLogin (String login){
        if (login!=null){
            return books;
        }
        return books.stream()
                .filter(book -> book.getYear()>1900)
                .toList();
    }
}
