package rx.internal.operators;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;
import rx.Notification;
import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;

public final class BlockingOperatorLatest {
    private BlockingOperatorLatest() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> Iterable<T> latest(final Observable<? extends T> source) {
        return new Iterable<T>() { // from class: rx.internal.operators.BlockingOperatorLatest.1
            @Override // java.lang.Iterable
            public Iterator<T> iterator() {
                LatestObserverIterator<T> lio = new LatestObserverIterator<>();
                source.materialize().subscribe(lio);
                return lio;
            }
        };
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class LatestObserverIterator<T> extends Subscriber<Notification<? extends T>> implements Iterator<T> {
        Notification<? extends T> iteratorNotification;
        final Semaphore notify = new Semaphore(0);
        final AtomicReference<Notification<? extends T>> value = new AtomicReference<>();

        LatestObserverIterator() {
        }

        public /* bridge */ /* synthetic */ void onNext(Object x0) {
            onNext((Notification) ((Notification) x0));
        }

        public void onNext(Notification<? extends T> args) {
            boolean wasNotAvailable = this.value.getAndSet(args) == null;
            if (wasNotAvailable) {
                this.notify.release();
            }
        }

        public void onError(Throwable e) {
        }

        public void onCompleted() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.iteratorNotification != null && this.iteratorNotification.isOnError()) {
                throw Exceptions.propagate(this.iteratorNotification.getThrowable());
            }
            if ((this.iteratorNotification == null || !this.iteratorNotification.isOnCompleted()) && this.iteratorNotification == null) {
                try {
                    this.notify.acquire();
                    Notification<? extends T> n = this.value.getAndSet(null);
                    this.iteratorNotification = n;
                    if (this.iteratorNotification.isOnError()) {
                        throw Exceptions.propagate(this.iteratorNotification.getThrowable());
                    }
                } catch (InterruptedException ex) {
                    unsubscribe();
                    Thread.currentThread().interrupt();
                    this.iteratorNotification = Notification.createOnError(ex);
                    throw Exceptions.propagate(ex);
                }
            }
            return !this.iteratorNotification.isOnCompleted();
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext() && this.iteratorNotification.isOnNext()) {
                T v = (T) this.iteratorNotification.getValue();
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