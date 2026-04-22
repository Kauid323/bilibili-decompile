package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Notification;
import io.reactivex.rxjava3.internal.util.BlockingHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.subscribers.DisposableSubscriber;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;

public final class BlockingFlowableNext<T> implements Iterable<T> {
    final Publisher<? extends T> source;

    public BlockingFlowableNext(Publisher<? extends T> source) {
        this.source = source;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        NextSubscriber<T> nextSubscriber = new NextSubscriber<>();
        return new NextIterator(this.source, nextSubscriber);
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class NextIterator<T> implements Iterator<T> {
        private Throwable error;
        private boolean hasNext = true;
        private boolean isNextConsumed = true;
        private final Publisher<? extends T> items;
        private T next;
        private boolean started;
        private final NextSubscriber<T> subscriber;

        NextIterator(Publisher<? extends T> items, NextSubscriber<T> subscriber) {
            this.items = items;
            this.subscriber = subscriber;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.error != null) {
                throw ExceptionHelper.wrapOrThrow(this.error);
            }
            if (this.hasNext) {
                return !this.isNextConsumed || moveToNext();
            }
            return false;
        }

        private boolean moveToNext() {
            try {
                if (!this.started) {
                    this.started = true;
                    this.subscriber.setWaiting();
                    Flowable.fromPublisher(this.items).materialize().subscribe((FlowableSubscriber<? super Notification<T>>) this.subscriber);
                }
                Notification<T> nextNotification = this.subscriber.takeNext();
                if (nextNotification.isOnNext()) {
                    this.isNextConsumed = false;
                    this.next = nextNotification.getValue();
                    return true;
                }
                this.hasNext = false;
                if (nextNotification.isOnComplete()) {
                    return false;
                }
                this.error = nextNotification.getError();
                throw ExceptionHelper.wrapOrThrow(this.error);
            } catch (InterruptedException e) {
                this.subscriber.dispose();
                this.error = e;
                throw ExceptionHelper.wrapOrThrow(e);
            }
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.error != null) {
                throw ExceptionHelper.wrapOrThrow(this.error);
            }
            if (hasNext()) {
                this.isNextConsumed = true;
                return this.next;
            }
            throw new NoSuchElementException("No more elements");
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read only iterator");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class NextSubscriber<T> extends DisposableSubscriber<Notification<T>> {
        private final BlockingQueue<Notification<T>> buf = new ArrayBlockingQueue(1);
        final AtomicInteger waiting = new AtomicInteger();

        NextSubscriber() {
        }

        public /* bridge */ /* synthetic */ void onNext(Object args) {
            onNext((Notification) ((Notification) args));
        }

        public void onComplete() {
        }

        public void onError(Throwable e) {
            RxJavaPlugins.onError(e);
        }

        public void onNext(Notification<T> args) {
            if (this.waiting.getAndSet(0) == 1 || !args.isOnNext()) {
                Notification<T> toOffer = args;
                while (!this.buf.offer(toOffer)) {
                    Notification<T> concurrentItem = this.buf.poll();
                    if (concurrentItem != null && !concurrentItem.isOnNext()) {
                        toOffer = concurrentItem;
                    }
                }
            }
        }

        public Notification<T> takeNext() throws InterruptedException {
            setWaiting();
            BlockingHelper.verifyNonBlocking();
            return this.buf.take();
        }

        void setWaiting() {
            this.waiting.set(1);
        }
    }
}