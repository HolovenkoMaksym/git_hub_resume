package com.holovenko.githubresume.mediatype;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

public interface MediaTypeResolverStrategy {

    /**
     * Returns response entity of particular media type from Java Object
     *
     * @param body - java object
     * @return response entity of particular media type
     * @param <T> - type of object to be returned in body of response entity
     */
    <T> ResponseEntity<T> getMediaTypeBasedResponse(T body);

    /**
     * Media type for particular strategy
     *
     * @return - media type
     */
    MediaType mediaType();
}
