package com.holovenko.githubresume.http.validator;

import com.holovenko.githubresume.http.exception.InvalidApiResponseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseEntityCodeValidator extends ResponseEntityBaseValidator {

    private static final String INVALID_RESPONSE_CODE_MESSAGE = "Status code from request is invalid. Expected '200'. Actual '%s'";

    @Override
    public void validate(ResponseEntity<?> responseEntity) {
        if (responseEntity.getStatusCode() != HttpStatus.OK) {
            throw new InvalidApiResponseException(INVALID_RESPONSE_CODE_MESSAGE.formatted(responseEntity.getStatusCode()));
        }

        handleNext(responseEntity);
    }
}
