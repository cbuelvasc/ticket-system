package com.xeppelin.ticketsystem.domain.exception;

public class ReservationExpiredException extends EventTicketException {

    public ReservationExpiredException() {
    }

    public ReservationExpiredException(String message) {
        super(message);
    }

    public ReservationExpiredException(String message, Throwable cause) {
        super(message, cause);
    }

    public ReservationExpiredException(Throwable cause) {
        super(cause);
    }

    public ReservationExpiredException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
} 