package io.reactivex.rxjava3.internal.operators.observable;

import androidx.compose.animation.core.MutatorMutex$;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.HasUpstreamObservableSource;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.observables.ConnectableObservable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservablePublish<T> extends ConnectableObservable<T> implements HasUpstreamObservableSource<T> {
    final AtomicReference<PublishConnection<T>> current = new AtomicReference<>();
    final ObservableSource<T> source;

    public ObservablePublish(ObservableSource<T> source) {
        this.source = source;
    }

    @Override // io.reactivex.rxjava3.observables.ConnectableObservable
    public void connect(Consumer<? super Disposable> connection) {
        PublishConnection<T> conn;
        while (true) {
            conn = this.current.get();
            if (conn != null && !conn.isDisposed()) {
                break;
            }
            PublishConnection<T> fresh = new PublishConnection<>(this.current);
            if (MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.current, conn, fresh)) {
                conn = fresh;
                break;
            }
        }
        boolean z = false;
        if (!conn.connect.get() && conn.connect.compareAndSet(false, true)) {
            z = true;
        }
        boolean doConnect = z;
        try {
            connection.accept(conn);
            if (doConnect) {
                this.source.subscribe(conn);
            }
        } catch (Throwable ex) {
            Exceptions.throwIfFatal(ex);
            throw ExceptionHelper.wrapOrThrow(ex);
        }
    }

    @Override // io.reactivex.rxjava3.core.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        PublishConnection<T> conn;
        while (true) {
            conn = this.current.get();
            if (conn != null) {
                break;
            }
            PublishConnection<T> fresh = new PublishConnection<>(this.current);
            if (MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.current, conn, fresh)) {
                conn = fresh;
                break;
            }
        }
        InnerDisposable<T> inner = new InnerDisposable<>(observer, conn);
        observer.onSubscribe(inner);
        if (conn.add(inner)) {
            if (inner.isDisposed()) {
                conn.remove(inner);
                return;
            }
            return;
        }
        Throwable error = conn.error;
        if (error != null) {
            observer.onError(error);
        } else {
            observer.onComplete();
        }
    }

    @Override // io.reactivex.rxjava3.observables.ConnectableObservable
    public void reset() {
        PublishConnection<T> conn = this.current.get();
        if (conn != null && conn.isDisposed()) {
            MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.current, conn, (Object) null);
        }
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.HasUpstreamObservableSource
    public ObservableSource<T> source() {
        return this.source;
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class PublishConnection<T> extends AtomicReference<InnerDisposable<T>[]> implements Observer<T>, Disposable {
        static final InnerDisposable[] EMPTY = new InnerDisposable[0];
        static final InnerDisposable[] TERMINATED = new InnerDisposable[0];
        private static final long serialVersionUID = -3251430252873581268L;
        final AtomicReference<PublishConnection<T>> current;
        Throwable error;
        final AtomicBoolean connect = new AtomicBoolean();
        final AtomicReference<Disposable> upstream = new AtomicReference<>();

        PublishConnection(AtomicReference<PublishConnection<T>> current) {
            this.current = current;
            lazySet(EMPTY);
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            getAndSet(TERMINATED);
            MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.current, this, (Object) null);
            DisposableHelper.dispose(this.upstream);
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return get() == TERMINATED;
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable d) {
            DisposableHelper.setOnce(this.upstream, d);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            InnerDisposable<T>[] innerDisposableArr;
            for (InnerDisposable<T> inner : get()) {
                inner.downstream.onNext(t);
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable e) {
            InnerDisposable<T>[] andSet;
            if (this.upstream.get() != DisposableHelper.DISPOSED) {
                this.error = e;
                this.upstream.lazySet(DisposableHelper.DISPOSED);
                for (InnerDisposable<T> inner : getAndSet(TERMINATED)) {
                    inner.downstream.onError(e);
                }
                return;
            }
            RxJavaPlugins.onError(e);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            InnerDisposable<T>[] andSet;
            this.upstream.lazySet(DisposableHelper.DISPOSED);
            for (InnerDisposable<T> inner : getAndSet(TERMINATED)) {
                inner.downstream.onComplete();
            }
        }

        public boolean add(InnerDisposable<T> inner) {
            InnerDisposable<T>[] a;
            InnerDisposable<T>[] b;
            do {
                a = get();
                if (a == TERMINATED) {
                    return false;
                }
                int n = a.length;
                b = new InnerDisposable[n + 1];
                System.arraycopy(a, 0, b, 0, n);
                b[n] = inner;
            } while (!compareAndSet(a, b));
            return true;
        }

        public void remove(InnerDisposable<T> inner) {
            InnerDisposable<T>[] a;
            InnerDisposable<T>[] b;
            do {
                a = get();
                int n = a.length;
                if (n == 0) {
                    return;
                }
                int j2 = -1;
                int i = 0;
                while (true) {
                    if (i >= n) {
                        break;
                    } else if (a[i] != inner) {
                        i++;
                    } else {
                        j2 = i;
                        break;
                    }
                }
                if (j2 < 0) {
                    return;
                }
                b = EMPTY;
                if (n != 1) {
                    b = new InnerDisposable[n - 1];
                    System.arraycopy(a, 0, b, 0, j2);
                    System.arraycopy(a, j2 + 1, b, j2, (n - j2) - 1);
                }
            } while (!compareAndSet(a, b));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class InnerDisposable<T> extends AtomicReference<PublishConnection<T>> implements Disposable {
        private static final long serialVersionUID = 7463222674719692880L;
        final Observer<? super T> downstream;

        InnerDisposable(Observer<? super T> downstream, PublishConnection<T> parent) {
            this.downstream = downstream;
            lazySet(parent);
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            PublishConnection<T> p = getAndSet(null);
            if (p != null) {
                p.remove(this);
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return get() == null;
        }
    }
}