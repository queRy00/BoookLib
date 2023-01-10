package com.memrevatan.booklib.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.context.annotation.Bean;

@Data
@AllArgsConstructor
public class Response<E> {

    private boolean isSuccess;
    private String message;
    private E body;

    public static <E> Response successResponse(E body, String message) {
        return new Response<E>(true, message, body);
    }

    public static <E> Response errorResponse(String message) {
        return new Response<E>(false, message, null);
    }
}
