package com.memrevatan.booklib.business;

import com.memrevatan.booklib.core.Response;
import com.memrevatan.booklib.core.dto.AuthorDTO;
import com.memrevatan.booklib.core.dto.BookDTO;
import com.memrevatan.booklib.dataAccess.AuthorRepository;
import com.memrevatan.booklib.dataAccess.BookRepository;
import com.memrevatan.booklib.entities.Author;
import com.memrevatan.booklib.entities.Book;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LibraryManager implements LibraryService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final ModelMapper modelMapper = new ModelMapper();
    private final Logger logger = LoggerFactory.getLogger(LibraryManager.class);

    public LibraryManager(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public Response addAuthor(AuthorDTO author) {
        try {
            Optional<Author> findAuthorId = Optional.ofNullable(authorRepository.findByName(author.getName()));

            if (findAuthorId.isPresent()) {
                logger.warn("This author already exists.");
                return Response.errorResponse("This author already exists.");
            }
            Author newAuthor = authorRepository.save(modelMapper.map(author, Author.class));
            logger.info("Author saved to database!");
            return Response.successResponse(modelMapper.map(newAuthor, AuthorDTO.class)
                    , "Author saved.");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return Response.errorResponse(e.getMessage());
        }
    }

    @Override
    public Response addBook(BookDTO book) {
        try {
            Optional<Book> findBookId = Optional.ofNullable(bookRepository.findByName(book.getName()));
            if (findBookId.isPresent()) {
                logger.warn("This book already exists.");
                return Response.errorResponse("This book already exists.");
            }

            Book newBook = bookRepository.save(modelMapper.map(book, Book.class));
            logger.info("Book saved to database!");
            return Response.successResponse(modelMapper.map(newBook, BookDTO.class)
                    , "Book saved.");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return Response.errorResponse(e.getMessage());
        }
    }

    @Override
    public Response searchBooks(String criteria) {
        try {
            List<Book> criteriaList = bookRepository.findByKeyword(criteria);
            List<BookDTO> bookDTOList = new ArrayList<>();
            for (Book book : criteriaList) {
                bookDTOList.add(modelMapper.map(book, BookDTO.class));
            }
            logger.info("Books listed!");
            return Response.successResponse(bookDTOList, "Successfully");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return Response.errorResponse(e.getMessage());
        }
    }

    @Override
    public Response getAllAuthor() {
        try {
            List<Author> allAuthor = authorRepository.findAll();
            List<AuthorDTO> allAuthorDTO = new ArrayList<>();
            for (Author author : allAuthor) {
                allAuthorDTO.add(modelMapper.map(author, AuthorDTO.class));
            }
            logger.info("Author listed");
            return Response.successResponse(allAuthorDTO, "Successfully");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return Response.errorResponse(e.getMessage());
        }
    }

}
