package kntr.base.dd.impl.internal.common;

import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kntr.base.utils.CoroutineExKt;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: DDConst.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u000e\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0005J\"\u0010\u000f\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0010\u001a\n\u0018\u00010\u0011j\u0004\u0018\u0001`\u0012J\"\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00052\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0017"}, d2 = {"Lkntr/base/dd/impl/internal/common/DDConst;", "", "<init>", "()V", "DD_LOG_TAG", "", "processName", "getProcessName", "()Ljava/lang/String;", "setProcessName", "(Ljava/lang/String;)V", "logD", "", "msg", "logI", "logE", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "trackT", "eventId", "params", "", "impl_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class DDConst {
    private static final String DD_LOG_TAG = "DDLib";
    public static final DDConst INSTANCE = new DDConst();
    private static String processName = "";

    private DDConst() {
    }

    public final String getProcessName() {
        return processName;
    }

    public final void setProcessName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        processName = str;
    }

    public final void logD(String msg) {
        KLog_androidKt.getKLog().d(DD_LOG_TAG, msg == null ? "" : msg);
    }

    public final void logI(String msg) {
        KLog_androidKt.getKLog().i(DD_LOG_TAG, msg == null ? "" : msg);
    }

    public static /* synthetic */ void logE$default(DDConst dDConst, String str, Exception exc, int i, Object obj) {
        if ((i & 2) != 0) {
            exc = null;
        }
        dDConst.logE(str, exc);
    }

    public final void logE(String msg, Exception e) {
        String message;
        if (e != null) {
            message = msg + ", has exception: " + e.getMessage() + "\n" + ExceptionsKt.stackTraceToString(e);
        } else {
            message = msg;
        }
        if (message == null) {
            message = "unknow error message.";
        }
        KLog_androidKt.getKLog().e(DD_LOG_TAG, message);
    }

    public final void trackT(String eventId, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(map, "params");
        BuildersKt.launch$default(CoroutineExKt.createIOScope(), (CoroutineContext) null, (CoroutineStart) null, new DDConst$trackT$1(eventId, map, null), 3, (Object) null);
    }
}