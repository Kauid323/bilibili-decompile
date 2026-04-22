package im.base;

import im.base.IMLog;
import kntr.base.log.KLogKt;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMLog.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lim/base/IMLog;", "", "<init>", "()V", "Companion", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMLog {
    public static final Companion Companion = new Companion(null);
    private static final String IM_LOG_TAG = "InstantMessage";

    /* compiled from: IMLog.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005J\u0016\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005J\"\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rJ\u0016\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005J\u001c\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fJ\u0016\u0010\u0010\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lim/base/IMLog$Companion;", "", "<init>", "()V", "IM_LOG_TAG", "", "i", "", "module", "message", "w", "e", "throwable", "", "d", "Lkotlin/Function0;", "v", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void i(String module, String message) {
            Intrinsics.checkNotNullParameter(module, "module");
            Intrinsics.checkNotNullParameter(message, "message");
            KLog_androidKt.getKLog().i(IMLog_androidKt.logTag(IMLog.IM_LOG_TAG, module), IMLog_androidKt.logMessage(module, message));
        }

        public final void w(String module, String message) {
            Intrinsics.checkNotNullParameter(module, "module");
            Intrinsics.checkNotNullParameter(message, "message");
            KLog_androidKt.getKLog().w(IMLog_androidKt.logTag(IMLog.IM_LOG_TAG, module), IMLog_androidKt.logMessage(module, message));
        }

        public static /* synthetic */ void e$default(Companion companion, String str, String str2, Throwable th, int i2, Object obj) {
            if ((i2 & 4) != 0) {
                th = null;
            }
            companion.e(str, str2, th);
        }

        public final void e(String module, String message, Throwable throwable) {
            Intrinsics.checkNotNullParameter(module, "module");
            Intrinsics.checkNotNullParameter(message, "message");
            KLog_androidKt.getKLog().e(IMLog_androidKt.logTag(IMLog.IM_LOG_TAG, module), IMLog_androidKt.logMessage(module, message), throwable);
        }

        public final void d(String module, String message) {
            Intrinsics.checkNotNullParameter(module, "module");
            Intrinsics.checkNotNullParameter(message, "message");
            KLog_androidKt.getKLog().d(IMLog_androidKt.logTag(IMLog.IM_LOG_TAG, module), IMLog_androidKt.logMessage(module, message));
        }

        public final void d(final String module, final Function0<String> function0) {
            Intrinsics.checkNotNullParameter(module, "module");
            Intrinsics.checkNotNullParameter(function0, "message");
            KLogKt.d(KLog_androidKt.getKLog(), IMLog_androidKt.logTag(IMLog.IM_LOG_TAG, module), new Function0() { // from class: im.base.IMLog$Companion$$ExternalSyntheticLambda0
                public final Object invoke() {
                    String d$lambda$0;
                    d$lambda$0 = IMLog.Companion.d$lambda$0(module, function0);
                    return d$lambda$0;
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String d$lambda$0(String $module, Function0 $message) {
            return IMLog_androidKt.logMessage($module, (String) $message.invoke());
        }

        public final void v(String module, String message) {
            Intrinsics.checkNotNullParameter(module, "module");
            Intrinsics.checkNotNullParameter(message, "message");
            KLog_androidKt.getKLog().v(IMLog_androidKt.logTag(IMLog.IM_LOG_TAG, module), IMLog_androidKt.logMessage(module, message));
        }
    }
}