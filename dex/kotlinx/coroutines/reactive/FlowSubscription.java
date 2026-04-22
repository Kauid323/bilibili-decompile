package kotlinx.coroutines.reactive;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.IntCompanionObject;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.intrinsics.CancellableKt;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: ReactiveFlow.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003B+\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u0013\u001a\u00020\u0004H\u0016J\u000e\u0010\u0014\u001a\u00020\u0004H\u0082@¢\u0006\u0002\u0010\u0015J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010H\u0002J\u000e\u0010\u0017\u001a\u00020\u0004H\u0082@¢\u0006\u0002\u0010\u0015J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00100\u000fX\u0082\u0004R\t\u0010\u0011\u001a\u00020\u0012X\u0082\u0004R\u0018\u0010\u0007\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lkotlinx/coroutines/reactive/FlowSubscription;", "T", "Lorg/reactivestreams/Subscription;", "Lkotlinx/coroutines/AbstractCoroutine;", "", "flow", "Lkotlinx/coroutines/flow/Flow;", "subscriber", "Lorg/reactivestreams/Subscriber;", "context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlinx/coroutines/flow/Flow;Lorg/reactivestreams/Subscriber;Lkotlin/coroutines/CoroutineContext;)V", "cancellationRequested", "", "producer", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlin/coroutines/Continuation;", "requested", "Lkotlinx/atomicfu/AtomicLong;", "cancel", "consumeFlow", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createInitialContinuation", "flowProcessing", "request", "n", "", "kotlinx-coroutines-reactive"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FlowSubscription<T> extends AbstractCoroutine<Unit> implements Subscription {
    private volatile boolean cancellationRequested;
    public final Flow<T> flow;
    private volatile /* synthetic */ Object producer$volatile;
    private volatile /* synthetic */ long requested$volatile;
    public final Subscriber<? super T> subscriber;
    private static final /* synthetic */ AtomicLongFieldUpdater requested$volatile$FU = AtomicLongFieldUpdater.newUpdater(FlowSubscription.class, "requested$volatile");
    private static final /* synthetic */ AtomicReferenceFieldUpdater producer$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(FlowSubscription.class, Object.class, "producer$volatile");

    private final /* synthetic */ long getAndUpdate$atomicfu(Object obj, AtomicLongFieldUpdater atomicLongFieldUpdater, Function1<? super Long, Long> function1) {
        long j;
        do {
            j = atomicLongFieldUpdater.get(obj);
        } while (!atomicLongFieldUpdater.compareAndSet(obj, j, function1.invoke(Long.valueOf(j)).longValue()));
        return j;
    }

    private final /* synthetic */ Object getProducer$volatile() {
        return this.producer$volatile;
    }

    private final /* synthetic */ long getRequested$volatile() {
        return this.requested$volatile;
    }

    private final /* synthetic */ void setProducer$volatile(Object obj) {
        this.producer$volatile = obj;
    }

    private final /* synthetic */ void setRequested$volatile(long j) {
        this.requested$volatile = j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FlowSubscription(Flow<? extends T> flow, Subscriber<? super T> subscriber, CoroutineContext context) {
        super(context, false, true);
        this.flow = flow;
        this.subscriber = subscriber;
        this.producer$volatile = createInitialContinuation();
    }

    private final Continuation<Unit> createInitialContinuation() {
        final CoroutineContext coroutineContext = getCoroutineContext();
        return new Continuation<Unit>() { // from class: kotlinx.coroutines.reactive.FlowSubscription$createInitialContinuation$$inlined$Continuation$1
            @Override // kotlin.coroutines.Continuation
            public CoroutineContext getContext() {
                return CoroutineContext.this;
            }

            @Override // kotlin.coroutines.Continuation
            public void resumeWith(Object result) {
                CancellableKt.startCoroutineCancellable(new FlowSubscription$createInitialContinuation$1$1(this), this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object flowProcessing(Continuation<? super Unit> continuation) {
        FlowSubscription$flowProcessing$1 flowSubscription$flowProcessing$1;
        FlowSubscription$flowProcessing$1 flowSubscription$flowProcessing$12;
        Throwable cause;
        FlowSubscription flowSubscription;
        if (continuation instanceof FlowSubscription$flowProcessing$1) {
            flowSubscription$flowProcessing$1 = (FlowSubscription$flowProcessing$1) continuation;
            if ((flowSubscription$flowProcessing$1.label & IntCompanionObject.MIN_VALUE) != 0) {
                flowSubscription$flowProcessing$1.label -= IntCompanionObject.MIN_VALUE;
                flowSubscription$flowProcessing$12 = flowSubscription$flowProcessing$1;
                Object $result = flowSubscription$flowProcessing$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (flowSubscription$flowProcessing$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        try {
                            flowSubscription$flowProcessing$12.L$0 = this;
                            flowSubscription$flowProcessing$12.label = 1;
                            if (consumeFlow(flowSubscription$flowProcessing$12) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            flowSubscription = this;
                            try {
                                flowSubscription.subscriber.onComplete();
                            } catch (Throwable e) {
                                CoroutineExceptionHandlerKt.handleCoroutineException(flowSubscription.getCoroutineContext(), e);
                            }
                            return Unit.INSTANCE;
                        } catch (Throwable th) {
                            cause = th;
                            flowSubscription = this;
                            Throwable unwrappedCause = DebugKt.getRECOVER_STACK_TRACES() ? cause : StackTraceRecoveryKt.unwrapImpl(cause);
                            if (flowSubscription.cancellationRequested) {
                                break;
                            }
                            try {
                                flowSubscription.subscriber.onError(cause);
                            } catch (Throwable e2) {
                                ExceptionsKt.addSuppressed(cause, e2);
                                CoroutineExceptionHandlerKt.handleCoroutineException(flowSubscription.getCoroutineContext(), cause);
                            }
                            return Unit.INSTANCE;
                        }
                    case 1:
                        flowSubscription = (FlowSubscription) flowSubscription$flowProcessing$12.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            flowSubscription.subscriber.onComplete();
                            return Unit.INSTANCE;
                        } catch (Throwable th2) {
                            cause = th2;
                            Throwable unwrappedCause2 = DebugKt.getRECOVER_STACK_TRACES() ? cause : StackTraceRecoveryKt.unwrapImpl(cause);
                            if (flowSubscription.cancellationRequested || flowSubscription.isActive() || unwrappedCause2 != flowSubscription.getCancellationException()) {
                                flowSubscription.subscriber.onError(cause);
                            }
                            return Unit.INSTANCE;
                        }
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        flowSubscription$flowProcessing$1 = new FlowSubscription$flowProcessing$1(this, continuation);
        flowSubscription$flowProcessing$12 = flowSubscription$flowProcessing$1;
        Object $result2 = flowSubscription$flowProcessing$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (flowSubscription$flowProcessing$12.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object consumeFlow(Continuation<? super Unit> continuation) {
        Object collect = this.flow.collect(new FlowCollector(this) { // from class: kotlinx.coroutines.reactive.FlowSubscription$consumeFlow$2
            final /* synthetic */ FlowSubscription<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.this$0 = this;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(T t, Continuation<? super Unit> continuation2) {
                AtomicLongFieldUpdater atomicLongFieldUpdater;
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
                this.this$0.subscriber.onNext(t);
                atomicLongFieldUpdater = FlowSubscription.requested$volatile$FU;
                if (atomicLongFieldUpdater.decrementAndGet(this.this$0) <= 0) {
                    FlowSubscription<T> flowSubscription = this.this$0;
                    CancellableContinuationImpl cancellable$iv = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation2), 1);
                    cancellable$iv.initCancellability();
                    atomicReferenceFieldUpdater = FlowSubscription.producer$volatile$FU;
                    atomicReferenceFieldUpdater.set(flowSubscription, cancellable$iv);
                    Object result = cancellable$iv.getResult();
                    if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        DebugProbesKt.probeCoroutineSuspended(continuation2);
                    }
                    return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
                }
                JobKt.ensureActive(this.this$0.getCoroutineContext());
                return Unit.INSTANCE;
            }
        }, continuation);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    public void cancel() {
        this.cancellationRequested = true;
        cancel((CancellationException) null);
    }

    @Override // org.reactivestreams.Subscription
    public void request(long n) {
        long value;
        long newValue;
        Continuation producer;
        if (n <= 0) {
            return;
        }
        AtomicLongFieldUpdater handler$atomicfu$iv = requested$volatile$FU;
        do {
            value = handler$atomicfu$iv.get(this);
            newValue = value + n;
        } while (!handler$atomicfu$iv.compareAndSet(this, value, newValue <= 0 ? Long.MAX_VALUE : newValue));
        if (value <= 0) {
            if (!(value == 0)) {
                throw new AssertionError("Assertion failed");
            }
            do {
                producer = (Continuation) producer$volatile$FU.getAndSet(this, null);
            } while (producer == null);
            Result.Companion companion = Result.Companion;
            producer.resumeWith(Result.constructor-impl(Unit.INSTANCE));
        }
    }
}