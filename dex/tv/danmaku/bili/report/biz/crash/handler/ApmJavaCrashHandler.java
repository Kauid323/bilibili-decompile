package tv.danmaku.bili.report.biz.crash.handler;

import android.content.Context;
import com.bilibili.droid.thread.HandlerThreads;
import java.lang.Thread;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;

/* compiled from: ApmJavaCrashHandler.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\t\u001a\u00020\u0006H\u0002J\u001c\u0010\n\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u001c\u0010\u000f\u001a\u00020\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/report/biz/crash/handler/ApmJavaCrashHandler;", "Ljava/lang/Thread$UncaughtExceptionHandler;", "<init>", "()V", "mDefaultHandler", "init", "", "context", "Landroid/content/Context;", "doInit", "uncaughtException", "t", "Ljava/lang/Thread;", "e", "", "handle", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ApmJavaCrashHandler implements Thread.UncaughtExceptionHandler {
    private static Thread.UncaughtExceptionHandler mDefaultHandler;
    public static final ApmJavaCrashHandler INSTANCE = new ApmJavaCrashHandler();
    public static final int $stable = 8;

    private ApmJavaCrashHandler() {
    }

    @JvmStatic
    public static final void init(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        HandlerThreads.post(2, new Runnable() { // from class: tv.danmaku.bili.report.biz.crash.handler.ApmJavaCrashHandler$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ApmJavaCrashHandler.init$lambda$0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$0() {
        INSTANCE.doInit();
    }

    private final void doInit() {
        if (!Intrinsics.areEqual(Thread.getDefaultUncaughtExceptionHandler(), this)) {
            mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread t, Throwable e) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
        if (handle(t, e) || (uncaughtExceptionHandler = mDefaultHandler) == null) {
            return;
        }
        uncaughtExceptionHandler.uncaughtException(t, e);
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000d, code lost:
        if (r3 == null) goto L4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean handle(Thread t, Throwable e) {
        String th;
        if (e != null) {
            try {
                th = e.toString();
            } catch (Throwable th2) {
            }
        }
        th = "na";
        BLog.vfmt("misaka.apm.crashhandler", "Handle uncaught exception %s.", th);
        return false;
    }
}