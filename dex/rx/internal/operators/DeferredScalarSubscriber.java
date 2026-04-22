package rx.internal.operators;

import java.util.concurrent.atomic.AtomicInteger;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;

public abstract class DeferredScalarSubscriber<T, R> extends Subscriber<T> {
    static final int HAS_REQUEST_HAS_VALUE = 3;
    static final int HAS_REQUEST_NO_VALUE = 1;
    static final int NO_REQUEST_HAS_VALUE = 2;
    static final int NO_REQUEST_NO_VALUE = 0;
    protected final Subscriber<? super R> actual;
    protected boolean hasValue;
    final AtomicInteger state = new AtomicInteger();
    protected R value;

    public DeferredScalarSubscriber(Subscriber<? super R> actual) {
        this.actual = actual;
    }

    public void onError(Throwable ex) {
        this.value = null;
        this.actual.onError(ex);
    }

    public void onCompleted() {
        if (this.hasValue) {
            complete(this.value);
        } else {
            complete();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void complete() {
        this.actual.onCompleted();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void complete(R value) {
        Subscriber<? super R> a = this.actual;
        do {
            int s = this.state.get();
            if (s == 2 || s == 3 || a.isUnsubscribed()) {
                return;
            }
            if (s == 1) {
                a.onNext(value);
                if (!a.isUnsubscribed()) {
                    a.onCompleted();
                }
                this.state.lazySet(3);
                return;
            }
            this.value = value;
        } while (!this.state.compareAndSet(0, 2));
    }

    final void downstreamRequest(long n) {
        if (n < 0) {
            throw new IllegalArgumentException("n >= 0 required but it was " + n);
        }
        if (n != 0) {
            Subscriber<? super R> a = this.actual;
            do {
                int s = this.state.get();
                if (s == 1 || s == 3 || a.isUnsubscribed()) {
                    return;
                }
                if (s == 2) {
                    if (this.state.compareAndSet(2, 3)) {
                        a.onNext(this.value);
                        if (!a.isUnsubscribed()) {
                            a.onCompleted();
                            return;
                        }
                        return;
                    }
                    return;
                }
            } while (!this.state.compareAndSet(0, 1));
        }
    }

    public final void setProducer(Producer p) {
        p.request(Long.MAX_VALUE);
    }

    public final void subscribeTo(Observable<? extends T> source) {
        setupDownstream();
        source.unsafeSubscribe(this);
    }

    final void setupDownstream() {
        Subscriber<? super R> a = this.actual;
        a.add(this);
        a.setProducer(new InnerProducer(this));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class InnerProducer implements Producer {
        final DeferredScalarSubscriber<?, ?> parent;

        public InnerProducer(DeferredScalarSubscriber<?, ?> parent) {
            this.parent = parent;
        }

        public void request(long n) {
            this.parent.downstreamRequest(n);
        }
    }
}