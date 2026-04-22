package rx.observables;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Action2;
import rx.functions.Action3;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.functions.Func3;
import rx.internal.operators.BufferUntilSubscriber;
import rx.observers.SerializedObserver;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.CompositeSubscription;

public abstract class AsyncOnSubscribe<S, T> implements Observable.OnSubscribe<T> {
    protected abstract S generateState();

    protected abstract S next(S s, long j, Observer<Observable<? extends T>> observer);

    public /* bridge */ /* synthetic */ void call(Object x0) {
        call((Subscriber) ((Subscriber) x0));
    }

    protected void onUnsubscribe(S state) {
    }

    public static <S, T> AsyncOnSubscribe<S, T> createSingleState(Func0<? extends S> generator, final Action3<? super S, Long, ? super Observer<Observable<? extends T>>> next) {
        return new AsyncOnSubscribeImpl(generator, new Func3<S, Long, Observer<Observable<? extends T>>, S>() { // from class: rx.observables.AsyncOnSubscribe.1
            public /* bridge */ /* synthetic */ Object call(Object x0, Object x1, Object x2) {
                return call((AnonymousClass1) x0, (Long) x1, (Observer) ((Observer) x2));
            }

            public S call(S state, Long requested, Observer<Observable<? extends T>> subscriber) {
                next.call(state, requested, subscriber);
                return state;
            }
        });
    }

    public static <S, T> AsyncOnSubscribe<S, T> createSingleState(Func0<? extends S> generator, final Action3<? super S, Long, ? super Observer<Observable<? extends T>>> next, Action1<? super S> onUnsubscribe) {
        Func3<S, Long, Observer<Observable<? extends T>>, S> nextFunc = new Func3<S, Long, Observer<Observable<? extends T>>, S>() { // from class: rx.observables.AsyncOnSubscribe.2
            public /* bridge */ /* synthetic */ Object call(Object x0, Object x1, Object x2) {
                return call((AnonymousClass2) x0, (Long) x1, (Observer) ((Observer) x2));
            }

            public S call(S state, Long requested, Observer<Observable<? extends T>> subscriber) {
                next.call(state, requested, subscriber);
                return state;
            }
        };
        return new AsyncOnSubscribeImpl(generator, nextFunc, onUnsubscribe);
    }

    public static <S, T> AsyncOnSubscribe<S, T> createStateful(Func0<? extends S> generator, Func3<? super S, Long, ? super Observer<Observable<? extends T>>, ? extends S> next, Action1<? super S> onUnsubscribe) {
        return new AsyncOnSubscribeImpl(generator, next, onUnsubscribe);
    }

    public static <S, T> AsyncOnSubscribe<S, T> createStateful(Func0<? extends S> generator, Func3<? super S, Long, ? super Observer<Observable<? extends T>>, ? extends S> next) {
        return new AsyncOnSubscribeImpl(generator, next);
    }

    public static <T> AsyncOnSubscribe<Void, T> createStateless(final Action2<Long, ? super Observer<Observable<? extends T>>> next) {
        Func3<Void, Long, Observer<Observable<? extends T>>, Void> nextFunc = new Func3<Void, Long, Observer<Observable<? extends T>>, Void>() { // from class: rx.observables.AsyncOnSubscribe.3
            public /* bridge */ /* synthetic */ Object call(Object x0, Object x1, Object x2) {
                return call((Void) x0, (Long) x1, (Observer) ((Observer) x2));
            }

            public Void call(Void state, Long requested, Observer<Observable<? extends T>> subscriber) {
                next.call(requested, subscriber);
                return state;
            }
        };
        return new AsyncOnSubscribeImpl(nextFunc);
    }

