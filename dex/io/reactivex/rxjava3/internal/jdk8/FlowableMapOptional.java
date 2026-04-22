package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber;
import io.reactivex.rxjava3.internal.subscribers.BasicFuseableConditionalSubscriber;
import io.reactivex.rxjava3.internal.subscribers.BasicFuseableSubscriber;
import j$.util.Objects;
import j$.util.Optional;
import org.reactivestreams.Subscriber;

public final class FlowableMapOptional<T, R> extends Flowable<R> {
    final Function<? super T, Optional<? extends R>> mapper;
    final Flowable<T> source;

    public FlowableMapOptional(Flowable<T> source, Function<? super T, Optional<? extends R>> mapper) {
        this.source = source;
        this.mapper = mapper;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    protected void subscribeActual(Subscriber<? super R> s) {
        if (s instanceof ConditionalSubscriber) {
            this.source.subscribe((FlowableSubscriber) new MapOptionalConditionalSubscriber((ConditionalSubscriber) s, this.mapper));
        } else {
            this.source.subscribe((FlowableSubscriber) new MapOptionalSubscriber(s, this.mapper));
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class MapOptionalSubscriber<T, R> extends BasicFuseableSubscriber<T, R> implements ConditionalSubscriber<T> {
        final Function<? super T, Optional<? extends R>> mapper;

        MapOptionalSubscriber(Subscriber<? super R> downstream, Function<? super T, Optional<? extends R>> mapper) {
            super(downstream);
            this.mapper = mapper;
        }

        public void onNext(T t) {
            if (!tryOnNext(t)) {
                this.upstream.request(1L);
            }
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.Optional != java.util.Optional<? extends R> */
        @Override // io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t) {
            if (this.done) {
                return true;
            }
            if (this.sourceMode != 0) {
                this.downstream.onNext((Object) null);
                return true;
            }
            try {
                Optional optional = (Optional) Objects.requireNonNull(this.mapper.apply(t), "The mapper returned a null Optional");
                if (optional.isPresent()) {
                    this.downstream.onNext(optional.get());
                    return true;
                }
                return false;
            } catch (Throwable ex) {
                fail(ex);
                return true;
            }
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.QueueFuseable
        public int requestFusion(int mode) {
            return transitiveBoundaryFusion(mode);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.Optional != java.util.Optional<? extends R> */
        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public R poll() throws Throwable {
            while (true) {
                T item = this.qs.poll();
                if (item == null) {
                    return null;
                }
                Optional optional = (Optional) Objects.requireNonNull(this.mapper.apply(item), "The mapper returned a null Optional");
                if (optional.isPresent()) {
                    return (R) optional.get();
                }
                if (this.sourceMode == 2) {
                    this.qs.request(1L);
                }
            }
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class MapOptionalConditionalSubscriber<T, R> extends BasicFuseableConditionalSubscriber<T, R> {
        final Function<? super T, Optional<? extends R>> mapper;

        MapOptionalConditionalSubscriber(ConditionalSubscriber<? super R> downstream, Function<? super T, Optional<? extends R>> mapper) {
            super(downstream);
            this.mapper = mapper;
        }

        public void onNext(T t) {
            if (!tryOnNext(t)) {
                this.upstream.request(1L);
            }
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.Optional != java.util.Optional<? extends R> */
        @Override // io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t) {
            if (this.done) {
                return true;
            }
            if (this.sourceMode != 0) {
                this.downstream.onNext(null);
                return true;
            }
            try {
                Optional optional = (Optional) Objects.requireNonNull(this.mapper.apply(t), "The mapper returned a null Optional");
                if (optional.isPresent()) {
                    return this.downstream.tryOnNext((Object) optional.get());
                }
                return false;
            } catch (Throwable ex) {
                fail(ex);
                return true;
            }
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.QueueFuseable
        public int requestFusion(int mode) {
            return transitiveBoundaryFusion(mode);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.Optional != java.util.Optional<? extends R> */
        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public R poll() throws Throwable {
            while (true) {
                T item = this.qs.poll();
                if (item == null) {
                    return null;
                }
                Optional optional = (Optional) Objects.requireNonNull(this.mapper.apply(item), "The mapper returned a null Optional");
                if (optional.isPresent()) {
                    return (R) optional.get();
                }
                if (this.sourceMode == 2) {
                    this.qs.request(1L);
                }
            }
        }
    }
}