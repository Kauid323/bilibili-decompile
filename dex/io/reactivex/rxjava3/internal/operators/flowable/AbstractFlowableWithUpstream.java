package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.internal.fuseable.HasUpstreamPublisher;
import j$.util.Objects;
import org.reactivestreams.Publisher;

/* JADX INFO: Access modifiers changed from: package-private */
public abstract class AbstractFlowableWithUpstream<T, R> extends Flowable<R> implements HasUpstreamPublisher<T> {
    protected final Flowable<T> source;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractFlowableWithUpstream(Flowable<T> source) {
        this.source = (Flowable) Objects.requireNonNull(source, "source is null");
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.HasUpstreamPublisher
    public final Publisher<T> source() {
        return this.source;
    }
}