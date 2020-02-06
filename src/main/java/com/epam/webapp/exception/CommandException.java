package com.epam.webapp.exception;

public class CommandException extends Exception {
    public CommandException(String message, Throwable cause) {
        super(message);
    }
}
