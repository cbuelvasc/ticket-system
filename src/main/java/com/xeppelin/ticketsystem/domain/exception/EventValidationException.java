package com.xeppelin.ticketsystem.domain.exception;

public class EventValidationException extends EventTicketException {

    public EventValidationException() {
    }

    public EventValidationException(String message) {
        super(message);
    }

    public EventValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public EventValidationException(Throwable cause) {
        super(cause);
    }

    public EventValidationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
} 