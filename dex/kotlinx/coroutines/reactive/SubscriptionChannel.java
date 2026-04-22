package kotlinx.coroutines.reactive;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.channels.BufferedChannel;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Channel.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\b\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0015\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001a\u00020\rH\u0016J\b\u0010\u0016\u001a\u00020\rH\u0016J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u000bH\u0016R\t\u0010\u0007\u001a\u00020\bX\u0082\u0004R\u0011\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nX\u0082\u0004R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lkotlinx/coroutines/reactive/SubscriptionChannel;", "T", "Lkotlinx/coroutines/channels/BufferedChannel;", "Lorg/reactivestreams/Subscriber;", "request", "", "(I)V", "_requested", "Lkotlinx/atomicfu/AtomicInt;", "_subscription", "Lkotlinx/atomicfu/AtomicRef;", "Lorg/reactivestreams/Subscription;", "onClosedIdempotent", "", "onComplete", "onError", "e", "", "onNext", "t", "(Ljava/lang/Object;)V", "onReceiveDequeued", "onReceiveEnqueued", "onSubscribe", "s", "kotlinx-coroutines-reactive"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SubscriptionChannel<T> extends BufferedChannel<T> implements Subscriber<T> {
    private volatile /* synthetic */ int _requested$volatile;
    private volatile /* synthetic */ Object _subscription$volatile;
    private final int request;
    private static final /* synthetic */ AtomicReferenceFieldUpdater _subscription$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(SubscriptionChannel.class, Object.class, "_subscription$volatile");
    private static final /* synthetic */ AtomicIntegerFieldUpdater _requested$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(SubscriptionChannel.class, "_requested$volatile");

    private final /* synthetic */ int get_requested$volatile() {
        return this._requested$volatile;
    }

    private final /* synthetic */ Object get_subscription$volatile() {
        return this._subscription$volatile;
    }

    private final /* synthetic */ void loop$atomicfu(Object obj, AtomicIntegerFieldUpdater atomicIntegerFieldUpdater, Function1<? super Integer, Unit> function1) {
        while (true) {
            function1.invoke(Integer.valueOf(atomicIntegerFieldUpdater.get(obj)));
        }
    }

    private final /* synthetic */ void set_requested$volatile(int i) {
        this._requested$volatile = i;
    }

    private final /* synthetic */ void set_subscription$volatile(Object obj) {
        this._subscription$volatile = obj;
    }

    public SubscriptionChannel(int request) {
        super(Integer.MAX_VALUE, null, 2, null);
        this.request = request;
        if (this.request >= 0) {
            return;
        }
        throw new IllegalArgumentException(("Invalid request size: " + this.request).toString());
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public void onReceiveEnqueued() {
        Subscription subscription;
        int needRequested;
        AtomicIntegerFieldUpdater handler$atomicfu$iv = _requested$volatile$FU;
        while (true) {
            int wasRequested = handler$atomicfu$iv.get(this);
            subscription = (Subscription) _subscription$volatile$FU.get(this);
            needRequested = wasRequested - 1;
            if (subscription != null && needRequested < 0) {
                if (wasRequested == this.request || _requested$volatile$FU.compareAndSet(this, wasRequested, this.request)) {
                    break;
                }
            } else if (_requested$volatile$FU.compareAndSet(this, wasRequested, needRequested)) {
                return;
            }
        }
        subscription.request(this.request - needRequested);
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public void onReceiveDequeued() {
        _requested$volatile$FU.incrementAndGet(this);
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public void onClosedIdempotent() {
        Subscription subscription = (Subscription) _subscription$volatile$FU.getAndSet(this, null);
        if (subscription != null) {
            subscription.cancel();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(Subscription s) {
        _subscription$volatile$FU.set(this, s);
        while (!isClosedForSend()) {
            int wasRequested = _requested$volatile$FU.get(this);
            if (wasRequested >= this.request) {
                return;
            }
            if (_requested$volatile$FU.compareAndSet(this, wasRequested, this.request)) {
                s.request(this.request - wasRequested);
                return;
            }
        }
        s.cancel();
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        _requested$volatile$FU.decrementAndGet(this);
        mo1399trySendJP2dKIU(t);
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        close(null);
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable e) {
        close(e);
    }
}