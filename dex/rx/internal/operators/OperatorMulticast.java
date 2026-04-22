package rx.internal.operators;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.observables.ConnectableObservable;
import rx.observers.Subscribers;
import rx.subjects.Subject;
import rx.subscriptions.Subscriptions;

public final class OperatorMulticast<T, R> extends ConnectableObservable<R> {
    final AtomicReference<Subject<? super T, ? extends R>> connectedSubject;
    final Object guard;
    Subscription guardedSubscription;
    final Observable<? extends T> source;
    final Func0<? extends Subject<? super T, ? extends R>> subjectFactory;
    Subscriber<T> subscription;
    final List<Subscriber<? super R>> waitingForConnect;

    public OperatorMulticast(Observable<? extends T> source, Func0<? extends Subject<? super T, ? extends R>> subjectFactory) {
        this(new Object(), new AtomicReference(), new ArrayList(), source, subjectFactory);
    }

    private OperatorMulticast(final Object guard, final AtomicReference<Subject<? super T, ? extends R>> connectedSubject, final List<Subscriber<? super R>> waitingForConnect, Observable<? extends T> source, Func0<? extends Subject<? super T, ? extends R>> subjectFactory) {
        super(new Observable.OnSubscribe<R>() { // from class: rx.internal.operators.OperatorMulticast.1
            public /* bridge */ /* synthetic */ void call(Object x0) {
                call((Subscriber) ((Subscriber) x0));
            }

            public void call(Subscriber<? super R> subscriber) {
                synchronized (guard) {
                    if (connectedSubject.get() == null) {
                        waitingForConnect.add(subscriber);
                    } else {
                        ((Subject) connectedSubject.get()).unsafeSubscribe(subscriber);
                    }
                }
            }
        });
        this.guard = guard;
        this.connectedSubject = connectedSubject;
        this.waitingForConnect = waitingForConnect;
        this.source = source;
        this.subjectFactory = subjectFactory;
    }

    public void connect(Action1<? super Subscription> connection) {
        synchronized (this.guard) {
            if (this.subscription != null) {
                connection.call(this.guardedSubscription);
                return;
            }
            Subject<? super T, ? extends R> subject = (Subject) this.subjectFactory.call();
            this.subscription = Subscribers.from(subject);
            final AtomicReference<Subscription> gs = new AtomicReference<>();
            gs.set(Subscriptions.create(new Action0() { // from class: rx.internal.operators.OperatorMulticast.2
                public void call() {
                    synchronized (OperatorMulticast.this.guard) {
                        try {
                            try {
                                if (OperatorMulticast.this.guardedSubscription == gs.get()) {
                                    Subscriber<T> subscriber = OperatorMulticast.this.subscription;
                                    OperatorMulticast.this.subscription = null;
                                    OperatorMulticast.this.guardedSubscription = null;
                                    OperatorMulticast.this.connectedSubject.set(null);
                                    if (subscriber != null) {
                                        subscriber.unsubscribe();
                                    }
                                }
                            } catch (Throwable th) {
                                th = th;
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            throw th;
                        }
                    }
                }
            }));
            this.guardedSubscription = gs.get();
            for (final Subscriber<? super R> s : this.waitingForConnect) {
                subject.unsafeSubscribe(new Subscriber<R>(s) { // from class: rx.internal.operators.OperatorMulticast.3
                    public void onNext(R t) {
                        s.onNext(t);
                    }

                    public void onError(Throwable e) {
                        s.onError(e);
                    }

                    public void onCompleted() {
                        s.onCompleted();
                    }
                });
            }
            this.waitingForConnect.clear();
            this.connectedSubject.set(subject);
            connection.call(this.guardedSubscription);
            synchronized (this.guard) {
                try {
                    try {
                        Subscriber<T> sub = this.subscription;
                        if (sub != null) {
                            this.source.subscribe(sub);
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
    }
}