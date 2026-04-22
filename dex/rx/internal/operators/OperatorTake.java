package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;

public final class OperatorTake<T> implements Observable.Operator<T, T> {
    final int limit;

    public /* bridge */ /* synthetic */ Object call(Object x0) {
        return call((Subscriber) ((Subscriber) x0));
    }

    public OperatorTake(int limit) {
        if (limit < 0) {
            throw new IllegalArgumentException("limit >= 0 required but it was " + limit);
        }
        this.limit = limit;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.operators.OperatorTake$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public class AnonymousClass1 extends Subscriber<T> {
        boolean completed;
        int count;
        final /* synthetic */ Subscriber val$child;

        AnonymousClass1(Subscriber subscriber) {
            this.val$child = subscriber;
        }

        public void onCompleted() {
            if (!this.completed) {
                this.completed = true;
                this.val$child.onCompleted();
            }
        }

        public void onError(Throwable e) {
            if (!this.completed) {
                this.completed = true;
                try {
                    this.val$child.onError(e);
                } finally {
                    unsubscribe();
                }
            }
        }

        public void onNext(T i) {
            if (isUnsubscribed()) {
                return;
            }
            int i2 = this.count;
            this.count = i2 + 1;
            if (i2 < OperatorTake.this.limit) {
                boolean stop = this.count == OperatorTake.this.limit;
                this.val$child.onNext(i);
                if (stop && !this.completed) {
                    this.completed = true;
                    try {
                        this.val$child.onCompleted();
                    } finally {
                        unsubscribe();
                    }
                }
            }
        }

        public void setProducer(final Producer producer) {
            this.val$child.setProducer(new Producer() { // from class: rx.internal.operators.OperatorTake.1.1
                final AtomicLong requested = new AtomicLong(0);

                public void request(long n) {
                    long r;
                    long c;
                    if (n > 0 && !AnonymousClass1.this.completed) {
                        do {
                            r = this.requested.get();
                            c = Math.min(n, OperatorTake.this.limit - r);
                            if (c == 0) {
                                return;
                            }
                        } while (!this.requested.compareAndSet(r, r + c));
                        producer.request(c);
                    }
                }
            });
        }
    }

    public Subscriber<? super T> call(Subscriber<? super T> child) {
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(child);
        if (this.limit == 0) {
            child.onCompleted();
            anonymousClass1.unsubscribe();
        }
        child.add(anonymousClass1);
        return anonymousClass1;
    }
}