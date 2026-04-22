package io.github.aakira.napier;

import com.tencent.matrix.report.Issue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Napier.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u001cB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005J,\u0010\t\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\fJ&\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\fJ,\u0010\u0010\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\fJ&\u0010\u0010\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\fJ,\u0010\u0011\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\fJ&\u0010\u0011\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\fJ\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u000f\u001a\u0004\u0018\u00010\fJ4\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ.\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\n\u001a\u00020\fJ.\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u000f\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\fH\u0001J\u0006\u0010\u0018\u001a\u00020\u0007J\u000e\u0010\u0018\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005J,\u0010\u0019\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\fJ&\u0010\u0019\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\fJ,\u0010\u001a\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\fJ&\u0010\u001a\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\fJ,\u0010\u001b\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\fJ&\u0010\u001b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\fR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lio/github/aakira/napier/Napier;", "", "()V", "baseArray", "", "Lio/github/aakira/napier/Antilog;", "base", "", "antilog", "d", "message", "Lkotlin/Function0;", "", "throwable", "", Issue.ISSUE_REPORT_TAG, "e", "i", "isEnable", "", "priority", "Lio/github/aakira/napier/Napier$Level;", "log", "rawLog", "takeLogarithm", "v", "w", "wtf", "Level", "napier_debug"}, k = 1, mv = {1, 4, 2})
public final class Napier {
    public static final Napier INSTANCE = new Napier();
    private static final List<Antilog> baseArray = new ArrayList();

