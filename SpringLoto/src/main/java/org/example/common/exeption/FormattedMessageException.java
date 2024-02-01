package org.example.common.exeption;

public class FormattedMessageException extends RuntimeException {

    public FormattedMessageException(String message) {
        super(message);
    }

    public FormattedMessageException(String message, Object... args) {
        super(String.format(message, args));
    }

    public FormattedMessageException(String message, Throwable cause) {
        super(message, cause);
    }

    public FormattedMessageException(String message, Throwable cause, Object... args) {
        super(String.format(message, args), cause);
    }

    public FormattedMessageException(Throwable cause) {
        super(cause);
    }
}
