package tv.danmaku.bili.provider;

public class ProviderNotFoundException extends RuntimeException {
    public ProviderNotFoundException() {
    }

    public ProviderNotFoundException(String detailMessage) {
        super(detailMessage);
    }

    public ProviderNotFoundException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    public ProviderNotFoundException(Throwable throwable) {
        super(throwable);
    }
}