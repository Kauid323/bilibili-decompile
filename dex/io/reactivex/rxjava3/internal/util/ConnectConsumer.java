package io.reactivex.rxjava3.internal.util;

import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;

public final class ConnectConsumer implements Consumer<Disposable> {
    public Disposable disposable;

    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Disposable t) {
        this.disposable = t;
    }
}