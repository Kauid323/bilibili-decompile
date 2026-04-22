package video.biz.offline.base.model.error;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ErrorCode.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0005J\u000e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lvideo/biz/offline/base/model/error/OfflineError;", "", "<init>", "()V", "TYPE_BITS", "", "NUMBER_MASK", "generateErrorCode", "errorType", "Lvideo/biz/offline/base/model/error/OfflineErrorType;", "errorNumber", "Lvideo/biz/offline/base/model/error/OfflineErrorCode;", "getErrorType", "errorCode", "getErrorNumber", "model_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OfflineError {
    public static final int $stable = 0;
    public static final OfflineError INSTANCE = new OfflineError();
    private static final int NUMBER_MASK = 1048575;
    private static final int TYPE_BITS = 20;

    private OfflineError() {
    }

    public final int generateErrorCode(OfflineErrorType errorType, OfflineErrorCode errorNumber) {
        Intrinsics.checkNotNullParameter(errorType, "errorType");
        Intrinsics.checkNotNullParameter(errorNumber, "errorNumber");
        return (errorType.getValue() << 20) | (errorNumber.getCode() & NUMBER_MASK);
    }

    public final OfflineErrorType getErrorType(int errorCode) {
        return OfflineErrorType.Companion.from((errorCode >> 20) & 15);
    }

    public final int getErrorNumber(int errorCode) {
        return NUMBER_MASK & errorCode;
    }
}