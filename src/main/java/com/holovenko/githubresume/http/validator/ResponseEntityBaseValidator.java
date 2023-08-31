package com.holovenko.githubresume.http.validator;

import org.springframework.http.ResponseEntity;

public abstract class ResponseEntityBaseValidator implements ResponseEntityValidator {

    private ResponseEntityValidator next;

    @Override
    public void setNext(ResponseEntityValidator validator) {
        if (next == null) {
            next = validator;
        } else {
            next.setNext(validator);
        }
    }

    protected void handleNext(ResponseEntity<?> response) {
        if (next != null) {
            next.validate(response);
        }
    }
}
