package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableAmb<T> extends Flowable<T> {
    final Publisher<? extends T>[] sources;
    final Iterable<? extends Publisher<? extends T>> sourcesIterable;

    public FlowableAmb(Publisher<? extends T>[] sources, Iterable<? extends Publisher<? extends T>> sourcesIterable) {
        this.sources = sources;
        this.sourcesIterable = sourcesIterable;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> s) {
        Publisher<? extends T>[] sources = this.sources;
        int count = 0;
        if (sources == null) {
            sources = new Publisher[8];
            try {
                for (Publisher<? extends T> p : this.sourcesIterable) {
                    if (p == null) {
                        EmptySubscription.error(new NullPointerException("One of the sources is null"), s);
                        return;
                    }
                    if (count == sources.length) {
                        Publisher<? extends T>[] b = new Publisher[(count >> 2) + count];
                        System.arraycopy(sources, 0, b, 0, count);
                        sources = b;
                    }
                    int count2 = count + 1;
                    try {
                        sources[count] = p;
                        count = count2;
                    } catch (Throwable th) {
                        e = th;
                        Exceptions.throwIfFatal(e);
                        EmptySubscription.error(e, s);
                        return;
                    }
                }
            } catch (Throwable th2) {
                e = th2;
            }
        } else {
            count = sources.length;
        }
        if (count == 0) {
            EmptySubscription.complete(s);
        } else if (count == 1) {
            sources[0].subscribe(s);
        } else {
            AmbCoordinator<T> ac = new AmbCoordinator<>(s, count);
            ac.subscribe(sources);
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class AmbCoordinator<T> implements Subscription {
        final Subscriber<? super T> downstream;
        final AmbInnerSubscriber<T>[] subscribers;
        final AtomicInteger winner = new AtomicInteger();

        AmbCoordinator(Subscriber<? super T> actual, int count) {
            this.downstream = actual;
            this.subscribers = new AmbInnerSubscriber[count];
        }

        public void subscribe(Publisher<? extends T>[] sources) {
            AmbInnerSubscriber<T>[] as = this.subscribers;
            int len = as.length;
            for (int i = 0; i < len; i++) {
                as[i] = new AmbInnerSubscriber<>(this, i + 1, this.downstream);
            }
            this.winner.lazySet(0);
            this.downstream.onSubscribe(this);
            for (int i2 = 0; i2 < len && this.winner.get() == 0; i2++) {
                sources[i2].subscribe(as[i2]);
            }
        }

        public void request(long n) {
            AmbInnerSubscriber<T>[] ambInnerSubscriberArr;
            if (SubscriptionHelper.validate(n)) {
                int w = this.winner.get();
                if (w > 0) {
                    this.subscribers[w - 1].request(n);
                } else if (w == 0) {
                    for (AmbInnerSubscriber<T> a : this.subscribers) {
                        a.request(n);
                    }
                }
            }
        }

        public boolean win(int index) {
            int w = this.winner.get();
            if (w != 0 || !this.winner.compareAndSet(0, index)) {
                return false;
            }
            AmbInnerSubscriber<T>[] a = this.subscribers;
            int n = a.length;
            for (int i = 0; i < n; i++) {
                if (i + 1 != index) {
                    a[i].cancel();
                }
            }
            return true;
        }

        public void cancel() {
            AmbInnerSubscriber<T>[] ambInnerSubscriberArr;
            if (this.winner.get() != -1) {
                this.winner.lazySet(-1);
                for (AmbInnerSubscriber<T> a : this.subscribers) {
                    a.cancel();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class AmbInnerSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -1185974347409665484L;
        final Subscriber<? super T> downstream;
        final int index;
        final AtomicLong missedRequested = new AtomicLong();
        final AmbCoordinator<T> parent;
        boolean won;

        AmbInnerSubscriber(AmbCoordinator<T> parent, int index, Subscriber<? super T> downstream) {
            this.parent = parent;
            this.index = index;
            this.downstream = downstream;
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber
        public void onSubscribe(Subscription s) {
            SubscriptionHelper.deferredSetOnce(this, this.missedRequested, s);
        }

        public void request(long n) {
            SubscriptionHelper.deferredRequest(this, this.missedRequested, n);
        }

        public void onNext(T t) {
            if (this.won) {
                this.downstream.onNext(t);
            } else if (this.parent.win(this.index)) {
                this.won = true;
                this.downstream.onNext(t);
            } else {
                get().cancel();
            }
        }

        public void onError(Throwable t) {
            if (this.won) {
                this.downstream.onError(t);
            } else if (this.parent.win(this.index)) {
                this.won = true;
                this.downstream.onError(t);
            } else {
                get().cancel();
                RxJavaPlugins.onError(t);
            }
        }

        public void onComplete() {
            if (this.won) {
                this.downstream.onComplete();
            } else if (this.parent.win(this.index)) {
                this.won = true;
                this.downstream.onComplete();
            } else {
                get().cancel();
            }
        }

        public void cancel() {
            SubscriptionHelper.cancel(this);
        }
    }
}