package kntr.base.utils.coroutine;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.JobKt;

/* compiled from: RunSuspendCatching.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a(\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0086H¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"runSuspendCatching", "Lkotlin/Result;", "R", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "coroutine_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class RunSuspendCatchingKt {
    public static final <R> Object runSuspendCatching(Function0<? extends R> function0, Continuation<? super Result<? extends R>> continuation) {
        Object m2636constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            m2636constructorimpl = Result.m2636constructorimpl(function0.invoke());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m2636constructorimpl = Result.m2636constructorimpl(ResultKt.createFailure(th));
        }
        JobKt.ensureActive(continuation.getContext());
        return m2636constructorimpl;
    }

    private static final <R> Object runSuspendCatching$$forInline(Function0<? extends R> function0, Continuation<? super Result<? extends R>> continuation) {
        Object m2636constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            m2636constructorimpl = Result.m2636constructorimpl(function0.invoke());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m2636constructorimpl = Result.m2636constructorimpl(ResultKt.createFailure(th));
        }
        Result.m2635boximpl(m2636constructorimpl).m2645unboximpl();
        InlineMarker.mark(3);
        Continuation continuation2 = null;
        continuation2.getContext();
        throw null;
    }
}