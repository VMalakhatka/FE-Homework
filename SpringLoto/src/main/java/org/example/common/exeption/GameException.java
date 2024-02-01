package org.example.common.exeption;

public class GameException extends FormattedMessageException {
    public GameException(Throwable cause) {
        super(cause);
    }

    public GameException(String message) {
        super(message);
    }

    public GameException(String message, Object... args) {
        super(message, args);
    }
}
