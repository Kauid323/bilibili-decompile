package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import j$.util.stream.Stream;
import org.reactivestreams.Subscriber;

public final class ParallelFlatMapStream<T, R> extends ParallelFlowable<R> {
    final Function<? super T, ? extends Stream<? extends R>> mapper;
    final int prefetch;
    final ParallelFlowable<T> source;

    public ParallelFlatMapStream(ParallelFlowable<T> source, Function<? super T, ? extends Stream<? extends R>> mapper, int prefetch) {
        this.source = source;
        this.mapper = mapper;
        this.prefetch = prefetch;
    }

    @Override // io.reactivex.rxjava3.parallel.ParallelFlowable
    public int parallelism() {
        return this.source.parallelism();
    }

    @Override // io.reactivex.rxjava3.parallel.ParallelFlowable
    public void subscribe(Subscriber<? super R>[] subscribers) {
        if (!validate(subscribers)) {
            return;
        }
        int n = subscribers.length;
        Subscriber<? super T>[] subscriberArr = new Subscriber[n];
        for (int i = 0; i < n; i++) {
            subscriberArr[i] = FlowableFlatMapStream.subscribe(subscribers[i], this.mapper, this.prefetch);
        }
        this.source.subscribe(subscriberArr);
    }
}