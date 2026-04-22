package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.ScalarSubscription;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import j$.util.Objects;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class FlowableScalarXMap {
    private FlowableScalarXMap() {
        throw new IllegalStateException("No instances!");
    }

    public static <T, R> boolean tryScalarXMapSubscribe(Publisher<T> source, Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> mapper) {
        if (source instanceof Supplier) {
            try {
                Object obj = (Object) ((Supplier) source).get();
                if (obj == 0) {
                    EmptySubscription.complete(subscriber);
                    return true;
                }
                try {
                    Supplier supplier = (Publisher) Objects.requireNonNull(mapper.apply(obj), "The mapper returned a null Publisher");
                    if (supplier instanceof Supplier) {
                        try {
                            Object obj2 = supplier.get();
                            if (obj2 == null) {
                                EmptySubscription.complete(subscriber);
                                return true;
                            }
                            subscriber.onSubscribe(new ScalarSubscription(subscriber, obj2));
                        } catch (Throwable ex) {
                            Exceptions.throwIfFatal(ex);
                            EmptySubscription.error(ex, subscriber);
                            return true;
                        }
                    } else {
                        supplier.subscribe(subscriber);
                    }
                    return true;
                } catch (Throwable ex2) {
                    Exceptions.throwIfFatal(ex2);
                    EmptySubscription.error(ex2, subscriber);
                    return true;
                }
            } catch (Throwable ex3) {
                Exceptions.throwIfFatal(ex3);
                EmptySubscription.error(ex3, subscriber);
                return true;
            }
        }
        return false;
    }

    public static <T, U> Flowable<U> scalarXMap(final T value, final Function<? super T, ? extends Publisher<? extends U>> mapper) {
        return RxJavaPlugins.onAssembly(new ScalarXMapFlowable(value, mapper));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class ScalarXMapFlowable<T, R> extends Flowable<R> {
        final Function<? super T, ? extends Publisher<? extends R>> mapper;
        final T value;

        ScalarXMapFlowable(T value, Function<? super T, ? extends Publisher<? extends R>> mapper) {
            this.value = value;
            this.mapper = mapper;
        }

        @Override // io.reactivex.rxjava3.core.Flowable
        public void subscribeActual(Subscriber<? super R> s) {
            try {
                Supplier supplier = (Publisher) Objects.requireNonNull(this.mapper.apply((T) this.value), "The mapper returned a null Publisher");
                if (supplier instanceof Supplier) {
                    try {
                        Object obj = supplier.get();
                        if (obj == null) {
                            EmptySubscription.complete(s);
                            return;
                        } else {
                            s.onSubscribe(new ScalarSubscription(s, obj));
                            return;
                        }
                    } catch (Throwable ex) {
                        Exceptions.throwIfFatal(ex);
                        EmptySubscription.error(ex, s);
                        return;
                    }
                }
                supplier.subscribe(s);
            } catch (Throwable e) {
                Exceptions.throwIfFatal(e);
                EmptySubscription.error(e, s);
            }
        }
    }
}