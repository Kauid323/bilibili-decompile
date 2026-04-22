package video.base.log;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.base.log.IVBLog;

/* compiled from: Log.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\"\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"tag", "", "subTag", "VBLog", "Lvideo/base/log/IVBLog;", "getVBLog", "()Lvideo/base/log/IVBLog;", "base_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class LogKt {
    private static final IVBLog VBLog = new IVBLog() { // from class: video.base.log.LogKt$VBLog$1
        @Override // video.base.log.IVBLog
        public /* bridge */ void debug(String message) {
            IVBLog.CC.$default$debug(this, message);
        }

        @Override // video.base.log.IVBLog
        public /* bridge */ void error(String message) {
            IVBLog.CC.$default$error(this, message);
        }

        @Override // video.base.log.IVBLog
        public /* bridge */ void error(String message, Throwable throwable) {
            IVBLog.CC.$default$error(this, message, throwable);
        }

        @Override // video.base.log.IVBLog
        public /* bridge */ String getLogType() {
            return IVBLog.CC.$default$getLogType(this);
        }

        @Override // video.base.log.IVBLog
        public /* bridge */ void info(String message) {
            IVBLog.CC.$default$info(this, message);
        }

        @Override // video.base.log.IVBLog
        public /* bridge */ void warn(String message) {
            IVBLog.CC.$default$warn(this, message);
        }
    };

    public static final String tag(String subTag) {
        Intrinsics.checkNotNullParameter(subTag, "subTag");
        return "[Video]-[" + subTag + "]";
    }

    public static final IVBLog getVBLog() {
        return VBLog;
    }
}