package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.observables.ConnectableObservable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableRefCount<T> extends Observable<T> {
    RefConnection connection;
    final int n;
    final Scheduler scheduler;
    final ConnectableObservable<T> source;
    final long timeout;
    final TimeUnit unit;

    public ObservableRefCount(ConnectableObservable<T> source) {
        this(source, 1, 0L, TimeUnit.NANOSECONDS, null);
    }

    public ObservableRefCount(ConnectableObservable<T> source, int n, long timeout, TimeUnit unit, Scheduler scheduler) {
        this.source = source;
        this.n = n;
        this.timeout = timeout;
        this.unit = unit;
        this.scheduler = scheduler;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        RefConnection conn;
        boolean connect = false;
        synchronized (this) {
            conn = this.connection;
            if (conn == null) {
                conn = new RefConnection(this);
                this.connection = conn;
            }
            long c = conn.subscriberCount;
            if (c == 0 && conn.timer != null) {
                conn.timer.dispose();
            }
            conn.subscriberCount = c + 1;
            if (!conn.connected && 1 + c == this.n) {
                connect = true;
                conn.connected = true;
            }
        }
        this.source.subscribe(new RefCountObserver(observer, this, conn));
        if (connect) {
            this.source.connect(conn);
        }
    }

    void cancel(RefConnection rc) {
        synchronized (this) {
            if (this.connection != null && this.connection == rc) {
                long c = rc.subscriberCount - 1;
                rc.subscriberCount = c;
                if (c == 0 && rc.connected) {
                    if (this.timeout == 0) {
                        timeout(rc);
                        return;
                    }
                    SequentialDisposable sd = new SequentialDisposable();
                    rc.timer = sd;
                    sd.replace(this.scheduler.scheduleDirect(rc, this.timeout, this.unit));
                }
            }
        }
    }

    void terminated(RefConnection rc) {
        synchronized (this) {
            if (this.connection == rc) {
                if (rc.timer != null) {
                    rc.timer.dispose();
                    rc.timer = null;
                }
                long j2 = rc.subscriberCount - 1;
                rc.subscriberCount = j2;
                if (j2 == 0) {
                    this.connection = null;
                    this.source.reset();
                }
            }
        }
    }

    void timeout(RefConnection rc) {
        synchronized (this) {
            if (rc.subscriberCount == 0 && rc == this.connection) {
                this.connection = null;
                Disposable connectionObject = rc.get();
                DisposableHelper.dispose(rc);
                if (connectionObject == null) {
                    rc.disconnectedEarly = true;
                } else {
                    this.source.reset();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class RefConnection extends AtomicReference<Disposable> implements Runnable, Consumer<Disposable> {
        private static final long serialVersionUID = -4552101107598366241L;
        boolean connected;
        boolean disconnectedEarly;
        final ObservableRefCount<?> parent;
        long subscriberCount;
        Disposable timer;

        RefConnection(ObservableRefCount<?> parent) {
            this.parent = parent;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.parent.timeout(this);
        }

        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Disposable t) {
            DisposableHelper.replace(this, t);
            synchronized (this.parent) {
                if (this.disconnectedEarly) {
                    this.parent.source.reset();
                }
            }
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class RefCountObserver<T> extends AtomicBoolean implements Observer<T>, Disposable {
        private static final long serialVersionUID = -7419642935409022375L;
        final RefConnection connection;
        final Observer<? super T> downstream;
        final ObservableRefCount<T> parent;
        Disposable upstream;

        RefCountObserver(Observer<? super T> downstream, ObservableRefCount<T> parent, RefConnection connection) {
            this.downstream = downstream;
            this.parent = parent;
            this.connection = connection;
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable t) {
            if (compareAndSet(false, true)) {
                this.parent.terminated(this.connection);
                this.downstream.onError(t);
                return;
            }
            RxJavaPlugins.onError(t);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            if (compareAndSet(false, true)) {
                this.parent.terminated(this.connection);
                this.downstream.onComplete();
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.upstream.dispose();
            if (compareAndSet(false, true)) {
                this.parent.cancel(this.connection);
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable d) {
            if (DisposableHelper.validate(this.upstream, d)) {
                this.upstream = d;
                this.downstream.onSubscribe(this);
            }
        }
    }
}