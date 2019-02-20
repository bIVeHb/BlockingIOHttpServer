package ru.biv.httpserver.io.config;

import ru.biv.httpserver.io.HttpRequest;
import ru.biv.httpserver.io.exceptions.HttpServerException;

import java.io.IOException;
import java.io.InputStream;

public interface HttpRequestParser {

    HttpRequest parseHttpRequest(InputStream inputStream, String remoteAddress) throws IOException, HttpServerException;
}
