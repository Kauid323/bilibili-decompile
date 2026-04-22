package rx.internal.operators;

import java.util.Iterator;
import java.util.NoSuchElementException;
import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;

public final class BlockingOperatorMostRecent {
    private BlockingOperatorMostRecent() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> Iterable<T> mostRecent(final Observable<? extends T> source, final T initialValue) {
        return new Iterable<T>() { // from class: rx.internal.operators.BlockingOperatorMostRecent.1
            @Override // java.lang.Iterable
            public Iterator<T> iterator() {
                MostRecentObserver<T> mostRecentObserver = new MostRecentObserver<>(initialValue);
                source.subscribe(mostRecentObserver);
                return mostRecentObserver.getIterable();
            }
        };
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class MostRecentObserver<T> extends Subscriber<T> {
        volatile Object value;

        MostRecentObserver(T value) {
            this.value = NotificationLite.next(value);
        }

        public void onCompleted() {
            this.value = NotificationLite.completed();
        }

        public void onError(Throwable e) {
            this.value = NotificationLite.error(e);
        }

        public void onNext(T args) {
            this.value = NotificationLite.next(args);
        }

        public Iterator<T> getIterable() {
            return new Iterator<T>() { // from class: rx.internal.operators.BlockingOperatorMostRecent.MostRecentObserver.1
                private Object buf;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    this.buf = MostRecentObserver.this.value;
                    return !NotificationLite.isCompleted(this.buf);
                }

                @Override // java.util.Iterator
                public T next() {
                    try {
                        if (this.buf == null) {
                            this.buf = MostRecentObserver.this.value;
                        }
                        if (NotificationLite.isCompleted(this.buf)) {
                            throw new NoSuchElementException();
                        }
                        if (NotificationLite.isError(this.buf)) {
                            throw Exceptions.propagate(NotificationLite.getError(this.buf));
                        }
                        return (T) NotificationLite.getValue(this.buf);
                    } finally {
                        this.buf = null;
                    }
                }

                @Override // java.util.Iterator
                public void remove() {
                    throw new UnsupportedOperationException("Read only iterator");
                }
            };
        }
    }
}