package ru.biv.httpserver.io;

import java.io.InputStream;
import java.io.Reader;

public interface HttpResponse {
    void setStatus(int status);

    void setHeader(String name, Object value);

    void setBody(String content);

    void setBody(InputStream inputStream);

    void setBody(Reader reader);
}
