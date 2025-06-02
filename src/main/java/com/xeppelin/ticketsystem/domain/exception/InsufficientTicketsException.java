package com.xeppelin.ticketsystem.domain.exception;

public class InsufficientTicketsException extends EventTicketException {

    public InsufficientTicketsException() {
    }

    public InsufficientTicketsException(String message) {
        super(message);
    }

    public InsufficientTicketsException(String message, Throwable cause) {
        super(message, cause);
    }

    public InsufficientTicketsException(Throwable cause) {
        super(cause);
    }

    public InsufficientTicketsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
} 