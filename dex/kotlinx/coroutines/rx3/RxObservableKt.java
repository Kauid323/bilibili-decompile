package kotlinx.coroutines.rx3;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.ProducerScope;

/* compiled from: RxObservable.kt */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aY\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\b\b\u0000\u0010\u0006*\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2/\b\u0001\u0010\n\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000b¢\u0006\u0002\b\u000fø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a_\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\b\b\u0000\u0010\u0006*\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\t2-\u0010\n\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000b¢\u0006\u0002\b\u000fH\u0002ø\u0001\u0000¢\u0006\u0002\u0010\u0014\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"CLOSED", "", "OPEN", "SIGNALLED", "rxObservable", "Lio/reactivex/rxjava3/core/Observable;", "T", "", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)Lio/reactivex/rxjava3/core/Observable;", "rxObservableInternal", "scope", "Lkotlinx/coroutines/CoroutineScope;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)Lio/reactivex/rxjava3/core/Observable;", "kotlinx-coroutines-rx3"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class RxObservableKt {
    private static final int CLOSED = -1;
    private static final int OPEN = 0;
    private static final int SIGNALLED = -2;

    public static /* synthetic */ Observable rxObservable$default(CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return rxObservable(coroutineContext, function2);
    }

    public static final <T> Observable<T> rxObservable(CoroutineContext context, Function2<? super ProducerScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        if (!(context.get(Job.Key) == null)) {
            throw new IllegalArgumentException(("Observable context cannot contain job in it.Its lifecycle should be managed via Disposable handle. Had " + context).toString());
        }
        return rxObservableInternal(GlobalScope.INSTANCE, context, function2);
    }

    private static final <T> Observable<T> rxObservableInternal(final CoroutineScope scope, final CoroutineContext context, final Function2<? super ProducerScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return Observable.create(new ObservableOnSubscribe() { // from class: kotlinx.coroutines.rx3.RxObservableKt$$ExternalSyntheticLambda0
            public final void subscribe(ObservableEmitter observableEmitter) {
                RxObservableKt.rxObservableInternal$lambda$1(CoroutineScope.this, context, function2, observableEmitter);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void rxObservableInternal$lambda$1(CoroutineScope $scope, CoroutineContext $context, Function2 $block, ObservableEmitter subscriber) {
        CoroutineContext newContext = CoroutineContextKt.newCoroutineContext($scope, $context);
        RxObservableCoroutine coroutine = new RxObservableCoroutine(newContext, subscriber);
        subscriber.setCancellable(new RxCancellable(coroutine));
        coroutine.start(CoroutineStart.DEFAULT, coroutine, $block);
    }
}