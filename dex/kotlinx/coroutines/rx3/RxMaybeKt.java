package kotlinx.coroutines.rx3;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeEmitter;
import io.reactivex.rxjava3.core.MaybeOnSubscribe;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

/* compiled from: RxMaybe.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aT\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\b\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042)\u0010\u0005\u001a%\b\u0001\u0012\u0004\u0012\u00020\u0007\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006¢\u0006\u0002\b\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\u0010\u000b\u001a\\\u0010\f\u001a\n\u0012\u0006\u0012\u0004\b\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00042)\u0010\u0005\u001a%\b\u0001\u0012\u0004\u0012\u00020\u0007\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006¢\u0006\u0002\b\nH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\u0010\u000e\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b9¨\u0006\u000f"}, d2 = {"rxMaybe", "Lio/reactivex/rxjava3/core/Maybe;", "T", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)Lio/reactivex/rxjava3/core/Maybe;", "rxMaybeInternal", "scope", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)Lio/reactivex/rxjava3/core/Maybe;", "kotlinx-coroutines-rx3"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class RxMaybeKt {
    public static /* synthetic */ Maybe rxMaybe$default(CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return rxMaybe(coroutineContext, function2);
    }

    public static final <T> Maybe<T> rxMaybe(CoroutineContext context, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) {
        if (!(context.get(Job.Key) == null)) {
            throw new IllegalArgumentException(("Maybe context cannot contain job in it.Its lifecycle should be managed via Disposable handle. Had " + context).toString());
        }
        return rxMaybeInternal(GlobalScope.INSTANCE, context, function2);
    }

    private static final <T> Maybe<T> rxMaybeInternal(final CoroutineScope scope, final CoroutineContext context, final Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) {
        return Maybe.create(new MaybeOnSubscribe() { // from class: kotlinx.coroutines.rx3.RxMaybeKt$$ExternalSyntheticLambda0
            public final void subscribe(MaybeEmitter maybeEmitter) {
                RxMaybeKt.rxMaybeInternal$lambda$1(CoroutineScope.this, context, function2, maybeEmitter);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void rxMaybeInternal$lambda$1(CoroutineScope $scope, CoroutineContext $context, Function2 $block, MaybeEmitter subscriber) {
        CoroutineContext newContext = CoroutineContextKt.newCoroutineContext($scope, $context);
        RxMaybeCoroutine coroutine = new RxMaybeCoroutine(newContext, subscriber);
        subscriber.setCancellable(new RxCancellable(coroutine));
        coroutine.start(CoroutineStart.DEFAULT, coroutine, $block);
    }
}