package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;

public final class CompletableMergeArrayDelayError extends Completable {
    final CompletableSource[] sources;

    public CompletableMergeArrayDelayError(CompletableSource[] sources) {
        this.sources = sources;
    }

    @Override // io.reactivex.rxjava3.core.Completable
    public void subscribeActual(final CompletableObserver observer) {
        CompletableSource[] completableSourceArr;
        CompositeDisposable set = new CompositeDisposable();
        AtomicInteger wip = new AtomicInteger(this.sources.length + 1);
        AtomicThrowable errors = new AtomicThrowable();
        set.add(new TryTerminateAndReportDisposable(errors));
        observer.onSubscribe(set);
        for (CompletableSource c : this.sources) {
            if (set.isDisposed()) {
                return;
            }
            if (c == null) {
                Throwable ex = new NullPointerException("A completable source is null");
                errors.tryAddThrowableOrReport(ex);
                wip.decrementAndGet();
            } else {
                c.subscribe(new MergeInnerCompletableObserver(observer, set, errors, wip));
            }
        }
        if (wip.decrementAndGet() == 0) {
            errors.tryTerminateConsumer(observer);
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class TryTerminateAndReportDisposable implements Disposable {
        final AtomicThrowable errors;

        /* JADX INFO: Access modifiers changed from: package-private */
        public TryTerminateAndReportDisposable(AtomicThrowable errors) {
            this.errors = errors;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.errors.tryTerminateAndReport();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.errors.isTerminated();
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class MergeInnerCompletableObserver implements CompletableObserver {
        final CompletableObserver downstream;
        final AtomicThrowable errors;
        final CompositeDisposable set;
        final AtomicInteger wip;

        /* JADX INFO: Access modifiers changed from: package-private */
        public MergeInnerCompletableObserver(CompletableObserver observer, CompositeDisposable set, AtomicThrowable error, AtomicInteger wip) {
            this.downstream = observer;
            this.set = set;
            this.errors = error;
            this.wip = wip;
        }

        @Override // io.reactivex.rxjava3.core.CompletableObserver
        public void onSubscribe(Disposable d) {
            this.set.add(d);
        }

        @Override // io.reactivex.rxjava3.core.CompletableObserver
        public void onError(Throwable e) {
            if (this.errors.tryAddThrowableOrReport(e)) {
                tryTerminate();
            }
        }

        @Override // io.reactivex.rxjava3.core.CompletableObserver
        public void onComplete() {
            tryTerminate();
        }

        void tryTerminate() {
            if (this.wip.decrementAndGet() == 0) {
                this.errors.tryTerminateConsumer(this.downstream);
            }
        }
    }
}