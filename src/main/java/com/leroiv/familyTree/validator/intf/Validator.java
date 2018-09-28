package com.leroiv.familyTree.validator.intf;

import org.springframework.validation.Errors;

public interface Validator {
    boolean supports(Class<?> aClass);

    void validate(Object o, Errors errors);
}
