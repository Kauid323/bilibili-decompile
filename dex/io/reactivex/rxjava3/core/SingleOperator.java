package io.reactivex.rxjava3.core;

@FunctionalInterface
public interface SingleOperator<Downstream, Upstream> {
    SingleObserver<? super Upstream> apply(SingleObserver<? super Downstream> observer) throws Throwable;
}