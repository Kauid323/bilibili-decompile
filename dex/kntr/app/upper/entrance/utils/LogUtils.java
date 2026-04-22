package kntr.app.upper.entrance.utils;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.config.IPlatformConfig;
import kntr.base.config.KConfig;
import kntr.base.log.KLog_androidKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LogUtils.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rJ\u0016\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rJ \u0010\u000f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/upper/entrance/utils/LogUtils;", "", "<init>", "()V", "shouldLog", "", "getShouldLog", "()Z", "shouldLog$delegate", "Lkotlin/Lazy;", "i", "", "tag", "", "message", "e", "throwable", "", "entrance_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class LogUtils {
    public static final LogUtils INSTANCE = new LogUtils();
    private static final Lazy shouldLog$delegate = LazyKt.lazy(new Function0() { // from class: kntr.app.upper.entrance.utils.LogUtils$$ExternalSyntheticLambda0
        public final Object invoke() {
            boolean shouldLog_delegate$lambda$0;
            shouldLog_delegate$lambda$0 = LogUtils.shouldLog_delegate$lambda$0();
            return Boolean.valueOf(shouldLog_delegate$lambda$0);
        }
    });

    private LogUtils() {
    }

    private final boolean getShouldLog() {
        return ((Boolean) shouldLog$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean shouldLog_delegate$lambda$0() {
        boolean m2636constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            m2636constructorimpl = Result.m2636constructorimpl(Boolean.valueOf(IPlatformConfig.CC.ff$default(KConfig.INSTANCE, "uper.center_plus_log_switch", false, 2, null)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m2636constructorimpl = Result.m2636constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m2639exceptionOrNullimpl(m2636constructorimpl) != null) {
            m2636constructorimpl = false;
        }
        return ((Boolean) m2636constructorimpl).booleanValue();
    }

    public final void i(String tag, String message) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        if (!getShouldLog()) {
            return;
        }
        KLog_androidKt.getKLog().i(tag, message);
    }

    public final void e(String tag, String message) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        if (!getShouldLog()) {
            return;
        }
        KLog_androidKt.getKLog().e(tag, message);
    }

    public final void e(String tag, String message, Throwable throwable) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        if (!getShouldLog()) {
            return;
        }
        KLog_androidKt.getKLog().e(tag, message, throwable);
    }
}