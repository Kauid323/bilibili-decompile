package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.IntCompanionObject;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.SystemPropsKt__SystemProps_commonKt;

/* compiled from: Semaphore.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u0004\u001a\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\rH\u0002\u001a3\u0010\u0011\u001a\u0002H\u0012\"\u0004\b\u0000\u0010\u0012*\u00020\t2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0014H\u0086H\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0015\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"BROKEN", "Lkotlinx/coroutines/internal/Symbol;", "CANCELLED", "MAX_SPIN_CYCLES", "", "PERMIT", "SEGMENT_SIZE", "TAKEN", "Semaphore", "Lkotlinx/coroutines/sync/Semaphore;", "permits", "acquiredPermits", "createSegment", "Lkotlinx/coroutines/sync/SemaphoreSegment;", "id", "", "prev", "withPermit", "T", "action", "Lkotlin/Function0;", "(Lkotlinx/coroutines/sync/Semaphore;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class SemaphoreKt {
    private static final Symbol BROKEN;
    private static final Symbol CANCELLED;
    private static final int MAX_SPIN_CYCLES;
    private static final Symbol PERMIT;
    private static final int SEGMENT_SIZE;
    private static final Symbol TAKEN;

    public static final Semaphore Semaphore(int permits, int acquiredPermits) {
        return new SemaphoreImpl(permits, acquiredPermits);
    }

    public static /* synthetic */ Semaphore Semaphore$default(int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return Semaphore(i, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object withPermit(Semaphore $this$withPermit, Function0<? extends T> function0, Continuation<? super T> continuation) {
        SemaphoreKt$withPermit$1 semaphoreKt$withPermit$1;
        SemaphoreKt$withPermit$1 semaphoreKt$withPermit$12;
        Semaphore $this$withPermit2;
        try {
            if (continuation instanceof SemaphoreKt$withPermit$1) {
                semaphoreKt$withPermit$1 = (SemaphoreKt$withPermit$1) continuation;
                if ((semaphoreKt$withPermit$1.label & IntCompanionObject.MIN_VALUE) != 0) {
                    semaphoreKt$withPermit$1.label -= IntCompanionObject.MIN_VALUE;
                    semaphoreKt$withPermit$12 = semaphoreKt$withPermit$1;
                    Object $result = semaphoreKt$withPermit$12.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (semaphoreKt$withPermit$12.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            semaphoreKt$withPermit$12.L$0 = $this$withPermit;
                            semaphoreKt$withPermit$12.L$1 = function0;
                            semaphoreKt$withPermit$12.label = 1;
                            if ($this$withPermit.acquire(semaphoreKt$withPermit$12) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $this$withPermit2 = $this$withPermit;
                            break;
                        case 1:
                            function0 = (Function0) semaphoreKt$withPermit$12.L$1;
                            $this$withPermit2 = (Semaphore) semaphoreKt$withPermit$12.L$0;
                            ResultKt.throwOnFailure($result);
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    T invoke = function0.invoke();
                    InlineMarker.finallyStart(1);
                    $this$withPermit2.release();
                    InlineMarker.finallyEnd(1);
                    return invoke;
                }
            }
            T invoke2 = function0.invoke();
            InlineMarker.finallyStart(1);
            $this$withPermit2.release();
            InlineMarker.finallyEnd(1);
            return invoke2;
        } catch (Throwable th) {
            InlineMarker.finallyStart(1);
            $this$withPermit2.release();
            InlineMarker.finallyEnd(1);
            throw th;
        }
        semaphoreKt$withPermit$1 = new SemaphoreKt$withPermit$1(continuation);
        semaphoreKt$withPermit$12 = semaphoreKt$withPermit$1;
        Object $result2 = semaphoreKt$withPermit$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (semaphoreKt$withPermit$12.label) {
        }
    }

    private static final <T> Object withPermit$$forInline(Semaphore $this$withPermit, Function0<? extends T> function0, Continuation<? super T> continuation) {
        InlineMarker.mark(0);
        $this$withPermit.acquire(continuation);
        InlineMarker.mark(1);
        try {
            return function0.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            $this$withPermit.release();
            InlineMarker.finallyEnd(1);
        }
    }

    public static final SemaphoreSegment createSegment(long id, SemaphoreSegment prev) {
        return new SemaphoreSegment(id, prev, 0);
    }

    static {
        int systemProp$default;
        int systemProp$default2;
        systemProp$default = SystemPropsKt__SystemProps_commonKt.systemProp$default("kotlinx.coroutines.semaphore.maxSpinCycles", 100, 0, 0, 12, (Object) null);
        MAX_SPIN_CYCLES = systemProp$default;
        PERMIT = new Symbol("PERMIT");
        TAKEN = new Symbol("TAKEN");
        BROKEN = new Symbol("BROKEN");
        CANCELLED = new Symbol("CANCELLED");
        systemProp$default2 = SystemPropsKt__SystemProps_commonKt.systemProp$default("kotlinx.coroutines.semaphore.segmentSize", 16, 0, 0, 12, (Object) null);
        SEGMENT_SIZE = systemProp$default2;
    }
}