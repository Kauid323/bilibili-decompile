package io.reactivex.rxjava3.internal.operators.mixed;

import androidx.compose.animation.core.MutatorMutex$;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import j$.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableSwitchMapCompletable<T> extends Completable {
    final boolean delayErrors;
    final Function<? super T, ? extends CompletableSource> mapper;
    final Observable<T> source;

    public ObservableSwitchMapCompletable(Observable<T> source, Function<? super T, ? extends CompletableSource> mapper, boolean delayErrors) {
        this.source = source;
        this.mapper = mapper;
        this.delayErrors = delayErrors;
    }

    @Override // io.reactivex.rxjava3.core.Completable
    protected void subscribeActual(CompletableObserver observer) {
        if (!ScalarXMapZHelper.tryAsCompletable(this.source, this.mapper, observer)) {
            this.source.subscribe(new SwitchMapCompletableObserver(observer, this.mapper, this.delayErrors));
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class SwitchMapCompletableObserver<T> implements Observer<T>, Disposable {
        static final SwitchMapInnerObserver INNER_DISPOSED = new SwitchMapInnerObserver(null);
        final boolean delayErrors;
        volatile boolean done;
        final CompletableObserver downstream;
        final AtomicThrowable errors = new AtomicThrowable();
        final AtomicReference<SwitchMapInnerObserver> inner = new AtomicReference<>();
        final Function<? super T, ? extends CompletableSource> mapper;
        Disposable upstream;

        SwitchMapCompletableObserver(CompletableObserver downstream, Function<? super T, ? extends CompletableSource> mapper, boolean delayErrors) {
            this.downstream = downstream;
            this.mapper = mapper;
            this.delayErrors = delayErrors;
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable d) {
            if (DisposableHelper.validate(this.upstream, d)) {
                this.upstream = d;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            SwitchMapInnerObserver current;
            try {
                CompletableSource c = (CompletableSource) Objects.requireNonNull(this.mapper.apply(t), "The mapper returned a null CompletableSource");
                SwitchMapInnerObserver o = new SwitchMapInnerObserver(this);
                do {
                    current = this.inner.get();
                    if (current == INNER_DISPOSED) {
                        return;
                    }
                } while (!MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.inner, current, o));
                if (current != null) {
                    current.dispose();
                }
                c.subscribe(o);
            } catch (Throwable ex) {
                Exceptions.throwIfFatal(ex);
                this.upstream.dispose();
                onError(ex);
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable t) {
            if (this.errors.tryAddThrowableOrReport(t)) {
                if (this.delayErrors) {
                    onComplete();
                    return;
                }
                disposeInner();
                this.errors.tryTerminateConsumer(this.downstream);
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            this.done = true;
            if (this.inner.get() == null) {
                this.errors.tryTerminateConsumer(this.downstream);
            }
        }

        void disposeInner() {
            SwitchMapInnerObserver o = this.inner.getAndSet(INNER_DISPOSED);
            if (o != null && o != INNER_DISPOSED) {
                o.dispose();
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.upstream.dispose();
            disposeInner();
            this.errors.tryTerminateAndReport();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.inner.get() == INNER_DISPOSED;
        }

        void innerError(SwitchMapInnerObserver sender, Throwable error) {
            if (MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.inner, sender, (Object) null)) {
                if (this.errors.tryAddThrowableOrReport(error)) {
                    if (this.delayErrors) {
                        if (this.done) {
                            this.errors.tryTerminateConsumer(this.downstream);
                            return;
                        }
                        return;
                    }
                    this.upstream.dispose();
                    disposeInner();
                    this.errors.tryTerminateConsumer(this.downstream);
                    return;
                }
                return;
            }
            RxJavaPlugins.onError(error);
        }

        void innerComplete(SwitchMapInnerObserver sender) {
            if (MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.inner, sender, (Object) null) && this.done) {
                this.errors.tryTerminateConsumer(this.downstream);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class SwitchMapInnerObserver extends AtomicReference<Disposable> implements CompletableObserver {
            private static final long serialVersionUID = -8003404460084760287L;
            final SwitchMapCompletableObserver<?> parent;

            SwitchMapInnerObserver(SwitchMapCompletableObserver<?> parent) {
                this.parent = parent;
            }

            @Override // io.reactivex.rxjava3.core.CompletableObserver
            public void onSubscribe(Disposable d) {
                DisposableHelper.setOnce(this, d);
            }

            @Override // io.reactivex.rxjava3.core.CompletableObserver
            public void onError(Throwable e) {
                this.parent.innerError(this, e);
            }

            @Override // io.reactivex.rxjava3.core.CompletableObserver
            public void onComplete() {
                this.parent.innerComplete(this);
            }

            void dispose() {
                DisposableHelper.dispose(this);
            }
        }
    }
}