package kotlinx.coroutines.rx3;

import io.reactivex.rxjava3.core.Flowable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.reactive.PublishKt;

/* compiled from: RxFlowable.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aY\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\b\b\u0000\u0010\u0007*\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032/\b\u0001\u0010\n\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\f\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0001¢\u0006\u0002\b\rø\u0001\u0000¢\u0006\u0002\u0010\u000e\" \u0010\u0000\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"RX_HANDLER", "Lkotlin/Function2;", "", "Lkotlin/coroutines/CoroutineContext;", "", "rxFlowable", "Lio/reactivex/rxjava3/core/Flowable;", "T", "", "context", "block", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)Lio/reactivex/rxjava3/core/Flowable;", "kotlinx-coroutines-rx3"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class RxFlowableKt {
    private static final Function2<Throwable, CoroutineContext, Unit> RX_HANDLER = RxFlowableKt$RX_HANDLER$1.INSTANCE;

    public static /* synthetic */ Flowable rxFlowable$default(CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return rxFlowable(coroutineContext, function2);
    }

    public static final <T> Flowable<T> rxFlowable(CoroutineContext context, Function2<? super ProducerScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        if (!(context.get(Job.Key) == null)) {
            throw new IllegalArgumentException(("Flowable context cannot contain job in it.Its lifecycle should be managed via Disposable handle. Had " + context).toString());
        }
        return Flowable.fromPublisher(PublishKt.publishInternal(GlobalScope.INSTANCE, context, RX_HANDLER, function2));
    }
}