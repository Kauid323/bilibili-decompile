package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.jdk8.FlowableFromCompletionStage;
import j$.util.function.BiConsumer;
import java.util.concurrent.CompletionStage;
import java.util.function.BiConsumer;

public final class CompletableFromCompletionStage<T> extends Completable {
    final CompletionStage<T> stage;

    public CompletableFromCompletionStage(CompletionStage<T> stage) {
        this.stage = stage;
    }

    @Override // io.reactivex.rxjava3.core.Completable
    protected void subscribeActual(CompletableObserver observer) {
        FlowableFromCompletionStage.BiConsumerAtomicReference<Object> whenReference = new FlowableFromCompletionStage.BiConsumerAtomicReference<>();
        CompletionStageHandler<Object> handler = new CompletionStageHandler<>(observer, whenReference);
        whenReference.lazySet(handler);
        observer.onSubscribe(handler);
        this.stage.whenComplete(whenReference);
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class CompletionStageHandler<T> implements Disposable, BiConsumer<T, Throwable> {
        final CompletableObserver downstream;
        final FlowableFromCompletionStage.BiConsumerAtomicReference<T> whenReference;

        @Override // java.util.function.BiConsumer
        public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
            return BiConsumer.-CC.$default$andThen(this, biConsumer);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.function.BiConsumer
        public /* bridge */ /* synthetic */ void accept(Object item, Throwable error) {
            accept2((CompletionStageHandler<T>) item, error);
        }

        CompletionStageHandler(CompletableObserver downstream, FlowableFromCompletionStage.BiConsumerAtomicReference<T> whenReference) {
            this.downstream = downstream;
            this.whenReference = whenReference;
        }

        /* renamed from: accept  reason: avoid collision after fix types in other method */
        public void accept2(T item, Throwable error) {
            if (error != null) {
                this.downstream.onError(error);
            } else {
                this.downstream.onComplete();
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.whenReference.set(null);
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.whenReference.get() == null;
        }
    }
}