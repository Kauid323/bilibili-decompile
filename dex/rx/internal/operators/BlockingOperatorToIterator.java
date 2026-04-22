package rx.internal.operators;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import rx.Notification;
import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.internal.util.RxRingBuffer;

public final class BlockingOperatorToIterator {
    private BlockingOperatorToIterator() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> Iterator<T> toIterator(Observable<? extends T> source) {
        SubscriberIterator<T> subscriber = new SubscriberIterator<>();
        source.materialize().subscribe(subscriber);
        return subscriber;
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class SubscriberIterator<T> extends Subscriber<Notification<? extends T>> implements Iterator<T> {
        static final int LIMIT = (RxRingBuffer.SIZE * 3) / 4;
        private Notification<? extends T> buf;
        private final BlockingQueue<Notification<? extends T>> notifications = new LinkedBlockingQueue();
        private int received;

        public /* bridge */ /* synthetic */ void onNext(Object x0) {
            onNext((Notification) ((Notification) x0));
        }

        public void onStart() {
            request(RxRingBuffer.SIZE);
        }

        public void onCompleted() {
        }

        public void onError(Throwable e) {
            this.notifications.offer(Notification.createOnError(e));
        }

        public void onNext(Notification<? extends T> args) {
            this.notifications.offer(args);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.buf == null) {
                this.buf = take();
                this.received++;
                if (this.received >= LIMIT) {
                    request(this.received);
                    this.received = 0;
                }
            }
            if (this.buf.isOnError()) {
                throw Exceptions.propagate(this.buf.getThrowable());
            }
            return !this.buf.isOnCompleted();
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext()) {
                T result = (T) this.buf.getValue();
                this.buf = null;
                return result;
            }
            throw new NoSuchElementException();
        }

        private Notification<? extends T> take() {
            try {
                Notification<? extends T> poll = this.notifications.poll();
                if (poll != null) {
                    return poll;
                }
                return this.notifications.take();
            } catch (InterruptedException e) {
                unsubscribe();
                throw Exceptions.propagate(e);
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read-only iterator");
        }
    }
}