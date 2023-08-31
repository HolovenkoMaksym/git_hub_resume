package com.holovenko.githubresume.http.exception;

public class InvalidApiResponseException extends RuntimeException {

    public InvalidApiResponseException(String message) {
        super(message);
    }
}
