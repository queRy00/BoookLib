package com.memrevatan.booklib.business;

import com.memrevatan.booklib.core.Response;
import com.memrevatan.booklib.core.dto.AuthorDTO;
import com.memrevatan.booklib.core.dto.BookDTO;

import java.util.List;

public interface LibraryService {

    Response<AuthorDTO> addAuthor(AuthorDTO author);
    Response<BookDTO> addBook(BookDTO book);
    Response<List<BookDTO>> searchBooks(String criteria);

    Response<List<AuthorDTO>> getAllAuthor();

}
