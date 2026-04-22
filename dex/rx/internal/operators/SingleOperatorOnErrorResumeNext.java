package rx.internal.operators;

import rx.Single;
import rx.SingleSubscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func1;

public final class SingleOperatorOnErrorResumeNext<T> implements Single.OnSubscribe<T> {
    private final Single<? extends T> originalSingle;
    final Func1<Throwable, ? extends Single<? extends T>> resumeFunctionInCaseOfError;

    public /* bridge */ /* synthetic */ void call(Object x0) {
        call((SingleSubscriber) ((SingleSubscriber) x0));
    }

    private SingleOperatorOnErrorResumeNext(Single<? extends T> originalSingle, Func1<Throwable, ? extends Single<? extends T>> resumeFunctionInCaseOfError) {
        if (originalSingle == null) {
            throw new NullPointerException("originalSingle must not be null");
        }
        if (resumeFunctionInCaseOfError == null) {
            throw new NullPointerException("resumeFunctionInCaseOfError must not be null");
        }
        this.originalSingle = originalSingle;
        this.resumeFunctionInCaseOfError = resumeFunctionInCaseOfError;
    }

    public static <T> SingleOperatorOnErrorResumeNext<T> withFunction(Single<? extends T> originalSingle, Func1<Throwable, ? extends Single<? extends T>> resumeFunctionInCaseOfError) {
        return new SingleOperatorOnErrorResumeNext<>(originalSingle, resumeFunctionInCaseOfError);
    }

    public static <T> SingleOperatorOnErrorResumeNext<T> withOther(Single<? extends T> originalSingle, final Single<? extends T> resumeSingleInCaseOfError) {
        if (resumeSingleInCaseOfError == null) {
            throw new NullPointerException("resumeSingleInCaseOfError must not be null");
        }
        return new SingleOperatorOnErrorResumeNext<>(originalSingle, new Func1<Throwable, Single<? extends T>>() { // from class: rx.internal.operators.SingleOperatorOnErrorResumeNext.1
            public Single<? extends T> call(Throwable throwable) {
                return resumeSingleInCaseOfError;
            }
        });
    }

    public void call(final SingleSubscriber<? super T> child) {
        SingleSubscriber<T> singleSubscriber = new SingleSubscriber<T>() { // from class: rx.internal.operators.SingleOperatorOnErrorResumeNext.2
            public void onSuccess(T value) {
                child.onSuccess(value);
            }

            public void onError(Throwable error) {
                try {
                    ((Single) SingleOperatorOnErrorResumeNext.this.resumeFunctionInCaseOfError.call(error)).subscribe(child);
                } catch (Throwable innerError) {
                    Exceptions.throwOrReport(innerError, child);
                }
            }
        };
        child.add(singleSubscriber);
        this.originalSingle.subscribe(singleSubscriber);
    }
}