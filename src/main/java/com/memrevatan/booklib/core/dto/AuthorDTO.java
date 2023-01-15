package com.memrevatan.booklib.core.dto;

import com.memrevatan.booklib.core.Unique;
import com.memrevatan.booklib.entities.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDTO {

    private long id;
    @NotNull(message = "The name cannot be null.")
    @Unique
    @NotEmpty(message = "The name cannot be empty")
    private String name;

    @NotNull(message = "The age cannot be null.")
    @NotEmpty(message = "The age cannot be empty")
    private String age;

    @NotNull(message = "The gender cannot be null.")
    private Gender gender;

    @NotNull(message = "The country cannot be null.")
    @NotEmpty(message = "The country cannot be empty")
    private String country;
}
