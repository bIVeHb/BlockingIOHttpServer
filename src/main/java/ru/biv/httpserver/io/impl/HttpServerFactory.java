package ru.biv.httpserver.io.impl;

import ru.biv.httpserver.io.HandlerConfig;
import ru.biv.httpserver.io.HttpServer;
import ru.biv.httpserver.io.config.HttpServerConfig;

import java.util.Properties;

public class HttpServerFactory {
    protected HttpServerFactory(){

    }

    public static HttpServerFactory create() {
        return new HttpServerFactory();
    }

    public HttpServer createHttpServer(HandlerConfig handlerConfig, Properties overrideServerProperties) {
        HttpServerConfig httpServerConfig = new DefaultHttpServerConfig(handlerConfig, overrideServerProperties);
        return new DefaultHttpServer(httpServerConfig);
    }
}
