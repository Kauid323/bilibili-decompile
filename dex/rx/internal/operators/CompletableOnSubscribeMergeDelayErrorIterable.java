package rx.internal.operators;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Completable;
import rx.CompletableSubscriber;
import rx.Subscription;
import rx.internal.util.atomic.MpscLinkedAtomicQueue;
import rx.internal.util.unsafe.MpscLinkedQueue;
import rx.internal.util.unsafe.UnsafeAccess;
import rx.subscriptions.CompositeSubscription;

public final class CompletableOnSubscribeMergeDelayErrorIterable implements Completable.OnSubscribe {
    final Iterable<? extends Completable> sources;

    public CompletableOnSubscribeMergeDelayErrorIterable(Iterable<? extends Completable> sources) {
        this.sources = sources;
    }

    public void call(final CompletableSubscriber s) {
        MpscLinkedAtomicQueue mpscLinkedAtomicQueue;
        final CompositeSubscription set = new CompositeSubscription();
        s.onSubscribe(set);
        try {
            Iterator<? extends Completable> iterator = this.sources.iterator();
            if (iterator == null) {
                s.onError(new NullPointerException("The source iterator returned is null"));
                return;
            }
            final AtomicInteger wip = new AtomicInteger(1);
            boolean z = false;
            if (UnsafeAccess.isUnsafeAvailable()) {
                mpscLinkedAtomicQueue = new MpscLinkedQueue();
            } else {
                mpscLinkedAtomicQueue = new MpscLinkedAtomicQueue();
            }
            while (!set.isUnsubscribed()) {
                try {
                    boolean b = iterator.hasNext();
                    if (b) {
                        if (set.isUnsubscribed()) {
                            return;
                        }
                        try {
                            Completable c = iterator.next();
                            if (set.isUnsubscribed()) {
                                return;
                            }
                            if (c == null) {
                                NullPointerException e = new NullPointerException("A completable source is null");
                                mpscLinkedAtomicQueue.offer(e);
                                if (wip.decrementAndGet() == 0) {
                                    if (mpscLinkedAtomicQueue.isEmpty()) {
                                        s.onCompleted();
                                        return;
                                    } else {
                                        s.onError(CompletableOnSubscribeMerge.collectErrors(mpscLinkedAtomicQueue));
                                        return;
                                    }
                                }
                                return;
                            }
                            wip.getAndIncrement();
                            final MpscLinkedAtomicQueue mpscLinkedAtomicQueue2 = mpscLinkedAtomicQueue;
                            c.unsafeSubscribe(new CompletableSubscriber() { // from class: rx.internal.operators.CompletableOnSubscribeMergeDelayErrorIterable.1
                                public void onSubscribe(Subscription d) {
                                    set.add(d);
                                }

                                public void onError(Throwable e2) {
                                    mpscLinkedAtomicQueue2.offer(e2);
                                    tryTerminate();
                                }

                                public void onCompleted() {
                                    tryTerminate();
                                }

                                void tryTerminate() {
                                    if (wip.decrementAndGet() == 0) {
                                        if (mpscLinkedAtomicQueue2.isEmpty()) {
                                            s.onCompleted();
                                        } else {
                                            s.onError(CompletableOnSubscribeMerge.collectErrors(mpscLinkedAtomicQueue2));
                                        }
                                    }
                                }
                            });
                            z = b;
                        } catch (Throwable th) {
                            mpscLinkedAtomicQueue.offer(th);
                            if (wip.decrementAndGet() == 0) {
                                if (mpscLinkedAtomicQueue.isEmpty()) {
                                    s.onCompleted();
                                    return;
                                } else {
                                    s.onError(CompletableOnSubscribeMerge.collectErrors(mpscLinkedAtomicQueue));
                                    return;
                                }
                            }
                            return;
                        }
                    } else if (wip.decrementAndGet() == 0) {
                        if (mpscLinkedAtomicQueue.isEmpty()) {
                            s.onCompleted();
                            return;
                        } else {
                            s.onError(CompletableOnSubscribeMerge.collectErrors(mpscLinkedAtomicQueue));
                            return;
                        }
                    } else {
                        return;
                    }
                } catch (Throwable th2) {
                    mpscLinkedAtomicQueue.offer(th2);
                    if (wip.decrementAndGet() == 0) {
                        if (mpscLinkedAtomicQueue.isEmpty()) {
                            s.onCompleted();
                            return;
                        } else {
                            s.onError(CompletableOnSubscribeMerge.collectErrors(mpscLinkedAtomicQueue));
                            return;
                        }
                    }
                    return;
                }
            }
        } catch (Throwable e2) {
            s.onError(e2);
        }
    }
}