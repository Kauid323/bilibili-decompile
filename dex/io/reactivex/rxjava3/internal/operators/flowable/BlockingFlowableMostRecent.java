package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import io.reactivex.rxjava3.subscribers.DefaultSubscriber;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class BlockingFlowableMostRecent<T> implements Iterable<T> {
    final T initialValue;
    final Flowable<T> source;

    public BlockingFlowableMostRecent(Flowable<T> source, T initialValue) {
        this.source = source;
        this.initialValue = initialValue;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        MostRecentSubscriber<T> mostRecentSubscriber = new MostRecentSubscriber<>(this.initialValue);
        this.source.subscribe((FlowableSubscriber) mostRecentSubscriber);
        return mostRecentSubscriber.getIterable();
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class MostRecentSubscriber<T> extends DefaultSubscriber<T> {
        volatile Object value;

        MostRecentSubscriber(T value) {
            this.value = NotificationLite.next(value);
        }

        public void onComplete() {
            this.value = NotificationLite.complete();
        }

        public void onError(Throwable e) {
            this.value = NotificationLite.error(e);
        }

        public void onNext(T args) {
            this.value = NotificationLite.next(args);
        }

        public MostRecentSubscriber<T>.Iterator getIterable() {
            return new Iterator();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public final class Iterator implements java.util.Iterator<T> {
            private Object buf;

            Iterator() {
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                this.buf = MostRecentSubscriber.this.value;
                return !NotificationLite.isComplete(this.buf);
            }

            @Override // java.util.Iterator
            public T next() {
                try {
                    if (this.buf == null) {
                        this.buf = MostRecentSubscriber.this.value;
                    }
                    if (NotificationLite.isComplete(this.buf)) {
                        throw new NoSuchElementException();
                    }
                    if (NotificationLite.isError(this.buf)) {
                        throw ExceptionHelper.wrapOrThrow(NotificationLite.getError(this.buf));
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
        }
    }
}