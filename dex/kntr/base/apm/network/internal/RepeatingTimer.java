package kntr.base.apm.network.internal;

import java.util.concurrent.CancellationException;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.atomicfu.AtomicFU;
import kotlinx.atomicfu.AtomicInt;
import kotlinx.atomicfu.AtomicRef;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* compiled from: RepeatingTimer.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J>\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\f0\u00122\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0014J\u0013\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\f0\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lkntr/base/apm/network/internal/RepeatingTimer;", "", "<init>", "()V", "count", "Lkotlinx/atomicfu/AtomicInt;", "jobRef", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/Job;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "start", "", "intervalMillis", "", "repeatCount", "", "onTick", "Lkotlin/Function1;", "onStop", "Lkotlin/Function0;", "stop", "Lkotlin/Result;", "stop-d1pmJ48", "()Ljava/lang/Object;", "network_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class RepeatingTimer {
    private final AtomicInt count = AtomicFU.atomic(0);
    private final AtomicRef<Job> jobRef = AtomicFU.atomic((Object) null);
    private final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault());

    public static /* synthetic */ void start$default(RepeatingTimer repeatingTimer, long j, int i, Function1 function1, Function0 function0, int i2, Object obj) {
        int i3;
        Function0 function02;
        if ((i2 & 2) == 0) {
            i3 = i;
        } else {
            i3 = Integer.MAX_VALUE;
        }
        if ((i2 & 8) == 0) {
            function02 = function0;
        } else {
            function02 = null;
        }
        repeatingTimer.start(j, i3, function1, function02);
    }

    public final void start(long intervalMillis, int repeatCount, Function1<? super Integer, Unit> function1, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function1, "onTick");
        if (this.jobRef.getValue() != null) {
            return;
        }
        this.jobRef.setValue(BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new RepeatingTimer$start$1(intervalMillis, repeatCount, this, function1, function0, null), 3, (Object) null));
    }

    /* renamed from: stop-d1pmJ48  reason: not valid java name */
    public final Object m1348stopd1pmJ48() {
        Object m2636constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            RepeatingTimer $this$stop_d1pmJ48_u24lambda_u240 = this;
            Job job = (Job) $this$stop_d1pmJ48_u24lambda_u240.jobRef.getAndSet((Object) null);
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            $this$stop_d1pmJ48_u24lambda_u240.count.setValue(0);
            CoroutineScopeKt.cancel$default($this$stop_d1pmJ48_u24lambda_u240.scope, (CancellationException) null, 1, (Object) null);
            m2636constructorimpl = Result.m2636constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m2636constructorimpl = Result.m2636constructorimpl(ResultKt.createFailure(th));
        }
        Throwable it = Result.m2639exceptionOrNullimpl(m2636constructorimpl);
        if (it != null && !(it instanceof CancellationException)) {
            UtilsKt.logE("timer", "stop", it);
        }
        return m2636constructorimpl;
    }
}