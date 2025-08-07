package org.bookscatalogue.bookscatalaogue.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException (
            String message
    ) {
        super(message);
    }
}
