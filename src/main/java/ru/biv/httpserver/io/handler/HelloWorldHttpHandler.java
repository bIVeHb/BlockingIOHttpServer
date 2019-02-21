package ru.biv.httpserver.io.handler;

import ru.biv.httpserver.io.HttpHandler;
import ru.biv.httpserver.io.HttpRequest;
import ru.biv.httpserver.io.HttpResponse;
import ru.biv.httpserver.io.HttpServerContext;

import java.io.IOException;

public class HelloWorldHttpHandler implements HttpHandler {

    @Override
    public void handle(HttpServerContext context, HttpRequest request, HttpResponse response) throws IOException {
        response.setBody("Hello world");
    }
}
