package ru.biv.httpserver.io.implementations;

import ru.biv.httpserver.io.config.HttpResponseWriter;
import ru.biv.httpserver.io.config.ReadableHttpResponse;

import java.io.IOException;
import java.io.OutputStream;

public class DefaultHttpResponseWriter implements HttpResponseWriter {
    @Override
    public void writtenHttpResponse(OutputStream outputStream, ReadableHttpResponse response) throws IOException {

    }
}
