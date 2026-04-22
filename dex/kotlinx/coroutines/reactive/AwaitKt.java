package kotlinx.coroutines.reactive;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.IntCompanionObject;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import org.reactivestreams.Publisher;

/* compiled from: Await.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001a\u001e\u0010\t\u001a\u0002H\n\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000bH\u0086@¢\u0006\u0002\u0010\f\u001a&\u0010\r\u001a\u0002H\n\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000b2\u0006\u0010\u000e\u001a\u0002H\nH\u0086@¢\u0006\u0002\u0010\u000f\u001a,\u0010\u0010\u001a\u0002H\n\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\n0\u0012H\u0086@¢\u0006\u0002\u0010\u0013\u001a \u0010\u0014\u001a\u0004\u0018\u0001H\n\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000bH\u0086@¢\u0006\u0002\u0010\f\u001a\u001e\u0010\u0015\u001a\u0002H\n\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000bH\u0086@¢\u0006\u0002\u0010\f\u001a2\u0010\u0016\u001a\u0002H\n\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000b2\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u0001H\nH\u0082@¢\u0006\u0002\u0010\u0017\u001a\u001e\u0010\u0018\u001a\u0002H\n\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000bH\u0086@¢\u0006\u0002\u0010\f\u001a&\u0010\u0019\u001a\u0002H\n\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000b2\u0006\u0010\u000e\u001a\u0002H\nH\u0087@¢\u0006\u0002\u0010\u000f\u001a,\u0010\u001a\u001a\u0002H\n\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\n0\u0012H\u0087@¢\u0006\u0002\u0010\u0013\u001a \u0010\u001b\u001a\u0004\u0018\u0001H\n\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000bH\u0087@¢\u0006\u0002\u0010\f¨\u0006\u001c"}, d2 = {"gotSignalInTerminalStateException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "signalName", "", "moreThanOneValueProvidedException", "mode", "Lkotlinx/coroutines/reactive/Mode;", "awaitFirst", "T", "Lorg/reactivestreams/Publisher;", "(Lorg/reactivestreams/Publisher;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitFirstOrDefault", "default", "(Lorg/reactivestreams/Publisher;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitFirstOrElse", "defaultValue", "Lkotlin/Function0;", "(Lorg/reactivestreams/Publisher;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitFirstOrNull", "awaitLast", "awaitOne", "(Lorg/reactivestreams/Publisher;Lkotlinx/coroutines/reactive/Mode;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitSingle", "awaitSingleOrDefault", "awaitSingleOrElse", "awaitSingleOrNull", "kotlinx-coroutines-reactive"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class AwaitKt {
    public static final <T> Object awaitFirst(Publisher<T> publisher, Continuation<? super T> continuation) {
        return awaitOne$default(publisher, Mode.FIRST, null, continuation, 2, null);
    }

    public static final <T> Object awaitFirstOrDefault(Publisher<T> publisher, T t, Continuation<? super T> continuation) {
        return awaitOne(publisher, Mode.FIRST_OR_DEFAULT, t, continuation);
    }

    public static final <T> Object awaitFirstOrNull(Publisher<T> publisher, Continuation<? super T> continuation) {
        return awaitOne$default(publisher, Mode.FIRST_OR_DEFAULT, null, continuation, 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object awaitFirstOrElse(Publisher<T> publisher, Function0<? extends T> function0, Continuation<? super T> continuation) {
        AwaitKt$awaitFirstOrElse$1 awaitKt$awaitFirstOrElse$1;
        AwaitKt$awaitFirstOrElse$1 awaitKt$awaitFirstOrElse$12;
        Function0 defaultValue;
        Object awaitOne$default;
        if (continuation instanceof AwaitKt$awaitFirstOrElse$1) {
            awaitKt$awaitFirstOrElse$1 = (AwaitKt$awaitFirstOrElse$1) continuation;
            if ((awaitKt$awaitFirstOrElse$1.label & IntCompanionObject.MIN_VALUE) != 0) {
                awaitKt$awaitFirstOrElse$1.label -= IntCompanionObject.MIN_VALUE;
                awaitKt$awaitFirstOrElse$12 = awaitKt$awaitFirstOrElse$1;
                Object $result = awaitKt$awaitFirstOrElse$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (awaitKt$awaitFirstOrElse$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        defaultValue = function0;
                        Mode mode = Mode.FIRST_OR_DEFAULT;
                        awaitKt$awaitFirstOrElse$12.L$0 = defaultValue;
                        awaitKt$awaitFirstOrElse$12.label = 1;
                        awaitOne$default = awaitOne$default(publisher, mode, null, awaitKt$awaitFirstOrElse$12, 2, null);
                        if (awaitOne$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        defaultValue = (Function0) awaitKt$awaitFirstOrElse$12.L$0;
                        ResultKt.throwOnFailure($result);
                        awaitOne$default = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return awaitOne$default != null ? defaultValue.invoke() : awaitOne$default;
            }
        }
        awaitKt$awaitFirstOrElse$1 = new AwaitKt$awaitFirstOrElse$1(continuation);
        awaitKt$awaitFirstOrElse$12 = awaitKt$awaitFirstOrElse$1;
        Object $result2 = awaitKt$awaitFirstOrElse$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (awaitKt$awaitFirstOrElse$12.label) {
        }
        if (awaitOne$default != null) {
        }
    }

    public static final <T> Object awaitLast(Publisher<T> publisher, Continuation<? super T> continuation) {
        return awaitOne$default(publisher, Mode.LAST, null, continuation, 2, null);
    }

    public static final <T> Object awaitSingle(Publisher<T> publisher, Continuation<? super T> continuation) {
        return awaitOne$default(publisher, Mode.SINGLE, null, continuation, 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated without a replacement due to its name incorrectly conveying the behavior. Please consider using awaitFirstOrElse().")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object awaitSingleOrElse(Publisher $this$awaitSingleOrElse, Function0 function0, Continuation continuation) {
        AwaitKt$awaitSingleOrElse$1 awaitKt$awaitSingleOrElse$1;
        AwaitKt$awaitSingleOrElse$1 awaitKt$awaitSingleOrElse$12;
        Function0 defaultValue;
        Object awaitOne$default;
        if (continuation instanceof AwaitKt$awaitSingleOrElse$1) {
            awaitKt$awaitSingleOrElse$1 = (AwaitKt$awaitSingleOrElse$1) continuation;
            if ((awaitKt$awaitSingleOrElse$1.label & IntCompanionObject.MIN_VALUE) != 0) {
                awaitKt$awaitSingleOrElse$1.label -= IntCompanionObject.MIN_VALUE;
                awaitKt$awaitSingleOrElse$12 = awaitKt$awaitSingleOrElse$1;
                Object $result = awaitKt$awaitSingleOrElse$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (awaitKt$awaitSingleOrElse$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        defaultValue = function0;
                        Mode mode = Mode.SINGLE_OR_DEFAULT;
                        awaitKt$awaitSingleOrElse$12.L$0 = defaultValue;
                        awaitKt$awaitSingleOrElse$12.label = 1;
                        awaitOne$default = awaitOne$default($this$awaitSingleOrElse, mode, null, awaitKt$awaitSingleOrElse$12, 2, null);
                        if (awaitOne$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        defaultValue = (Function0) awaitKt$awaitSingleOrElse$12.L$0;
                        ResultKt.throwOnFailure($result);
                        awaitOne$default = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return awaitOne$default != null ? defaultValue.invoke() : awaitOne$default;
            }
        }
        awaitKt$awaitSingleOrElse$1 = new AwaitKt$awaitSingleOrElse$1(continuation);
        awaitKt$awaitSingleOrElse$12 = awaitKt$awaitSingleOrElse$1;
        Object $result2 = awaitKt$awaitSingleOrElse$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (awaitKt$awaitSingleOrElse$12.label) {
        }
        if (awaitOne$default != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object awaitOne$default(Publisher publisher, Mode mode, Object obj, Continuation continuation, int i, Object obj2) {
        if ((i & 2) != 0) {
            obj = null;
        }
        return awaitOne(publisher, mode, obj, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> Object awaitOne(Publisher<T> publisher, Mode mode, T t, Continuation<? super T> continuation) {
        CancellableContinuationImpl cancellable$iv = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellable$iv.initCancellability();
        CancellableContinuationImpl cont = cancellable$iv;
        ReactiveFlowKt.injectCoroutineContext(publisher, cont.getContext()).subscribe(new AwaitKt$awaitOne$2$1(cont, mode, t));
        Object result = cancellable$iv.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void gotSignalInTerminalStateException(CoroutineContext context, String signalName) {
        CoroutineExceptionHandlerKt.handleCoroutineException(context, new IllegalStateException('\'' + signalName + "' was called after the publisher already signalled being in a terminal state"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void moreThanOneValueProvidedException(CoroutineContext context, Mode mode) {
        CoroutineExceptionHandlerKt.handleCoroutineException(context, new IllegalStateException("Only a single value was requested in '" + mode + "', but the publisher provided more"));
    }
}