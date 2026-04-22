package j$.util.stream;

import j$.util.Objects;
import j$.util.Optional;
import j$.util.Spliterator;
import j$.util.Spliterators;
import j$.util.function.BinaryOperator$CC;
import j$.util.function.Consumer$CC;
import j$.util.stream.Collector;
import j$.util.stream.DoublePipeline;
import j$.util.stream.IntPipeline;
import j$.util.stream.LongPipeline;
import j$.util.stream.MatchOps;
import j$.util.stream.Node;
import j$.util.stream.Sink;
import j$.util.stream.StreamSpliterators;
import java.util.Comparator;
import java.util.Iterator;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.LongConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

abstract class ReferencePipeline<P_IN, P_OUT> extends AbstractPipeline<P_IN, P_OUT, Stream<P_OUT>> implements Stream<P_OUT> {
    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ReferencePipeline != java.util.stream.ReferencePipeline<P_IN, P_OUT> */
    ReferencePipeline(Supplier<? extends Spliterator<?>> supplier, int sourceFlags, boolean parallel) {
        super(supplier, sourceFlags, parallel);
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<?> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ReferencePipeline != java.util.stream.ReferencePipeline<P_IN, P_OUT> */
    ReferencePipeline(Spliterator<?> spliterator, int sourceFlags, boolean parallel) {
        super(spliterator, sourceFlags, parallel);
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.AbstractPipeline != java.util.stream.AbstractPipeline<?, P_IN, ?> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ReferencePipeline != java.util.stream.ReferencePipeline<P_IN, P_OUT> */
    ReferencePipeline(AbstractPipeline<?, P_IN, ?> abstractPipeline, int opFlags) {
        super(abstractPipeline, opFlags);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ReferencePipeline != java.util.stream.ReferencePipeline<P_IN, P_OUT> */
    @Override // j$.util.stream.AbstractPipeline
    public final StreamShape getOutputShape() {
        return StreamShape.REFERENCE;
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<P_IN> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.PipelineHelper != java.util.stream.PipelineHelper<P_OUT> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ReferencePipeline != java.util.stream.ReferencePipeline<P_IN, P_OUT> */
    @Override // j$.util.stream.AbstractPipeline
    final <P_IN> Node<P_OUT> evaluateToNode(PipelineHelper<P_OUT> pipelineHelper, Spliterator<P_IN> spliterator, boolean flattenTree, IntFunction<P_OUT[]> generator) {
        return Nodes.collect(pipelineHelper, spliterator, flattenTree, generator);
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.PipelineHelper != java.util.stream.PipelineHelper<P_OUT> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ReferencePipeline != java.util.stream.ReferencePipeline<P_IN, P_OUT> */
    @Override // j$.util.stream.AbstractPipeline
    final <P_IN> Spliterator<P_OUT> wrap(PipelineHelper<P_OUT> pipelineHelper, Supplier<Spliterator<P_IN>> supplier, boolean isParallel) {
        return new StreamSpliterators.WrappingSpliterator(pipelineHelper, supplier, isParallel);
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ReferencePipeline != java.util.stream.ReferencePipeline<P_IN, P_OUT> */
    @Override // j$.util.stream.AbstractPipeline
    final Spliterator<P_OUT> lazySpliterator(Supplier<? extends Spliterator<P_OUT>> supplier) {
        return new StreamSpliterators.DelegatingSpliterator(supplier);
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<P_OUT> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ReferencePipeline != java.util.stream.ReferencePipeline<P_IN, P_OUT> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Sink != java.util.stream.Sink<P_OUT> */
    @Override // j$.util.stream.AbstractPipeline
    final boolean forEachWithCancel(Spliterator<P_OUT> spliterator, Sink<P_OUT> sink) {
        boolean cancelled;
        do {
            cancelled = sink.cancellationRequested();
            if (cancelled) {
                break;
            }
        } while (spliterator.tryAdvance(sink));
        return cancelled;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ReferencePipeline != java.util.stream.ReferencePipeline<P_IN, P_OUT> */
    @Override // j$.util.stream.AbstractPipeline, j$.util.stream.PipelineHelper
    public final Node.Builder<P_OUT> makeNodeBuilder(long exactSizeIfKnown, IntFunction<P_OUT[]> generator) {
        return Nodes.builder(exactSizeIfKnown, generator);
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ReferencePipeline != java.util.stream.ReferencePipeline<P_IN, P_OUT> */
    @Override // j$.util.stream.BaseStream
    public final Iterator<P_OUT> iterator() {
        return Spliterators.iterator(spliterator());
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ReferencePipeline != java.util.stream.ReferencePipeline<P_IN, P_OUT> */
    @Override // j$.util.stream.BaseStream
    public Stream<P_OUT> unordered() {
        if (!isOrdered()) {
            return this;
        }
        return new StatelessOp<P_OUT, P_OUT>(this, StreamShape.REFERENCE, StreamOpFlag.NOT_ORDERED) { // from class: j$.util.stream.ReferencePipeline.1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Sink != java.util.stream.Sink<P_OUT> */
            @Override // j$.util.stream.AbstractPipeline
            public Sink<P_OUT> opWrapSink(int flags, Sink<P_OUT> sink) {
                return sink;
            }
        };
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ReferencePipeline != java.util.stream.ReferencePipeline<P_IN, P_OUT> */
    @Override // j$.util.stream.Stream
    public final Stream<P_OUT> filter(final Predicate<? super P_OUT> predicate) {
        Objects.requireNonNull(predicate);
        return new StatelessOp<P_OUT, P_OUT>(this, StreamShape.REFERENCE, StreamOpFlag.NOT_SIZED) { // from class: j$.util.stream.ReferencePipeline.2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Sink != java.util.stream.Sink<P_OUT> */
            @Override // j$.util.stream.AbstractPipeline
            public Sink<P_OUT> opWrapSink(int flags, Sink<P_OUT> sink) {
                return new Sink.ChainedReference<P_OUT, P_OUT>(sink) { // from class: j$.util.stream.ReferencePipeline.2.1
                    @Override // j$.util.stream.Sink.ChainedReference, j$.util.stream.Sink
                    public void begin(long size) {
                        this.downstream.begin(-1L);
                    }

                    @Override // java.util.function.Consumer
                    public void accept(P_OUT u) {
                        if (predicate.test(u)) {
                            this.downstream.accept(u);
                        }
                    }
                };
            }
        };
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ReferencePipeline != java.util.stream.ReferencePipeline<P_IN, P_OUT> */
    @Override // j$.util.stream.Stream
    public final <R> Stream<R> map(final Function<? super P_OUT, ? extends R> mapper) {
        Objects.requireNonNull(mapper);
        return new StatelessOp<P_OUT, R>(this, StreamShape.REFERENCE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT) { // from class: j$.util.stream.ReferencePipeline.3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Sink != java.util.stream.Sink<R> */
            @Override // j$.util.stream.AbstractPipeline
            public Sink<P_OUT> opWrapSink(int flags, Sink<R> sink) {
                return new Sink.ChainedReference<P_OUT, R>(sink) { // from class: j$.util.stream.ReferencePipeline.3.1
                    @Override // java.util.function.Consumer
                    public void accept(P_OUT u) {
                        this.downstream.accept(mapper.apply(u));
                    }
                };
            }
        };
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ReferencePipeline != java.util.stream.ReferencePipeline<P_IN, P_OUT> */
    @Override // j$.util.stream.Stream
    public final IntStream mapToInt(final ToIntFunction<? super P_OUT> mapper) {
        Objects.requireNonNull(mapper);
        return new IntPipeline.StatelessOp<P_OUT>(this, StreamShape.REFERENCE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT) { // from class: j$.util.stream.ReferencePipeline.4
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Sink != java.util.stream.Sink<java.lang.Integer> */
            @Override // j$.util.stream.AbstractPipeline
            public Sink<P_OUT> opWrapSink(int flags, Sink<Integer> sink) {
                return new Sink.ChainedReference<P_OUT, Integer>(sink) { // from class: j$.util.stream.ReferencePipeline.4.1
                    @Override // java.util.function.Consumer
                    public void accept(P_OUT u) {
                        this.downstream.accept(mapper.applyAsInt(u));
                    }
                };
            }
        };
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ReferencePipeline != java.util.stream.ReferencePipeline<P_IN, P_OUT> */
    @Override // j$.util.stream.Stream
    public final LongStream mapToLong(final ToLongFunction<? super P_OUT> mapper) {
        Objects.requireNonNull(mapper);
        return new LongPipeline.StatelessOp<P_OUT>(this, StreamShape.REFERENCE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT) { // from class: j$.util.stream.ReferencePipeline.5
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Sink != java.util.stream.Sink<java.lang.Long> */
            @Override // j$.util.stream.AbstractPipeline
            public Sink<P_OUT> opWrapSink(int flags, Sink<Long> sink) {
                return new Sink.ChainedReference<P_OUT, Long>(sink) { // from class: j$.util.stream.ReferencePipeline.5.1
                    @Override // java.util.function.Consumer
                    public void accept(P_OUT u) {
                        this.downstream.accept(mapper.applyAsLong(u));
                    }
                };
            }
        };
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ReferencePipeline != java.util.stream.ReferencePipeline<P_IN, P_OUT> */
    @Override // j$.util.stream.Stream
    public final DoubleStream mapToDouble(final ToDoubleFunction<? super P_OUT> mapper) {
        Objects.requireNonNull(mapper);
        return new DoublePipeline.StatelessOp<P_OUT>(this, StreamShape.REFERENCE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT) { // from class: j$.util.stream.ReferencePipeline.6
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Sink != java.util.stream.Sink<java.lang.Double> */
            @Override // j$.util.stream.AbstractPipeline
            public Sink<P_OUT> opWrapSink(int flags, Sink<Double> sink) {
                return new Sink.ChainedReference<P_OUT, Double>(sink) { // from class: j$.util.stream.ReferencePipeline.6.1
                    @Override // java.util.function.Consumer
                    public void accept(P_OUT u) {
                        this.downstream.accept(mapper.applyAsDouble(u));
                    }
                };
            }
        };
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ReferencePipeline != java.util.stream.ReferencePipeline<P_IN, P_OUT> */
    @Override // j$.util.stream.Stream
    public final <R> Stream<R> flatMap(final Function<? super P_OUT, ? extends Stream<? extends R>> function) {
        Objects.requireNonNull(function);
        return new StatelessOp<P_OUT, R>(this, StreamShape.REFERENCE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT | StreamOpFlag.NOT_SIZED) { // from class: j$.util.stream.ReferencePipeline.7
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Sink != java.util.stream.Sink<R> */
            @Override // j$.util.stream.AbstractPipeline
            public Sink<P_OUT> opWrapSink(int flags, Sink<R> sink) {
                return new Sink.ChainedReference<P_OUT, R>(sink) { // from class: j$.util.stream.ReferencePipeline.7.1
                    boolean cancellationRequestedCalled;

                    @Override // j$.util.stream.Sink.ChainedReference, j$.util.stream.Sink
                    public void begin(long size) {
                        this.downstream.begin(-1L);
                    }

                    /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<? extends R> */
                    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Stream != java.util.stream.Stream<? extends R> */
                    @Override // java.util.function.Consumer
                    public void accept(P_OUT u) {
                        Stream stream = (Stream) function.apply(u);
                        if (stream != null) {
                            try {
                                if (!this.cancellationRequestedCalled) {
                                    stream.sequential().forEach(this.downstream);
                                } else {
                                    Spliterator<T> spliterator = stream.sequential().spliterator();
                                    while (!this.downstream.cancellationRequested() && spliterator.tryAdvance(this.downstream)) {
                                    }
                                }
                            } catch (Throwable th) {
                                if (stream != null) {
                                    try {
                                        stream.close();
                                    } catch (Throwable th2) {
                                        th.addSuppressed(th2);
                                    }
                                }
                                throw th;
                            }
                        }
                        if (stream != null) {
                            stream.close();
                        }
                    }

                    @Override // j$.util.stream.Sink.ChainedReference, j$.util.stream.Sink
                    public boolean cancellationRequested() {
                        this.cancellationRequestedCalled = true;
                        return this.downstream.cancellationRequested();
                    }
                };
            }
        };
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ReferencePipeline != java.util.stream.ReferencePipeline<P_IN, P_OUT> */
    @Override // j$.util.stream.Stream
    public final IntStream flatMapToInt(final Function<? super P_OUT, ? extends IntStream> function) {
        Objects.requireNonNull(function);
        return new IntPipeline.StatelessOp<P_OUT>(this, StreamShape.REFERENCE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT | StreamOpFlag.NOT_SIZED) { // from class: j$.util.stream.ReferencePipeline.8
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Sink != java.util.stream.Sink<java.lang.Integer> */
            @Override // j$.util.stream.AbstractPipeline
            public Sink<P_OUT> opWrapSink(int flags, Sink<Integer> sink) {
                return new Sink.ChainedReference<P_OUT, Integer>(sink) { // from class: j$.util.stream.ReferencePipeline.8.1
                    boolean cancellationRequestedCalled;
                    IntConsumer downstreamAsInt;

                    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Sink != java.util.stream.Sink<? super java.lang.Integer> */
                    {
                        Sink<? super E_OUT> sink2 = this.downstream;
                        Objects.requireNonNull(sink2);
                        this.downstreamAsInt = new IntPipeline$$ExternalSyntheticLambda10(sink2);
                    }

                    @Override // j$.util.stream.Sink.ChainedReference, j$.util.stream.Sink
                    public void begin(long size) {
                        this.downstream.begin(-1L);
                    }

                    /* JADX WARN: Type inference failed for: r1v3, types: [j$.util.Spliterator$OfInt] */
                    @Override // java.util.function.Consumer
                    public void accept(P_OUT u) {
                        IntStream result = (IntStream) function.apply(u);
                        if (result != null) {
                            try {
                                if (!this.cancellationRequestedCalled) {
                                    result.sequential().forEach(this.downstreamAsInt);
                                } else {
                                    ?? spliterator = result.sequential().spliterator();
                                    while (!this.downstream.cancellationRequested() && spliterator.tryAdvance(this.downstreamAsInt)) {
                                    }
                                }
                            } catch (Throwable th) {
                                if (result != null) {
                                    try {
                                        result.close();
                                    } catch (Throwable th2) {
                                        th.addSuppressed(th2);
                                    }
                                }
                                throw th;
                            }
                        }
                        if (result != null) {
                            result.close();
                        }
                    }

                    @Override // j$.util.stream.Sink.ChainedReference, j$.util.stream.Sink
                    public boolean cancellationRequested() {
                        this.cancellationRequestedCalled = true;
                        return this.downstream.cancellationRequested();
                    }
                };
            }
        };
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ReferencePipeline != java.util.stream.ReferencePipeline<P_IN, P_OUT> */
    @Override // j$.util.stream.Stream
    public final DoubleStream flatMapToDouble(final Function<? super P_OUT, ? extends DoubleStream> function) {
        Objects.requireNonNull(function);
        return new DoublePipeline.StatelessOp<P_OUT>(this, StreamShape.REFERENCE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT | StreamOpFlag.NOT_SIZED) { // from class: j$.util.stream.ReferencePipeline.9
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Sink != java.util.stream.Sink<java.lang.Double> */
            @Override // j$.util.stream.AbstractPipeline
            public Sink<P_OUT> opWrapSink(int flags, Sink<Double> sink) {
                return new Sink.ChainedReference<P_OUT, Double>(sink) { // from class: j$.util.stream.ReferencePipeline.9.1
                    boolean cancellationRequestedCalled;
                    DoubleConsumer downstreamAsDouble;

                    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Sink != java.util.stream.Sink<? super java.lang.Double> */
                    {
                        Sink<? super E_OUT> sink2 = this.downstream;
                        Objects.requireNonNull(sink2);
                        this.downstreamAsDouble = new DoublePipeline$$ExternalSyntheticLambda0(sink2);
                    }

                    @Override // j$.util.stream.Sink.ChainedReference, j$.util.stream.Sink
                    public void begin(long size) {
                        this.downstream.begin(-1L);
                    }

                    /* JADX WARN: Type inference failed for: r1v3, types: [j$.util.Spliterator$OfDouble] */
                    @Override // java.util.function.Consumer
                    public void accept(P_OUT u) {
                        DoubleStream result = (DoubleStream) function.apply(u);
                        if (result != null) {
                            try {
                                if (!this.cancellationRequestedCalled) {
                                    result.sequential().forEach(this.downstreamAsDouble);
                                } else {
                                    ?? spliterator = result.sequential().spliterator();
                                    while (!this.downstream.cancellationRequested() && spliterator.tryAdvance(this.downstreamAsDouble)) {
                                    }
                                }
                            } catch (Throwable th) {
                                if (result != null) {
                                    try {
                                        result.close();
                                    } catch (Throwable th2) {
                                        th.addSuppressed(th2);
                                    }
                                }
                                throw th;
                            }
                        }
                        if (result != null) {
                            result.close();
                        }
                    }

                    @Override // j$.util.stream.Sink.ChainedReference, j$.util.stream.Sink
                    public boolean cancellationRequested() {
                        this.cancellationRequestedCalled = true;
                        return this.downstream.cancellationRequested();
                    }
                };
            }
        };
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ReferencePipeline != java.util.stream.ReferencePipeline<P_IN, P_OUT> */
    @Override // j$.util.stream.Stream
    public final LongStream flatMapToLong(final Function<? super P_OUT, ? extends LongStream> function) {
        Objects.requireNonNull(function);
        return new LongPipeline.StatelessOp<P_OUT>(this, StreamShape.REFERENCE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT | StreamOpFlag.NOT_SIZED) { // from class: j$.util.stream.ReferencePipeline.10
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Sink != java.util.stream.Sink<java.lang.Long> */
            @Override // j$.util.stream.AbstractPipeline
            public Sink<P_OUT> opWrapSink(int flags, Sink<Long> sink) {
                return new Sink.ChainedReference<P_OUT, Long>(sink) { // from class: j$.util.stream.ReferencePipeline.10.1
                    boolean cancellationRequestedCalled;
                    LongConsumer downstreamAsLong;

                    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Sink != java.util.stream.Sink<? super java.lang.Long> */
                    {
                        Sink<? super E_OUT> sink2 = this.downstream;
                        Objects.requireNonNull(sink2);
                        this.downstreamAsLong = new LongPipeline$$ExternalSyntheticLambda12(sink2);
                    }

                    @Override // j$.util.stream.Sink.ChainedReference, j$.util.stream.Sink
                    public void begin(long size) {
                        this.downstream.begin(-1L);
                    }

                    /* JADX WARN: Type inference failed for: r1v3, types: [j$.util.Spliterator$OfLong] */
                    @Override // java.util.function.Consumer
                    public void accept(P_OUT u) {
                        LongStream result = (LongStream) function.apply(u);
                        if (result != null) {
                            try {
                                if (!this.cancellationRequestedCalled) {
                                    result.sequential().forEach(this.downstreamAsLong);
                                } else {
                                    ?? spliterator = result.sequential().spliterator();
                                    while (!this.downstream.cancellationRequested() && spliterator.tryAdvance(this.downstreamAsLong)) {
                                    }
                                }
                            } catch (Throwable th) {
                                if (result != null) {
                                    try {
                                        result.close();
                                    } catch (Throwable th2) {
                                        th.addSuppressed(th2);
                                    }
                                }
                                throw th;
                            }
                        }
                        if (result != null) {
                            result.close();
                        }
                    }

                    @Override // j$.util.stream.Sink.ChainedReference, j$.util.stream.Sink
                    public boolean cancellationRequested() {
                        this.cancellationRequestedCalled = true;
                        return this.downstream.cancellationRequested();
                    }
                };
            }
        };
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ReferencePipeline != java.util.stream.ReferencePipeline<P_IN, P_OUT> */
    @Override // j$.util.stream.Stream
    public final Stream<P_OUT> peek(final Consumer<? super P_OUT> action) {
        Objects.requireNonNull(action);
        return new StatelessOp<P_OUT, P_OUT>(this, StreamShape.REFERENCE, 0) { // from class: j$.util.stream.ReferencePipeline.11
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Sink != java.util.stream.Sink<P_OUT> */
            @Override // j$.util.stream.AbstractPipeline
            public Sink<P_OUT> opWrapSink(int flags, Sink<P_OUT> sink) {
                return new Sink.ChainedReference<P_OUT, P_OUT>(sink) { // from class: j$.util.stream.ReferencePipeline.11.1
                    @Override // java.util.function.Consumer
                    public void accept(P_OUT u) {
                        action.accept(u);
                        this.downstream.accept(u);
                    }
                };
            }
        };
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ReferencePipeline != java.util.stream.ReferencePipeline<P_IN, P_OUT> */
    @Override // j$.util.stream.Stream
    public final Stream<P_OUT> distinct() {
        return DistinctOps.makeRef(this);
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ReferencePipeline != java.util.stream.ReferencePipeline<P_IN, P_OUT> */
    @Override // j$.util.stream.Stream
    public final Stream<P_OUT> sorted() {
        return SortedOps.makeRef(this);
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ReferencePipeline != java.util.stream.ReferencePipeline<P_IN, P_OUT> */
    @Override // j$.util.stream.Stream
    public final Stream<P_OUT> sorted(Comparator<? super P_OUT> comparator) {
        return SortedOps.makeRef(this, comparator);
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ReferencePipeline != java.util.stream.ReferencePipeline<P_IN, P_OUT> */
    @Override // j$.util.stream.Stream
    public final Stream<P_OUT> limit(long maxSize) {
        if (maxSize < 0) {
            throw new IllegalArgumentException(Long.toString(maxSize));
        }
        return SliceOps.makeRef(this, 0L, maxSize);
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ReferencePipeline != java.util.stream.ReferencePipeline<P_IN, P_OUT> */
    @Override // j$.util.stream.Stream
    public final Stream<P_OUT> skip(long n) {
        if (n < 0) {
            throw new IllegalArgumentException(Long.toString(n));
        }
        if (n == 0) {
            return this;
        }
        return SliceOps.makeRef(this, n, -1L);
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ReferencePipeline != java.util.stream.ReferencePipeline<P_IN, P_OUT> */
    @Override // j$.util.stream.Stream
    public final Stream<P_OUT> takeWhile(Predicate<? super P_OUT> predicate) {
        return WhileOps.makeTakeWhileRef(this, predicate);
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ReferencePipeline != java.util.stream.ReferencePipeline<P_IN, P_OUT> */
    @Override // j$.util.stream.Stream
    public final Stream<P_OUT> dropWhile(Predicate<? super P_OUT> predicate) {
        return WhileOps.makeDropWhileRef(this, predicate);
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ReferencePipeline != java.util.stream.ReferencePipeline<P_IN, P_OUT> */
    @Override // j$.util.stream.Stream
    public void forEach(Consumer<? super P_OUT> action) {
        evaluate(ForEachOps.makeRef(action, false));
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ReferencePipeline != java.util.stream.ReferencePipeline<P_IN, P_OUT> */
    @Override // j$.util.stream.Stream
    public void forEachOrdered(Consumer<? super P_OUT> action) {
        evaluate(ForEachOps.makeRef(action, true));
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ReferencePipeline != java.util.stream.ReferencePipeline<P_IN, P_OUT> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // j$.util.stream.Stream
    public final <A> A[] toArray(IntFunction<A[]> generator) {
        return (A[]) Nodes.flatten(evaluateToArrayNode(generator), generator).asArray(generator);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object[] lambda$toArray$0(int x$0) {
        return new Object[x$0];
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ReferencePipeline != java.util.stream.ReferencePipeline<P_IN, P_OUT> */
    @Override // j$.util.stream.Stream
    public final Object[] toArray() {
        return toArray(new IntFunction() { // from class: j$.util.stream.ReferencePipeline$$ExternalSyntheticLambda1
            @Override // java.util.function.IntFunction
            public final Object apply(int i) {
                return ReferencePipeline.lambda$toArray$0(i);
            }
        });
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ReferencePipeline != java.util.stream.ReferencePipeline<P_IN, P_OUT> */
    @Override // j$.util.stream.Stream
    public final boolean anyMatch(Predicate<? super P_OUT> predicate) {
        return ((Boolean) evaluate(MatchOps.makeRef(predicate, MatchOps.MatchKind.ANY))).booleanValue();
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ReferencePipeline != java.util.stream.ReferencePipeline<P_IN, P_OUT> */
    @Override // j$.util.stream.Stream
    public final boolean allMatch(Predicate<? super P_OUT> predicate) {
        return ((Boolean) evaluate(MatchOps.makeRef(predicate, MatchOps.MatchKind.ALL))).booleanValue();
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ReferencePipeline != java.util.stream.ReferencePipeline<P_IN, P_OUT> */
    @Override // j$.util.stream.Stream
    public final boolean noneMatch(Predicate<? super P_OUT> predicate) {
        return ((Boolean) evaluate(MatchOps.makeRef(predicate, MatchOps.MatchKind.NONE))).booleanValue();
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ReferencePipeline != java.util.stream.ReferencePipeline<P_IN, P_OUT> */
    @Override // j$.util.stream.Stream
    public final Optional<P_OUT> findFirst() {
        return (Optional) evaluate(FindOps.makeRef(true));
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ReferencePipeline != java.util.stream.ReferencePipeline<P_IN, P_OUT> */
    @Override // j$.util.stream.Stream
    public final Optional<P_OUT> findAny() {
        return (Optional) evaluate(FindOps.makeRef(false));
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ReferencePipeline != java.util.stream.ReferencePipeline<P_IN, P_OUT> */
    @Override // j$.util.stream.Stream
    public final P_OUT reduce(P_OUT identity, BinaryOperator<P_OUT> accumulator) {
        return (P_OUT) evaluate(ReduceOps.makeRef(identity, accumulator, accumulator));
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ReferencePipeline != java.util.stream.ReferencePipeline<P_IN, P_OUT> */
    @Override // j$.util.stream.Stream
    public final Optional<P_OUT> reduce(BinaryOperator<P_OUT> accumulator) {
        return (Optional) evaluate(ReduceOps.makeRef(accumulator));
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ReferencePipeline != java.util.stream.ReferencePipeline<P_IN, P_OUT> */
    @Override // j$.util.stream.Stream
    public final <R> R reduce(R identity, BiFunction<R, ? super P_OUT, R> accumulator, BinaryOperator<R> combiner) {
        return (R) evaluate(ReduceOps.makeRef(identity, (BiFunction<R, ? super T, R>) accumulator, combiner));
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Collector != java.util.stream.Collector<? super P_OUT, A, R> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ReferencePipeline != java.util.stream.ReferencePipeline<P_IN, P_OUT> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13 */
    @Override // j$.util.stream.Stream
    public final <R, A> R collect(Collector<? super P_OUT, A, R> collector) {
        final A container;
        if (isParallel() && collector.characteristics().contains(Collector.Characteristics.CONCURRENT) && (!isOrdered() || collector.characteristics().contains(Collector.Characteristics.UNORDERED))) {
            container = collector.supplier().get();
            final BiConsumer<A, ? super P_OUT> accumulator = collector.accumulator();
            forEach(new Consumer() { // from class: j$.util.stream.ReferencePipeline$$ExternalSyntheticLambda0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    BiConsumer.this.accept(container, obj);
                }

                @Override // java.util.function.Consumer
                public /* synthetic */ Consumer andThen(Consumer consumer) {
                    return Consumer$CC.$default$andThen(this, consumer);
                }
            });
        } else {
            container = (A) evaluate(ReduceOps.makeRef(collector));
        }
        if (collector.characteristics().contains(Collector.Characteristics.IDENTITY_FINISH)) {
            return container;
        }
        return collector.finisher().apply(container);
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ReferencePipeline != java.util.stream.ReferencePipeline<P_IN, P_OUT> */
    @Override // j$.util.stream.Stream
    public final <R> R collect(Supplier<R> supplier, BiConsumer<R, ? super P_OUT> accumulator, BiConsumer<R, R> combiner) {
        return (R) evaluate(ReduceOps.makeRef(supplier, accumulator, combiner));
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ReferencePipeline != java.util.stream.ReferencePipeline<P_IN, P_OUT> */
    @Override // j$.util.stream.Stream
    public final Optional<P_OUT> max(Comparator<? super P_OUT> comparator) {
        return reduce(BinaryOperator$CC.maxBy(comparator));
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ReferencePipeline != java.util.stream.ReferencePipeline<P_IN, P_OUT> */
    @Override // j$.util.stream.Stream
    public final Optional<P_OUT> min(Comparator<? super P_OUT> comparator) {
        return reduce(BinaryOperator$CC.minBy(comparator));
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ReferencePipeline != java.util.stream.ReferencePipeline<P_IN, P_OUT> */
    @Override // j$.util.stream.Stream
    public final long count() {
        return ((Long) evaluate(ReduceOps.makeRefCounting())).longValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public static class Head<E_IN, E_OUT> extends ReferencePipeline<E_IN, E_OUT> {
        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ReferencePipeline$Head != java.util.stream.ReferencePipeline$Head<E_IN, E_OUT> */
        public Head(Supplier<? extends Spliterator<?>> supplier, int sourceFlags, boolean parallel) {
            super(supplier, sourceFlags, parallel);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<?> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ReferencePipeline$Head != java.util.stream.ReferencePipeline$Head<E_IN, E_OUT> */
        public Head(Spliterator<?> spliterator, int sourceFlags, boolean parallel) {
            super(spliterator, sourceFlags, parallel);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ReferencePipeline$Head != java.util.stream.ReferencePipeline$Head<E_IN, E_OUT> */
        @Override // j$.util.stream.AbstractPipeline
        final boolean opIsStateful() {
            throw new UnsupportedOperationException();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ReferencePipeline$Head != java.util.stream.ReferencePipeline$Head<E_IN, E_OUT> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Sink != java.util.stream.Sink<E_OUT> */
        @Override // j$.util.stream.AbstractPipeline
        public final Sink<E_IN> opWrapSink(int flags, Sink<E_OUT> sink) {
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ReferencePipeline$Head != java.util.stream.ReferencePipeline$Head<E_IN, E_OUT> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // j$.util.stream.ReferencePipeline, j$.util.stream.Stream
        public void forEach(Consumer<? super E_OUT> action) {
            if (!isParallel()) {
                sourceStageSpliterator().forEachRemaining(action);
            } else {
                super.forEach(action);
            }
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ReferencePipeline$Head != java.util.stream.ReferencePipeline$Head<E_IN, E_OUT> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // j$.util.stream.ReferencePipeline, j$.util.stream.Stream
        public void forEachOrdered(Consumer<? super E_OUT> action) {
            if (!isParallel()) {
                sourceStageSpliterator().forEachRemaining(action);
            } else {
                super.forEachOrdered(action);
            }
        }
    }

    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    static abstract class StatelessOp<E_IN, E_OUT> extends ReferencePipeline<E_IN, E_OUT> {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.AbstractPipeline != java.util.stream.AbstractPipeline<?, E_IN, ?> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ReferencePipeline$StatelessOp != java.util.stream.ReferencePipeline$StatelessOp<E_IN, E_OUT> */
        public StatelessOp(AbstractPipeline<?, E_IN, ?> abstractPipeline, StreamShape inputShape, int opFlags) {
            super(abstractPipeline, opFlags);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ReferencePipeline$StatelessOp != java.util.stream.ReferencePipeline$StatelessOp<E_IN, E_OUT> */
        @Override // j$.util.stream.AbstractPipeline
        final boolean opIsStateful() {
            return false;
        }
    }

    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    static abstract class StatefulOp<E_IN, E_OUT> extends ReferencePipeline<E_IN, E_OUT> {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        @Override // j$.util.stream.AbstractPipeline
        abstract <P_IN> Node<E_OUT> opEvaluateParallel(PipelineHelper<E_OUT> pipelineHelper, Spliterator<P_IN> spliterator, IntFunction<E_OUT[]> intFunction);

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.AbstractPipeline != java.util.stream.AbstractPipeline<?, E_IN, ?> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ReferencePipeline$StatefulOp != java.util.stream.ReferencePipeline$StatefulOp<E_IN, E_OUT> */
        public StatefulOp(AbstractPipeline<?, E_IN, ?> abstractPipeline, StreamShape inputShape, int opFlags) {
            super(abstractPipeline, opFlags);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ReferencePipeline$StatefulOp != java.util.stream.ReferencePipeline$StatefulOp<E_IN, E_OUT> */
        @Override // j$.util.stream.AbstractPipeline
        final boolean opIsStateful() {
            return true;
        }
    }
}