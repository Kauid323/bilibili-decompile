package kotlinx.coroutines.rx3;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

/* compiled from: RxAwait.kt */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0003\u001a(\u0010\u0000\u001a\u0004\u0018\u0001H\u0004\"\u0004\b\u0000\u0010\u0004*\n\u0012\u0006\u0012\u0004\b\u0002H\u00040\u0005H\u0087@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\u0010\u0006\u001a&\u0010\u0000\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u0004*\n\u0012\u0006\u0012\u0004\b\u0002H\u00040\u0007H\u0086@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\u0010\b\u001a&\u0010\t\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u0004*\n\u0012\u0006\u0012\u0004\b\u0002H\u00040\nH\u0086@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\u0010\u000b\u001a.\u0010\f\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u0004*\n\u0012\u0006\u0012\u0004\b\u0002H\u00040\n2\u0006\u0010\r\u001a\u0002H\u0004H\u0086@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\u0010\u000e\u001a4\u0010\u000f\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u0004*\n\u0012\u0006\u0012\u0004\b\u0002H\u00040\n2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0011H\u0086@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\u0010\u0012\u001a(\u0010\u0013\u001a\u0004\u0018\u0001H\u0004\"\u0004\b\u0000\u0010\u0004*\n\u0012\u0006\u0012\u0004\b\u0002H\u00040\nH\u0086@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\u0010\u000b\u001a&\u0010\u0014\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u0004*\n\u0012\u0006\u0012\u0004\b\u0002H\u00040\nH\u0086@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\u0010\u000b\u001a<\u0010\u0015\u001a\u0004\u0018\u0001H\u0004\"\u0004\b\u0000\u0010\u0004*\n\u0012\u0006\u0012\u0004\b\u0002H\u00040\n2\u0006\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\r\u001a\u0004\u0018\u0001H\u0004H\u0082@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\u0010\u0018\u001a.\u0010\u0019\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u0004*\n\u0012\u0006\u0012\u0004\b\u0002H\u00040\u00052\u0006\u0010\r\u001a\u0002H\u0004H\u0087@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\u0010\u001a\u001a&\u0010\u001b\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u0004*\n\u0012\u0006\u0012\u0004\b\u0002H\u00040\u0005H\u0086@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\u0010\u0006\u001a&\u0010\u001b\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u0004*\n\u0012\u0006\u0012\u0004\b\u0002H\u00040\nH\u0086@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\u0010\u000b\u001a(\u0010\u001c\u001a\u0004\u0018\u0001H\u0004\"\u0004\b\u0000\u0010\u0004*\n\u0012\u0006\u0012\u0004\b\u0002H\u00040\u0005H\u0086@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\u0010\u0006\u001a\u0018\u0010\u001d\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b9¨\u0006!"}, d2 = {"await", "", "Lio/reactivex/rxjava3/core/CompletableSource;", "(Lio/reactivex/rxjava3/core/CompletableSource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "T", "Lio/reactivex/rxjava3/core/MaybeSource;", "(Lio/reactivex/rxjava3/core/MaybeSource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/reactivex/rxjava3/core/SingleSource;", "(Lio/reactivex/rxjava3/core/SingleSource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitFirst", "Lio/reactivex/rxjava3/core/ObservableSource;", "(Lio/reactivex/rxjava3/core/ObservableSource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitFirstOrDefault", "default", "(Lio/reactivex/rxjava3/core/ObservableSource;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitFirstOrElse", "defaultValue", "Lkotlin/Function0;", "(Lio/reactivex/rxjava3/core/ObservableSource;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitFirstOrNull", "awaitLast", "awaitOne", "mode", "Lkotlinx/coroutines/rx3/Mode;", "(Lio/reactivex/rxjava3/core/ObservableSource;Lkotlinx/coroutines/rx3/Mode;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitOrDefault", "(Lio/reactivex/rxjava3/core/MaybeSource;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitSingle", "awaitSingleOrNull", "disposeOnCancellation", "Lkotlinx/coroutines/CancellableContinuation;", "d", "Lio/reactivex/rxjava3/disposables/Disposable;", "kotlinx-coroutines-rx3"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class RxAwaitKt {
    public static final Object await(CompletableSource $this$await, Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellable$iv = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellable$iv.initCancellability();
        final CancellableContinuationImpl cont = cancellable$iv;
        $this$await.subscribe(new CompletableObserver() { // from class: kotlinx.coroutines.rx3.RxAwaitKt$await$2$1
            public void onSubscribe(Disposable d) {
                RxAwaitKt.disposeOnCancellation(cont, d);
            }

            public void onComplete() {
                Result.Companion companion = Result.Companion;
                cont.resumeWith(Result.constructor-impl(Unit.INSTANCE));
            }

            public void onError(Throwable e) {
                Result.Companion companion = Result.Companion;
                cont.resumeWith(Result.constructor-impl(ResultKt.createFailure(e)));
            }
        });
        Object result = cancellable$iv.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }

    public static final <T> Object awaitSingleOrNull(MaybeSource<T> maybeSource, Continuation<? super T> continuation) {
        CancellableContinuationImpl cancellable$iv = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellable$iv.initCancellability();
        final CancellableContinuationImpl cont = cancellable$iv;
        maybeSource.subscribe(new MaybeObserver<T>() { // from class: kotlinx.coroutines.rx3.RxAwaitKt$awaitSingleOrNull$2$1
            public void onSubscribe(Disposable d) {
                RxAwaitKt.disposeOnCancellation(cont, d);
            }

            public void onComplete() {
                Result.Companion companion = Result.Companion;
                cont.resumeWith(Result.constructor-impl((Object) null));
            }

            public void onSuccess(T t) {
                Result.Companion companion = Result.Companion;
                cont.resumeWith(Result.constructor-impl(t));
            }

            public void onError(Throwable error) {
                Result.Companion companion = Result.Companion;
                cont.resumeWith(Result.constructor-impl(ResultKt.createFailure(error)));
            }
        });
        Object result = cancellable$iv.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0041 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object awaitSingle(MaybeSource<T> maybeSource, Continuation<? super T> continuation) {
        RxAwaitKt$awaitSingle$1 rxAwaitKt$awaitSingle$1;
        RxAwaitKt$awaitSingle$1 rxAwaitKt$awaitSingle$12;
        Object awaitSingleOrNull;
        if (continuation instanceof RxAwaitKt$awaitSingle$1) {
            rxAwaitKt$awaitSingle$1 = (RxAwaitKt$awaitSingle$1) continuation;
            if ((rxAwaitKt$awaitSingle$1.label & IntCompanionObject.MIN_VALUE) != 0) {
                rxAwaitKt$awaitSingle$1.label -= IntCompanionObject.MIN_VALUE;
                rxAwaitKt$awaitSingle$12 = rxAwaitKt$awaitSingle$1;
                Object $result = rxAwaitKt$awaitSingle$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (rxAwaitKt$awaitSingle$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        rxAwaitKt$awaitSingle$12.label = 1;
                        awaitSingleOrNull = awaitSingleOrNull(maybeSource, rxAwaitKt$awaitSingle$12);
                        if (awaitSingleOrNull == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        awaitSingleOrNull = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (awaitSingleOrNull == null) {
                    return awaitSingleOrNull;
                }
                throw new NoSuchElementException();
            }
        }
        rxAwaitKt$awaitSingle$1 = new RxAwaitKt$awaitSingle$1(continuation);
        rxAwaitKt$awaitSingle$12 = rxAwaitKt$awaitSingle$1;
        Object $result2 = rxAwaitKt$awaitSingle$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (rxAwaitKt$awaitSingle$12.label) {
        }
        if (awaitSingleOrNull == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in favor of awaitSingleOrNull()", replaceWith = @ReplaceWith(expression = "this.awaitSingleOrNull() ?: default", imports = {}))
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object awaitOrDefault(MaybeSource $this$awaitOrDefault, Object obj, Continuation continuation) {
        RxAwaitKt$awaitOrDefault$1 rxAwaitKt$awaitOrDefault$1;
        RxAwaitKt$awaitOrDefault$1 rxAwaitKt$awaitOrDefault$12;
        Object awaitSingleOrNull;
        if (continuation instanceof RxAwaitKt$awaitOrDefault$1) {
            rxAwaitKt$awaitOrDefault$1 = (RxAwaitKt$awaitOrDefault$1) continuation;
            if ((rxAwaitKt$awaitOrDefault$1.label & IntCompanionObject.MIN_VALUE) != 0) {
                rxAwaitKt$awaitOrDefault$1.label -= IntCompanionObject.MIN_VALUE;
                rxAwaitKt$awaitOrDefault$12 = rxAwaitKt$awaitOrDefault$1;
                Object $result = rxAwaitKt$awaitOrDefault$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (rxAwaitKt$awaitOrDefault$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        rxAwaitKt$awaitOrDefault$12.L$0 = obj;
                        rxAwaitKt$awaitOrDefault$12.label = 1;
                        awaitSingleOrNull = awaitSingleOrNull($this$awaitOrDefault, rxAwaitKt$awaitOrDefault$12);
                        if (awaitSingleOrNull == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        Object obj2 = rxAwaitKt$awaitOrDefault$12.L$0;
                        ResultKt.throwOnFailure($result);
                        obj = obj2;
                        awaitSingleOrNull = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return awaitSingleOrNull != null ? obj : awaitSingleOrNull;
            }
        }
        rxAwaitKt$awaitOrDefault$1 = new RxAwaitKt$awaitOrDefault$1(continuation);
        rxAwaitKt$awaitOrDefault$12 = rxAwaitKt$awaitOrDefault$1;
        Object $result2 = rxAwaitKt$awaitOrDefault$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (rxAwaitKt$awaitOrDefault$12.label) {
        }
        if (awaitSingleOrNull != null) {
        }
    }

    public static final <T> Object await(SingleSource<T> singleSource, Continuation<? super T> continuation) {
        CancellableContinuationImpl cancellable$iv = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellable$iv.initCancellability();
        final CancellableContinuationImpl cont = cancellable$iv;
        singleSource.subscribe(new SingleObserver<T>() { // from class: kotlinx.coroutines.rx3.RxAwaitKt$await$5$1
            public void onSubscribe(Disposable d) {
                RxAwaitKt.disposeOnCancellation(cont, d);
            }

            public void onSuccess(T t) {
                Result.Companion companion = Result.Companion;
                cont.resumeWith(Result.constructor-impl(t));
            }

            public void onError(Throwable error) {
                Result.Companion companion = Result.Companion;
                cont.resumeWith(Result.constructor-impl(ResultKt.createFailure(error)));
            }
        });
        Object result = cancellable$iv.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public static final <T> Object awaitFirst(ObservableSource<T> observableSource, Continuation<? super T> continuation) {
        Object awaitOne$default = awaitOne$default(observableSource, Mode.FIRST, null, continuation, 2, null);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return awaitOne$default;
    }

    public static final <T> Object awaitFirstOrDefault(ObservableSource<T> observableSource, T t, Continuation<? super T> continuation) {
        Object awaitOne = awaitOne(observableSource, Mode.FIRST_OR_DEFAULT, t, continuation);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return awaitOne;
    }

    public static final <T> Object awaitFirstOrNull(ObservableSource<T> observableSource, Continuation<? super T> continuation) {
        return awaitOne$default(observableSource, Mode.FIRST_OR_DEFAULT, null, continuation, 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object awaitFirstOrElse(ObservableSource<T> observableSource, Function0<? extends T> function0, Continuation<? super T> continuation) {
        RxAwaitKt$awaitFirstOrElse$1 rxAwaitKt$awaitFirstOrElse$1;
        RxAwaitKt$awaitFirstOrElse$1 rxAwaitKt$awaitFirstOrElse$12;
        Function0 defaultValue;
        Object awaitOne$default;
        if (continuation instanceof RxAwaitKt$awaitFirstOrElse$1) {
            rxAwaitKt$awaitFirstOrElse$1 = (RxAwaitKt$awaitFirstOrElse$1) continuation;
            if ((rxAwaitKt$awaitFirstOrElse$1.label & IntCompanionObject.MIN_VALUE) != 0) {
                rxAwaitKt$awaitFirstOrElse$1.label -= IntCompanionObject.MIN_VALUE;
                rxAwaitKt$awaitFirstOrElse$12 = rxAwaitKt$awaitFirstOrElse$1;
                Object $result = rxAwaitKt$awaitFirstOrElse$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (rxAwaitKt$awaitFirstOrElse$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        defaultValue = function0;
                        Mode mode = Mode.FIRST_OR_DEFAULT;
                        rxAwaitKt$awaitFirstOrElse$12.L$0 = defaultValue;
                        rxAwaitKt$awaitFirstOrElse$12.label = 1;
                        awaitOne$default = awaitOne$default(observableSource, mode, null, rxAwaitKt$awaitFirstOrElse$12, 2, null);
                        if (awaitOne$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        defaultValue = (Function0) rxAwaitKt$awaitFirstOrElse$12.L$0;
                        ResultKt.throwOnFailure($result);
                        awaitOne$default = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return awaitOne$default != null ? defaultValue.invoke() : awaitOne$default;
            }
        }
        rxAwaitKt$awaitFirstOrElse$1 = new RxAwaitKt$awaitFirstOrElse$1(continuation);
        rxAwaitKt$awaitFirstOrElse$12 = rxAwaitKt$awaitFirstOrElse$1;
        Object $result2 = rxAwaitKt$awaitFirstOrElse$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (rxAwaitKt$awaitFirstOrElse$12.label) {
        }
        if (awaitOne$default != null) {
        }
    }

    public static final <T> Object awaitLast(ObservableSource<T> observableSource, Continuation<? super T> continuation) {
        Object awaitOne$default = awaitOne$default(observableSource, Mode.LAST, null, continuation, 2, null);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return awaitOne$default;
    }

    public static final <T> Object awaitSingle(ObservableSource<T> observableSource, Continuation<? super T> continuation) {
        Object awaitOne$default = awaitOne$default(observableSource, Mode.SINGLE, null, continuation, 2, null);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return awaitOne$default;
    }

    public static final void disposeOnCancellation(CancellableContinuation<?> cancellableContinuation, final Disposable d) {
        cancellableContinuation.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.rx3.RxAwaitKt$disposeOnCancellation$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                d.dispose();
            }
        });
    }

    static /* synthetic */ Object awaitOne$default(ObservableSource observableSource, Mode mode, Object obj, Continuation continuation, int i, Object obj2) {
        if ((i & 2) != 0) {
            obj = null;
        }
        return awaitOne(observableSource, mode, obj, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> Object awaitOne(ObservableSource<T> observableSource, final Mode mode, final T t, Continuation<? super T> continuation) {
        CancellableContinuationImpl cancellable$iv = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellable$iv.initCancellability();
        final CancellableContinuationImpl cont = cancellable$iv;
        observableSource.subscribe(new Observer<T>() { // from class: kotlinx.coroutines.rx3.RxAwaitKt$awaitOne$2$1
            private boolean seenValue;
            private Disposable subscription;
            private T value;

            /* compiled from: RxAwait.kt */
            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
            /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[Mode.values().length];
                    try {
                        iArr[Mode.FIRST.ordinal()] = 1;
                    } catch (NoSuchFieldError e) {
                    }
                    try {
                        iArr[Mode.FIRST_OR_DEFAULT.ordinal()] = 2;
                    } catch (NoSuchFieldError e2) {
                    }
                    try {
                        iArr[Mode.LAST.ordinal()] = 3;
                    } catch (NoSuchFieldError e3) {
                    }
                    try {
                        iArr[Mode.SINGLE.ordinal()] = 4;
                    } catch (NoSuchFieldError e4) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            public void onSubscribe(final Disposable sub) {
                this.subscription = sub;
                cont.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.rx3.RxAwaitKt$awaitOne$2$1$onSubscribe$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                        invoke2(th);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(Throwable it) {
                        sub.dispose();
                    }
                });
            }

            public void onNext(T t2) {
                Disposable disposable = null;
                switch (WhenMappings.$EnumSwitchMapping$0[mode.ordinal()]) {
                    case 1:
                    case 2:
                        if (!this.seenValue) {
                            this.seenValue = true;
                            Result.Companion companion = Result.Companion;
                            cont.resumeWith(Result.constructor-impl(t2));
                            Disposable disposable2 = this.subscription;
                            if (disposable2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("subscription");
                            } else {
                                disposable = disposable2;
                            }
                            disposable.dispose();
                            return;
                        }
                        return;
                    case 3:
                    case 4:
                        if (mode == Mode.SINGLE && this.seenValue) {
                            if (cont.isActive()) {
                                Result.Companion companion2 = Result.Companion;
                                cont.resumeWith(Result.constructor-impl(ResultKt.createFailure(new IllegalArgumentException("More than one onNext value for " + mode))));
                            }
                            Disposable disposable3 = this.subscription;
                            if (disposable3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("subscription");
                            } else {
                                disposable = disposable3;
                            }
                            disposable.dispose();
                            return;
                        }
                        this.value = t2;
                        this.seenValue = true;
                        return;
                    default:
                        return;
                }
            }

            public void onComplete() {
                if (this.seenValue) {
                    if (cont.isActive()) {
                        Result.Companion companion = Result.Companion;
                        cont.resumeWith(Result.constructor-impl(this.value));
                    }
                } else if (mode == Mode.FIRST_OR_DEFAULT) {
                    Result.Companion companion2 = Result.Companion;
                    cont.resumeWith(Result.constructor-impl(t));
                } else if (cont.isActive()) {
                    Result.Companion companion3 = Result.Companion;
                    cont.resumeWith(Result.constructor-impl(ResultKt.createFailure(new NoSuchElementException("No value received via onNext for " + mode))));
                }
            }

            public void onError(Throwable e) {
                Result.Companion companion = Result.Companion;
                cont.resumeWith(Result.constructor-impl(ResultKt.createFailure(e)));
            }
        });
        Object result = cancellable$iv.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}