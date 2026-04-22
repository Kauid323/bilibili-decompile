package tv.danmaku.android.log.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import tv.danmaku.app.AppConfig;
import tv.danmaku.bili.BR;

/* compiled from: ILogger.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0007\u001a\u00020\u0003H&J.\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J=\u0010\r\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0016\u0010\u000f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0010\"\u0004\u0018\u00010\u0001H&¢\u0006\u0002\u0010\u0011J2\u0010\u0012\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u0014H&¨\u0006\u0015"}, d2 = {"Ltv/danmaku/android/log/internal/ILogger;", "", "event", "", AppConfig.HOST_TAG, "", "message", "flush", "log", "priority", "", "t", "", "logFormat", "fmt", "args", "", "(ILjava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V", "logLazy", "lazyMsg", "Lkotlin/Function0;", "blog_android_release"}, k = 1, mv = {1, 9, 0}, xi = BR.badgeVisibility)
public interface ILogger {
    void event(String str, String str2);

    void flush();

    void log(int i, String str, Throwable th, String str2);

    void logFormat(int i, String str, String str2, Object... objArr);

    void logLazy(int i, String str, Throwable th, Function0<? extends Object> function0);
}