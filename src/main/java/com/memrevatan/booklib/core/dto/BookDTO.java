package com.memrevatan.booklib.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {

    private long id;
    private String name;
    private long isbn;
    private String category;
    private long authorId;

}
