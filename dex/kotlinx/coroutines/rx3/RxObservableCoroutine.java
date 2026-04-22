package kotlinx.coroutines.rx3;

import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.exceptions.UndeliverableException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectClause2Impl;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RxObservable.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0005B\u001b\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t¢\u0006\u0002\u0010\nJ\u0012\u0010\u001c\u001a\u00020\u00122\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0017\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010 \u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010!J\u001a\u0010\"\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010#\u001a\u00020\u0012H\u0002J\u001e\u0010$\u001a\u00020%2\u0014\u0010&\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0012\u0004\u0012\u00020\u00040'H\u0016J\u0018\u0010(\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u0012H\u0014J\u0015\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u0004H\u0014¢\u0006\u0002\u0010+J\u001e\u0010,\u001a\u0004\u0018\u00010\u00022\b\u0010-\u001a\u0004\u0018\u00010\u00022\b\u0010.\u001a\u0004\u0018\u00010\u0002H\u0002J\u001e\u0010/\u001a\u00020\u00042\n\u00100\u001a\u0006\u0012\u0002\b\u0003012\b\u0010-\u001a\u0004\u0018\u00010\u0002H\u0002J\u0019\u00102\u001a\u00020\u00042\u0006\u0010-\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0002\u00103J\u001a\u00104\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010#\u001a\u00020\u0012H\u0002J&\u00105\u001a\b\u0012\u0004\u0012\u00020\u0004062\u0006\u0010-\u001a\u00028\u0000H\u0016ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b7\u00108J\b\u00109\u001a\u00020\u0004H\u0002R\t\u0010\u000b\u001a\u00020\fX\u0082\u0004R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e0\u00178VX\u0096\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006:"}, d2 = {"Lkotlinx/coroutines/rx3/RxObservableCoroutine;", "T", "", "Lkotlinx/coroutines/AbstractCoroutine;", "", "Lkotlinx/coroutines/channels/ProducerScope;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "subscriber", "Lio/reactivex/rxjava3/core/ObservableEmitter;", "(Lkotlin/coroutines/CoroutineContext;Lio/reactivex/rxjava3/core/ObservableEmitter;)V", "_signal", "Lkotlinx/atomicfu/AtomicInt;", "channel", "Lkotlinx/coroutines/channels/SendChannel;", "getChannel", "()Lkotlinx/coroutines/channels/SendChannel;", "isClosedForSend", "", "()Z", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "onSend", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend$annotations", "()V", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "close", "cause", "", "doLockedNext", "elem", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "doLockedSignalCompleted", "handled", "invokeOnClose", "", "handler", "Lkotlin/Function1;", "onCancelled", "onCompleted", "value", "(Lkotlin/Unit;)V", "processResultSelectSend", "element", "selectResult", "registerSelectForSend", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signalCompleted", "trySend", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "unlockAndCheckCompleted", "kotlinx-coroutines-rx3"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RxObservableCoroutine<T> extends AbstractCoroutine<Unit> implements ProducerScope<T> {
    private static final AtomicIntegerFieldUpdater _signal$FU = AtomicIntegerFieldUpdater.newUpdater(RxObservableCoroutine.class, "_signal");
    @Volatile
    private volatile int _signal;
    private final Mutex mutex;
    private final ObservableEmitter<T> subscriber;

    public static /* synthetic */ void getOnSend$annotations() {
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    /* renamed from: invokeOnClose */
    public /* bridge */ /* synthetic */ void mo1469invokeOnClose(Function1 handler) {
        invokeOnClose((Function1<? super Throwable, Unit>) handler);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @ReplaceWith(expression = "trySend(element).isSuccess", imports = {}))
    public boolean offer(T t) {
        return ProducerScope.DefaultImpls.offer(this, t);
    }

    public RxObservableCoroutine(CoroutineContext parentContext, ObservableEmitter<T> observableEmitter) {
        super(parentContext, false, true);
        this.subscriber = observableEmitter;
        this.mutex = MutexKt.Mutex$default(false, 1, null);
    }

    @Override // kotlinx.coroutines.channels.ProducerScope
    public SendChannel<T> getChannel() {
        return this;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean isClosedForSend() {
        return !isActive();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean close(Throwable cause) {
        return cancelCoroutine(cause);
    }

    public Void invokeOnClose(Function1<? super Throwable, Unit> function1) {
        throw new UnsupportedOperationException("RxObservableCoroutine doesn't support invokeOnClose");
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public SelectClause2<T, SendChannel<T>> getOnSend() {
        RxObservableCoroutine$onSend$1 rxObservableCoroutine$onSend$1 = RxObservableCoroutine$onSend$1.INSTANCE;
        Intrinsics.checkNotNull(rxObservableCoroutine$onSend$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        Function3 function3 = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(rxObservableCoroutine$onSend$1, 3);
        RxObservableCoroutine$onSend$2 rxObservableCoroutine$onSend$2 = RxObservableCoroutine$onSend$2.INSTANCE;
        Intrinsics.checkNotNull(rxObservableCoroutine$onSend$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new SelectClause2Impl(this, function3, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(rxObservableCoroutine$onSend$2, 3), null, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void registerSelectForSend(SelectInstance<?> selectInstance, Object element) {
        if (!Mutex.DefaultImpls.tryLock$default(this.mutex, null, 1, null)) {
            BuildersKt__Builders_commonKt.launch$default(this, null, null, new RxObservableCoroutine$registerSelectForSend$1(this, selectInstance, null), 3, null);
        } else {
            selectInstance.selectInRegistrationPhase(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final Object processResultSelectSend(Object element, Object selectResult) {
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type T of kotlinx.coroutines.rx3.RxObservableCoroutine");
        Throwable it = doLockedNext(element);
        if (it != null) {
            throw it;
        }
        return this;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    /* renamed from: trySend-JP2dKIU */
    public Object mo1399trySendJP2dKIU(T t) {
        if (!Mutex.DefaultImpls.tryLock$default(this.mutex, null, 1, null)) {
            return ChannelResult.Companion.m1424failurePtdJZtk();
        }
        Throwable throwable = doLockedNext(t);
        return throwable == null ? ChannelResult.Companion.m1425successJP2dKIU(Unit.INSTANCE) : ChannelResult.Companion.m1423closedJP2dKIU(throwable);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0056  */
    @Override // kotlinx.coroutines.channels.SendChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object send(T t, Continuation<? super Unit> continuation) {
        RxObservableCoroutine$send$1 rxObservableCoroutine$send$1;
        RxObservableCoroutine$send$1 rxObservableCoroutine$send$12;
        RxObservableCoroutine rxObservableCoroutine;
        Throwable it;
        if (continuation instanceof RxObservableCoroutine$send$1) {
            rxObservableCoroutine$send$1 = (RxObservableCoroutine$send$1) continuation;
            if ((rxObservableCoroutine$send$1.label & IntCompanionObject.MIN_VALUE) != 0) {
                rxObservableCoroutine$send$1.label -= IntCompanionObject.MIN_VALUE;
                rxObservableCoroutine$send$12 = rxObservableCoroutine$send$1;
                Object $result = rxObservableCoroutine$send$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (rxObservableCoroutine$send$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Mutex mutex = this.mutex;
                        rxObservableCoroutine$send$12.L$0 = this;
                        rxObservableCoroutine$send$12.L$1 = t;
                        rxObservableCoroutine$send$12.label = 1;
                        if (Mutex.DefaultImpls.lock$default(mutex, null, rxObservableCoroutine$send$12, 1, null) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        rxObservableCoroutine = this;
                        break;
                    case 1:
                        t = (T) rxObservableCoroutine$send$12.L$1;
                        rxObservableCoroutine = (RxObservableCoroutine) rxObservableCoroutine$send$12.L$0;
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                it = rxObservableCoroutine.doLockedNext(t);
                if (it == null) {
                    throw it;
                }
                return Unit.INSTANCE;
            }
        }
        rxObservableCoroutine$send$1 = new RxObservableCoroutine$send$1(this, continuation);
        rxObservableCoroutine$send$12 = rxObservableCoroutine$send$1;
        Object $result2 = rxObservableCoroutine$send$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (rxObservableCoroutine$send$12.label) {
        }
        it = rxObservableCoroutine.doLockedNext(t);
        if (it == null) {
        }
    }

    private final Throwable doLockedNext(T t) {
        if (!isActive()) {
            doLockedSignalCompleted(getCompletionCause(), getCompletionCauseHandled());
            return getCancellationException();
        }
        try {
            this.subscriber.onNext(t);
            unlockAndCheckCompleted();
            return null;
        } catch (Throwable e) {
            Throwable undeliverableException = new UndeliverableException(e);
            boolean causeDelivered = close(undeliverableException);
            unlockAndCheckCompleted();
            if (causeDelivered) {
                return undeliverableException;
            }
            RxCancellableKt.handleUndeliverableException(undeliverableException, getContext());
            return getCancellationException();
        }
    }

    private final void unlockAndCheckCompleted() {
        Mutex.DefaultImpls.unlock$default(this.mutex, null, 1, null);
        if (!isActive() && Mutex.DefaultImpls.tryLock$default(this.mutex, null, 1, null)) {
            doLockedSignalCompleted(getCompletionCause(), getCompletionCauseHandled());
        }
    }

    private final void doLockedSignalCompleted(Throwable cause, boolean handled) {
        Throwable th;
        if (_signal$FU.get(this) == -2) {
            return;
        }
        _signal$FU.set(this, -2);
        if (cause != null) {
            th = !DebugKt.getRECOVER_STACK_TRACES() ? cause : StackTraceRecoveryKt.unwrapImpl(cause);
        } else {
            th = null;
        }
        Throwable unwrappedCause = th;
        if (unwrappedCause == null) {
            try {
                this.subscriber.onComplete();
            } catch (Exception e) {
                RxCancellableKt.handleUndeliverableException(e, getContext());
            }
            return;
        }
        if ((unwrappedCause instanceof UndeliverableException) && !handled) {
            RxCancellableKt.handleUndeliverableException(cause, getContext());
        } else if (unwrappedCause != getCancellationException() || !this.subscriber.isDisposed()) {
            try {
                this.subscriber.onError(cause);
            } catch (Exception e2) {
                ExceptionsKt.addSuppressed(cause, e2);
                RxCancellableKt.handleUndeliverableException(cause, getContext());
            }
        }
        return;
        Mutex.DefaultImpls.unlock$default(this.mutex, null, 1, null);
    }

    private final void signalCompleted(Throwable cause, boolean handled) {
        if (_signal$FU.compareAndSet(this, 0, -1) && Mutex.DefaultImpls.tryLock$default(this.mutex, null, 1, null)) {
            doLockedSignalCompleted(cause, handled);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.AbstractCoroutine
    public void onCompleted(Unit value) {
        signalCompleted(null, false);
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    protected void onCancelled(Throwable cause, boolean handled) {
        signalCompleted(cause, handled);
    }
}