package tv.danmaku.biliplayerv2.service.interact.log;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: DanmakuLogger.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005J\u000e\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005J\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005J\u000e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005J\u0018\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0002J\u0018\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0002J\u0018\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/log/DanmakuLogger;", "", "<init>", "()V", "DANMAKU_TAG", "", "MODULE_API", "MODULE_SERVICE", "MODULE_CHRONOS", "MODULE_ERROR", "logReq", "", "logMsg", "logService", "logChronos", "error", "logD", "module", "content", "logI", "logE", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class DanmakuLogger {
    private static final String DANMAKU_TAG = "DanmakuLog";
    public static final DanmakuLogger INSTANCE = new DanmakuLogger();
    private static final String MODULE_API = "api";
    private static final String MODULE_CHRONOS = "chronos";
    private static final String MODULE_ERROR = "error";
    private static final String MODULE_SERVICE = "service";

    private DanmakuLogger() {
    }

    public final void logReq(String logMsg) {
        Intrinsics.checkNotNullParameter(logMsg, "logMsg");
        logI(MODULE_API, logMsg);
    }

    public final void logService(String logMsg) {
        Intrinsics.checkNotNullParameter(logMsg, "logMsg");
        logI(MODULE_SERVICE, logMsg);
    }

    public final void logChronos(String logMsg) {
        Intrinsics.checkNotNullParameter(logMsg, "logMsg");
        logI(MODULE_CHRONOS, logMsg);
    }

    public final void error(String logMsg) {
        Intrinsics.checkNotNullParameter(logMsg, "logMsg");
        logE("error", logMsg);
    }

    private final void logD(String module, String content) {
        BLog.d("DanmakuLog-" + module, content);
    }

    private final void logI(String module, String content) {
        BLog.i("DanmakuLog-" + module, content);
    }

    private final void logE(String module, String content) {
        BLog.e("DanmakuLog-" + module, content);
    }
}