package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.util.BlockingHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class BlockingObservableIterable<T> implements Iterable<T> {
    final int bufferSize;
    final ObservableSource<? extends T> source;

    public BlockingObservableIterable(ObservableSource<? extends T> source, int bufferSize) {
        this.source = source;
        this.bufferSize = bufferSize;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        BlockingObservableIterator<T> it = new BlockingObservableIterator<>(this.bufferSize);
        this.source.subscribe(it);
        return it;
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class BlockingObservableIterator<T> extends AtomicReference<Disposable> implements Observer<T>, Iterator<T>, Disposable {
        private static final long serialVersionUID = 6695226475494099826L;
        volatile boolean done;
        volatile Throwable error;
        final SpscLinkedArrayQueue<T> queue;
        final Lock lock = new ReentrantLock();
        final Condition condition = this.lock.newCondition();

        BlockingObservableIterator(int batchSize) {
            this.queue = new SpscLinkedArrayQueue<>(batchSize);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            while (!isDisposed()) {
                boolean d = this.done;
                boolean empty = this.queue.isEmpty();
                if (d) {
                    Throwable e = this.error;
                    if (e != null) {
                        throw ExceptionHelper.wrapOrThrow(e);
                    }
                    if (empty) {
                        return false;
                    }
                }
                if (empty) {
                    try {
                        BlockingHelper.verifyNonBlocking();
                        this.lock.lock();
                        while (!this.done && this.queue.isEmpty() && !isDisposed()) {
                            this.condition.await();
                        }
                        this.lock.unlock();
                    } catch (InterruptedException ex) {
                        DisposableHelper.dispose(this);
                        signalConsumer();
                        throw ExceptionHelper.wrapOrThrow(ex);
                    }
                } else {
                    return true;
                }
            }
            Throwable e2 = this.error;
            if (e2 == null) {
                return false;
            }
            throw ExceptionHelper.wrapOrThrow(e2);
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext()) {
                return this.queue.poll();
            }
            throw new NoSuchElementException();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable d) {
            DisposableHelper.setOnce(this, d);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            this.queue.offer(t);
            signalConsumer();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable t) {
            this.error = t;
            this.done = true;
            signalConsumer();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            this.done = true;
            signalConsumer();
        }

        void signalConsumer() {
            this.lock.lock();
            try {
                this.condition.signalAll();
            } finally {
                this.lock.unlock();
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
            signalConsumer();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }
    }
}