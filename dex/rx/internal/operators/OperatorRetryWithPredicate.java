package rx.internal.operators;

import java.util.concurrent.atomic.AtomicInteger;
import rx.Observable;
import rx.Producer;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Func2;
import rx.internal.producers.ProducerArbiter;
import rx.schedulers.Schedulers;
import rx.subscriptions.SerialSubscription;

public final class OperatorRetryWithPredicate<T> implements Observable.Operator<T, Observable<T>> {
    final Func2<Integer, Throwable, Boolean> predicate;

    public /* bridge */ /* synthetic */ Object call(Object x0) {
        return call((Subscriber) ((Subscriber) x0));
    }

    public OperatorRetryWithPredicate(Func2<Integer, Throwable, Boolean> predicate) {
        this.predicate = predicate;
    }

    public Subscriber<? super Observable<T>> call(Subscriber<? super T> child) {
        Scheduler.Worker inner = Schedulers.trampoline().createWorker();
        child.add(inner);
        SerialSubscription serialSubscription = new SerialSubscription();
        child.add(serialSubscription);
        ProducerArbiter pa = new ProducerArbiter();
        child.setProducer(pa);
        return new SourceSubscriber(child, this.predicate, inner, serialSubscription, pa);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class SourceSubscriber<T> extends Subscriber<Observable<T>> {
        final AtomicInteger attempts = new AtomicInteger();
        final Subscriber<? super T> child;
        final Scheduler.Worker inner;
        final ProducerArbiter pa;
        final Func2<Integer, Throwable, Boolean> predicate;
        final SerialSubscription serialSubscription;

        public /* bridge */ /* synthetic */ void onNext(Object x0) {
            onNext((Observable) ((Observable) x0));
        }

        public SourceSubscriber(Subscriber<? super T> child, Func2<Integer, Throwable, Boolean> predicate, Scheduler.Worker inner, SerialSubscription serialSubscription, ProducerArbiter pa) {
            this.child = child;
            this.predicate = predicate;
            this.inner = inner;
            this.serialSubscription = serialSubscription;
            this.pa = pa;
        }

        public void onCompleted() {
        }

        public void onError(Throwable e) {
            this.child.onError(e);
        }

        public void onNext(final Observable<T> o) {
            this.inner.schedule(new Action0() { // from class: rx.internal.operators.OperatorRetryWithPredicate.SourceSubscriber.1
                public void call() {
                    SourceSubscriber.this.attempts.incrementAndGet();
                    Subscriber<T> subscriber = new Subscriber<T>() { // from class: rx.internal.operators.OperatorRetryWithPredicate.SourceSubscriber.1.1
                        boolean done;

                        public void onCompleted() {
                            if (!this.done) {
                                this.done = true;
                                SourceSubscriber.this.child.onCompleted();
                            }
                        }

                        public void onError(Throwable e) {
                            if (!this.done) {
                                this.done = true;
                                if (((Boolean) SourceSubscriber.this.predicate.call(Integer.valueOf(SourceSubscriber.this.attempts.get()), e)).booleanValue() && !SourceSubscriber.this.inner.isUnsubscribed()) {
                                    SourceSubscriber.this.inner.schedule(this);
                                } else {
                                    SourceSubscriber.this.child.onError(e);
                                }
                            }
                        }

                        public void onNext(T v) {
                            if (!this.done) {
                                SourceSubscriber.this.child.onNext(v);
                                SourceSubscriber.this.pa.produced(1L);
                            }
                        }

                        public void setProducer(Producer p) {
                            SourceSubscriber.this.pa.setProducer(p);
                        }
                    };
                    SourceSubscriber.this.serialSubscription.set(subscriber);
                    o.unsafeSubscribe(subscriber);
                }
            });
        }
    }
}