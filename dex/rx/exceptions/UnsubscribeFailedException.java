package rx.exceptions;

public final class UnsubscribeFailedException extends RuntimeException {
    private static final long serialVersionUID = 4594672310593167598L;

    public UnsubscribeFailedException(Throwable throwable) {
        super(throwable != null ? throwable : new NullPointerException());
    }

    public UnsubscribeFailedException(String message, Throwable throwable) {
        super(message, throwable != null ? throwable : new NullPointerException());
    }
}