    public static <T> AsyncOnSubscribe<Void, T> createStateless(final Action2<Long, ? super Observer<Observable<? extends T>>> next, final Action0 onUnsubscribe) {
        Func3<Void, Long, Observer<Observable<? extends T>>, Void> nextFunc = new Func3<Void, Long, Observer<Observable<? extends T>>, Void>() { // from class: rx.observables.AsyncOnSubscribe.4
            public /* bridge */ /* synthetic */ Object call(Object x0, Object x1, Object x2) {
                return call((Void) x0, (Long) x1, (Observer) ((Observer) x2));
            }

            public Void call(Void state, Long requested, Observer<Observable<? extends T>> subscriber) {
                next.call(requested, subscriber);
                return null;
            }
        };
        Action1<? super Void> wrappedOnUnsubscribe = new Action1<Void>() { // from class: rx.observables.AsyncOnSubscribe.5
            public void call(Void t) {
                onUnsubscribe.call();
            }
        };
        return new AsyncOnSubscribeImpl(nextFunc, wrappedOnUnsubscribe);
    }

    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    static final class AsyncOnSubscribeImpl<S, T> extends AsyncOnSubscribe<S, T> {
        private final Func0<? extends S> generator;
        private final Func3<? super S, Long, ? super Observer<Observable<? extends T>>, ? extends S> next;
        private final Action1<? super S> onUnsubscribe;

        @Override // rx.observables.AsyncOnSubscribe
        public /* bridge */ /* synthetic */ void call(Object x0) {
            super.call((Subscriber) ((Subscriber) x0));
        }

        AsyncOnSubscribeImpl(Func0<? extends S> generator, Func3<? super S, Long, ? super Observer<Observable<? extends T>>, ? extends S> next, Action1<? super S> onUnsubscribe) {
            this.generator = generator;
            this.next = next;
            this.onUnsubscribe = onUnsubscribe;
        }

        public AsyncOnSubscribeImpl(Func0<? extends S> generator, Func3<? super S, Long, ? super Observer<Observable<? extends T>>, ? extends S> next) {
            this(generator, next, null);
        }

        public AsyncOnSubscribeImpl(Func3<S, Long, Observer<Observable<? extends T>>, S> next, Action1<? super S> onUnsubscribe) {
            this(null, next, onUnsubscribe);
        }

        public AsyncOnSubscribeImpl(Func3<S, Long, Observer<Observable<? extends T>>, S> nextFunc) {
            this(null, nextFunc, null);
        }

        @Override // rx.observables.AsyncOnSubscribe
        protected S generateState() {
            if (this.generator == null) {
                return null;
            }
            return (S) this.generator.call();
        }

        @Override // rx.observables.AsyncOnSubscribe
        protected S next(S state, long requested, Observer<Observable<? extends T>> observer) {
            return (S) this.next.call(state, Long.valueOf(requested), observer);
        }

        @Override // rx.observables.AsyncOnSubscribe
        protected void onUnsubscribe(S state) {
            if (this.onUnsubscribe != null) {
                this.onUnsubscribe.call(state);
            }
        }
    }

