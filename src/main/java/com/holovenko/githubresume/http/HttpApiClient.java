package com.holovenko.githubresume.http;

import java.util.Map;

/**
 * Utility class for http client operations.
 * It extracts HTTP client operation and adds additional layer of abstraction (model mapping).
 */
public interface HttpApiClient {

    /**
     * Fires HTTP GET request with particular parameters.
     *
     * @param url     - target URL
     * @param headers - headers for corresponding HTTP request
     * @param responseType   - type of response
     * @return response with appropriate data type
     */
    <T> T doGet(String url, Map<String, String> headers, Class<T> responseType);
}
