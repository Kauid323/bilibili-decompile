package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.operators.completable.CompletableMergeArrayDelayError;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import j$.util.Objects;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public final class CompletableMergeDelayErrorIterable extends Completable {
    final Iterable<? extends CompletableSource> sources;

    public CompletableMergeDelayErrorIterable(Iterable<? extends CompletableSource> sources) {
        this.sources = sources;
    }

    @Override // io.reactivex.rxjava3.core.Completable
    public void subscribeActual(final CompletableObserver observer) {
        CompositeDisposable set = new CompositeDisposable();
        observer.onSubscribe(set);
        try {
            Iterator<? extends CompletableSource> iterator = (Iterator) Objects.requireNonNull(this.sources.iterator(), "The source iterator returned is null");
            AtomicInteger wip = new AtomicInteger(1);
            AtomicThrowable errors = new AtomicThrowable();
            set.add(new CompletableMergeArrayDelayError.TryTerminateAndReportDisposable(errors));
            while (!set.isDisposed()) {
                try {
                    boolean b = iterator.hasNext();
                    if (b) {
                        if (set.isDisposed()) {
                            return;
                        }
                        try {
                            CompletableSource c = (CompletableSource) Objects.requireNonNull(iterator.next(), "The iterator returned a null CompletableSource");
                            if (set.isDisposed()) {
                                return;
                            }
                            wip.getAndIncrement();
                            c.subscribe(new CompletableMergeArrayDelayError.MergeInnerCompletableObserver(observer, set, errors, wip));
                        } catch (Throwable e) {
                            Exceptions.throwIfFatal(e);
                            errors.tryAddThrowableOrReport(e);
                        }
                    }
                } catch (Throwable e2) {
                    Exceptions.throwIfFatal(e2);
                    errors.tryAddThrowableOrReport(e2);
                }
                if (wip.decrementAndGet() == 0) {
                    errors.tryTerminateConsumer(observer);
                    return;
                }
                return;
            }
        } catch (Throwable e3) {
            Exceptions.throwIfFatal(e3);
            observer.onError(e3);
        }
    }
}