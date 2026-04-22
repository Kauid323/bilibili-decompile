package io.reactivex.rxjava3.internal.fuseable;

public final class CancellableQueueFuseable<T> extends AbstractEmptyQueueFuseable<T> {
    volatile boolean disposed;

    @Override // io.reactivex.rxjava3.internal.fuseable.AbstractEmptyQueueFuseable
    public void cancel() {
        this.disposed = true;
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.AbstractEmptyQueueFuseable, io.reactivex.rxjava3.disposables.Disposable
    public void dispose() {
        this.disposed = true;
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.AbstractEmptyQueueFuseable, io.reactivex.rxjava3.disposables.Disposable
    public boolean isDisposed() {
        return this.disposed;
    }
}