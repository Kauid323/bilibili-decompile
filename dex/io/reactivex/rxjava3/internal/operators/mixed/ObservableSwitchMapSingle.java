package io.reactivex.rxjava3.internal.operators.mixed;

import androidx.compose.animation.core.MutatorMutex$;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import j$.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableSwitchMapSingle<T, R> extends Observable<R> {
    final boolean delayErrors;
    final Function<? super T, ? extends SingleSource<? extends R>> mapper;
    final Observable<T> source;

    public ObservableSwitchMapSingle(Observable<T> source, Function<? super T, ? extends SingleSource<? extends R>> mapper, boolean delayErrors) {
        this.source = source;
        this.mapper = mapper;
        this.delayErrors = delayErrors;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    protected void subscribeActual(Observer<? super R> observer) {
        if (!ScalarXMapZHelper.tryAsSingle(this.source, this.mapper, observer)) {
            this.source.subscribe(new SwitchMapSingleMainObserver(observer, this.mapper, this.delayErrors));
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class SwitchMapSingleMainObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        static final SwitchMapSingleObserver<Object> INNER_DISPOSED = new SwitchMapSingleObserver<>(null);
        private static final long serialVersionUID = -5402190102429853762L;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final Observer<? super R> downstream;
        final AtomicThrowable errors = new AtomicThrowable();
        final AtomicReference<SwitchMapSingleObserver<R>> inner = new AtomicReference<>();
        final Function<? super T, ? extends SingleSource<? extends R>> mapper;
        Disposable upstream;

        SwitchMapSingleMainObserver(Observer<? super R> downstream, Function<? super T, ? extends SingleSource<? extends R>> mapper, boolean delayErrors) {
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

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            SwitchMapSingleObserver<R> current;
            SwitchMapSingleObserver<R> current2 = this.inner.get();
            if (current2 != null) {
                current2.dispose();
            }
            try {
                SingleSource<? extends R> ss = (SingleSource) Objects.requireNonNull(this.mapper.apply(t), "The mapper returned a null SingleSource");
                SwitchMapSingleObserver<R> observer = new SwitchMapSingleObserver<>(this);
                do {
                    current = this.inner.get();
                    if (current == INNER_DISPOSED) {
                        return;
                    }
                } while (!MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.inner, current, observer));
                ss.subscribe(observer);
            } catch (Throwable ex) {
                Exceptions.throwIfFatal(ex);
                this.upstream.dispose();
                this.inner.getAndSet(INNER_DISPOSED);
                onError(ex);
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable t) {
            if (this.errors.tryAddThrowableOrReport(t)) {
                if (!this.delayErrors) {
                    disposeInner();
                }
                this.done = true;
                drain();
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            this.done = true;
            drain();
        }

        /* JADX WARN: Multi-variable type inference failed */
        void disposeInner() {
            SwitchMapSingleObserver<R> current = this.inner.getAndSet(INNER_DISPOSED);
            if (current != null && current != INNER_DISPOSED) {
                current.dispose();
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.cancelled = true;
            this.upstream.dispose();
            disposeInner();
            this.errors.tryTerminateAndReport();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        void innerError(SwitchMapSingleObserver<R> sender, Throwable ex) {
            if (MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.inner, sender, (Object) null)) {
                if (this.errors.tryAddThrowableOrReport(ex)) {
                    if (!this.delayErrors) {
                        this.upstream.dispose();
                        disposeInner();
                    }
                    drain();
                    return;
                }
                return;
            }
            RxJavaPlugins.onError(ex);
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            int missed = 1;
            Observer<? super R> downstream = this.downstream;
            AtomicThrowable errors = this.errors;
            AtomicReference<SwitchMapSingleObserver<R>> inner = this.inner;
            while (!this.cancelled) {
                if (errors.get() != null && !this.delayErrors) {
                    errors.tryTerminateConsumer(downstream);
                    return;
                }
                boolean d = this.done;
                SwitchMapSingleObserver<R> current = inner.get();
                boolean empty = current == null;
                if (d && empty) {
                    errors.tryTerminateConsumer(downstream);
                    return;
                } else if (!empty && current.item != null) {
                    MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(inner, current, (Object) null);
                    downstream.onNext((R) current.item);
                } else {
                    missed = addAndGet(-missed);
                    if (missed == 0) {
                        return;
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class SwitchMapSingleObserver<R> extends AtomicReference<Disposable> implements SingleObserver<R> {
            private static final long serialVersionUID = 8042919737683345351L;
            volatile R item;
            final SwitchMapSingleMainObserver<?, R> parent;

            SwitchMapSingleObserver(SwitchMapSingleMainObserver<?, R> parent) {
                this.parent = parent;
            }

            @Override // io.reactivex.rxjava3.core.SingleObserver, io.reactivex.rxjava3.core.CompletableObserver
            public void onSubscribe(Disposable d) {
                DisposableHelper.setOnce(this, d);
            }

            @Override // io.reactivex.rxjava3.core.SingleObserver
            public void onSuccess(R t) {
                this.item = t;
                this.parent.drain();
            }

            @Override // io.reactivex.rxjava3.core.SingleObserver, io.reactivex.rxjava3.core.CompletableObserver
            public void onError(Throwable e) {
                this.parent.innerError(this, e);
            }

            void dispose() {
                DisposableHelper.dispose(this);
            }
        }
    }
}