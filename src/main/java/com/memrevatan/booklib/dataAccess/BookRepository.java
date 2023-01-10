package com.memrevatan.booklib.dataAccess;

import com.memrevatan.booklib.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    Book findByName(String name);
    @Query("FROM Book b INNER JOIN Author a ON b.author.id = a.id " +
            "WHERE b.category = :keyword OR b.author.name = :keyword OR b.name = :keyword OR b.isbn = :keyword")
    List<Book> findByKeyword(String keyword);

}
