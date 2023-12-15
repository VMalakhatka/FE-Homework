package org.malakhatka.exception;

public class FileAccessorException extends RuntimeException {
    public FileAccessorException(String message) {
        super(message);
    }

    public FileAccessorException(String message, Throwable cause) {
        super(message, cause);
    }
}
