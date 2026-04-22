package im.direct.notification.interactive;

import kotlin.Metadata;

/* compiled from: INState.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lim/direct/notification/interactive/INHttpBusinessException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "statusCode", "", "errorMsg", "", "<init>", "(ILjava/lang/String;)V", "getStatusCode", "()I", "getErrorMsg", "()Ljava/lang/String;", "interactive_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class INHttpBusinessException extends Exception {
    private final String errorMsg;
    private final int statusCode;

    public INHttpBusinessException(int statusCode, String errorMsg) {
        super(errorMsg);
        this.statusCode = statusCode;
        this.errorMsg = errorMsg;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public final String getErrorMsg() {
        return this.errorMsg;
    }
}