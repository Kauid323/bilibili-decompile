package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Notification;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.internal.util.BlockingHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.observers.DisposableObserver;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;

public final class BlockingObservableLatest<T> implements Iterable<T> {
    final ObservableSource<T> source;

    public BlockingObservableLatest(ObservableSource<T> source) {
        this.source = source;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        BlockingObservableLatestIterator<T> lio = new BlockingObservableLatestIterator<>();
        Observable<Notification<T>> materialized = Observable.wrap(this.source).materialize();
        materialized.subscribe(lio);
        return lio;
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class BlockingObservableLatestIterator<T> extends DisposableObserver<Notification<T>> implements Iterator<T> {
        Notification<T> iteratorNotification;
        final Semaphore notify = new Semaphore(0);
        final AtomicReference<Notification<T>> value = new AtomicReference<>();

        BlockingObservableLatestIterator() {
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public /* bridge */ /* synthetic */ void onNext(Object args) {
            onNext((Notification) ((Notification) args));
        }

        public void onNext(Notification<T> args) {
            boolean wasNotAvailable = this.value.getAndSet(args) == null;
            if (wasNotAvailable) {
                this.notify.release();
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable e) {
            RxJavaPlugins.onError(e);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.iteratorNotification != null && this.iteratorNotification.isOnError()) {
                throw ExceptionHelper.wrapOrThrow(this.iteratorNotification.getError());
            }
            if (this.iteratorNotification == null) {
                try {
                    BlockingHelper.verifyNonBlocking();
                    this.notify.acquire();
                    Notification<T> n = this.value.getAndSet(null);
                    this.iteratorNotification = n;
                    if (n.isOnError()) {
                        throw ExceptionHelper.wrapOrThrow(n.getError());
                    }
                } catch (InterruptedException ex) {
                    dispose();
                    this.iteratorNotification = Notification.createOnError(ex);
                    throw ExceptionHelper.wrapOrThrow(ex);
                }
            }
            return this.iteratorNotification.isOnNext();
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext()) {
                T v = this.iteratorNotification.getValue();
                this.iteratorNotification = null;
                return v;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read-only iterator.");
        }
    }
}