package io.reactivex.rxjava3.observers;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.EndConsumerHelper;

public abstract class DefaultObserver<T> implements Observer<T> {
    private Disposable upstream;

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onSubscribe(Disposable d) {
        if (EndConsumerHelper.validate(this.upstream, d, getClass())) {
            this.upstream = d;
            onStart();
        }
    }

    protected final void cancel() {
        Disposable upstream = this.upstream;
        this.upstream = DisposableHelper.DISPOSED;
        upstream.dispose();
    }

    protected void onStart() {
    }
}