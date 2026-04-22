package kotlinx.coroutines.rx3;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableEmitter;
import io.reactivex.rxjava3.core.CompletableOnSubscribe;
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

/* compiled from: RxCompletable.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aA\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032'\u0010\u0004\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0005¢\u0006\u0002\b\nø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001aI\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00032'\u0010\u0004\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0005¢\u0006\u0002\b\nH\u0002ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"rxCompletable", "Lio/reactivex/rxjava3/core/Completable;", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)Lio/reactivex/rxjava3/core/Completable;", "rxCompletableInternal", "scope", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)Lio/reactivex/rxjava3/core/Completable;", "kotlinx-coroutines-rx3"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class RxCompletableKt {
    public static /* synthetic */ Completable rxCompletable$default(CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return rxCompletable(coroutineContext, function2);
    }

    public static final Completable rxCompletable(CoroutineContext context, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        if (!(context.get(Job.Key) == null)) {
            throw new IllegalArgumentException(("Completable context cannot contain job in it.Its lifecycle should be managed via Disposable handle. Had " + context).toString());
        }
        return rxCompletableInternal(GlobalScope.INSTANCE, context, function2);
    }

    private static final Completable rxCompletableInternal(final CoroutineScope scope, final CoroutineContext context, final Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return Completable.create(new CompletableOnSubscribe() { // from class: kotlinx.coroutines.rx3.RxCompletableKt$$ExternalSyntheticLambda0
            public final void subscribe(CompletableEmitter completableEmitter) {
                RxCompletableKt.rxCompletableInternal$lambda$1(CoroutineScope.this, context, function2, completableEmitter);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void rxCompletableInternal$lambda$1(CoroutineScope $scope, CoroutineContext $context, Function2 $block, CompletableEmitter subscriber) {
        CoroutineContext newContext = CoroutineContextKt.newCoroutineContext($scope, $context);
        RxCompletableCoroutine coroutine = new RxCompletableCoroutine(newContext, subscriber);
        subscriber.setCancellable(new RxCancellable(coroutine));
        coroutine.start(CoroutineStart.DEFAULT, coroutine, $block);
    }
}