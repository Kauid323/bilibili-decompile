package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.observables.GroupedObservable;
import j$.util.Objects;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableGroupBy<T, K, V> extends AbstractObservableWithUpstream<T, GroupedObservable<K, V>> {
    final int bufferSize;
    final boolean delayError;
    final Function<? super T, ? extends K> keySelector;
    final Function<? super T, ? extends V> valueSelector;

    public ObservableGroupBy(ObservableSource<T> source, Function<? super T, ? extends K> keySelector, Function<? super T, ? extends V> valueSelector, int bufferSize, boolean delayError) {
        super(source);
        this.keySelector = keySelector;
        this.valueSelector = valueSelector;
        this.bufferSize = bufferSize;
        this.delayError = delayError;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super GroupedObservable<K, V>> t) {
        this.source.subscribe(new GroupByObserver(t, this.keySelector, this.valueSelector, this.bufferSize, this.delayError));
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class GroupByObserver<T, K, V> extends AtomicInteger implements Observer<T>, Disposable {
        static final Object NULL_KEY = new Object();
        private static final long serialVersionUID = -3688291656102519502L;
        final int bufferSize;
        final boolean delayError;
        final Observer<? super GroupedObservable<K, V>> downstream;
        final Function<? super T, ? extends K> keySelector;
        Disposable upstream;
        final Function<? super T, ? extends V> valueSelector;
        final AtomicBoolean cancelled = new AtomicBoolean();
        final Map<Object, GroupedUnicast<K, V>> groups = new ConcurrentHashMap();

        public GroupByObserver(Observer<? super GroupedObservable<K, V>> actual, Function<? super T, ? extends K> keySelector, Function<? super T, ? extends V> valueSelector, int bufferSize, boolean delayError) {
            this.downstream = actual;
            this.keySelector = keySelector;
            this.valueSelector = valueSelector;
            this.bufferSize = bufferSize;
            this.delayError = delayError;
            lazySet(1);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable d) {
            if (DisposableHelper.validate(this.upstream, d)) {
                this.upstream = d;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            try {
                K key = this.keySelector.apply(t);
                Object mapKey = key != null ? key : NULL_KEY;
                GroupedUnicast<K, V> group = this.groups.get(mapKey);
                boolean newGroup = false;
                if (group == null) {
                    if (this.cancelled.get()) {
                        return;
                    }
                    group = GroupedUnicast.createWith(key, this.bufferSize, this, this.delayError);
                    this.groups.put(mapKey, group);
                    getAndIncrement();
                    newGroup = true;
                }
                try {
                    V v = (V) Objects.requireNonNull(this.valueSelector.apply(t), "The value supplied is null");
                    group.onNext(v);
                    if (newGroup) {
                        this.downstream.onNext(group);
                        if (group.state.tryAbandon()) {
                            cancel(key);
                            group.onComplete();
                        }
                    }
                } catch (Throwable e) {
                    Exceptions.throwIfFatal(e);
                    this.upstream.dispose();
                    if (newGroup) {
                        this.downstream.onNext(group);
                    }
                    onError(e);
                }
            } catch (Throwable e2) {
                Exceptions.throwIfFatal(e2);
                this.upstream.dispose();
                onError(e2);
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable t) {
            List<GroupedUnicast<K, V>> list = new ArrayList<>(this.groups.values());
            this.groups.clear();
            for (GroupedUnicast<K, V> e : list) {
                e.onError(t);
            }
            this.downstream.onError(t);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            List<GroupedUnicast<K, V>> list = new ArrayList<>(this.groups.values());
            this.groups.clear();
            for (GroupedUnicast<K, V> e : list) {
                e.onComplete();
            }
            this.downstream.onComplete();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            if (this.cancelled.compareAndSet(false, true) && decrementAndGet() == 0) {
                this.upstream.dispose();
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled.get();
        }

        public void cancel(K key) {
            Object mapKey = key != null ? key : NULL_KEY;
            this.groups.remove(mapKey);
            if (decrementAndGet() == 0) {
                this.upstream.dispose();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class GroupedUnicast<K, T> extends GroupedObservable<K, T> {
        final State<T, K> state;

        public static <T, K> GroupedUnicast<K, T> createWith(K key, int bufferSize, GroupByObserver<?, K, T> parent, boolean delayError) {
            State<T, K> state = new State<>(bufferSize, parent, key, delayError);
            return new GroupedUnicast<>(key, state);
        }

        protected GroupedUnicast(K key, State<T, K> state) {
            super(key);
            this.state = state;
        }

        @Override // io.reactivex.rxjava3.core.Observable
        protected void subscribeActual(Observer<? super T> observer) {
            this.state.subscribe(observer);
        }

        public void onNext(T t) {
            this.state.onNext(t);
        }

        public void onError(Throwable e) {
            this.state.onError(e);
        }

        public void onComplete() {
            this.state.onComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class State<T, K> extends AtomicInteger implements Disposable, ObservableSource<T> {
        static final int ABANDONED = 2;
        static final int ABANDONED_HAS_SUBSCRIBER = 3;
        static final int FRESH = 0;
        static final int HAS_SUBSCRIBER = 1;
        private static final long serialVersionUID = -3852313036005250360L;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final K key;
        final GroupByObserver<?, K, T> parent;
        final SpscLinkedArrayQueue<T> queue;
        final AtomicBoolean cancelled = new AtomicBoolean();
        final AtomicReference<Observer<? super T>> actual = new AtomicReference<>();
        final AtomicInteger once = new AtomicInteger();

        State(int bufferSize, GroupByObserver<?, K, T> parent, K key, boolean delayError) {
            this.queue = new SpscLinkedArrayQueue<>(bufferSize);
            this.parent = parent;
            this.key = key;
            this.delayError = delayError;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            if (this.cancelled.compareAndSet(false, true) && getAndIncrement() == 0) {
                this.actual.lazySet(null);
                cancelParent();
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled.get();
        }

        @Override // io.reactivex.rxjava3.core.ObservableSource
        public void subscribe(Observer<? super T> observer) {
            int s;
            int u;
            do {
                s = this.once.get();
                if ((s & 1) == 0) {
                    u = s | 1;
                } else {
                    EmptyDisposable.error(new IllegalStateException("Only one Observer allowed!"), observer);
                    return;
                }
            } while (!this.once.compareAndSet(s, u));
            observer.onSubscribe(this);
            this.actual.lazySet(observer);
            if (this.cancelled.get()) {
                this.actual.lazySet(null);
            } else {
                drain();
            }
        }

        public void onNext(T t) {
            this.queue.offer(t);
            drain();
        }

        public void onError(Throwable e) {
            this.error = e;
            this.done = true;
            drain();
        }

        public void onComplete() {
            this.done = true;
            drain();
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            int missed = 1;
            SpscLinkedArrayQueue<T> q = this.queue;
            boolean delayError = this.delayError;
            Observer<? super T> a = this.actual.get();
            while (true) {
                if (a != null) {
                    while (true) {
                        boolean d = this.done;
                        Object obj = (T) q.poll();
                        boolean empty = obj == null;
                        if (checkTerminated(d, empty, a, delayError)) {
                            return;
                        }
                        if (empty) {
                            break;
                        }
                        a.onNext(obj);
                    }
                }
                missed = addAndGet(-missed);
                if (missed != 0) {
                    if (a == null) {
                        Observer<? super T> a2 = this.actual.get();
                        a = a2;
                    }
                } else {
                    return;
                }
            }
        }

        void cancelParent() {
            if ((this.once.get() & 2) == 0) {
                this.parent.cancel(this.key);
            }
        }

        boolean tryAbandon() {
            return this.once.get() == 0 && this.once.compareAndSet(0, 2);
        }

        boolean checkTerminated(boolean d, boolean empty, Observer<? super T> a, boolean delayError) {
            if (this.cancelled.get()) {
                this.queue.clear();
                this.actual.lazySet(null);
                cancelParent();
                return true;
            } else if (d) {
                if (delayError) {
                    if (empty) {
                        Throwable e = this.error;
                        this.actual.lazySet(null);
                        if (e != null) {
                            a.onError(e);
                        } else {
                            a.onComplete();
                        }
                        return true;
                    }
                    return false;
                }
                Throwable e2 = this.error;
                if (e2 != null) {
                    this.queue.clear();
                    this.actual.lazySet(null);
                    a.onError(e2);
                    return true;
                } else if (empty) {
                    this.actual.lazySet(null);
                    a.onComplete();
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
    }
}