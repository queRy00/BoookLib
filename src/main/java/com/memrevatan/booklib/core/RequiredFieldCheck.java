package com.memrevatan.booklib.core;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RequiredFieldCheck implements ConstraintValidator<RequiredField, Long> {

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        return value != 0;
    }
}