    /* compiled from: Napier.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lio/github/aakira/napier/Napier$Level;", "", "(Ljava/lang/String;I)V", "VERBOSE", "DEBUG", "INFO", "WARNING", "ERROR", "ASSERT", "napier_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public enum Level {
        VERBOSE,
        DEBUG,
        INFO,
        WARNING,
        ERROR,
        ASSERT
    }

    private Napier() {
    }

    public final void base(Antilog antilog) {
        Intrinsics.checkNotNullParameter(antilog, "antilog");
        baseArray.add(antilog);
    }

    public final boolean isEnable(Level priority, String tag) {
        Intrinsics.checkNotNullParameter(priority, "priority");
        Iterable $this$any$iv = baseArray;
        if (($this$any$iv instanceof Collection) && ((Collection) $this$any$iv).isEmpty()) {
            return false;
        }
        for (Object element$iv : $this$any$iv) {
            Antilog it = (Antilog) element$iv;
            if (it.isEnable(priority, tag)) {
                return true;
            }
        }
        return false;
    }

    public final void rawLog(Level priority, String tag, Throwable throwable, String message) {
        Intrinsics.checkNotNullParameter(priority, "priority");
        Iterable $this$forEach$iv = baseArray;
        for (Object element$iv : $this$forEach$iv) {
            Antilog it = (Antilog) element$iv;
            it.rawLog$napier_debug(priority, tag, throwable, message);
        }
    }

    public static /* synthetic */ void v$default(Napier napier, String str, Throwable th, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            th = null;
        }
        if ((i2 & 4) != 0) {
            str2 = null;
        }
        napier.v(str, th, str2);
    }

    public final void v(String message, Throwable throwable, String tag) {
        Intrinsics.checkNotNullParameter(message, "message");
        log(Level.VERBOSE, tag, throwable, message);
    }

    public static /* synthetic */ void v$default(Napier napier, Function0 function0, Throwable th, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            th = null;
        }
        if ((i2 & 4) != 0) {
            str = null;
        }
        napier.v(function0, th, str);
    }

    public final void v(Function0<String> function0, Throwable throwable, String tag) {
        Intrinsics.checkNotNullParameter(function0, "message");
        log(Level.VERBOSE, tag, throwable, function0);
    }

    public static /* synthetic */ void i$default(Napier napier, String str, Throwable th, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            th = null;
        }
        if ((i2 & 4) != 0) {
            str2 = null;
        }
        napier.i(str, th, str2);
    }

    public final void i(String message, Throwable throwable, String tag) {
        Intrinsics.checkNotNullParameter(message, "message");
        log(Level.INFO, tag, throwable, message);
    }

    public static /* synthetic */ void i$default(Napier napier, Function0 function0, Throwable th, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            th = null;
        }
        if ((i2 & 4) != 0) {
            str = null;
        }
        napier.i(function0, th, str);
    }

    public final void i(Function0<String> function0, Throwable throwable, String tag) {
        Intrinsics.checkNotNullParameter(function0, "message");
        log(Level.INFO, tag, throwable, function0);
    }

    public static /* synthetic */ void d$default(Napier napier, String str, Throwable th, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            th = null;
        }
        if ((i2 & 4) != 0) {
            str2 = null;
        }
        napier.d(str, th, str2);
    }

    public final void d(String message, Throwable throwable, String tag) {
        Intrinsics.checkNotNullParameter(message, "message");
        log(Level.DEBUG, tag, throwable, message);
    }

    public static /* synthetic */ void d$default(Napier napier, Function0 function0, Throwable th, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            th = null;
        }
        if ((i2 & 4) != 0) {
            str = null;
        }
        napier.d(function0, th, str);
    }

    public final void d(Function0<String> function0, Throwable throwable, String tag) {
        Intrinsics.checkNotNullParameter(function0, "message");
        log(Level.DEBUG, tag, throwable, function0);
    }

    public static /* synthetic */ void w$default(Napier napier, String str, Throwable th, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            th = null;
        }
        if ((i2 & 4) != 0) {
            str2 = null;
        }
        napier.w(str, th, str2);
    }

    public final void w(String message, Throwable throwable, String tag) {
        Intrinsics.checkNotNullParameter(message, "message");
        log(Level.WARNING, tag, throwable, message);
    }

    public static /* synthetic */ void w$default(Napier napier, Function0 function0, Throwable th, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            th = null;
        }
        if ((i2 & 4) != 0) {
            str = null;
        }
        napier.w(function0, th, str);
    }

    public final void w(Function0<String> function0, Throwable throwable, String tag) {
        Intrinsics.checkNotNullParameter(function0, "message");
        log(Level.WARNING, tag, throwable, function0);
    }

    public static /* synthetic */ void e$default(Napier napier, String str, Throwable th, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            th = null;
        }
        if ((i2 & 4) != 0) {
            str2 = null;
        }
        napier.e(str, th, str2);
    }

    public final void e(String message, Throwable throwable, String tag) {
        Intrinsics.checkNotNullParameter(message, "message");
        log(Level.ERROR, tag, throwable, message);
    }

    public static /* synthetic */ void e$default(Napier napier, Function0 function0, Throwable th, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            th = null;
        }
        if ((i2 & 4) != 0) {
            str = null;
        }
        napier.e(function0, th, str);
    }

    public final void e(Function0<String> function0, Throwable throwable, String tag) {
        Intrinsics.checkNotNullParameter(function0, "message");
        log(Level.ERROR, tag, throwable, function0);
    }

    public static /* synthetic */ void wtf$default(Napier napier, String str, Throwable th, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            th = null;
        }
        if ((i2 & 4) != 0) {
            str2 = null;
        }
        napier.wtf(str, th, str2);
    }

    public final void wtf(String message, Throwable throwable, String tag) {
        Intrinsics.checkNotNullParameter(message, "message");
        log(Level.ASSERT, tag, throwable, message);
    }

    public static /* synthetic */ void wtf$default(Napier napier, Function0 function0, Throwable th, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            th = null;
        }
        if ((i2 & 4) != 0) {
            str = null;
        }
        napier.wtf(function0, th, str);
    }

    public final void wtf(Function0<String> function0, Throwable throwable, String tag) {
        Intrinsics.checkNotNullParameter(function0, "message");
        log(Level.ASSERT, tag, throwable, function0);
    }

    public static /* synthetic */ void log$default(Napier napier, Level level, String str, Throwable th, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        if ((i2 & 4) != 0) {
            th = null;
        }
        napier.log(level, str, th, str2);
    }

    public final void log(Level priority, String tag, Throwable throwable, String message) {
        Intrinsics.checkNotNullParameter(priority, "priority");
        Intrinsics.checkNotNullParameter(message, "message");
        if (isEnable(priority, tag)) {
            rawLog(priority, tag, throwable, message);
        }
    }

    public static /* synthetic */ void log$default(Napier napier, Level level, String str, Throwable th, Function0 function0, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        if ((i2 & 4) != 0) {
            th = null;
        }
        napier.log(level, str, th, function0);
    }

    public final void log(Level priority, String tag, Throwable throwable, Function0<String> function0) {
        Intrinsics.checkNotNullParameter(priority, "priority");
        Intrinsics.checkNotNullParameter(function0, "message");
        if (isEnable(priority, tag)) {
            rawLog(priority, tag, throwable, (String) function0.invoke());
        }
    }

    public final void takeLogarithm(Antilog antilog) {
        Intrinsics.checkNotNullParameter(antilog, "antilog");
        baseArray.remove(antilog);
    }

    public final void takeLogarithm() {
        baseArray.clear();
    }
}