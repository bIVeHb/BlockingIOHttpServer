package ru.biv.httpserver.io.impl;

import ru.biv.httpserver.io.config.HttpServerConfig;

public class AbstractHttpConfigurableComponent {
    final HttpServerConfig httpServerConfig;

    AbstractHttpConfigurableComponent(HttpServerConfig httpServerConfig) {
        super();
        this.httpServerConfig = httpServerConfig;
    }
}
