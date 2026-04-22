package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionArbiter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableConcatArray<T> extends Flowable<T> {
    final boolean delayError;
    final Publisher<? extends T>[] sources;

    public FlowableConcatArray(Publisher<? extends T>[] sources, boolean delayError) {
        this.sources = sources;
        this.delayError = delayError;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    protected void subscribeActual(Subscriber<? super T> s) {
        ConcatArraySubscriber<T> parent = new ConcatArraySubscriber<>(this.sources, this.delayError, s);
        s.onSubscribe(parent);
        parent.onComplete();
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class ConcatArraySubscriber<T> extends SubscriptionArbiter implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -8158322871608889516L;
        final boolean delayError;
        final Subscriber<? super T> downstream;
        List<Throwable> errors;
        int index;
        long produced;
        final Publisher<? extends T>[] sources;
        final AtomicInteger wip;

        ConcatArraySubscriber(Publisher<? extends T>[] sources, boolean delayError, Subscriber<? super T> downstream) {
            super(false);
            this.downstream = downstream;
            this.sources = sources;
            this.delayError = delayError;
            this.wip = new AtomicInteger();
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber
        public void onSubscribe(Subscription s) {
            setSubscription(s);
        }

        public void onNext(T t) {
            this.produced++;
            this.downstream.onNext(t);
        }

        public void onError(Throwable t) {
            if (this.delayError) {
                List<Throwable> list = this.errors;
                if (list == null) {
                    list = new ArrayList((this.sources.length - this.index) + 1);
                    this.errors = list;
                }
                list.add(t);
                onComplete();
                return;
            }
            this.downstream.onError(t);
        }

        public void onComplete() {
            if (this.wip.getAndIncrement() == 0) {
                Publisher<? extends T>[] sources = this.sources;
                int n = sources.length;
                int i = this.index;
                while (i != n) {
                    Publisher<? extends T> p = sources[i];
                    if (p == null) {
                        Throwable ex = new NullPointerException("A Publisher entry is null");
                        if (this.delayError) {
                            List<Throwable> list = this.errors;
                            if (list == null) {
                                list = new ArrayList((n - i) + 1);
                                this.errors = list;
                            }
                            list.add(ex);
                            i++;
                        } else {
                            this.downstream.onError(ex);
                            return;
                        }
                    } else {
                        long r = this.produced;
                        if (r != 0) {
                            this.produced = 0L;
                            produced(r);
                        }
                        p.subscribe(this);
                        i++;
                        this.index = i;
                        if (this.wip.decrementAndGet() == 0) {
                            return;
                        }
                    }
                }
                List<Throwable> list2 = this.errors;
                if (list2 != null) {
                    if (list2.size() == 1) {
                        this.downstream.onError(list2.get(0));
                        return;
                    } else {
                        this.downstream.onError(new CompositeException(list2));
                        return;
                    }
                }
                this.downstream.onComplete();
            }
        }
    }
}