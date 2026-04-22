package tv.danmaku.bili.update.internal.exception;

public class UpdateError extends Exception {
    public final int code;

    public UpdateError(int code) {
        this.code = code;
    }

    public UpdateError(String message, int code) {
        super(message);
        this.code = code;
    }

    public UpdateError(String message, Throwable cause, int code) {
        super(message, cause);
        this.code = code;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "UpdateError{code=" + this.code + '}';
    }
}