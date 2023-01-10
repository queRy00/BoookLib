package com.memrevatan.booklib.dataAccess;

import com.memrevatan.booklib.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    Author findByName(String name);
}
