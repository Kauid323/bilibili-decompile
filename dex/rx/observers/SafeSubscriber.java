package rx.observers;

import java.util.Arrays;
import rx.Subscriber;
import rx.exceptions.CompositeException;
import rx.exceptions.Exceptions;
import rx.exceptions.OnCompletedFailedException;
import rx.exceptions.OnErrorFailedException;
import rx.exceptions.OnErrorNotImplementedException;
import rx.exceptions.UnsubscribeFailedException;
import rx.plugins.RxJavaHooks;
import rx.plugins.RxJavaPlugins;

public class SafeSubscriber<T> extends Subscriber<T> {
    private final Subscriber<? super T> actual;
    boolean done;

    public SafeSubscriber(Subscriber<? super T> actual) {
        super(actual);
        this.actual = actual;
    }

    public void onCompleted() {
        UnsubscribeFailedException unsubscribeFailedException;
        if (!this.done) {
            this.done = true;
            try {
                this.actual.onCompleted();
                try {
                    unsubscribe();
                } finally {
                }
            } catch (Throwable e) {
                try {
                    Exceptions.throwIfFatal(e);
                    RxJavaHooks.onError(e);
                    throw new OnCompletedFailedException(e.getMessage(), e);
                } catch (Throwable e2) {
                    try {
                        unsubscribe();
                        throw e2;
                    } finally {
                    }
                }
            }
        }
    }

    public void onError(Throwable e) {
        Exceptions.throwIfFatal(e);
        if (!this.done) {
            this.done = true;
            _onError(e);
        }
    }

    public void onNext(T t) {
        try {
            if (!this.done) {
                this.actual.onNext(t);
            }
        } catch (Throwable e) {
            Exceptions.throwOrReport(e, this);
        }
    }

    protected void _onError(Throwable e) {
        RxJavaPlugins.getInstance().getErrorHandler().handleError(e);
        try {
            this.actual.onError(e);
            try {
                unsubscribe();
            } catch (Throwable unsubscribeException) {
                RxJavaHooks.onError(unsubscribeException);
                throw new OnErrorFailedException(unsubscribeException);
            }
        } catch (OnErrorNotImplementedException e2) {
            try {
                unsubscribe();
                throw e2;
            } catch (Throwable unsubscribeException2) {
                RxJavaHooks.onError(unsubscribeException2);
                throw new OnErrorNotImplementedException("Observer.onError not implemented and error while unsubscribing.", new CompositeException(Arrays.asList(e, unsubscribeException2)));
            }
        } catch (Throwable e22) {
            RxJavaHooks.onError(e22);
            try {
                unsubscribe();
                throw new OnErrorFailedException("Error occurred when trying to propagate error to Observer.onError", new CompositeException(Arrays.asList(e, e22)));
            } catch (Throwable unsubscribeException3) {
                RxJavaHooks.onError(unsubscribeException3);
                throw new OnErrorFailedException("Error occurred when trying to propagate error to Observer.onError and during unsubscription.", new CompositeException(Arrays.asList(e, e22, unsubscribeException3)));
            }
        }
    }

    public Subscriber<? super T> getActual() {
        return this.actual;
    }
}