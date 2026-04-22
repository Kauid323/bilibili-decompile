package tv.danmaku.bili.provider;

import android.net.Uri;

public class ProviderOperationsException extends RuntimeException {
    public ProviderOperationsException(String op, Uri uri, Throwable cause) {
        this("Error occurred while doing operation '" + op + "' on uri " + uri, cause);
    }

    public ProviderOperationsException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    public ProviderOperationsException(Throwable throwable) {
        super(throwable);
    }
}