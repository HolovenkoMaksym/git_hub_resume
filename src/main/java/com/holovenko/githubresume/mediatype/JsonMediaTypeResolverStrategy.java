package com.holovenko.githubresume.mediatype;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class JsonMediaTypeResolverStrategy implements MediaTypeResolverStrategy {

    @Override
    public <T> ResponseEntity<T> getMediaTypeBasedResponse(T body) {
        return ResponseEntity.ok()
                             .contentType(MediaType.APPLICATION_JSON)
                             .body(body);
    }

    @Override
    public MediaType mediaType() {
        return MediaType.APPLICATION_JSON;
    }
}
