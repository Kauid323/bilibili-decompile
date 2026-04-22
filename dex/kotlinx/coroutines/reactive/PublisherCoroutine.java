package kotlinx.coroutines.reactive;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectClause2Impl;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: Publish.kt */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00042\u00020\u0005B5\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t\u0012\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\u0002\u0010\rJ\b\u0010 \u001a\u00020\u0003H\u0016J\u0012\u0010!\u001a\u00020\u00112\b\u0010\"\u001a\u0004\u0018\u00010\fH\u0016J\u0017\u0010#\u001a\u0004\u0018\u00010\f2\u0006\u0010$\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010%J\u001a\u0010&\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010\f2\u0006\u0010'\u001a\u00020\u0011H\u0002J\u001e\u0010(\u001a\u00020)2\u0014\u0010*\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u00030+H\u0016J\u0018\u0010,\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\f2\u0006\u0010'\u001a\u00020\u0011H\u0014J\u0015\u0010-\u001a\u00020\u00032\u0006\u0010.\u001a\u00020\u0003H\u0014¢\u0006\u0002\u0010/J\u001e\u00100\u001a\u0004\u0018\u0001012\b\u00102\u001a\u0004\u0018\u0001012\b\u00103\u001a\u0004\u0018\u000101H\u0002J\u001e\u00104\u001a\u00020\u00032\n\u00105\u001a\u0006\u0012\u0002\b\u0003062\b\u00102\u001a\u0004\u0018\u000101H\u0002J\u0010\u00107\u001a\u00020\u00032\u0006\u00108\u001a\u000209H\u0016J\u0016\u0010:\u001a\u00020\u00032\u0006\u00102\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u0010;J\u001a\u0010<\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010\f2\u0006\u0010'\u001a\u00020\u0011H\u0002J#\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00030>2\u0006\u00102\u001a\u00028\u0000H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b?\u0010@J\b\u0010A\u001a\u00020\u0003H\u0002R\t\u0010\u000e\u001a\u00020\u000fX\u0082\u0004R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R \u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00130\u001b8VX\u0096\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tX\u0088\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006B"}, d2 = {"Lkotlinx/coroutines/reactive/PublisherCoroutine;", "T", "Lkotlinx/coroutines/AbstractCoroutine;", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lorg/reactivestreams/Subscription;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "subscriber", "Lorg/reactivestreams/Subscriber;", "exceptionOnCancelHandler", "Lkotlin/Function2;", "", "(Lkotlin/coroutines/CoroutineContext;Lorg/reactivestreams/Subscriber;Lkotlin/jvm/functions/Function2;)V", "_nRequested", "Lkotlinx/atomicfu/AtomicLong;", "cancelled", "", "channel", "Lkotlinx/coroutines/channels/SendChannel;", "getChannel", "()Lkotlinx/coroutines/channels/SendChannel;", "isClosedForSend", "()Z", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "onSend", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend$annotations", "()V", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "cancel", "close", "cause", "doLockedNext", "elem", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "doLockedSignalCompleted", "handled", "invokeOnClose", "", "handler", "Lkotlin/Function1;", "onCancelled", "onCompleted", "value", "(Lkotlin/Unit;)V", "processResultSelectSend", "", "element", "selectResult", "registerSelectForSend", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "request", "n", "", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signalCompleted", "trySend", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "unlockAndCheckCompleted", "kotlinx-coroutines-reactive"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PublisherCoroutine<T> extends AbstractCoroutine<Unit> implements ProducerScope<T>, Subscription {
    private static final /* synthetic */ AtomicLongFieldUpdater _nRequested$volatile$FU = AtomicLongFieldUpdater.newUpdater(PublisherCoroutine.class, "_nRequested$volatile");
    private volatile /* synthetic */ long _nRequested$volatile;
    private volatile boolean cancelled;
    private final Function2<Throwable, CoroutineContext, Unit> exceptionOnCancelHandler;
    private final Mutex mutex;
    private final Subscriber<T> subscriber;

    public static /* synthetic */ void getOnSend$annotations() {
    }

    private final /* synthetic */ long get_nRequested$volatile() {
        return this._nRequested$volatile;
    }

    private final /* synthetic */ void set_nRequested$volatile(long j) {
        this._nRequested$volatile = j;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    /* renamed from: invokeOnClose  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ void mo1469invokeOnClose(Function1 handler) {
        invokeOnClose((Function1<? super Throwable, Unit>) handler);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @ReplaceWith(expression = "trySend(element).isSuccess", imports = {}))
    public boolean offer(T t) {
        return ProducerScope.DefaultImpls.offer(this, t);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PublisherCoroutine(CoroutineContext parentContext, Subscriber<T> subscriber, Function2<? super Throwable, ? super CoroutineContext, Unit> function2) {
        super(parentContext, false, true);
        this.subscriber = subscriber;
        this.exceptionOnCancelHandler = function2;
        this.mutex = MutexKt.Mutex(true);
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
        throw new UnsupportedOperationException("PublisherCoroutine doesn't support invokeOnClose");
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public SelectClause2<T, SendChannel<T>> getOnSend() {
        PublisherCoroutine$onSend$1 publisherCoroutine$onSend$1 = PublisherCoroutine$onSend$1.INSTANCE;
        Intrinsics.checkNotNull(publisherCoroutine$onSend$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        Function3 function3 = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(publisherCoroutine$onSend$1, 3);
        PublisherCoroutine$onSend$2 publisherCoroutine$onSend$2 = PublisherCoroutine$onSend$2.INSTANCE;
        Intrinsics.checkNotNull(publisherCoroutine$onSend$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new SelectClause2Impl(this, function3, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(publisherCoroutine$onSend$2, 3), null, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void registerSelectForSend(SelectInstance<?> selectInstance, Object element) {
        if (!Mutex.DefaultImpls.tryLock$default(this.mutex, null, 1, null)) {
            BuildersKt__Builders_commonKt.launch$default(this, null, null, new PublisherCoroutine$registerSelectForSend$1(this, selectInstance, null), 3, null);
        } else {
            selectInstance.selectInRegistrationPhase(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final Object processResultSelectSend(Object element, Object selectResult) {
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
        PublisherCoroutine$send$1 publisherCoroutine$send$1;
        PublisherCoroutine$send$1 publisherCoroutine$send$12;
        PublisherCoroutine publisherCoroutine;
        Throwable it;
        if (continuation instanceof PublisherCoroutine$send$1) {
            publisherCoroutine$send$1 = (PublisherCoroutine$send$1) continuation;
            if ((publisherCoroutine$send$1.label & IntCompanionObject.MIN_VALUE) != 0) {
                publisherCoroutine$send$1.label -= IntCompanionObject.MIN_VALUE;
                publisherCoroutine$send$12 = publisherCoroutine$send$1;
                Object $result = publisherCoroutine$send$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (publisherCoroutine$send$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Mutex mutex = this.mutex;
                        publisherCoroutine$send$12.L$0 = this;
                        publisherCoroutine$send$12.L$1 = t;
                        publisherCoroutine$send$12.label = 1;
                        if (Mutex.DefaultImpls.lock$default(mutex, null, publisherCoroutine$send$12, 1, null) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        publisherCoroutine = this;
                        break;
                    case 1:
                        t = (T) publisherCoroutine$send$12.L$1;
                        publisherCoroutine = (PublisherCoroutine) publisherCoroutine$send$12.L$0;
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                it = publisherCoroutine.doLockedNext(t);
                if (it == null) {
                    throw it;
                }
                return Unit.INSTANCE;
            }
        }
        publisherCoroutine$send$1 = new PublisherCoroutine$send$1(this, continuation);
        publisherCoroutine$send$12 = publisherCoroutine$send$1;
        Object $result2 = publisherCoroutine$send$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (publisherCoroutine$send$12.label) {
        }
        it = publisherCoroutine.doLockedNext(t);
        if (it == null) {
        }
    }

    private final Throwable doLockedNext(T t) {
        if (t == null) {
            unlockAndCheckCompleted();
            throw new NullPointerException("Attempted to emit `null` inside a reactive publisher");
        } else if (!isActive()) {
            unlockAndCheckCompleted();
            return getCancellationException();
        } else {
            try {
                this.subscriber.onNext(t);
                while (true) {
                    long current = _nRequested$volatile$FU.get(this);
                    if (current < 0 || current == LongCompanionObject.MAX_VALUE) {
                        break;
                    }
                    long updated = current - 1;
                    if (_nRequested$volatile$FU.compareAndSet(this, current, updated)) {
                        if (updated == 0) {
                            return null;
                        }
                    }
                }
                unlockAndCheckCompleted();
                return null;
            } catch (Throwable cause) {
                this.cancelled = true;
                boolean causeDelivered = close(cause);
                unlockAndCheckCompleted();
                if (causeDelivered) {
                    return cause;
                }
                this.exceptionOnCancelHandler.invoke(cause, getContext());
                return getCancellationException();
            }
        }
    }

    private final void unlockAndCheckCompleted() {
        Mutex.DefaultImpls.unlock$default(this.mutex, null, 1, null);
        if (isCompleted() && Mutex.DefaultImpls.tryLock$default(this.mutex, null, 1, null)) {
            doLockedSignalCompleted(getCompletionCause(), getCompletionCauseHandled());
        }
    }

    private final void doLockedSignalCompleted(Throwable cause, boolean handled) {
        try {
            if (_nRequested$volatile$FU.get(this) == -2) {
                return;
            }
            _nRequested$volatile$FU.set(this, -2L);
            if (this.cancelled) {
                if (cause != null && !handled) {
                    this.exceptionOnCancelHandler.invoke(cause, getContext());
                }
                return;
            }
            if (cause == null) {
                this.subscriber.onComplete();
            } else {
                this.subscriber.onError(cause);
            }
        } finally {
            Mutex.DefaultImpls.unlock$default(this.mutex, null, 1, null);
        }
    }

    @Override // org.reactivestreams.Subscription
    public void request(long n) {
        long cur;
        long upd;
        if (n <= 0) {
            cancelCoroutine(new IllegalArgumentException("non-positive subscription request " + n));
            return;
        }
        do {
            cur = _nRequested$volatile$FU.get(this);
            if (cur < 0) {
                return;
            }
            long upd2 = cur + n;
            upd = (upd2 < 0 || n == LongCompanionObject.MAX_VALUE) ? Long.MAX_VALUE : upd2;
            if (cur == upd) {
                return;
            }
        } while (!_nRequested$volatile$FU.compareAndSet(this, cur, upd));
        if (cur == 0) {
            unlockAndCheckCompleted();
        }
    }

    private final void signalCompleted(Throwable cause, boolean handled) {
        long current;
        do {
            current = _nRequested$volatile$FU.get(this);
            if (current == -2) {
                return;
            }
            if (!(current >= 0)) {
                throw new IllegalStateException("Check failed.".toString());
            }
        } while (!_nRequested$volatile$FU.compareAndSet(this, current, -1L));
        if (current == 0) {
            doLockedSignalCompleted(cause, handled);
        } else if (Mutex.DefaultImpls.tryLock$default(this.mutex, null, 1, null)) {
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

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    public void cancel() {
        this.cancelled = true;
        super.cancel((CancellationException) null);
    }
}