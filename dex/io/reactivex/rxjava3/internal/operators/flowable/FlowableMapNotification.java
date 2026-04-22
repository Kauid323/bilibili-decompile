package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscribers.SinglePostCompleteSubscriber;
import j$.util.Objects;
import org.reactivestreams.Subscriber;

public final class FlowableMapNotification<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final Supplier<? extends R> onCompleteSupplier;
    final Function<? super Throwable, ? extends R> onErrorMapper;
    final Function<? super T, ? extends R> onNextMapper;

    public FlowableMapNotification(Flowable<T> source, Function<? super T, ? extends R> onNextMapper, Function<? super Throwable, ? extends R> onErrorMapper, Supplier<? extends R> onCompleteSupplier) {
        super(source);
        this.onNextMapper = onNextMapper;
        this.onErrorMapper = onErrorMapper;
        this.onCompleteSupplier = onCompleteSupplier;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    protected void subscribeActual(Subscriber<? super R> s) {
        this.source.subscribe((FlowableSubscriber) new MapNotificationSubscriber(s, this.onNextMapper, this.onErrorMapper, this.onCompleteSupplier));
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class MapNotificationSubscriber<T, R> extends SinglePostCompleteSubscriber<T, R> {
        private static final long serialVersionUID = 2757120512858778108L;
        final Supplier<? extends R> onCompleteSupplier;
        final Function<? super Throwable, ? extends R> onErrorMapper;
        final Function<? super T, ? extends R> onNextMapper;

        MapNotificationSubscriber(Subscriber<? super R> actual, Function<? super T, ? extends R> onNextMapper, Function<? super Throwable, ? extends R> onErrorMapper, Supplier<? extends R> onCompleteSupplier) {
            super(actual);
            this.onNextMapper = onNextMapper;
            this.onErrorMapper = onErrorMapper;
            this.onCompleteSupplier = onCompleteSupplier;
        }

        public void onNext(T t) {
            try {
                Object requireNonNull = Objects.requireNonNull(this.onNextMapper.apply(t), "The onNext publisher returned is null");
                this.produced++;
                this.downstream.onNext(requireNonNull);
            } catch (Throwable e) {
                Exceptions.throwIfFatal(e);
                this.downstream.onError(e);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void onError(Throwable t) {
            try {
                complete(Objects.requireNonNull(this.onErrorMapper.apply(t), "The onError publisher returned is null"));
            } catch (Throwable e) {
                Exceptions.throwIfFatal(e);
                this.downstream.onError(new CompositeException(t, e));
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void onComplete() {
            try {
                complete(Objects.requireNonNull(this.onCompleteSupplier.get(), "The onComplete publisher returned is null"));
            } catch (Throwable e) {
                Exceptions.throwIfFatal(e);
                this.downstream.onError(e);
            }
        }
    }
}