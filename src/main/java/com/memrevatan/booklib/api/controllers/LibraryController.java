package com.memrevatan.booklib.api.controllers;

import com.memrevatan.booklib.business.LibraryService;
import com.memrevatan.booklib.core.Response;
import com.memrevatan.booklib.core.dto.AuthorDTO;
import com.memrevatan.booklib.core.dto.BookDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/1.0")
@CrossOrigin
public class LibraryController {

    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @PostMapping("/register/author")
    public ResponseEntity<Response<AuthorDTO>> addAuthor(@Valid @RequestBody AuthorDTO author) {
        Response<AuthorDTO> response = libraryService.addAuthor(author);
        return response.isSuccess() ? ResponseEntity.ok(response) : ResponseEntity.badRequest().body(response);
    }

    @PostMapping("/register/book")
    public ResponseEntity<Response<BookDTO>> addBook(@Valid @RequestBody BookDTO book) {
        Response<BookDTO> response = libraryService.addBook(book);
        return response.isSuccess() ? ResponseEntity.ok(response) : ResponseEntity.badRequest().body(response);
    }

    @GetMapping("/book/search")
    public ResponseEntity<Response<List<BookDTO>>> searchBooks(@RequestParam(value = "criteria") String criteria) {
        Response<List<BookDTO>> response = libraryService.searchBooks(criteria);
        return response.isSuccess() ? ResponseEntity.ok(response) : ResponseEntity.badRequest().body(response);
    }

    @GetMapping("/author")
    public ResponseEntity<Response<List<AuthorDTO>>> getAllAuthor() {
        Response<List<AuthorDTO>> response = libraryService.getAllAuthor();
        return response.isSuccess() ? ResponseEntity.ok(response) : ResponseEntity.badRequest().body(response);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Response handleValidationExceptions(MethodArgumentNotValidException ex) {
        try {
            Map<String, String> errors = new HashMap<>();
            ex.getBindingResult().getAllErrors().forEach((error) -> {
                String fieldName = ((FieldError) error).getField();
                String errorMessage = error.getDefaultMessage();
                errors.put(fieldName, errorMessage);
            });
            return Response.successResponse(errors, "Bad request");
        } catch (Error e) {
            return Response.errorResponse(e.getMessage());
        }

    }

}
