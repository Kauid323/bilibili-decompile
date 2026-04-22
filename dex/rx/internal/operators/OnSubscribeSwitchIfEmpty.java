package rx.internal.operators;

import java.util.concurrent.atomic.AtomicInteger;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.internal.producers.ProducerArbiter;
import rx.subscriptions.SerialSubscription;

public final class OnSubscribeSwitchIfEmpty<T> implements Observable.OnSubscribe<T> {
    final Observable<? extends T> alternate;
    final Observable<? extends T> source;

    public /* bridge */ /* synthetic */ void call(Object x0) {
        call((Subscriber) ((Subscriber) x0));
    }

    public OnSubscribeSwitchIfEmpty(Observable<? extends T> source, Observable<? extends T> alternate) {
        this.source = source;
        this.alternate = alternate;
    }

    public void call(Subscriber<? super T> child) {
        SerialSubscription serial = new SerialSubscription();
        ProducerArbiter arbiter = new ProducerArbiter();
        ParentSubscriber<T> parent = new ParentSubscriber<>(child, serial, arbiter, this.alternate);
        serial.set(parent);
        child.add(serial);
        child.setProducer(arbiter);
        parent.subscribe(this.source);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class ParentSubscriber<T> extends Subscriber<T> {
        volatile boolean active;
        private final Observable<? extends T> alternate;
        private final ProducerArbiter arbiter;
        private final Subscriber<? super T> child;
        private final SerialSubscription serial;
        private boolean empty = true;
        final AtomicInteger wip = new AtomicInteger();

        ParentSubscriber(Subscriber<? super T> child, SerialSubscription serial, ProducerArbiter arbiter, Observable<? extends T> alternate) {
            this.child = child;
            this.serial = serial;
            this.arbiter = arbiter;
            this.alternate = alternate;
        }

        public void setProducer(Producer producer) {
            this.arbiter.setProducer(producer);
        }

        public void onCompleted() {
            if (!this.empty) {
                this.child.onCompleted();
            } else if (!this.child.isUnsubscribed()) {
                this.active = false;
                subscribe(null);
            }
        }

        void subscribe(Observable<? extends T> source) {
            if (this.wip.getAndIncrement() == 0) {
                while (!this.child.isUnsubscribed()) {
                    if (!this.active) {
                        if (source == null) {
                            AlternateSubscriber<T> as = new AlternateSubscriber<>(this.child, this.arbiter);
                            this.serial.set(as);
                            this.active = true;
                            this.alternate.unsafeSubscribe(as);
                        } else {
                            this.active = true;
                            source.unsafeSubscribe(this);
                            source = null;
                        }
                    }
                    if (this.wip.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        public void onError(Throwable e) {
            this.child.onError(e);
        }

        public void onNext(T t) {
            this.empty = false;
            this.child.onNext(t);
            this.arbiter.produced(1L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class AlternateSubscriber<T> extends Subscriber<T> {
        private final ProducerArbiter arbiter;
        private final Subscriber<? super T> child;

        AlternateSubscriber(Subscriber<? super T> child, ProducerArbiter arbiter) {
            this.child = child;
            this.arbiter = arbiter;
        }

        public void setProducer(Producer producer) {
            this.arbiter.setProducer(producer);
        }

        public void onCompleted() {
            this.child.onCompleted();
        }

        public void onError(Throwable e) {
            this.child.onError(e);
        }

        public void onNext(T t) {
            this.child.onNext(t);
            this.arbiter.produced(1L);
        }
    }
}