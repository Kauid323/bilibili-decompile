package tv.danmaku.android.log.adapters;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: DiskLogAdapter.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Ltv/danmaku/android/log/adapters/ThreadResource;", "", "pr", "Ljava/io/PrintWriter;", "bos", "Ljava/io/ByteArrayOutputStream;", "fmt", "Ljava/text/SimpleDateFormat;", "tidStr", "", "(Ljava/io/PrintWriter;Ljava/io/ByteArrayOutputStream;Ljava/text/SimpleDateFormat;Ljava/lang/String;)V", "getBos", "()Ljava/io/ByteArrayOutputStream;", "getFmt", "()Ljava/text/SimpleDateFormat;", "getPr", "()Ljava/io/PrintWriter;", "getTidStr", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "blog_android_release"}, k = 1, mv = {1, 9, 0}, xi = BR.badgeVisibility)
public final class ThreadResource {
    private final ByteArrayOutputStream bos;
    private final SimpleDateFormat fmt;
    private final PrintWriter pr;
    private final String tidStr;

    public static /* synthetic */ ThreadResource copy$default(ThreadResource threadResource, PrintWriter printWriter, ByteArrayOutputStream byteArrayOutputStream, SimpleDateFormat simpleDateFormat, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            printWriter = threadResource.pr;
        }
        if ((i & 2) != 0) {
            byteArrayOutputStream = threadResource.bos;
        }
        if ((i & 4) != 0) {
            simpleDateFormat = threadResource.fmt;
        }
        if ((i & 8) != 0) {
            str = threadResource.tidStr;
        }
        return threadResource.copy(printWriter, byteArrayOutputStream, simpleDateFormat, str);
    }

    public final PrintWriter component1() {
        return this.pr;
    }

    public final ByteArrayOutputStream component2() {
        return this.bos;
    }

    public final SimpleDateFormat component3() {
        return this.fmt;
    }

    public final String component4() {
        return this.tidStr;
    }

    public final ThreadResource copy(PrintWriter printWriter, ByteArrayOutputStream byteArrayOutputStream, SimpleDateFormat simpleDateFormat, String str) {
        Intrinsics.checkNotNullParameter(printWriter, "pr");
        Intrinsics.checkNotNullParameter(byteArrayOutputStream, "bos");
        Intrinsics.checkNotNullParameter(simpleDateFormat, "fmt");
        Intrinsics.checkNotNullParameter(str, "tidStr");
        return new ThreadResource(printWriter, byteArrayOutputStream, simpleDateFormat, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ThreadResource) {
            ThreadResource threadResource = (ThreadResource) obj;
            return Intrinsics.areEqual(this.pr, threadResource.pr) && Intrinsics.areEqual(this.bos, threadResource.bos) && Intrinsics.areEqual(this.fmt, threadResource.fmt) && Intrinsics.areEqual(this.tidStr, threadResource.tidStr);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.pr.hashCode() * 31) + this.bos.hashCode()) * 31) + this.fmt.hashCode()) * 31) + this.tidStr.hashCode();
    }

    public String toString() {
        return "ThreadResource(pr=" + this.pr + ", bos=" + this.bos + ", fmt=" + this.fmt + ", tidStr=" + this.tidStr + ')';
    }

    public ThreadResource(PrintWriter pr, ByteArrayOutputStream bos, SimpleDateFormat fmt, String tidStr) {
        Intrinsics.checkNotNullParameter(pr, "pr");
        Intrinsics.checkNotNullParameter(bos, "bos");
        Intrinsics.checkNotNullParameter(fmt, "fmt");
        Intrinsics.checkNotNullParameter(tidStr, "tidStr");
        this.pr = pr;
        this.bos = bos;
        this.fmt = fmt;
        this.tidStr = tidStr;
    }

    public final PrintWriter getPr() {
        return this.pr;
    }

    public final ByteArrayOutputStream getBos() {
        return this.bos;
    }

    public final SimpleDateFormat getFmt() {
        return this.fmt;
    }

    public final String getTidStr() {
        return this.tidStr;
    }
}