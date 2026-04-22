package tv.danmaku.bili.report.biz.crash.handler;

import android.app.Activity;
import com.bilibili.base.BiliContext;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: HandlerModelAdapter.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a2\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"CRASHTYPE_JAVA_CRASH", "", "CRASHTYPE_JAVA_CATCH", "fromException", "", "exception", "", "caught", "", "thread", "Ljava/lang/Thread;", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class HandlerModelAdapterKt {
    public static final String CRASHTYPE_JAVA_CATCH = "1";
    public static final String CRASHTYPE_JAVA_CRASH = "0";

    public static /* synthetic */ Map fromException$default(Throwable th, boolean z, Thread thread, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            thread = null;
        }
        return fromException(th, z, thread);
    }

    public static final Map<String, String> fromException(Throwable exception, boolean caught, Thread thread) {
        Class<?> cls;
        String name;
        Throwable cause;
        Throwable cause2;
        StackTraceElement[] stackTrace;
        Throwable cause3;
        StackTraceElement[] stackTrace2;
        StackTraceElement[] stackTrace3;
        Class<?> cls2;
        HashMap $this$fromException_u24lambda_u240 = new HashMap();
        $this$fromException_u24lambda_u240.put("process", BiliContext.currentProcessName());
        String str = "";
        $this$fromException_u24lambda_u240.put("thread", (thread == null || (r4 = thread.getName()) == null) ? "" : "");
        $this$fromException_u24lambda_u240.put("crash_type", caught ? "1" : "0");
        $this$fromException_u24lambda_u240.put("error_type", (exception == null || (cls2 = exception.getClass()) == null || (r4 = cls2.getName()) == null) ? "" : "");
        $this$fromException_u24lambda_u240.put("error_msg", (exception == null || (r4 = exception.getMessage()) == null) ? "" : "");
        $this$fromException_u24lambda_u240.put("error_stack", (exception == null || (stackTrace3 = exception.getStackTrace()) == null || (r5 = ArraysKt.joinToString$default(stackTrace3, "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: tv.danmaku.bili.report.biz.crash.handler.HandlerModelAdapterKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                CharSequence fromException$lambda$0$0;
                fromException$lambda$0$0 = HandlerModelAdapterKt.fromException$lambda$0$0((StackTraceElement) obj);
                return fromException$lambda$0$0;
            }
        }, 30, (Object) null)) == null) ? "" : "");
        $this$fromException_u24lambda_u240.put("caused_by", (exception == null || (cause3 = exception.getCause()) == null || (stackTrace2 = cause3.getStackTrace()) == null || (r5 = ArraysKt.joinToString$default(stackTrace2, "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: tv.danmaku.bili.report.biz.crash.handler.HandlerModelAdapterKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                CharSequence fromException$lambda$0$1;
                fromException$lambda$0$1 = HandlerModelAdapterKt.fromException$lambda$0$1((StackTraceElement) obj);
                return fromException$lambda$0$1;
            }
        }, 30, (Object) null)) == null) ? "" : "");
        $this$fromException_u24lambda_u240.put("caused_byby", (exception == null || (cause = exception.getCause()) == null || (cause2 = cause.getCause()) == null || (stackTrace = cause2.getStackTrace()) == null || (r4 = ArraysKt.joinToString$default(stackTrace, "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: tv.danmaku.bili.report.biz.crash.handler.HandlerModelAdapterKt$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                CharSequence fromException$lambda$0$2;
                fromException$lambda$0$2 = HandlerModelAdapterKt.fromException$lambda$0$2((StackTraceElement) obj);
                return fromException$lambda$0$2;
            }
        }, 30, (Object) null)) == null) ? "" : "");
        Activity activity = BiliContext.topActivitiy();
        if (activity != null && (cls = activity.getClass()) != null && (name = cls.getName()) != null) {
            str = name;
        }
        $this$fromException_u24lambda_u240.put("top_activity", str);
        $this$fromException_u24lambda_u240.put("last_activity", BiliContext.lastActivityName());
        return $this$fromException_u24lambda_u240;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence fromException$lambda$0$0(StackTraceElement it) {
        String stackTraceElement = it.toString();
        Intrinsics.checkNotNullExpressionValue(stackTraceElement, "toString(...)");
        return stackTraceElement;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence fromException$lambda$0$1(StackTraceElement it) {
        String stackTraceElement = it.toString();
        Intrinsics.checkNotNullExpressionValue(stackTraceElement, "toString(...)");
        return stackTraceElement;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence fromException$lambda$0$2(StackTraceElement it) {
        String stackTraceElement = it.toString();
        Intrinsics.checkNotNullExpressionValue(stackTraceElement, "toString(...)");
        return stackTraceElement;
    }
}