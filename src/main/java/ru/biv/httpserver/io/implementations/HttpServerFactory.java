package ru.biv.httpserver.io.implementations;

import ru.biv.httpserver.io.HttpServer;

import java.util.Properties;

public class HttpServerFactory {

    protected HttpServerFactory() {
    }

    public static HttpServerFactory create(){
        return new HttpServerFactory();
    }

    public HttpServer createHttpServer(Properties ovveridesServerProperties) {
        return new HttpServer() {

            @Override
            public void start() {

            }

            @Override
            public void stop() {

            }
        };
    }
}
