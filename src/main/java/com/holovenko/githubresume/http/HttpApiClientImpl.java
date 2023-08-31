package com.holovenko.githubresume.http;

import com.holovenko.githubresume.http.exception.ApiResourceNotFoundException;
import com.holovenko.githubresume.http.validator.ResponseEntityValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.function.Supplier;


@Component
@RequiredArgsConstructor
public class HttpApiClientImpl implements HttpApiClient {

    private static final String COULD_NOT_FIND_RESOURCE = "Couldn't find resource, URL - %s";

    private final RestTemplate restTemplate;
    private final ResponseEntityValidator responseEntityValidator;

    @Override
    public <T> T doGet(String url, Map<String, String> headers, Class<T> responseType) {
        final HttpEntity<?> entity = prepareHttpEntity(headers, null);

        return doHttpCall(url, () -> restTemplate.exchange(url, HttpMethod.GET, entity, responseType));
    }

    private <T> T doHttpCall(final String url, final Supplier<ResponseEntity<T>> clientResponseSupplier) {
        try {
            final ResponseEntity<T> response = clientResponseSupplier.get();
            responseEntityValidator.validate(response);

            return response.getBody();
        } catch (final HttpClientErrorException.NotFound e) {
            throw new ApiResourceNotFoundException(COULD_NOT_FIND_RESOURCE.formatted(url));
        }
    }

    private HttpEntity<?> prepareHttpEntity(final Map<String, String> headers, final Object body) {
        final var httpHeaders = new HttpHeaders();
        httpHeaders.setAll(headers);

        return new HttpEntity<>(body, httpHeaders);
    }
}
