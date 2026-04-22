package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber;
import io.reactivex.rxjava3.internal.subscribers.BasicFuseableConditionalSubscriber;
import io.reactivex.rxjava3.internal.subscribers.BasicFuseableSubscriber;
import j$.util.Objects;
import org.reactivestreams.Subscriber;

public final class FlowableMap<T, U> extends AbstractFlowableWithUpstream<T, U> {
    final Function<? super T, ? extends U> mapper;

    public FlowableMap(Flowable<T> source, Function<? super T, ? extends U> mapper) {
        super(source);
        this.mapper = mapper;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super U> s) {
        if (s instanceof ConditionalSubscriber) {
            this.source.subscribe((FlowableSubscriber) new MapConditionalSubscriber((ConditionalSubscriber) s, this.mapper));
        } else {
            this.source.subscribe((FlowableSubscriber) new MapSubscriber(s, this.mapper));
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class MapSubscriber<T, U> extends BasicFuseableSubscriber<T, U> {
        final Function<? super T, ? extends U> mapper;

        /* JADX INFO: Access modifiers changed from: package-private */
        public MapSubscriber(Subscriber<? super U> actual, Function<? super T, ? extends U> mapper) {
            super(actual);
            this.mapper = mapper;
        }

        public void onNext(T t) {
            if (this.done) {
                return;
            }
            if (this.sourceMode != 0) {
                this.downstream.onNext((Object) null);
                return;
            }
            try {
                this.downstream.onNext(Objects.requireNonNull(this.mapper.apply(t), "The mapper function returned a null value."));
            } catch (Throwable ex) {
                fail(ex);
            }
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.QueueFuseable
        public int requestFusion(int mode) {
            return transitiveBoundaryFusion(mode);
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public U poll() throws Throwable {
            T t = this.qs.poll();
            if (t != null) {
                return (U) Objects.requireNonNull(this.mapper.apply(t), "The mapper function returned a null value.");
            }
            return null;
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class MapConditionalSubscriber<T, U> extends BasicFuseableConditionalSubscriber<T, U> {
        final Function<? super T, ? extends U> mapper;

        MapConditionalSubscriber(ConditionalSubscriber<? super U> actual, Function<? super T, ? extends U> function) {
            super(actual);
            this.mapper = function;
        }

        public void onNext(T t) {
            if (this.done) {
                return;
            }
            if (this.sourceMode != 0) {
                this.downstream.onNext(null);
                return;
            }
            try {
                this.downstream.onNext(Objects.requireNonNull(this.mapper.apply(t), "The mapper function returned a null value."));
            } catch (Throwable ex) {
                fail(ex);
            }
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t) {
            if (this.done) {
                return false;
            }
            try {
                return this.downstream.tryOnNext(Objects.requireNonNull(this.mapper.apply(t), "The mapper function returned a null value."));
            } catch (Throwable ex) {
                fail(ex);
                return true;
            }
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.QueueFuseable
        public int requestFusion(int mode) {
            return transitiveBoundaryFusion(mode);
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public U poll() throws Throwable {
            T t = this.qs.poll();
            if (t != null) {
                return (U) Objects.requireNonNull(this.mapper.apply(t), "The mapper function returned a null value.");
            }
            return null;
        }
    }
}