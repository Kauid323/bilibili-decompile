package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.internal.observers.DeferredScalarDisposable;
import j$.util.function.BiConsumer;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiConsumer;

public final class ObservableFromCompletionStage<T> extends Observable<T> {
    final CompletionStage<T> stage;

    public ObservableFromCompletionStage(CompletionStage<T> stage) {
        this.stage = stage;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        BiConsumerAtomicReference<T> whenReference = new BiConsumerAtomicReference<>();
        CompletionStageHandler<T> handler = new CompletionStageHandler<>(observer, whenReference);
        whenReference.lazySet(handler);
        observer.onSubscribe(handler);
        this.stage.whenComplete(whenReference);
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class CompletionStageHandler<T> extends DeferredScalarDisposable<T> implements BiConsumer<T, Throwable> {
        private static final long serialVersionUID = 4665335664328839859L;
        final BiConsumerAtomicReference<T> whenReference;

        @Override // java.util.function.BiConsumer
        public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
            return BiConsumer.-CC.$default$andThen(this, biConsumer);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.function.BiConsumer
        public /* bridge */ /* synthetic */ void accept(Object item, Throwable error) {
            accept2((CompletionStageHandler<T>) item, error);
        }

        CompletionStageHandler(Observer<? super T> downstream, BiConsumerAtomicReference<T> whenReference) {
            super(downstream);
            this.whenReference = whenReference;
        }

        /* renamed from: accept  reason: avoid collision after fix types in other method */
        public void accept2(T item, Throwable error) {
            if (error != null) {
                this.downstream.onError(error);
            } else if (item != null) {
                complete(item);
            } else {
                this.downstream.onError(new NullPointerException("The CompletionStage terminated with null."));
            }
        }

        @Override // io.reactivex.rxjava3.internal.observers.DeferredScalarDisposable, io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            super.dispose();
            this.whenReference.set(null);
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class BiConsumerAtomicReference<T> extends AtomicReference<java.util.function.BiConsumer<T, Throwable>> implements java.util.function.BiConsumer<T, Throwable> {
        private static final long serialVersionUID = 45838553147237545L;

        @Override // java.util.function.BiConsumer
        public /* synthetic */ java.util.function.BiConsumer andThen(java.util.function.BiConsumer biConsumer) {
            return BiConsumer.-CC.$default$andThen(this, biConsumer);
        }

        BiConsumerAtomicReference() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.function.BiConsumer
        public /* bridge */ /* synthetic */ void accept(Object t, Throwable u) {
            accept2((BiConsumerAtomicReference<T>) t, u);
        }

        /* renamed from: accept  reason: avoid collision after fix types in other method */
        public void accept2(T t, Throwable u) {
            java.util.function.BiConsumer<T, Throwable> biConsumer = get();
            if (biConsumer != null) {
                biConsumer.accept(t, u);
            }
        }
    }
}