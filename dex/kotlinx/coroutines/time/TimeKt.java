package kotlinx.coroutines.time;

import j$.time.Duration;
import j$.time.temporal.ChronoUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.LongCompanionObject;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.selects.OnTimeoutKt;
import kotlinx.coroutines.selects.SelectBuilder;

/* compiled from: Time.kt */
@Metadata(d1 = {"\u0000@\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\u001a\u0018\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0086@¢\u0006\u0004\b\u0003\u0010\u0004\u001a-\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010\u0007\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\b\u0010\t\u001a-\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010\n\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u000b\u0010\t\u001aC\u0010\u0012\u001a\u00020\u0002\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\r2\u0006\u0010\u0001\u001a\u00020\u00002\u001c\u0010\u0011\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000e¢\u0006\u0004\b\u0012\u0010\u0013\u001aT\u0010\u0017\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0001\u001a\u00020\u00002'\u0010\u0011\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0014¢\u0006\u0002\b\u0016H\u0086@\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0004\b\u0017\u0010\u0018\u001aI\u0010\u0019\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0001\u001a\u00020\u00002'\u0010\u0011\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0014¢\u0006\u0002\b\u0016H\u0086@¢\u0006\u0004\b\u0019\u0010\u0018\u001a\u0013\u0010\u001b\u001a\u00020\u001a*\u00020\u0000H\u0002¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"j$/time/Duration", "duration", "", "delay", "(Lj$/time/Duration;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "T", "Lkotlinx/coroutines/flow/Flow;", "timeout", "debounce", "(Lkotlinx/coroutines/flow/Flow;Lj$/time/Duration;)Lkotlinx/coroutines/flow/Flow;", "period", "sample", "R", "Lkotlinx/coroutines/selects/SelectBuilder;", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "block", "onTimeout", "(Lkotlinx/coroutines/selects/SelectBuilder;Lj$/time/Duration;Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/ExtensionFunctionType;", "withTimeout", "(Lj$/time/Duration;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withTimeoutOrNull", "", "coerceToMillis", "(Lj$/time/Duration;)J", "kotlinx-coroutines-core"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class TimeKt {
    public static final Object delay(Duration duration, Continuation<? super Unit> continuation) {
        Object delay = DelayKt.delay(coerceToMillis(duration), continuation);
        return delay == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? delay : Unit.INSTANCE;
    }

    public static final <T> Flow<T> debounce(Flow<? extends T> flow, Duration timeout) {
        return FlowKt.debounce(flow, coerceToMillis(timeout));
    }

    public static final <T> Flow<T> sample(Flow<? extends T> flow, Duration period) {
        return FlowKt.sample(flow, coerceToMillis(period));
    }

    public static final <R> void onTimeout(SelectBuilder<? super R> selectBuilder, Duration duration, Function1<? super Continuation<? super R>, ? extends Object> function1) {
        OnTimeoutKt.onTimeout(selectBuilder, coerceToMillis(duration), function1);
    }

    public static final <T> Object withTimeout(Duration duration, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        return TimeoutKt.withTimeout(coerceToMillis(duration), function2, continuation);
    }

    public static final <T> Object withTimeoutOrNull(Duration duration, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        return TimeoutKt.withTimeoutOrNull(coerceToMillis(duration), function2, continuation);
    }

    private static final long coerceToMillis(Duration $this$coerceToMillis) {
        if ($this$coerceToMillis.compareTo(Duration.ZERO) <= 0) {
            return 0L;
        }
        if ($this$coerceToMillis.compareTo(ChronoUnit.MILLIS.getDuration()) <= 0) {
            return 1L;
        }
        if ($this$coerceToMillis.getSeconds() < 9223372036854775L || ($this$coerceToMillis.getSeconds() == 9223372036854775L && $this$coerceToMillis.getNano() < 807000000)) {
            return $this$coerceToMillis.toMillis();
        }
        return LongCompanionObject.MAX_VALUE;
    }
}