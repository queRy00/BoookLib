package com.memrevatan.booklib.core;

import com.memrevatan.booklib.dataAccess.AuthorRepository;
import com.memrevatan.booklib.dataAccess.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class UniqueValidator implements ConstraintValidator<Unique, String> {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        var authValid = authorRepository.findByName(value);
        if(authValid != null) {
            return false;
        }

        var bookValid = bookRepository.findByName(value);
        if(bookValid != null) {
            return false;
        }
        return true;
    }
}
