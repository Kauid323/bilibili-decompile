package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.subjects.PublishSubject;
import j$.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservablePublishSelector<T, R> extends AbstractObservableWithUpstream<T, R> {
    final Function<? super Observable<T>, ? extends ObservableSource<R>> selector;

    public ObservablePublishSelector(final ObservableSource<T> source, final Function<? super Observable<T>, ? extends ObservableSource<R>> selector) {
        super(source);
        this.selector = selector;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    protected void subscribeActual(Observer<? super R> observer) {
        PublishSubject<T> subject = PublishSubject.create();
        try {
            ObservableSource<? extends R> target = (ObservableSource) Objects.requireNonNull(this.selector.apply(subject), "The selector returned a null ObservableSource");
            TargetObserver<R> o = new TargetObserver<>(observer);
            target.subscribe(o);
            this.source.subscribe(new SourceObserver(subject, o));
        } catch (Throwable ex) {
            Exceptions.throwIfFatal(ex);
            EmptyDisposable.error(ex, observer);
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class SourceObserver<T> implements Observer<T> {
        final PublishSubject<T> subject;
        final AtomicReference<Disposable> target;

        SourceObserver(PublishSubject<T> subject, AtomicReference<Disposable> target) {
            this.subject = subject;
            this.target = target;
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable d) {
            DisposableHelper.setOnce(this.target, d);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T value) {
            this.subject.onNext(value);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable e) {
            this.subject.onError(e);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            this.subject.onComplete();
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class TargetObserver<R> extends AtomicReference<Disposable> implements Observer<R>, Disposable {
        private static final long serialVersionUID = 854110278590336484L;
        final Observer<? super R> downstream;
        Disposable upstream;

        TargetObserver(Observer<? super R> downstream) {
            this.downstream = downstream;
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable d) {
            if (DisposableHelper.validate(this.upstream, d)) {
                this.upstream = d;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(R value) {
            this.downstream.onNext(value);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable e) {
            DisposableHelper.dispose(this);
            this.downstream.onError(e);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            DisposableHelper.dispose(this);
            this.downstream.onComplete();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.upstream.dispose();
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }
    }
}