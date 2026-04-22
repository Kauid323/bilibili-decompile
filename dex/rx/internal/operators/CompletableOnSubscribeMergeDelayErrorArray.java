package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Completable;
import rx.CompletableSubscriber;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

public final class CompletableOnSubscribeMergeDelayErrorArray implements Completable.OnSubscribe {
    final Completable[] sources;

    public CompletableOnSubscribeMergeDelayErrorArray(Completable[] sources) {
        this.sources = sources;
    }

    public void call(final CompletableSubscriber s) {
        final CompositeSubscription set = new CompositeSubscription();
        final AtomicInteger wip = new AtomicInteger(this.sources.length + 1);
        final Queue<Throwable> q = new ConcurrentLinkedQueue<>();
        s.onSubscribe(set);
        Completable[] arr$ = this.sources;
        for (Completable c : arr$) {
            if (set.isUnsubscribed()) {
                return;
            }
            if (c == null) {
                q.offer(new NullPointerException("A completable source is null"));
                wip.decrementAndGet();
            } else {
                c.unsafeSubscribe(new CompletableSubscriber() { // from class: rx.internal.operators.CompletableOnSubscribeMergeDelayErrorArray.1
                    public void onSubscribe(Subscription d) {
                        set.add(d);
                    }

                    public void onError(Throwable e) {
                        q.offer(e);
                        tryTerminate();
                    }

                    public void onCompleted() {
                        tryTerminate();
                    }

                    void tryTerminate() {
                        if (wip.decrementAndGet() == 0) {
                            if (q.isEmpty()) {
                                s.onCompleted();
                            } else {
                                s.onError(CompletableOnSubscribeMerge.collectErrors(q));
                            }
                        }
                    }
                });
            }
        }
        if (wip.decrementAndGet() == 0) {
            if (q.isEmpty()) {
                s.onCompleted();
            } else {
                s.onError(CompletableOnSubscribeMerge.collectErrors(q));
            }
        }
    }
}