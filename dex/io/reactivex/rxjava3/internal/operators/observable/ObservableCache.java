package io.reactivex.rxjava3.internal.operators.observable;

import androidx.compose.animation.core.MutatorMutex$;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableCache<T> extends AbstractObservableWithUpstream<T, T> implements Observer<T> {
    static final CacheDisposable[] EMPTY = new CacheDisposable[0];
    static final CacheDisposable[] TERMINATED = new CacheDisposable[0];
    final int capacityHint;
    volatile boolean done;
    Throwable error;
    final Node<T> head;
    final AtomicReference<CacheDisposable<T>[]> observers;
    final AtomicBoolean once;
    volatile long size;
    Node<T> tail;
    int tailOffset;

    public ObservableCache(Observable<T> source, int capacityHint) {
        super(source);
        this.capacityHint = capacityHint;
        this.once = new AtomicBoolean();
        Node<T> n = new Node<>(capacityHint);
        this.head = n;
        this.tail = n;
        this.observers = new AtomicReference<>(EMPTY);
    }

    @Override // io.reactivex.rxjava3.core.Observable
    protected void subscribeActual(Observer<? super T> t) {
        CacheDisposable<T> consumer = new CacheDisposable<>(t, this);
        t.onSubscribe(consumer);
        add(consumer);
        if (!this.once.get() && this.once.compareAndSet(false, true)) {
            this.source.subscribe(this);
        } else {
            replay(consumer);
        }
    }

    boolean isConnected() {
        return this.once.get();
    }

    boolean hasObservers() {
        return this.observers.get().length != 0;
    }

    long cachedEventCount() {
        return this.size;
    }

    void add(CacheDisposable<T> consumer) {
        CacheDisposable<T>[] current;
        CacheDisposable<T>[] next;
        do {
            current = this.observers.get();
            if (current == TERMINATED) {
                return;
            }
            int n = current.length;
            next = new CacheDisposable[n + 1];
            System.arraycopy(current, 0, next, 0, n);
            next[n] = consumer;
        } while (!MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.observers, current, next));
    }

    void remove(CacheDisposable<T> consumer) {
        CacheDisposable<T>[] current;
        CacheDisposable<T>[] next;
        do {
            current = this.observers.get();
            int n = current.length;
            if (n == 0) {
                return;
            }
            int j2 = -1;
            int i = 0;
            while (true) {
                if (i >= n) {
                    break;
                } else if (current[i] != consumer) {
                    i++;
                } else {
                    j2 = i;
                    break;
                }
            }
            if (j2 < 0) {
                return;
            }
            if (n == 1) {
                next = EMPTY;
            } else {
                CacheDisposable<T>[] next2 = new CacheDisposable[n - 1];
                System.arraycopy(current, 0, next2, 0, j2);
                System.arraycopy(current, j2 + 1, next2, j2, (n - j2) - 1);
                next = next2;
            }
        } while (!MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.observers, current, next));
    }

    void replay(CacheDisposable<T> consumer) {
        if (consumer.getAndIncrement() != 0) {
            return;
        }
        int missed = 1;
        long index = consumer.index;
        int offset = consumer.offset;
        Node<T> node = consumer.node;
        Observer<? super T> downstream = consumer.downstream;
        int capacity = this.capacityHint;
        while (!consumer.disposed) {
            boolean sourceDone = this.done;
            boolean empty = this.size == index;
            if (sourceDone && empty) {
                consumer.node = null;
                Throwable ex = this.error;
                if (ex != null) {
                    downstream.onError(ex);
                    return;
                } else {
                    downstream.onComplete();
                    return;
                }
            } else if (!empty) {
                if (offset == capacity) {
                    node = node.next;
                    offset = 0;
                }
                downstream.onNext((Object) node.values[offset]);
                offset++;
                index++;
            } else {
                consumer.index = index;
                consumer.offset = offset;
                consumer.node = node;
                missed = consumer.addAndGet(-missed);
                if (missed == 0) {
                    return;
                }
            }
        }
        consumer.node = null;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onSubscribe(Disposable d) {
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onNext(T t) {
        CacheDisposable<T>[] cacheDisposableArr;
        int tailOffset = this.tailOffset;
        if (tailOffset == this.capacityHint) {
            Node<T> n = new Node<>(tailOffset);
            n.values[0] = t;
            this.tailOffset = 1;
            this.tail.next = n;
            this.tail = n;
        } else {
            this.tail.values[tailOffset] = t;
            this.tailOffset = tailOffset + 1;
        }
        this.size++;
        for (CacheDisposable<T> consumer : this.observers.get()) {
            replay(consumer);
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onError(Throwable t) {
        CacheDisposable<T>[] andSet;
        this.error = t;
        this.done = true;
        for (CacheDisposable<T> consumer : this.observers.getAndSet(TERMINATED)) {
            replay(consumer);
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onComplete() {
        CacheDisposable<T>[] andSet;
        this.done = true;
        for (CacheDisposable<T> consumer : this.observers.getAndSet(TERMINATED)) {
            replay(consumer);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class CacheDisposable<T> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = 6770240836423125754L;
        volatile boolean disposed;
        final Observer<? super T> downstream;
        long index;
        Node<T> node;
        int offset;
        final ObservableCache<T> parent;

        CacheDisposable(Observer<? super T> downstream, ObservableCache<T> parent) {
            this.downstream = downstream;
            this.parent = parent;
            this.node = parent.head;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            if (!this.disposed) {
                this.disposed = true;
                this.parent.remove(this);
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.disposed;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Node<T> {
        volatile Node<T> next;
        final T[] values;

        Node(int capacityHint) {
            this.values = (T[]) new Object[capacityHint];
        }
    }
}