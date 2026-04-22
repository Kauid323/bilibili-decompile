package rx.internal.operators;

import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.functions.Func1;

public final class OperatorTakeLast<T> implements Observable.Operator<T, T> {
    final int count;

    public /* bridge */ /* synthetic */ Object call(Object x0) {
        return call((Subscriber) ((Subscriber) x0));
    }

    public OperatorTakeLast(int count) {
        if (count < 0) {
            throw new IndexOutOfBoundsException("count cannot be negative");
        }
        this.count = count;
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        final TakeLastSubscriber<T> parent = new TakeLastSubscriber<>(subscriber, this.count);
        subscriber.add(parent);
        subscriber.setProducer(new Producer() { // from class: rx.internal.operators.OperatorTakeLast.1
            public void request(long n) {
                parent.requestMore(n);
            }
        });
        return parent;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class TakeLastSubscriber<T> extends Subscriber<T> implements Func1<Object, T> {
        final Subscriber<? super T> actual;
        final int count;
        final AtomicLong requested = new AtomicLong();
        final ArrayDeque<Object> queue = new ArrayDeque<>();

        public TakeLastSubscriber(Subscriber<? super T> actual, int count) {
            this.actual = actual;
            this.count = count;
        }

        public void onNext(T t) {
            if (this.queue.size() == this.count) {
                this.queue.poll();
            }
            this.queue.offer(NotificationLite.next(t));
        }

        public void onError(Throwable e) {
            this.queue.clear();
            this.actual.onError(e);
        }

        public void onCompleted() {
            BackpressureUtils.postCompleteDone(this.requested, this.queue, this.actual, this);
        }

        public T call(Object t) {
            return (T) NotificationLite.getValue(t);
        }

        void requestMore(long n) {
            if (n > 0) {
                BackpressureUtils.postCompleteRequest(this.requested, n, this.queue, this.actual, this);
            }
        }
    }
}