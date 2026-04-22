package tv.danmaku.bili.update.internal.exception;

public class ViewNotFoundException extends Exception {
    public ViewNotFoundException() {
    }

    public ViewNotFoundException(String message) {
        super(message);
    }

    public ViewNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}