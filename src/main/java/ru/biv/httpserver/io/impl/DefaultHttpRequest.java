package ru.biv.httpserver.io.impl;

import ru.biv.httpserver.io.HttpRequest;

import java.util.Collections;
import java.util.Map;

public class DefaultHttpRequest implements HttpRequest {

    private final String method;
    private final String url;
    private final String httpVersion;
    private final String remoteAddress;
    private final Map<String, String> headers;
    private final Map<String, String> parameters;

    public DefaultHttpRequest(String method, String url, String httpVersion, String remoteAddress, Map<String, String> headers, Map<String, String> parameters) {
        this.method = method;
        this.url = url;
        this.httpVersion = httpVersion;
        this.remoteAddress = remoteAddress;
        this.headers = Collections.unmodifiableMap(headers);
        this.parameters = Collections.unmodifiableMap(parameters);
    }

    @Override
    public String getStartingLine() {
        return String.format("%s %s $s", getMethod(), getUri(), getHttpVersion());
    }

    @Override
    public String getMethod() {
        return method;
    }

    @Override
    public String getUri() {
        return url;
    }

    @Override
    public String getHttpVersion() {
        return httpVersion;
    }

    @Override
    public String getRemoteAddress() {
        return remoteAddress;
    }

    @Override
    public Map<String, String> getHeaders() {
        return headers;
    }

    @Override
    public Map<String, String> getParameters() {
        return parameters;
    }
}
