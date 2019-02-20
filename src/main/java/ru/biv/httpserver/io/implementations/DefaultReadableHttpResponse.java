package ru.biv.httpserver.io.implementations;

import ru.biv.httpserver.io.config.ReadableHttpResponse;

import java.io.InputStream;
import java.io.Reader;
import java.util.Map;

public class DefaultReadableHttpResponse implements ReadableHttpResponse{
    @Override
    public int getStatus() {
        return 0;
    }

    @Override
    public Map<String, String> getHeaders() {
        return null;
    }

    @Override
    public byte[] getBody() {
        return new byte[0];
    }

    @Override
    public boolean isBodyEmpty() {
        return false;
    }

    @Override
    public int getBodyLength() {
        return 0;
    }

    @Override
    public void setStatus(int status) {

    }

    @Override
    public void setHeader(String name, Object value) {

    }

    @Override
    public void setBody(String content) {

    }

    @Override
    public void setBody(InputStream inputStream) {

    }

    @Override
    public void setBody(Reader reader) {

    }
}
