package video.base.log;

import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: Log.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003H\u0016J\u0012\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003H\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H\u0016J\u0012\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003H\u0016J\u001c\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0002R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Lvideo/base/log/IVBLog;", "", "logType", "", "getLogType", "()Ljava/lang/String;", "info", "", "message", "debug", "warn", "error", "throwable", "", "msg", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface IVBLog {
    void debug(String str);

    void error(String str);

    void error(String str, Throwable th);

    String getLogType();

    void info(String str);

    void warn(String str);

    /* compiled from: Log.kt */
    /* renamed from: video.base.log.IVBLog$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public final /* synthetic */ class CC {
        public static String $default$getLogType(IVBLog _this) {
            return "Common";
        }

        public static /* synthetic */ void info$default(IVBLog iVBLog, String str, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: info");
            }
            if ((i & 1) != 0) {
                str = "";
            }
            iVBLog.info(str);
        }

        public static void $default$info(IVBLog _this, String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            KLog_androidKt.getKLog().i(LogKt.tag(_this.getLogType()), $private$message(_this, message));
        }

        public static /* synthetic */ void debug$default(IVBLog iVBLog, String str, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: debug");
            }
            if ((i & 1) != 0) {
                str = "";
            }
            iVBLog.debug(str);
        }

        public static void $default$debug(IVBLog _this, String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            KLog_androidKt.getKLog().d(LogKt.tag(_this.getLogType()), $private$message(_this, message));
        }

        public static void $default$warn(IVBLog _this, String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            KLog_androidKt.getKLog().w(LogKt.tag(_this.getLogType()), $private$message(_this, message));
        }

        public static /* synthetic */ void error$default(IVBLog iVBLog, String str, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: error");
            }
            if ((i & 1) != 0) {
                str = "";
            }
            iVBLog.error(str);
        }

        public static void $default$error(IVBLog _this, String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            KLog_androidKt.getKLog().e(LogKt.tag(_this.getLogType()), $private$message(_this, message));
        }

        public static /* synthetic */ void error$default(IVBLog iVBLog, String str, Throwable th, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: error");
            }
            if ((i & 1) != 0) {
                str = "";
            }
            iVBLog.error(str, th);
        }

        public static void $default$error(IVBLog _this, String message, Throwable throwable) {
            Intrinsics.checkNotNullParameter(message, "message");
            KLog_androidKt.getKLog().e(LogKt.tag(_this.getLogType()), $private$message(_this, message), throwable);
        }

        public static String $private$message(IVBLog _this, String msg) {
            return msg.length() == 0 ? "" : "[" + msg + "]";
        }
    }

    /* compiled from: Log.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static String getLogType(IVBLog $this) {
            return CC.$default$getLogType($this);
        }

        @Deprecated
        public static void info(IVBLog $this, String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            CC.$default$info($this, message);
        }

        @Deprecated
        public static void debug(IVBLog $this, String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            CC.$default$debug($this, message);
        }

        @Deprecated
        public static void warn(IVBLog $this, String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            CC.$default$warn($this, message);
        }

        @Deprecated
        public static void error(IVBLog $this, String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            CC.$default$error($this, message);
        }

        @Deprecated
        public static void error(IVBLog $this, String message, Throwable throwable) {
            Intrinsics.checkNotNullParameter(message, "message");
            CC.$default$error($this, message, throwable);
        }
    }
}