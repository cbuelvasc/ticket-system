package com.xeppelin.ticketsystem.domain.exception;

public class UnauthorizedOperationException extends EventTicketException {

    public UnauthorizedOperationException() {
    }

    public UnauthorizedOperationException(String message) {
        super(message);
    }

    public UnauthorizedOperationException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnauthorizedOperationException(Throwable cause) {
        super(cause);
    }

    public UnauthorizedOperationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
} 