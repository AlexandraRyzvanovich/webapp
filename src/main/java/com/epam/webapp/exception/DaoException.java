package com.epam.webapp.exception;

public class DaoException extends Exception {
    public DaoException(String message, Throwable cause) {
        super(message);
    }

    public DaoException(String message) {
    }
}
