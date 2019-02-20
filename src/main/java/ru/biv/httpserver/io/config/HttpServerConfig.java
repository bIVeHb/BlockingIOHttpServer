package ru.biv.httpserver.io.config;

import ru.biv.httpserver.io.HttpServerContext;
import ru.biv.httpserver.io.ServerInfo;

import java.net.Socket;
import java.util.concurrent.ThreadFactory;

public interface HttpServerConfig {
    ServerInfo getServerInfo();

    String getStatusMessage(int statusCode);

    HttpRequestParser getHttpRequestParser();

    HttpResponseBuilder getHttpResponseBuilder();

    HttpResponseWriter getHttpResponseWriter();

    HttpServerContext getHttpServerContext();

    HttpRequestDispatcher getHttpRequestDispatcher();

    ThreadFactory getWorkerThreadFactory();

    HttpClientSocketHandler buildNewHttpClientSocketHandler(Socket clientSocket);
}
