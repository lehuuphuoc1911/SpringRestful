package com.App.RestfulApp.Service;

import com.App.RestfulApp.Entity.Book;
import com.App.RestfulApp.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public  BookService(){}

    public List<Book> getAllBooks(){
        List<Book> list = new ArrayList<>();

        for (Book book : bookRepository.findAll()
                ) {
            list.add(book);
        }

        return list;
    }

    public List<Book> findBookWhereTitleContain(String keyWord){
        return bookRepository.findBookWhereTitleContain("%"+keyWord+"%");
    }

    public List<Book> findBookWhereReleasedYearEqual(int keyWord){
        return bookRepository.findBookWhereReleasedYearEqual(keyWord);
    }

    public List<Book> findBookWhereAuthorIs(String keyWord){
        return bookRepository.findBookWhereAuthorIs(keyWord);
    }

}
