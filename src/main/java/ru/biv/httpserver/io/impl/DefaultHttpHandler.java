package ru.biv.httpserver.io.impl;

import org.apache.commons.io.FilenameUtils;
import ru.biv.httpserver.io.HttpHandler;
import ru.biv.httpserver.io.HttpRequest;
import ru.biv.httpserver.io.HttpResponse;
import ru.biv.httpserver.io.HttpServerContext;
import ru.biv.httpserver.io.utils.DataUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.*;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;

class DefaultHttpHandler implements HttpHandler {

    @Override
    public void handle(HttpServerContext context, HttpRequest request, HttpResponse response) throws IOException {
        String url = request.getUri();
        Path path = Paths.get(context.getRootPath().toString() + url);
        if (Files.exists(path)) {
            if (Files.isDirectory(path)) {
                handleDirectoryUrl(context, response, path);
            } else {
                handleFileUrl(context, response, path);
            }
        } else {
            response.setStatus(404);
        }
    }

    protected void handleDirectoryUrl(HttpServerContext context, HttpResponse response, Path path) throws IOException {
        String content = getResponseForDirectory(context, path);
        response.setBody(content);
    }

    protected void handleFileUrl(HttpServerContext context, HttpResponse response, Path path) throws IOException {
        setEntityHeaders(context, response, path);
        try (InputStream in = Files.newInputStream(path, StandardOpenOption.READ)) {
            response.setBody(in);
        }
    }

    protected void setEntityHeaders(HttpServerContext context, HttpResponse response, Path path) throws IOException {
        String extension = FilenameUtils.getExtension(path.toString());
        response.setHeader("Content-Type", context.getContentType(extension));
        response.setHeader("Last-Modified", Files.getLastModifiedTime(path, LinkOption.NOFOLLOW_LINKS));
        Integer expiresDays = context.getExpiresDaysForResource(extension);
        if(expiresDays != null) {
            response.setHeader("Expires", new Date(System.currentTimeMillis() + TimeUnit.DAYS.toMillis(expiresDays)));
        }
    }

    protected String getResponseForDirectory(HttpServerContext context, Path dir) throws IOException {
        String root = context.getRootPath().toString();
        StringBuilder htmlBody = new StringBuilder();
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(dir)) {
            for (Path path : directoryStream) {
                htmlBody.append("<a href=\"").append(getHref(root, path)).append("\">").append(path.getFileName()).append("</a><br>\r\n");
            }
        }
        Map<String, Object> args = DataUtils.buildMap(new Object[][] {
                { "TITLE",   "File list for " + dir.getFileName() },
                { "HEADER", "File list for " + dir.getFileName() },
                { "BODY", 	 htmlBody }
        });
        return context.getHtmlTemplateManager().processTemplate("simple.html", args);
    }

    private String getHref(String root, Path path) {
        return path.toString().replace(root, "").replace("\\", "/");
    }
}
