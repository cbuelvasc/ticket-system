package com.xeppelin.ticketsystem.domain.exception;

public class EventDeletionException extends EventTicketException {

    public EventDeletionException() {
    }

    public EventDeletionException(String message) {
        super(message);
    }

    public EventDeletionException(String message, Throwable cause) {
        super(message, cause);
    }

    public EventDeletionException(Throwable cause) {
        super(cause);
    }

    public EventDeletionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
} 