package rx.plugins;

import rx.Completable;

public abstract class RxJavaCompletableExecutionHook {
    @Deprecated
    public Completable.OnSubscribe onCreate(Completable.OnSubscribe f) {
        return f;
    }

    @Deprecated
    public Completable.OnSubscribe onSubscribeStart(Completable completableInstance, Completable.OnSubscribe onSubscribe) {
        return onSubscribe;
    }

    @Deprecated
    public Throwable onSubscribeError(Throwable e) {
        return e;
    }

    @Deprecated
    public Completable.Operator onLift(Completable.Operator lift) {
        return lift;
    }
}