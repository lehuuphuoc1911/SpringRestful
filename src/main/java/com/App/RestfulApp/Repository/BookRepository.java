package com.App.RestfulApp.Repository;

import com.App.RestfulApp.Entity.Book;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Integer> {

    @Query(value = "SELECT * FROM books WHERE title like \"%\\n-- #keyWord\\n%\";", nativeQuery = true)
    List<Book> findBookTitleContain(String keyWord);
}
