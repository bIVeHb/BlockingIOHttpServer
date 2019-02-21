package ru.biv.httpserver.io.impl;

import ru.biv.httpserver.io.config.HttpResponseBuilder;
import ru.biv.httpserver.io.config.HttpServerConfig;
import ru.biv.httpserver.io.config.ReadableHttpResponse;
import ru.biv.httpserver.io.utils.DataUtils;

import java.util.Date;
import java.util.Map;

class DefaultHttpResponseBuilder extends AbstractHttpConfigurableComponent implements HttpResponseBuilder {

    DefaultHttpResponseBuilder(HttpServerConfig httpServerConfig) {
        super(httpServerConfig);
    }

    protected ReadableHttpResponse createReadableHttpResponseInstance(){
        return new DefaultReadableHttpResponse();
    }

    @Override
    public ReadableHttpResponse buildNewHttpResponse() {
        ReadableHttpResponse response = createReadableHttpResponseInstance();
        response.setHeader("Date", new Date());
        response.setHeader("Server", httpServerConfig.getServerInfo().getName());
        response.setHeader("Content-Language", "en");
        response.setHeader("Connection", "close");
        response.setHeader("Content-Type", "text/html");// default content type
        return response;
    }

    @Override
    public void prepareHttpResponse(ReadableHttpResponse response, boolean clearBody) {
        if (response.getStatus() >= 400 && response.isBodyEmpty()) {
            setDefaultResponseErrorBody(response);
        }
        setContentLength(response);
        if (clearBody) {
            clearBody(response);
        }
    }

    protected void setDefaultResponseErrorBody(ReadableHttpResponse response) {
        Map<String, Object> args = DataUtils.buildMap(new Object[][] {
                { "STATUS-CODE", response.getStatus() },
                { "STATUS-MESSAGE", httpServerConfig.getStatusMessage(response.getStatus()) }
        });
        String content = httpServerConfig.getHttpServerContext().getHtmlTemplateManager().processTemplate("error.html", args);
        response.setBody(content);
    }

    protected void setContentLength(ReadableHttpResponse response) {
        response.setHeader("Content-Length", response.getBodyLength());
    }

    protected void clearBody(ReadableHttpResponse response) {
        response.setBody("");
    }
}
