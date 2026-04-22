package tv.danmaku.android.log.internal;

import android.content.Context;
import com.bilibili.droid.ProcessUtils;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.LogSetting;
import tv.danmaku.app.AppConfig;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;

/* compiled from: NativeLogger.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000f\u001a\u00020\u000bH\u0016J.\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J=\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\r2\u0016\u0010\u0016\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00180\u0017\"\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0002\u0010\u0019J2\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u001cH\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Ltv/danmaku/android/log/internal/NativeLogger;", "Ltv/danmaku/android/log/internal/ILogger;", "setting", "Ltv/danmaku/android/log/LogSetting;", "(Ltv/danmaku/android/log/LogSetting;)V", "flushExecutor", "Ljava/util/concurrent/ScheduledExecutorService;", "kotlin.jvm.PlatformType", "minimalPriority", "", "event", "", AppConfig.HOST_TAG, "", "message", "flush", "log", "priority", "t", "", "logFormat", "fmt", "args", "", "", "(ILjava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V", "logLazy", "lazyMsg", "Lkotlin/Function0;", "Companion", "blog_android_release"}, k = 1, mv = {1, 9, 0}, xi = BR.badgeVisibility)
public final class NativeLogger implements ILogger {
    public static final Companion Companion = new Companion(null);
    public static final String DEFAULT_TAG = "BLOG";
    private final ScheduledExecutorService flushExecutor;
    private final int minimalPriority;

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void initializeNativeDefault(int i, int i2, String str, String str2, long j, long j2, int i3, int i4, int i5, String str3, String str4);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void nativeEvent(String str, String str2, String str3);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void nativeFlush();

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void nativeLiteFlush();

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void nativeLog(int i, String str, String str2, String str3);

    public NativeLogger(LogSetting setting) {
        Intrinsics.checkNotNullParameter(setting, "setting");
        this.minimalPriority = Math.min(setting.getLogcatPriority(), setting.getLogfilePriority());
        this.flushExecutor = Executors.newScheduledThreadPool(1, new BLogThreadFactory("flush"));
        System.loadLibrary("blog");
        long flushMillis = setting.getAutoFlushMillis();
        Companion companion = Companion;
        int logcatPriority = setting.getLogcatPriority();
        int logfilePriority = setting.getLogfilePriority();
        String path = setting.getLogDir().getPath();
        Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
        String path2 = setting.getCacheDir().getPath();
        Intrinsics.checkNotNullExpressionValue(path2, "getPath(...)");
        long maxLogSize = setting.maxLogSize();
        int expiredDay = setting.getExpiredDay();
        int blockAmount = setting.getBlockAmount();
        int pageAmountInBlock = setting.getPageAmountInBlock();
        String myProcName = ProcessUtils.myProcName(setting.getContext());
        Intrinsics.checkNotNullExpressionValue(myProcName, "myProcName(...)");
        Context context = setting.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        companion.initializeNativeDefault(logcatPriority, logfilePriority, path, path2, flushMillis, maxLogSize, expiredDay, blockAmount, pageAmountInBlock, myProcName, UtilKt.getBlogProcess(context));
        this.flushExecutor.scheduleWithFixedDelay(new Runnable() { // from class: tv.danmaku.android.log.internal.NativeLogger$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                NativeLogger._init_$lambda$0();
            }
        }, flushMillis, flushMillis, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0() {
        Companion.nativeLiteFlush();
    }

    @Override // tv.danmaku.android.log.internal.ILogger
    public void event(String tag, String message) {
        Companion companion = Companion;
        String str = tag == null ? DEFAULT_TAG : tag;
        String name = Thread.currentThread().getName();
        if (name == null) {
            name = "";
        }
        companion.nativeEvent(str, name, String.valueOf(message));
    }

    @Override // tv.danmaku.android.log.internal.ILogger
    public void log(int priority, String tag, Throwable t, String message) {
        String s;
        if (priority >= this.minimalPriority) {
            if (t != null) {
                StringBuilder sb = new StringBuilder(String.valueOf(message));
                sb.append('\n');
                StringWriter $this$log_u24lambda_u241 = new StringWriter();
                t.printStackTrace(new PrintWriter($this$log_u24lambda_u241));
                sb.append($this$log_u24lambda_u241.getBuffer());
                s = sb.toString();
            } else {
                s = String.valueOf(message);
            }
            Intrinsics.checkNotNull(s);
            Companion companion = Companion;
            String str = tag == null ? DEFAULT_TAG : tag;
            String name = Thread.currentThread().getName();
            if (name == null) {
                name = "";
            }
            companion.nativeLog(priority, str, name, s);
        }
    }

    @Override // tv.danmaku.android.log.internal.ILogger
    public void logLazy(int priority, String tag, Throwable t, Function0<? extends Object> function0) {
        Intrinsics.checkNotNullParameter(function0, "lazyMsg");
        if (priority >= this.minimalPriority) {
            StringBuilder s = new StringBuilder(function0.invoke().toString());
            if (t != null) {
                s.append('\n');
                StringWriter $this$logLazy_u24lambda_u242 = new StringWriter();
                t.printStackTrace(new PrintWriter($this$logLazy_u24lambda_u242));
                s.append($this$logLazy_u24lambda_u242.getBuffer());
            }
            Companion companion = Companion;
            String str = tag == null ? DEFAULT_TAG : tag;
            String name = Thread.currentThread().getName();
            if (name == null) {
                name = "";
            }
            String sb = s.toString();
            Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
            companion.nativeLog(priority, str, name, sb);
        }
    }

    @Override // tv.danmaku.android.log.internal.ILogger
    public void logFormat(int priority, String tag, String fmt, Object... args) {
        Intrinsics.checkNotNullParameter(tag, AppConfig.HOST_TAG);
        Intrinsics.checkNotNullParameter(fmt, "fmt");
        Intrinsics.checkNotNullParameter(args, "args");
        if (priority >= this.minimalPriority) {
            try {
                Object[] copyOf = Arrays.copyOf(args, args.length);
                String msg = String.format(fmt, Arrays.copyOf(copyOf, copyOf.length));
                Intrinsics.checkNotNullExpressionValue(msg, "format(...)");
                Companion companion = Companion;
                String name = Thread.currentThread().getName();
                if (name == null) {
                    name = "";
                }
                companion.nativeLog(priority, tag, name, msg);
            } catch (RuntimeException e) {
                log(6, tag, e, "Format log string failed.");
            }
        }
    }

    @Override // tv.danmaku.android.log.internal.ILogger
    public void flush() {
        Companion.nativeFlush();
    }

    /* compiled from: NativeLogger.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Ja\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004H\u0083 J!\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004H\u0083 J\t\u0010\u0018\u001a\u00020\u0006H\u0083 J\t\u0010\u0019\u001a\u00020\u0006H\u0083 J)\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004H\u0083 R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Ltv/danmaku/android/log/internal/NativeLogger$Companion;", "", "()V", "DEFAULT_TAG", "", "initializeNativeDefault", "", "logcatPriority", "", "logfilePriority", "logPath", "cachePath", "flushMillis", "", "logSize", "expiredDay", "blockCount", "pagesOfBlock", "procName", "uniqueId", "nativeEvent", AppConfig.HOST_TAG, "threadName", AuthResultCbHelper.ARGS_MSG, "nativeFlush", "nativeLiteFlush", "nativeLog", "priority", "blog_android_release"}, k = 1, mv = {1, 9, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void initializeNativeDefault(int i, int i2, String str, String str2, long j, long j2, int i3, int i4, int i5, String str3, String str4) {
            NativeLogger.initializeNativeDefault(i, i2, str, str2, j, j2, i3, i4, i5, str3, str4);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void nativeEvent(String str, String str2, String str3) {
            NativeLogger.nativeEvent(str, str2, str3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void nativeFlush() {
            NativeLogger.nativeFlush();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void nativeLiteFlush() {
            NativeLogger.nativeLiteFlush();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void nativeLog(int i, String str, String str2, String str3) {
            NativeLogger.nativeLog(i, str, str2, str3);
        }

        private Companion() {
        }
    }
}