    public final void call(final Subscriber<? super T> actualSubscriber) {
        try {
            S state = generateState();
            UnicastSubject<Observable<T>> subject = UnicastSubject.create();
            final AsyncOuterManager<S, T> outerProducer = new AsyncOuterManager<>(this, state, subject);
            Subscriber<T> concatSubscriber = new Subscriber<T>() { // from class: rx.observables.AsyncOnSubscribe.6
                public void onNext(T t) {
                    actualSubscriber.onNext(t);
                }

                public void onError(Throwable e) {
                    actualSubscriber.onError(e);
                }

                public void onCompleted() {
                    actualSubscriber.onCompleted();
                }

                public void setProducer(Producer p) {
                    outerProducer.setConcatProducer(p);
                }
            };
            subject.onBackpressureBuffer().concatMap(new Func1<Observable<T>, Observable<T>>() { // from class: rx.observables.AsyncOnSubscribe.7
                public /* bridge */ /* synthetic */ Object call(Object x0) {
                    return call((Observable) ((Observable) x0));
                }

                public Observable<T> call(Observable<T> v) {
                    return v.onBackpressureBuffer();
                }
            }).unsafeSubscribe(concatSubscriber);
            actualSubscriber.add(concatSubscriber);
            actualSubscriber.add(outerProducer);
            actualSubscriber.setProducer(outerProducer);
        } catch (Throwable ex) {
            actualSubscriber.onError(ex);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class AsyncOuterManager<S, T> implements Producer, Subscription, Observer<Observable<? extends T>> {
        Producer concatProducer;
        boolean emitting;
        long expectedDelivery;
        private boolean hasTerminated;
        private final UnicastSubject<Observable<T>> merger;
        private boolean onNextCalled;
        private final AsyncOnSubscribe<S, T> parent;
        List<Long> requests;
        private S state;
        final CompositeSubscription subscriptions = new CompositeSubscription();
        private final SerializedObserver<Observable<? extends T>> serializedSubscriber = new SerializedObserver<>(this);
        final AtomicBoolean isUnsubscribed = new AtomicBoolean();

        public /* bridge */ /* synthetic */ void onNext(Object x0) {
            onNext((Observable) ((Observable) x0));
        }

        public AsyncOuterManager(AsyncOnSubscribe<S, T> parent, S initialState, UnicastSubject<Observable<T>> merger) {
            this.parent = parent;
            this.state = initialState;
            this.merger = merger;
        }

        public void unsubscribe() {
            if (this.isUnsubscribed.compareAndSet(false, true)) {
                synchronized (this) {
                    if (this.emitting) {
                        this.requests = new ArrayList();
                        this.requests.add(0L);
                        return;
                    }
                    this.emitting = true;
                    cleanup();
                }
            }
        }

        void setConcatProducer(Producer p) {
            if (this.concatProducer != null) {
                throw new IllegalStateException("setConcatProducer may be called at most once!");
            }
            this.concatProducer = p;
        }

        public boolean isUnsubscribed() {
            return this.isUnsubscribed.get();
        }

        public void nextIteration(long requestCount) {
            this.state = this.parent.next(this.state, requestCount, this.serializedSubscriber);
        }

        void cleanup() {
            this.subscriptions.unsubscribe();
            try {
                this.parent.onUnsubscribe(this.state);
            } catch (Throwable ex) {
                handleThrownError(ex);
            }
        }

        public void request(long n) {
            if (n == 0) {
                return;
            }
            if (n < 0) {
                throw new IllegalStateException("Request can't be negative! " + n);
            }
            boolean quit = false;
            synchronized (this) {
                if (this.emitting) {
                    List<Long> q = this.requests;
                    if (q == null) {
                        q = new ArrayList();
                        this.requests = q;
                    }
                    q.add(Long.valueOf(n));
                    quit = true;
                } else {
                    this.emitting = true;
                }
            }
            this.concatProducer.request(n);
            if (quit || tryEmit(n)) {
                return;
            }
            while (true) {
                synchronized (this) {
                    try {
                        List<Long> q2 = this.requests;
                        if (q2 == null) {
                            this.emitting = false;
                            return;
                        }
                        try {
                            this.requests = null;
                            for (Long l : q2) {
                                long r = l.longValue();
                                if (tryEmit(r)) {
                                    return;
                                }
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

        public void requestRemaining(long n) {
            if (n == 0) {
                return;
            }
            if (n < 0) {
                throw new IllegalStateException("Request can't be negative! " + n);
            }
            synchronized (this) {
                if (this.emitting) {
                    List<Long> q = this.requests;
                    if (q == null) {
                        q = new ArrayList();
                        this.requests = q;
                    }
                    q.add(Long.valueOf(n));
                    return;
                }
                this.emitting = true;
                if (tryEmit(n)) {
                    return;
                }
                while (true) {
                    synchronized (this) {
                        try {
                            List<Long> q2 = this.requests;
                            if (q2 == null) {
                                this.emitting = false;
                                return;
                            }
                            try {
                                this.requests = null;
                                for (Long l : q2) {
                                    long r = l.longValue();
                                    if (tryEmit(r)) {
                                        return;
                                    }
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

        boolean tryEmit(long n) {
            if (isUnsubscribed()) {
                cleanup();
                return true;
            }
            try {
                this.onNextCalled = false;
                this.expectedDelivery = n;
                nextIteration(n);
                if (!this.hasTerminated && !isUnsubscribed()) {
                    if (this.onNextCalled) {
                        return false;
                    }
                    handleThrownError(new IllegalStateException("No events emitted!"));
                    return true;
                }
                cleanup();
                return true;
            } catch (Throwable ex) {
                handleThrownError(ex);
                return true;
            }
        }

        private void handleThrownError(Throwable ex) {
            if (this.hasTerminated) {
                RxJavaHooks.onError(ex);
                return;
            }
            this.hasTerminated = true;
            this.merger.onError(ex);
            cleanup();
        }

        public void onCompleted() {
            if (this.hasTerminated) {
                throw new IllegalStateException("Terminal event already emitted.");
            }
            this.hasTerminated = true;
            this.merger.onCompleted();
        }

        public void onError(Throwable e) {
            if (this.hasTerminated) {
                throw new IllegalStateException("Terminal event already emitted.");
            }
            this.hasTerminated = true;
            this.merger.onError(e);
        }

        public void onNext(Observable<? extends T> t) {
            if (this.onNextCalled) {
                throw new IllegalStateException("onNext called multiple times!");
            }
            this.onNextCalled = true;
            if (this.hasTerminated) {
                return;
            }
            subscribeBufferToObservable(t);
        }

        private void subscribeBufferToObservable(Observable<? extends T> t) {
            final Observable<T> create = BufferUntilSubscriber.create();
            final long expected = this.expectedDelivery;
            final Subscription subscription = new Subscriber<T>() { // from class: rx.observables.AsyncOnSubscribe.AsyncOuterManager.1
                long remaining;

                {
                    this.remaining = expected;
                }

                public void onNext(T t2) {
                    this.remaining--;
                    create.onNext(t2);
                }

                public void onError(Throwable e) {
                    create.onError(e);
                }

                public void onCompleted() {
                    create.onCompleted();
                    long r = this.remaining;
                    if (r > 0) {
                        AsyncOuterManager.this.requestRemaining(r);
                    }
                }
            };
            this.subscriptions.add(subscription);
            Observable<? extends T> doOnTerminate = t.doOnTerminate(new Action0() { // from class: rx.observables.AsyncOnSubscribe.AsyncOuterManager.2
                public void call() {
                    AsyncOuterManager.this.subscriptions.remove(subscription);
                }
            });
            doOnTerminate.subscribe(subscription);
            this.merger.onNext(create);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class UnicastSubject<T> extends Observable<T> implements Observer<T> {
        private final State<T> state;

        public static <T> UnicastSubject<T> create() {
            return new UnicastSubject<>(new State());
        }

        protected UnicastSubject(State<T> state) {
            super(state);
            this.state = state;
        }

        public void onCompleted() {
            this.state.subscriber.onCompleted();
        }

        public void onError(Throwable e) {
            this.state.subscriber.onError(e);
        }

        public void onNext(T t) {
            this.state.subscriber.onNext(t);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class State<T> implements Observable.OnSubscribe<T> {
            Subscriber<? super T> subscriber;

            State() {
            }

            public /* bridge */ /* synthetic */ void call(Object x0) {
                call((Subscriber) ((Subscriber) x0));
            }

            public void call(Subscriber<? super T> s) {
                synchronized (this) {
                    if (this.subscriber == null) {
                        this.subscriber = s;
                    } else {
                        s.onError(new IllegalStateException("There can be only one subscriber"));
                    }
                }
            }
        }
    }
}