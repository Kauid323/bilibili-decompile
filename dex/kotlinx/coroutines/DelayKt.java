package kotlinx.coroutines;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* compiled from: Delay.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u000e\u0010\u0005\u001a\u00020\u0006H\u0086@¢\u0006\u0002\u0010\u0007\u001a\u0016\u0010\u0000\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086@¢\u0006\u0002\u0010\u000b\u001a\u001b\u0010\u0000\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000b\u001a\u0016\u0010\u000f\u001a\u00020\n*\u00020\rH\u0000ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0012"}, d2 = {"delay", "Lkotlinx/coroutines/Delay;", "Lkotlin/coroutines/CoroutineContext;", "getDelay", "(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/Delay;", "awaitCancellation", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "timeMillis", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "duration", "Lkotlin/time/Duration;", "delay-VtjQ1oo", "toDelayMillis", "toDelayMillis-LRDsOJo", "(J)J", "kotlinx-coroutines-core"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class DelayKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object awaitCancellation(Continuation<?> continuation) {
        DelayKt$awaitCancellation$1 delayKt$awaitCancellation$1;
        DelayKt$awaitCancellation$1 delayKt$awaitCancellation$12;
        if (continuation instanceof DelayKt$awaitCancellation$1) {
            delayKt$awaitCancellation$1 = (DelayKt$awaitCancellation$1) continuation;
            if ((delayKt$awaitCancellation$1.label & IntCompanionObject.MIN_VALUE) != 0) {
                delayKt$awaitCancellation$1.label -= IntCompanionObject.MIN_VALUE;
                delayKt$awaitCancellation$12 = delayKt$awaitCancellation$1;
                Object $result = delayKt$awaitCancellation$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (delayKt$awaitCancellation$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        delayKt$awaitCancellation$12.label = 1;
                        DelayKt$awaitCancellation$1 uCont$iv = delayKt$awaitCancellation$12;
                        CancellableContinuationImpl cancellable$iv = new CancellableContinuationImpl(IntrinsicsKt.intercepted(uCont$iv), 1);
                        cancellable$iv.initCancellability();
                        Object result = cancellable$iv.getResult();
                        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                            DebugProbesKt.probeCoroutineSuspended(delayKt$awaitCancellation$12);
                        }
                        if (result != coroutine_suspended) {
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    case 1:
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                throw new KotlinNothingValueException();
            }
        }
        delayKt$awaitCancellation$1 = new DelayKt$awaitCancellation$1(continuation);
        delayKt$awaitCancellation$12 = delayKt$awaitCancellation$1;
        Object $result2 = delayKt$awaitCancellation$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (delayKt$awaitCancellation$12.label) {
        }
        throw new KotlinNothingValueException();
    }

    public static final Object delay(long timeMillis, Continuation<? super Unit> continuation) {
        if (timeMillis <= 0) {
            return Unit.INSTANCE;
        }
        CancellableContinuationImpl cancellable$iv = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellable$iv.initCancellability();
        CancellableContinuationImpl cont = cancellable$iv;
        if (timeMillis < LongCompanionObject.MAX_VALUE) {
            getDelay(cont.getContext()).mo1457scheduleResumeAfterDelay(timeMillis, cont);
        }
        Object result = cancellable$iv.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }

    /* renamed from: delay-VtjQ1oo  reason: not valid java name */
    public static final Object m1387delayVtjQ1oo(long duration, Continuation<? super Unit> continuation) {
        Object delay = delay(m1388toDelayMillisLRDsOJo(duration), continuation);
        return delay == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? delay : Unit.INSTANCE;
    }

    public static final Delay getDelay(CoroutineContext $this$delay) {
        CoroutineContext.Element element = $this$delay.get(ContinuationInterceptor.Key);
        Delay delay = element instanceof Delay ? (Delay) element : null;
        return delay == null ? DefaultExecutorKt.getDefaultDelay() : delay;
    }

    /* renamed from: toDelayMillis-LRDsOJo  reason: not valid java name */
    public static final long m1388toDelayMillisLRDsOJo(long $this$toDelayMillis_u2dLRDsOJo) {
        boolean m1272isPositiveimpl = Duration.m1272isPositiveimpl($this$toDelayMillis_u2dLRDsOJo);
        if (m1272isPositiveimpl) {
            Duration.Companion companion = Duration.Companion;
            return Duration.m1256getInWholeMillisecondsimpl(Duration.m1274plusLRDsOJo($this$toDelayMillis_u2dLRDsOJo, DurationKt.toDuration(999999L, DurationUnit.NANOSECONDS)));
        } else if (m1272isPositiveimpl) {
            throw new NoWhenBranchMatchedException();
        } else {
            return 0L;
        }
    }
}