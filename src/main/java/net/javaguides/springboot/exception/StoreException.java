package net.javaguides.springboot.exception;

public class StoreException extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = -7167911525072088390L;

    public StoreException(String exMessage, Exception exception) {
        super(exMessage, exception);
    }

    public StoreException(String exMessage) {
        super(exMessage);
    }
}
