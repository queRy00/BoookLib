package com.memrevatan.booklib.core.dto;

import com.memrevatan.booklib.core.RequiredField;
import com.memrevatan.booklib.core.Unique;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {

    private long id;

    @NotNull(message = "The name cannot be null.")
    @Unique
    @NotEmpty(message = "The name cannot be empty")
    private String name;

    @NotNull(message = "The isbn cannot be null.")
    @RequiredField
    private long isbn;

    @NotNull(message = "The category cannot be null.")
    @NotEmpty(message = "The category cannot be empty.")
    private String category;

    @NotNull(message = "The book cannot be null.")
    @RequiredField
    private long authorId;

}
