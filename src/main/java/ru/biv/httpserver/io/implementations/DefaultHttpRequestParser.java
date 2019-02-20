package ru.biv.httpserver.io.implementations;

import ru.biv.httpserver.io.HttpRequest;
import ru.biv.httpserver.io.config.HttpRequestParser;
import ru.biv.httpserver.io.exceptions.HttpServerException;

import java.io.IOException;
import java.io.InputStream;

public class DefaultHttpRequestParser implements HttpRequestParser {
    @Override
    public HttpRequest parseHttpRequest(InputStream inputStream, String remoteAddress) throws IOException, HttpServerException {
        return null;
    }
}
