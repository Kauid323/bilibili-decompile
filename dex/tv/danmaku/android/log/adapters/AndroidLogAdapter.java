package tv.danmaku.android.log.adapters;

import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.LogAdapter;
import tv.danmaku.android.log.internal.NativeLogger;
import tv.danmaku.app.AppConfig;
import tv.danmaku.bili.BR;

/* compiled from: AndroidLogAdapter.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u0005H\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016J\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0016J,\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0005H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Ltv/danmaku/android/log/adapters/AndroidLogAdapter;", "Ltv/danmaku/android/log/LogAdapter;", "priority", "", "defaultTag", "", "(ILjava/lang/String;)V", "getDefaultTag", "()Ljava/lang/String;", "getPriority", "()I", "event", "", AppConfig.HOST_TAG, "message", "flush", "isLoggable", "", "log", "t", "", "threadName", "blog_android_release"}, k = 1, mv = {1, 9, 0}, xi = BR.badgeVisibility)
public final class AndroidLogAdapter implements LogAdapter {
    private final String defaultTag;
    private final int priority;

    public AndroidLogAdapter() {
        this(0, null, 3, null);
    }

    public AndroidLogAdapter(int priority, String defaultTag) {
        Intrinsics.checkNotNullParameter(defaultTag, "defaultTag");
        this.priority = priority;
        this.defaultTag = defaultTag;
    }

    public /* synthetic */ AndroidLogAdapter(int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 3 : i, (i2 & 2) != 0 ? NativeLogger.DEFAULT_TAG : str);
    }

    public final String getDefaultTag() {
        return this.defaultTag;
    }

    public final int getPriority() {
        return this.priority;
    }

    @Override // tv.danmaku.android.log.LogAdapter
    public void flush() {
    }

    @Override // tv.danmaku.android.log.LogAdapter
    public void event(String tag, String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (tag == null) {
            Log.i("BLOG-EVENT", message);
        } else {
            Log.d("BLOG-EVENT-" + tag, message);
        }
    }

    @Override // tv.danmaku.android.log.LogAdapter
    public boolean isLoggable(int priority, String tag) {
        return priority >= this.priority;
    }

    @Override // tv.danmaku.android.log.LogAdapter
    public void log(int priority, String tag, String message, Throwable t) {
        Intrinsics.checkNotNullParameter(message, "message");
        String actualTag = tag == null ? this.defaultTag : tag;
        String actualMsg = threadName() + message;
        switch (priority) {
            case 2:
                Log.v(actualTag, actualMsg, t);
                return;
            case 3:
                Log.d(actualTag, actualMsg, t);
                return;
            case 4:
                Log.i(actualTag, actualMsg, t);
                return;
            case 5:
                Log.w(actualTag, actualMsg, t);
                return;
            case 6:
                Log.e(actualTag, actualMsg, t);
                return;
            case 7:
                Log.wtf(actualTag, actualMsg, t);
                return;
            default:
                return;
        }
    }

    private final String threadName() {
        String t = Thread.currentThread().getName();
        return '[' + t + "] ";
    }
}