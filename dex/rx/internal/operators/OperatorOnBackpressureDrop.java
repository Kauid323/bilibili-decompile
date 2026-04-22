package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Action1;
import rx.plugins.RxJavaHooks;

public class OperatorOnBackpressureDrop<T> implements Observable.Operator<T, T> {
    final Action1<? super T> onDrop;

    public /* bridge */ /* synthetic */ Object call(Object x0) {
        return call((Subscriber) ((Subscriber) x0));
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class Holder {
        static final OperatorOnBackpressureDrop<Object> INSTANCE = new OperatorOnBackpressureDrop<>();

        Holder() {
        }
    }

    public static <T> OperatorOnBackpressureDrop<T> instance() {
        return (OperatorOnBackpressureDrop<T>) Holder.INSTANCE;
    }

    OperatorOnBackpressureDrop() {
        this(null);
    }

    public OperatorOnBackpressureDrop(Action1<? super T> onDrop) {
        this.onDrop = onDrop;
    }

    public Subscriber<? super T> call(final Subscriber<? super T> child) {
        final AtomicLong requested = new AtomicLong();
        child.setProducer(new Producer() { // from class: rx.internal.operators.OperatorOnBackpressureDrop.1
            public void request(long n) {
                BackpressureUtils.getAndAddRequest(requested, n);
            }
        });
        return (Subscriber<T>) new Subscriber<T>(child) { // from class: rx.internal.operators.OperatorOnBackpressureDrop.2
            boolean done;

            public void onStart() {
                request(Long.MAX_VALUE);
            }

            public void onCompleted() {
                if (!this.done) {
                    this.done = true;
                    child.onCompleted();
                }
            }

            public void onError(Throwable e) {
                if (!this.done) {
                    this.done = true;
                    child.onError(e);
                    return;
                }
                RxJavaHooks.onError(e);
            }

            public void onNext(T t) {
                if (this.done) {
                    return;
                }
                if (requested.get() > 0) {
                    child.onNext(t);
                    requested.decrementAndGet();
                } else if (OperatorOnBackpressureDrop.this.onDrop != null) {
                    try {
                        OperatorOnBackpressureDrop.this.onDrop.call(t);
                    } catch (Throwable e) {
                        Exceptions.throwOrReport(e, this, t);
                    }
                }
            }
        };
    }
}