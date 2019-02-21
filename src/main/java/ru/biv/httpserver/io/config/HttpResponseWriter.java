package ru.biv.httpserver.io.config;

import java.io.IOException;
import java.io.OutputStream;

public interface HttpResponseWriter {
    void writeHttpResponse(OutputStream outputStream, ReadableHttpResponse response) throws IOException;
}
