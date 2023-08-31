package com.holovenko.githubresume.http.validator;

import com.holovenko.githubresume.http.exception.InvalidApiResponseException;
import org.springframework.http.ResponseEntity;


public class ResponseEntityBodyValidator extends ResponseEntityBaseValidator {

    public static final String INVALID_RESPONSE_BODY_MESSAGE = "Invalid response body: null or empty.";

    @Override
    public void validate(final ResponseEntity<?> responseEntity) {
        if (responseEntity.getBody() == null || responseEntity.getBody().toString().isBlank()) {
            throw new InvalidApiResponseException(INVALID_RESPONSE_BODY_MESSAGE);
        }

        handleNext(responseEntity);
    }
}
