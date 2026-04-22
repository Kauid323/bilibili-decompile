package kntr.app.ad.common.utils;

import kntr.base.log.ILogger;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;

/* compiled from: Logger.android.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0011\u0010\u0000\u001a\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"AdLog", "Lkntr/base/log/ILogger;", "getAdLog", "()Lkntr/base/log/ILogger;", "utils_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class Logger_androidKt {
    public static final ILogger getAdLog() {
        return KLog_androidKt.getKLog();
    }
}