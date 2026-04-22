package rx.internal.operators;

import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func1;
import rx.internal.operators.OnSubscribeCreate;
import rx.internal.producers.ProducerArbiter;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.SerialSubscription;

public final class OperatorOnErrorResumeNextViaFunction<T> implements Observable.Operator<T, T> {
    final Func1<? super Throwable, ? extends Observable<? extends T>> resumeFunction;

    public /* bridge */ /* synthetic */ Object call(Object x0) {
        return call((Subscriber) ((Subscriber) x0));
    }

    public static <T> OperatorOnErrorResumeNextViaFunction<T> withSingle(final Func1<? super Throwable, ? extends T> resumeFunction) {
        return new OperatorOnErrorResumeNextViaFunction<>(new Func1<Throwable, Observable<? extends T>>() { // from class: rx.internal.operators.OperatorOnErrorResumeNextViaFunction.1
            public Observable<? extends T> call(Throwable t) {
                return Observable.just(resumeFunction.call(t));
            }
        });
    }

    public static <T> OperatorOnErrorResumeNextViaFunction<T> withOther(final Observable<? extends T> other) {
        return new OperatorOnErrorResumeNextViaFunction<>(new Func1<Throwable, Observable<? extends T>>() { // from class: rx.internal.operators.OperatorOnErrorResumeNextViaFunction.2
            public Observable<? extends T> call(Throwable t) {
                return other;
            }
        });
    }

    public static <T> OperatorOnErrorResumeNextViaFunction<T> withException(final Observable<? extends T> other) {
        return new OperatorOnErrorResumeNextViaFunction<>(new Func1<Throwable, Observable<? extends T>>() { // from class: rx.internal.operators.OperatorOnErrorResumeNextViaFunction.3
            public Observable<? extends T> call(Throwable t) {
                if (t instanceof Exception) {
                    return other;
                }
                return Observable.error(t);
            }
        });
    }

    public OperatorOnErrorResumeNextViaFunction(Func1<? super Throwable, ? extends Observable<? extends T>> f) {
        this.resumeFunction = f;
    }

    public Subscriber<? super T> call(final Subscriber<? super T> child) {
        final ProducerArbiter pa = new ProducerArbiter();
        final SerialSubscription serial = new SerialSubscription();
        OnSubscribeCreate.NoneEmitter noneEmitter = (Subscriber<T>) new Subscriber<T>() { // from class: rx.internal.operators.OperatorOnErrorResumeNextViaFunction.4
            private boolean done;
            long produced;

            public void onCompleted() {
                if (this.done) {
                    return;
                }
                this.done = true;
                child.onCompleted();
            }

            public void onError(Throwable e) {
                if (this.done) {
                    Exceptions.throwIfFatal(e);
                    RxJavaHooks.onError(e);
                    return;
                }
                this.done = true;
                try {
                    unsubscribe();
                    Subscriber<T> next = new Subscriber<T>() { // from class: rx.internal.operators.OperatorOnErrorResumeNextViaFunction.4.1
                        public void onNext(T t) {
                            child.onNext(t);
                        }

                        public void onError(Throwable e2) {
                            child.onError(e2);
                        }

                        public void onCompleted() {
                            child.onCompleted();
                        }

                        public void setProducer(Producer producer) {
                            pa.setProducer(producer);
                        }
                    };
                    serial.set(next);
                    long p = this.produced;
                    if (p != 0) {
                        pa.produced(p);
                    }
                    Observable<? extends T> resume = (Observable) OperatorOnErrorResumeNextViaFunction.this.resumeFunction.call(e);
                    resume.unsafeSubscribe(next);
                } catch (Throwable e2) {
                    Exceptions.throwOrReport(e2, child);
                }
            }

            public void onNext(T t) {
                if (this.done) {
                    return;
                }
                this.produced++;
                child.onNext(t);
            }

            public void setProducer(Producer producer) {
                pa.setProducer(producer);
            }
        };
        serial.set(noneEmitter);
        child.add(serial);
        child.setProducer(pa);
        return noneEmitter;
    }
}