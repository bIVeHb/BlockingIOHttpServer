package ru.biv.httpserver.io.implementations;

import ru.biv.httpserver.io.HttpRequest;

import java.util.Map;

public class DefaultHttpRequest implements HttpRequest {
    @Override
    public String getStartingLine() {
        return null;
    }

    @Override
    public String getMethod() {
        return null;
    }

    @Override
    public String getUri() {
        return null;
    }

    @Override
    public String getHttpVersion() {
        return null;
    }

    @Override
    public String getRemoteAddress() {
        return null;
    }

    @Override
    public Map<String, String> getHeaders() {
        return null;
    }

    @Override
    public Map<String, String> getParameters() {
        return null;
    }
}
