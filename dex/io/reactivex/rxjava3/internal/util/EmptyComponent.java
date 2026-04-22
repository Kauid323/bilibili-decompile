package io.reactivex.rxjava3.internal.util;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public enum EmptyComponent implements FlowableSubscriber<Object>, Observer<Object>, MaybeObserver<Object>, SingleObserver<Object>, CompletableObserver, Subscription, Disposable {
    INSTANCE;

    public static <T> Subscriber<T> asSubscriber() {
        return INSTANCE;
    }

    public static <T> Observer<T> asObserver() {
        return INSTANCE;
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public void dispose() {
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public boolean isDisposed() {
        return true;
    }

    public void request(long n) {
    }

    public void cancel() {
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onSubscribe(Disposable d) {
        d.dispose();
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber
    public void onSubscribe(Subscription s) {
        s.cancel();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onNext(Object t) {
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onError(Throwable t) {
        RxJavaPlugins.onError(t);
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onComplete() {
    }

    @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver
    public void onSuccess(Object value) {
    }
}