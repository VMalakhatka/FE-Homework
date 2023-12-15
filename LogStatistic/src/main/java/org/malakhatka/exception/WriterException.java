package org.malakhatka.exception;

public class WriterException extends RuntimeException {
    public WriterException(String message) {
        super(message);
    }

    public WriterException(String message, Throwable cause) {
        super(message, cause);
    }
}
