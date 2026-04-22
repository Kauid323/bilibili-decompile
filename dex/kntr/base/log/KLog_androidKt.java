package kntr.base.log;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;

/* compiled from: KLog.android.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"KLog", "Lkntr/base/log/ILogger;", "getKLog", "()Lkntr/base/log/ILogger;", "log_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class KLog_androidKt {
    private static final ILogger KLog = new ILogger() { // from class: kntr.base.log.KLog_androidKt$KLog$1
        @Override // kntr.base.log.ILogger
        public void v(String tag, String message) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(message, "message");
            BLog.v(tag, message);
        }

        @Override // kntr.base.log.ILogger
        public void i(String tag, String message) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(message, "message");
            BLog.i(tag, message);
        }

        @Override // kntr.base.log.ILogger
        public void d(String tag, String message) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(message, "message");
            BLog.d(tag, message);
        }

        @Override // kntr.base.log.ILogger
        public void w(String tag, String message) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(message, "message");
            BLog.w(tag, message);
        }

        @Override // kntr.base.log.ILogger
        public void e(String tag, String message) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(message, "message");
            BLog.e(tag, message);
        }

        @Override // kntr.base.log.ILogger
        public void e(String tag, String message, Throwable throwable) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(message, "message");
            BLog.e(tag, message, throwable);
        }

        @Override // kntr.base.log.ILogger
        public void wtf(String tag, String msg) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            BLog.wtf(tag, msg);
        }
    };

    public static final ILogger getKLog() {
        return KLog;
    }
}