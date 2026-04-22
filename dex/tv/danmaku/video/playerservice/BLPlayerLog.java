package tv.danmaku.video.playerservice;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BLPlayerLog.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0007J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0007J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0007J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0007J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0007J \u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0007J\u0018\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0007J\u0018\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0007J \u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Ltv/danmaku/video/playerservice/BLPlayerLog;", "", "<init>", "()V", "TAG", "", "d", "", "module", "msg", "i", "w", "throwable", "", "e", "playerservice_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BLPlayerLog {
    public static final BLPlayerLog INSTANCE = new BLPlayerLog();
    private static final String TAG = "BLPlayer";

    private BLPlayerLog() {
    }

    @JvmStatic
    public static final void d(String module, String msg) {
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(msg, "msg");
        BLog.d(TAG, module + "-" + msg);
    }

    @JvmStatic
    public static final void i(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        BLog.i(TAG, msg);
    }

    @JvmStatic
    public static final void i(String module, String msg) {
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(msg, "msg");
        BLog.i(TAG, module + "-" + msg);
    }

    @JvmStatic
    public static final void w(String module, String msg) {
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(msg, "msg");
        BLog.w(TAG, module + "-" + msg);
    }

    @JvmStatic
    public static final void w(String module, Throwable throwable) {
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        BLog.w(TAG, module, throwable);
    }

    @JvmStatic
    public static final void w(String module, String msg, Throwable throwable) {
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        BLog.w(TAG, module + "-" + msg, throwable);
    }

    @JvmStatic
    public static final void e(String module, String msg) {
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(msg, "msg");
        BLog.e(TAG, module + "-" + msg);
    }

    @JvmStatic
    public static final void e(String module, Throwable throwable) {
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        BLog.e(TAG, module, throwable);
    }

    @JvmStatic
    public static final void e(String module, String msg, Throwable throwable) {
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        BLog.e(TAG, module + "-" + msg, throwable);
    }
}