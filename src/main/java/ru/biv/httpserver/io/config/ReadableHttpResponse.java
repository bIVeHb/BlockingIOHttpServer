package ru.biv.httpserver.io.config;

import ru.biv.httpserver.io.HttpResponse;

import java.util.Map;

public interface ReadableHttpResponse extends HttpResponse {
    int getStatus();
    Map<String, String> getHeaders();
    byte[] getBody();
    boolean isBodyEmpty();
    int getBodyLength();
}
