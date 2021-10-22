package com.App.RestfulApp.Repository;

import com.App.RestfulApp.Entity.Book;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Integer> {

    @Query(value = "SELECT * FROM books WHERE title like ?1 ;", nativeQuery = true)
    List<Book> findBookWhereTitleContain(String keyWord);

    @Query(value = "SELECT * FROM books WHERE released_year = ?1 ;", nativeQuery = true)
    List<Book> findBookWhereReleasedYearEqual(int keyWord);

    @Query(value = "SELECT * FROM books WHERE CONCAT_WS('_', author_fname, author_lname) = ?1 ;", nativeQuery = true)
    List<Book> findBookWhereAuthorIs(String keyWord);
}
