package com.App.RestfulApp.Controller;

import com.App.RestfulApp.Entity.Book;
import com.App.RestfulApp.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {
    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/book/getAllBooks", method = RequestMethod.GET)
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }
    @RequestMapping(value = "/book/contain", method = RequestMethod.GET)
    public List<Book> findBookTitleContain(@RequestParam(required = true, name = "key") String keyWord){
        return bookService.findBookTitleContain(keyWord);

    }
}
