package ru.biv.httpserver.io;

import ru.biv.httpserver.io.handler.HelloWorldHttpHandler;
import ru.biv.httpserver.io.handler.ServerInfoHttpHandler;
import ru.biv.httpserver.io.handler.TestJDBCHandler;
import ru.biv.httpserver.io.impl.HttpServerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ServiceWrapper {
    private static final HttpServer httpServer = createServer();

    private static HttpServer createServer() {
        HttpServerFactory httpServerFactory = HttpServerFactory.create();
        HandlerConfig handlerConfig = new HandlerConfig()
                .addHandler("/info", new ServerInfoHttpHandler())
                .addHandler("/jdbc", new TestJDBCHandler())
                .addHandler("/hello", new HelloWorldHttpHandler());
        return httpServerFactory.createHttpServer(handlerConfig, getServerProperties());
    }

    private static Properties getServerProperties(){
        Properties prop = new Properties();
        String pathToServerProperties = System.getProperty("server-prop");
        try(InputStream in = new FileInputStream(pathToServerProperties)) {
            prop.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

    public static void main(String[] args) {
        if ("start".equals(args[0])) {
            start(args);
        } else if ("stop".equals(args[0])) {
            stop(args);
        }
    }

    public static void start(String[] args) {
        httpServer.start();
    }

    public static void stop(String[] args) {
        httpServer.stop();
    }
}
