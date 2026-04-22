package rx.internal.operators;

import java.util.concurrent.TimeoutException;
import rx.Observable;
import rx.Producer;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Func3;
import rx.functions.Func4;
import rx.internal.producers.ProducerArbiter;
import rx.observers.SerializedSubscriber;
import rx.subscriptions.SerialSubscription;

class OperatorTimeoutBase<T> implements Observable.Operator<T, T> {
    final FirstTimeoutStub<T> firstTimeoutStub;
    final Observable<? extends T> other;
    final Scheduler scheduler;
    final TimeoutStub<T> timeoutStub;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public interface FirstTimeoutStub<T> extends Func3<TimeoutSubscriber<T>, Long, Scheduler.Worker, Subscription> {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public interface TimeoutStub<T> extends Func4<TimeoutSubscriber<T>, Long, T, Scheduler.Worker, Subscription> {
    }

    public /* bridge */ /* synthetic */ Object call(Object x0) {
        return call((Subscriber) ((Subscriber) x0));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OperatorTimeoutBase(FirstTimeoutStub<T> firstTimeoutStub, TimeoutStub<T> timeoutStub, Observable<? extends T> other, Scheduler scheduler) {
        this.firstTimeoutStub = firstTimeoutStub;
        this.timeoutStub = timeoutStub;
        this.other = other;
        this.scheduler = scheduler;
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        Scheduler.Worker inner = this.scheduler.createWorker();
        subscriber.add(inner);
        SerializedSubscriber<T> synchronizedSubscriber = new SerializedSubscriber<>(subscriber);
        SerialSubscription serial = new SerialSubscription();
        synchronizedSubscriber.add(serial);
        TimeoutSubscriber<T> timeoutSubscriber = new TimeoutSubscriber<>(synchronizedSubscriber, this.timeoutStub, serial, this.other, inner);
        synchronizedSubscriber.add(timeoutSubscriber);
        synchronizedSubscriber.setProducer(timeoutSubscriber.arbiter);
        serial.set((Subscription) this.firstTimeoutStub.call(timeoutSubscriber, 0L, inner));
        return timeoutSubscriber;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class TimeoutSubscriber<T> extends Subscriber<T> {
        long actual;
        final ProducerArbiter arbiter = new ProducerArbiter();
        final Scheduler.Worker inner;
        final Observable<? extends T> other;
        final SerialSubscription serial;
        final SerializedSubscriber<T> serializedSubscriber;
        boolean terminated;
        final TimeoutStub<T> timeoutStub;

        TimeoutSubscriber(SerializedSubscriber<T> serializedSubscriber, TimeoutStub<T> timeoutStub, SerialSubscription serial, Observable<? extends T> other, Scheduler.Worker inner) {
            this.serializedSubscriber = serializedSubscriber;
            this.timeoutStub = timeoutStub;
            this.serial = serial;
            this.other = other;
            this.inner = inner;
        }

        public void setProducer(Producer p) {
            this.arbiter.setProducer(p);
        }

        public void onNext(T value) {
            long a;
            boolean onNextWins = false;
            synchronized (this) {
                try {
                    try {
                        if (!this.terminated) {
                            long j2 = this.actual + 1;
                            this.actual = j2;
                            a = j2;
                            onNextWins = true;
                        } else {
                            a = this.actual;
                        }
                        if (onNextWins) {
                            this.serializedSubscriber.onNext(value);
                            this.serial.set((Subscription) this.timeoutStub.call(this, Long.valueOf(a), value, this.inner));
                        }
                    } catch (Throwable th) {
                        th = th;
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }

        public void onError(Throwable error) {
            boolean onErrorWins = false;
            synchronized (this) {
                if (!this.terminated) {
                    this.terminated = true;
                    onErrorWins = true;
                }
            }
            if (onErrorWins) {
                this.serial.unsubscribe();
                this.serializedSubscriber.onError(error);
            }
        }

        public void onCompleted() {
            boolean onCompletedWins = false;
            synchronized (this) {
                if (!this.terminated) {
                    this.terminated = true;
                    onCompletedWins = true;
                }
            }
            if (onCompletedWins) {
                this.serial.unsubscribe();
                this.serializedSubscriber.onCompleted();
            }
        }

        public void onTimeout(long seqId) {
            boolean timeoutWins = false;
            synchronized (this) {
                if (seqId == this.actual && !this.terminated) {
                    this.terminated = true;
                    timeoutWins = true;
                }
            }
            if (timeoutWins) {
                if (this.other == null) {
                    this.serializedSubscriber.onError(new TimeoutException());
                    return;
                }
                Subscriber<T> second = new Subscriber<T>() { // from class: rx.internal.operators.OperatorTimeoutBase.TimeoutSubscriber.1
                    public void onNext(T t) {
                        TimeoutSubscriber.this.serializedSubscriber.onNext(t);
                    }

                    public void onError(Throwable e) {
                        TimeoutSubscriber.this.serializedSubscriber.onError(e);
                    }

                    public void onCompleted() {
                        TimeoutSubscriber.this.serializedSubscriber.onCompleted();
                    }

                    public void setProducer(Producer p) {
                        TimeoutSubscriber.this.arbiter.setProducer(p);
                    }
                };
                this.other.unsafeSubscribe(second);
                this.serial.set(second);
            }
        }
    }
}