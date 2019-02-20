package ru.biv.httpserver.io.implementations;

import ru.biv.httpserver.io.config.HttpResponseBuilder;
import ru.biv.httpserver.io.config.ReadableHttpResponse;

public class DefaultHttpResponseBuilder implements HttpResponseBuilder {
    @Override
    public ReadableHttpResponse buildNewHttpResponse() {
        return null;
    }

    @Override
    public void prepareHttpResponse(ReadableHttpResponse response, boolean clearBody) {

    }
}
