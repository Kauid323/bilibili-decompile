package kotlinx.coroutines.rx3;

import io.reactivex.rxjava3.core.SingleEmitter;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.AbstractCoroutine;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RxSingle.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001b\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0014J\u0015\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0011R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/rx3/RxSingleCoroutine;", "T", "", "Lkotlinx/coroutines/AbstractCoroutine;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "subscriber", "Lio/reactivex/rxjava3/core/SingleEmitter;", "(Lkotlin/coroutines/CoroutineContext;Lio/reactivex/rxjava3/core/SingleEmitter;)V", "onCancelled", "", "cause", "", "handled", "", "onCompleted", "value", "(Ljava/lang/Object;)V", "kotlinx-coroutines-rx3"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RxSingleCoroutine<T> extends AbstractCoroutine<T> {
    private final SingleEmitter<T> subscriber;

    public RxSingleCoroutine(CoroutineContext parentContext, SingleEmitter<T> singleEmitter) {
        super(parentContext, false, true);
        this.subscriber = singleEmitter;
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    protected void onCompleted(T t) {
        try {
            this.subscriber.onSuccess(t);
        } catch (Throwable e) {
            RxCancellableKt.handleUndeliverableException(e, getContext());
        }
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    protected void onCancelled(Throwable cause, boolean handled) {
        try {
            if (this.subscriber.tryOnError(cause)) {
                return;
            }
        } catch (Throwable e) {
            ExceptionsKt.addSuppressed(cause, e);
        }
        RxCancellableKt.handleUndeliverableException(cause, getContext());
    }
}