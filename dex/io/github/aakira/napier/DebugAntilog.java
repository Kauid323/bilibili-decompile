package io.github.aakira.napier;

import android.os.Build;
import android.util.Log;
import com.tencent.matrix.report.Issue;
import com.vivo.push.PushClientConstants;
import external.org.apache.commons.lang3.ClassUtils;
import io.github.aakira.napier.Napier;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: DebugAntilog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0015\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H\u0000¢\u0006\u0002\b\u000eJ.\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003H\u0014J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0003H\u0002J\f\u0010\u0017\u001a\u00020\u0018*\u00020\u0012H\u0002R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\b\u001a\u00020\u0003*\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u001a"}, d2 = {"Lio/github/aakira/napier/DebugAntilog;", "Lio/github/aakira/napier/Antilog;", "defaultTag", "", "(Ljava/lang/String;)V", "anonymousClass", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "stackTraceString", "", "getStackTraceString", "(Ljava/lang/Throwable;)Ljava/lang/String;", "createStackElementTag", PushClientConstants.TAG_CLASS_NAME, "createStackElementTag$napier_debug", "performLog", "", "priority", "Lio/github/aakira/napier/Napier$Level;", Issue.ISSUE_REPORT_TAG, "throwable", "message", "performTag", "toValue", "", "Companion", "napier_debug"}, k = 1, mv = {1, 4, 2})
public final class DebugAntilog extends Antilog {
    private static final int CALL_STACK_INDEX = 9;
    public static final Companion Companion = new Companion(null);
    private static final int MAX_LOG_LENGTH = 4000;
    private static final int MAX_TAG_LENGTH = 23;
    private final Pattern anonymousClass;
    private final String defaultTag;

    public DebugAntilog() {
        this(null, 1, null);
    }

    public DebugAntilog(String defaultTag) {
        Intrinsics.checkNotNullParameter(defaultTag, "defaultTag");
        this.defaultTag = defaultTag;
        this.anonymousClass = Pattern.compile("(\\$\\d+)+$");
    }

    public /* synthetic */ DebugAntilog(String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "app" : str);
    }

    /* compiled from: DebugAntilog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lio/github/aakira/napier/DebugAntilog$Companion;", "", "()V", "CALL_STACK_INDEX", "", "MAX_LOG_LENGTH", "MAX_TAG_LENGTH", "napier_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Override // io.github.aakira.napier.Antilog
    protected void performLog(Napier.Level priority, String tag, Throwable throwable, String message) {
        String fullMessage;
        Intrinsics.checkNotNullParameter(priority, "priority");
        String debugTag = tag != null ? tag : performTag(this.defaultTag);
        if (message != null) {
            if (throwable == null) {
                fullMessage = message;
            } else {
                fullMessage = message + '\n' + getStackTraceString(throwable);
            }
        } else if (throwable == null || (fullMessage = getStackTraceString(throwable)) == null) {
            return;
        }
        int length = fullMessage.length();
        if (length <= MAX_LOG_LENGTH) {
            if (priority == Napier.Level.ASSERT) {
                Log.wtf(debugTag, fullMessage);
                return;
            } else {
                Log.println(toValue(priority), debugTag, fullMessage);
                return;
            }
        }
        int i2 = 0;
        while (i2 < length) {
            int newline = StringsKt.indexOf$default(fullMessage, '\n', i2, false, 4, (Object) null);
            int newline2 = newline != -1 ? newline : length;
            do {
                int end = Math.min(newline2, i2 + MAX_LOG_LENGTH);
                if (fullMessage == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String part = fullMessage.substring(i2, end);
                Intrinsics.checkNotNullExpressionValue(part, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                if (toValue(priority) == 7) {
                    Log.wtf(debugTag, part);
                } else {
                    Log.println(toValue(priority), debugTag, part);
                }
                i2 = end;
            } while (i2 < newline2);
            i2++;
        }
    }

    private final String performTag(String tag) {
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
        StackTraceElement[] thread = currentThread.getStackTrace();
        if (thread != null && thread.length >= 9) {
            StackTraceElement $this$run = thread[9];
            StringBuilder sb = new StringBuilder();
            String className = $this$run.getClassName();
            Intrinsics.checkNotNullExpressionValue(className, PushClientConstants.TAG_CLASS_NAME);
            return sb.append(createStackElementTag$napier_debug(className)).append(ClassUtils.INNER_CLASS_SEPARATOR_CHAR).append($this$run.getMethodName()).toString();
        }
        return tag;
    }

    public final String createStackElementTag$napier_debug(String className) {
        Intrinsics.checkNotNullParameter(className, PushClientConstants.TAG_CLASS_NAME);
        String tag = className;
        Matcher m = this.anonymousClass.matcher(tag);
        if (m.find()) {
            String replaceAll = m.replaceAll("");
            Intrinsics.checkNotNullExpressionValue(replaceAll, "m.replaceAll(\"\")");
            tag = replaceAll;
        }
        int lastIndexOf$default = StringsKt.lastIndexOf$default(tag, (char) ClassUtils.PACKAGE_SEPARATOR_CHAR, 0, false, 6, (Object) null) + 1;
        if (tag == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String tag2 = tag.substring(lastIndexOf$default);
        Intrinsics.checkNotNullExpressionValue(tag2, "(this as java.lang.String).substring(startIndex)");
        if (tag2.length() <= 23 || Build.VERSION.SDK_INT >= 24) {
            return tag2;
        }
        if (tag2 != null) {
            String substring = tag2.substring(0, 23);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    private final String getStackTraceString(Throwable $this$stackTraceString) {
        StringWriter sw = new StringWriter(256);
        PrintWriter pw = new PrintWriter((Writer) sw, false);
        $this$stackTraceString.printStackTrace(pw);
        pw.flush();
        String stringWriter = sw.toString();
        Intrinsics.checkNotNullExpressionValue(stringWriter, "sw.toString()");
        return stringWriter;
    }

    private final int toValue(Napier.Level $this$toValue) {
        switch ($this$toValue) {
            case VERBOSE:
                return 2;
            case DEBUG:
                return 3;
            case INFO:
                return 4;
            case WARNING:
                return 5;
            case ERROR:
                return 6;
            case ASSERT:
                return 7;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}