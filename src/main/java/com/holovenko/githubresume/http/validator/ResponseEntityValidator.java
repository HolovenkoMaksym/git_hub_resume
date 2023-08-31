package com.holovenko.githubresume.http.validator;

import org.springframework.http.ResponseEntity;

public interface ResponseEntityValidator {

    /**
     * Binds next handler for current one.
     *
     * @param next - next handler to be called for validation
     */
    void setNext(ResponseEntityValidator next);

    /**
     * Performs some specific validations on provided response instance.
     *
     * @param responseEntity - target response instance
     */
    void validate(ResponseEntity<?> responseEntity);
}
