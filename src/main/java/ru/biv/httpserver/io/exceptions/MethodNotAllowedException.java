package ru.biv.httpserver.io.exceptions;

import ru.biv.httpserver.io.Constants;

public class MethodNotAllowedException extends AbstractRequestParseFailedException {

    private static final long serialVersionUID = 1226345593185916605L;

    public MethodNotAllowedException(String method, String startingLine) {
        super("Only " + Constants.ALLOWED_METHODS + " are supported. Current method is " + method, startingLine);
        setStatusCode(405);
    }
}
