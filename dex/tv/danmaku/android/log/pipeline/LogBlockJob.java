package tv.danmaku.android.log.pipeline;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.cache.Meta;
import tv.danmaku.bili.BR;

/* compiled from: Jobs.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0014\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0011\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u0000H\u0096\u0002J\b\u0010\u001f\u001a\u00020\u0007H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\n\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Ltv/danmaku/android/log/pipeline/LogBlockJob;", "", "id", "", "block", "Ltv/danmaku/android/log/cache/Meta$Block;", "day", "", "preLog", "", "curLog", "size", "", "(JLtv/danmaku/android/log/cache/Meta$Block;Ljava/lang/String;[B[BI)V", "getBlock", "()Ltv/danmaku/android/log/cache/Meta$Block;", "getCurLog", "()[B", "setCurLog", "([B)V", "getDay", "()Ljava/lang/String;", "getId", "()J", "getPreLog", "getSize", "()I", "setSize", "(I)V", "compareTo", "other", "toString", "blog_android_release"}, k = 1, mv = {1, 9, 0}, xi = BR.badgeVisibility)
public final class LogBlockJob implements Comparable<LogBlockJob> {
    private final Meta.Block block;
    private byte[] curLog;
    private final String day;
    private final long id;
    private final byte[] preLog;
    private int size;

    public LogBlockJob(long id, Meta.Block block, String day, byte[] preLog, byte[] curLog, int size) {
        Intrinsics.checkNotNullParameter(block, "block");
        Intrinsics.checkNotNullParameter(curLog, "curLog");
        this.id = id;
        this.block = block;
        this.day = day;
        this.preLog = preLog;
        this.curLog = curLog;
        this.size = size;
    }

    public final Meta.Block getBlock() {
        return this.block;
    }

    public final long getId() {
        return this.id;
    }

    public final String getDay() {
        return this.day;
    }

    public final byte[] getPreLog() {
        return this.preLog;
    }

    public final byte[] getCurLog() {
        return this.curLog;
    }

    public final void setCurLog(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<set-?>");
        this.curLog = bArr;
    }

    public final int getSize() {
        return this.size;
    }

    public final void setSize(int i) {
        this.size = i;
    }

    @Override // java.lang.Comparable
    public int compareTo(LogBlockJob other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (this.id < other.id) {
            return -1;
        }
        return this.id > other.id ? 1 : 0;
    }

    public String toString() {
        return "LogBlockJob(id=" + this.id + ')';
    }
}