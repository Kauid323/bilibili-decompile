package tv.danmaku.android.log;

import kotlin.Metadata;
import tv.danmaku.app.AppConfig;
import tv.danmaku.bili.BR;

/* compiled from: LogAdapter.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0003H&J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J,\u0010\f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&¨\u0006\u000f"}, d2 = {"Ltv/danmaku/android/log/LogAdapter;", "", "event", "", AppConfig.HOST_TAG, "", "message", "flush", "isLoggable", "", "priority", "", "log", "t", "", "blog_android_release"}, k = 1, mv = {1, 9, 0}, xi = BR.badgeVisibility)
public interface LogAdapter {
    void event(String str, String str2);

    void flush();

    boolean isLoggable(int i, String str);

    void log(int i, String str, String str2, Throwable th);
}