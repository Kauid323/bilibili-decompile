package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableTimer extends Flowable<Long> {
    final long delay;
    final Scheduler scheduler;
    final TimeUnit unit;

    public FlowableTimer(long delay, TimeUnit unit, Scheduler scheduler) {
        this.delay = delay;
        this.unit = unit;
        this.scheduler = scheduler;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super Long> s) {
        TimerSubscriber ios = new TimerSubscriber(s);
        s.onSubscribe(ios);
        Disposable d = this.scheduler.scheduleDirect(ios, this.delay, this.unit);
        ios.setResource(d);
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class TimerSubscriber extends AtomicReference<Disposable> implements Subscription, Runnable {
        private static final long serialVersionUID = -2809475196591179431L;
        final Subscriber<? super Long> downstream;
        volatile boolean requested;

        TimerSubscriber(Subscriber<? super Long> downstream) {
            this.downstream = downstream;
        }

        public void request(long n) {
            if (SubscriptionHelper.validate(n)) {
                this.requested = true;
            }
        }

        public void cancel() {
            DisposableHelper.dispose(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (get() != DisposableHelper.DISPOSED) {
                if (this.requested) {
                    this.downstream.onNext(0L);
                    lazySet(EmptyDisposable.INSTANCE);
                    this.downstream.onComplete();
                    return;
                }
                lazySet(EmptyDisposable.INSTANCE);
                this.downstream.onError(new MissingBackpressureException("Can't deliver value due to lack of requests"));
            }
        }

        public void setResource(Disposable d) {
            DisposableHelper.trySet(this, d);
        }
    }
}