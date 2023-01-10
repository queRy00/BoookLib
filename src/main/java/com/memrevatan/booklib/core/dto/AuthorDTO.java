package com.memrevatan.booklib.core.dto;

import com.memrevatan.booklib.entities.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDTO {

    private long id;
    private String name;
    private String age;
    private Gender gender;
    private String country;
}
