package io.reactivex.rxjava3.core;

@FunctionalInterface
public interface CompletableOperator {
    CompletableObserver apply(CompletableObserver observer) throws Throwable;
}