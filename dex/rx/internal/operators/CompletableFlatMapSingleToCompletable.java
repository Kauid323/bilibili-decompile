package rx.internal.operators;

import rx.Completable;
import rx.CompletableSubscriber;
import rx.Single;
import rx.SingleSubscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Func1;

public final class CompletableFlatMapSingleToCompletable<T> implements Completable.OnSubscribe {
    final Func1<? super T, ? extends Completable> mapper;
    final Single<T> source;

    public CompletableFlatMapSingleToCompletable(Single<T> source, Func1<? super T, ? extends Completable> mapper) {
        this.source = source;
        this.mapper = mapper;
    }

    public void call(CompletableSubscriber t) {
        SourceSubscriber<T> parent = new SourceSubscriber<>(t, this.mapper);
        t.onSubscribe(parent);
        this.source.subscribe(parent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class SourceSubscriber<T> extends SingleSubscriber<T> implements CompletableSubscriber {
        final CompletableSubscriber actual;
        final Func1<? super T, ? extends Completable> mapper;

        public SourceSubscriber(CompletableSubscriber actual, Func1<? super T, ? extends Completable> mapper) {
            this.actual = actual;
            this.mapper = mapper;
        }

        public void onSuccess(T value) {
            try {
                Completable c = (Completable) this.mapper.call(value);
                if (c == null) {
                    onError(new NullPointerException("The mapper returned a null Completable"));
                } else {
                    c.subscribe(this);
                }
            } catch (Throwable ex) {
                Exceptions.throwIfFatal(ex);
                onError(ex);
            }
        }

        public void onError(Throwable error) {
            this.actual.onError(error);
        }

        public void onCompleted() {
            this.actual.onCompleted();
        }

        public void onSubscribe(Subscription d) {
            add(d);
        }
    }
}