package j$.util.stream;

import j$.util.LongSummaryStatistics;
import j$.util.Objects;
import j$.util.OptionalDouble;
import j$.util.OptionalLong;
import j$.util.Spliterator;
import j$.util.Spliterators;
import j$.util.function.BiConsumer$CC;
import j$.util.function.BiFunction$CC;
import j$.util.stream.DoublePipeline;
import j$.util.stream.IntPipeline;
import j$.util.stream.MatchOps;
import j$.util.stream.Node;
import j$.util.stream.ReferencePipeline;
import j$.util.stream.Sink;
import j$.util.stream.StreamSpliterators;
import java.util.Iterator;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.LongBinaryOperator;
import java.util.function.LongConsumer;
import java.util.function.LongFunction;
import java.util.function.LongPredicate;
import java.util.function.LongToDoubleFunction;
import java.util.function.LongToIntFunction;
import java.util.function.LongUnaryOperator;
import java.util.function.ObjLongConsumer;
import java.util.function.Supplier;
import java.util.function.ToLongFunction;

abstract class LongPipeline<E_IN> extends AbstractPipeline<E_IN, Long, LongStream> implements LongStream {
    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.LongPipeline != java.util.stream.LongPipeline<E_IN> */
    @Override // j$.util.stream.AbstractPipeline, j$.util.stream.BaseStream
    public /* bridge */ /* synthetic */ LongStream parallel() {
        return (LongStream) super.parallel();
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.LongPipeline != java.util.stream.LongPipeline<E_IN> */
    @Override // j$.util.stream.AbstractPipeline, j$.util.stream.BaseStream
    public /* bridge */ /* synthetic */ LongStream sequential() {
        return (LongStream) super.sequential();
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.LongPipeline != java.util.stream.LongPipeline<E_IN> */
    LongPipeline(Supplier<? extends Spliterator<Long>> supplier, int sourceFlags, boolean parallel) {
        super(supplier, sourceFlags, parallel);
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<java.lang.Long> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.LongPipeline != java.util.stream.LongPipeline<E_IN> */
    LongPipeline(Spliterator<Long> spliterator, int sourceFlags, boolean parallel) {
        super(spliterator, sourceFlags, parallel);
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.AbstractPipeline != java.util.stream.AbstractPipeline<?, E_IN, ?> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.LongPipeline != java.util.stream.LongPipeline<E_IN> */
    LongPipeline(AbstractPipeline<?, E_IN, ?> abstractPipeline, int opFlags) {
        super(abstractPipeline, opFlags);
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Sink != java.util.stream.Sink<java.lang.Long> */
    private static LongConsumer adapt(Sink<Long> sink) {
        if (sink instanceof LongConsumer) {
            return (LongConsumer) sink;
        }
        if (Tripwire.ENABLED) {
            Tripwire.trip(AbstractPipeline.class, "using LongStream.adapt(Sink<Long> s)");
        }
        Objects.requireNonNull(sink);
        return new LongPipeline$$ExternalSyntheticLambda12(sink);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<java.lang.Long> */
    public static Spliterator.OfLong adapt(Spliterator<Long> spliterator) {
        if (spliterator instanceof Spliterator.OfLong) {
            return (Spliterator.OfLong) spliterator;
        }
        if (Tripwire.ENABLED) {
            Tripwire.trip(AbstractPipeline.class, "using LongStream.adapt(Spliterator<Long> s)");
        }
        throw new UnsupportedOperationException("LongStream.adapt(Spliterator<Long> s)");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.LongPipeline != java.util.stream.LongPipeline<E_IN> */
    @Override // j$.util.stream.AbstractPipeline
    public final StreamShape getOutputShape() {
        return StreamShape.LONG_VALUE;
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<P_IN> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.LongPipeline != java.util.stream.LongPipeline<E_IN> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.PipelineHelper != java.util.stream.PipelineHelper<java.lang.Long> */
    @Override // j$.util.stream.AbstractPipeline
    final <P_IN> Node<Long> evaluateToNode(PipelineHelper<Long> pipelineHelper, Spliterator<P_IN> spliterator, boolean flattenTree, IntFunction<Long[]> generator) {
        return Nodes.collectLong(pipelineHelper, spliterator, flattenTree);
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.LongPipeline != java.util.stream.LongPipeline<E_IN> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.PipelineHelper != java.util.stream.PipelineHelper<java.lang.Long> */
    @Override // j$.util.stream.AbstractPipeline
    final <P_IN> Spliterator<Long> wrap(PipelineHelper<Long> pipelineHelper, Supplier<Spliterator<P_IN>> supplier, boolean isParallel) {
        return new StreamSpliterators.LongWrappingSpliterator(pipelineHelper, supplier, isParallel);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.LongPipeline != java.util.stream.LongPipeline<E_IN> */
    @Override // j$.util.stream.AbstractPipeline
    /* renamed from: lazySpliterator */
    public final Spliterator<Long> lazySpliterator2(Supplier<? extends Spliterator<Long>> supplier) {
        return new StreamSpliterators.DelegatingSpliterator.OfLong(supplier);
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<java.lang.Long> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.LongPipeline != java.util.stream.LongPipeline<E_IN> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Sink != java.util.stream.Sink<java.lang.Long> */
    @Override // j$.util.stream.AbstractPipeline
    final boolean forEachWithCancel(Spliterator<Long> spliterator, Sink<Long> sink) {
        boolean cancelled;
        Spliterator.OfLong spl = adapt(spliterator);
        LongConsumer adaptedSink = adapt(sink);
        do {
            cancelled = sink.cancellationRequested();
            if (cancelled) {
                break;
            }
        } while (spl.tryAdvance(adaptedSink));
        return cancelled;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.LongPipeline != java.util.stream.LongPipeline<E_IN> */
    @Override // j$.util.stream.AbstractPipeline, j$.util.stream.PipelineHelper
    public final Node.Builder<Long> makeNodeBuilder(long exactSizeIfKnown, IntFunction<Long[]> generator) {
        return Nodes.longBuilder(exactSizeIfKnown);
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.LongPipeline != java.util.stream.LongPipeline<E_IN> */
    private <U> Stream<U> mapToObj(final LongFunction<? extends U> mapper, int opFlags) {
        return new ReferencePipeline.StatelessOp<Long, U>(this, StreamShape.LONG_VALUE, opFlags) { // from class: j$.util.stream.LongPipeline.1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Sink != java.util.stream.Sink<U> */
            @Override // j$.util.stream.AbstractPipeline
            public Sink<Long> opWrapSink(int flags, Sink<U> sink) {
                return new Sink.ChainedLong<U>(sink) { // from class: j$.util.stream.LongPipeline.1.1
                    @Override // j$.util.stream.Sink.OfLong, j$.util.stream.Sink
                    public void accept(long t) {
                        this.downstream.accept(mapper.apply(t));
                    }
                };
            }
        };
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.LongPipeline != java.util.stream.LongPipeline<E_IN> */
    /* JADX WARN: Type inference failed for: r0v0, types: [j$.util.Spliterator$OfLong] */
    @Override // j$.util.stream.BaseStream
    /* renamed from: iterator */
    public final Iterator<Long> iterator2() {
        return Spliterators.iterator((Spliterator.OfLong) spliterator2());
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.LongPipeline != java.util.stream.LongPipeline<E_IN> */
    @Override // j$.util.stream.AbstractPipeline, j$.util.stream.BaseStream
    /* renamed from: spliterator */
    public final Spliterator<Long> spliterator2() {
        return adapt(super.spliterator());
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.LongPipeline != java.util.stream.LongPipeline<E_IN> */
    @Override // j$.util.stream.LongStream
    public final DoubleStream asDoubleStream() {
        return new DoublePipeline.StatelessOp<Long>(this, StreamShape.LONG_VALUE, StreamOpFlag.NOT_DISTINCT) { // from class: j$.util.stream.LongPipeline.2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Sink != java.util.stream.Sink<java.lang.Double> */
            @Override // j$.util.stream.AbstractPipeline
            public Sink<Long> opWrapSink(int flags, Sink<Double> sink) {
                return new Sink.ChainedLong<Double>(sink) { // from class: j$.util.stream.LongPipeline.2.1
                    @Override // j$.util.stream.Sink.OfLong, j$.util.stream.Sink
                    public void accept(long t) {
                        this.downstream.accept(t);
                    }
                };
            }
        };
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.LongPipeline != java.util.stream.LongPipeline<E_IN> */
    @Override // j$.util.stream.LongStream
    public final Stream<Long> boxed() {
        return mapToObj(new LongFunction() { // from class: j$.util.stream.LongPipeline$$ExternalSyntheticLambda3
            @Override // java.util.function.LongFunction
            public final Object apply(long j) {
                return Long.valueOf(j);
            }
        }, 0);
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.LongPipeline != java.util.stream.LongPipeline<E_IN> */
    @Override // j$.util.stream.LongStream
    public final LongStream map(final LongUnaryOperator mapper) {
        Objects.requireNonNull(mapper);
        return new StatelessOp<Long>(this, StreamShape.LONG_VALUE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT) { // from class: j$.util.stream.LongPipeline.3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Sink != java.util.stream.Sink<java.lang.Long> */
            @Override // j$.util.stream.AbstractPipeline
            public Sink<Long> opWrapSink(int flags, Sink<Long> sink) {
                return new Sink.ChainedLong<Long>(sink) { // from class: j$.util.stream.LongPipeline.3.1
                    @Override // j$.util.stream.Sink.OfLong, j$.util.stream.Sink
                    public void accept(long t) {
                        this.downstream.accept(mapper.applyAsLong(t));
                    }
                };
            }
        };
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.LongPipeline != java.util.stream.LongPipeline<E_IN> */
    @Override // j$.util.stream.LongStream
    public final <U> Stream<U> mapToObj(LongFunction<? extends U> mapper) {
        Objects.requireNonNull(mapper);
        return mapToObj(mapper, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT);
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.LongPipeline != java.util.stream.LongPipeline<E_IN> */
    @Override // j$.util.stream.LongStream
    public final IntStream mapToInt(final LongToIntFunction mapper) {
        Objects.requireNonNull(mapper);
        return new IntPipeline.StatelessOp<Long>(this, StreamShape.LONG_VALUE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT) { // from class: j$.util.stream.LongPipeline.4
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Sink != java.util.stream.Sink<java.lang.Integer> */
            @Override // j$.util.stream.AbstractPipeline
            public Sink<Long> opWrapSink(int flags, Sink<Integer> sink) {
                return new Sink.ChainedLong<Integer>(sink) { // from class: j$.util.stream.LongPipeline.4.1
                    @Override // j$.util.stream.Sink.OfLong, j$.util.stream.Sink
                    public void accept(long t) {
                        this.downstream.accept(mapper.applyAsInt(t));
                    }
                };
            }
        };
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.LongPipeline != java.util.stream.LongPipeline<E_IN> */
    @Override // j$.util.stream.LongStream
    public final DoubleStream mapToDouble(final LongToDoubleFunction mapper) {
        Objects.requireNonNull(mapper);
        return new DoublePipeline.StatelessOp<Long>(this, StreamShape.LONG_VALUE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT) { // from class: j$.util.stream.LongPipeline.5
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Sink != java.util.stream.Sink<java.lang.Double> */
            @Override // j$.util.stream.AbstractPipeline
            public Sink<Long> opWrapSink(int flags, Sink<Double> sink) {
                return new Sink.ChainedLong<Double>(sink) { // from class: j$.util.stream.LongPipeline.5.1
                    @Override // j$.util.stream.Sink.OfLong, j$.util.stream.Sink
                    public void accept(long t) {
                        this.downstream.accept(mapper.applyAsDouble(t));
                    }
                };
            }
        };
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.LongPipeline != java.util.stream.LongPipeline<E_IN> */
    @Override // j$.util.stream.LongStream
    public final LongStream flatMap(final LongFunction<? extends LongStream> longFunction) {
        Objects.requireNonNull(longFunction);
        return new StatelessOp<Long>(this, StreamShape.LONG_VALUE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT | StreamOpFlag.NOT_SIZED) { // from class: j$.util.stream.LongPipeline.6
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Sink != java.util.stream.Sink<java.lang.Long> */
            @Override // j$.util.stream.AbstractPipeline
            public Sink<Long> opWrapSink(int flags, Sink<Long> sink) {
                return new Sink.ChainedLong<Long>(sink) { // from class: j$.util.stream.LongPipeline.6.1
                    boolean cancellationRequestedCalled;
                    LongConsumer downstreamAsLong;

                    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Sink != java.util.stream.Sink<? super java.lang.Long> */
                    {
                        Sink<? super E_OUT> sink2 = this.downstream;
                        Objects.requireNonNull(sink2);
                        this.downstreamAsLong = new LongPipeline$$ExternalSyntheticLambda12(sink2);
                    }

                    @Override // j$.util.stream.Sink.ChainedLong, j$.util.stream.Sink
                    public void begin(long size) {
                        this.downstream.begin(-1L);
                    }

                    /* JADX WARN: Type inference failed for: r1v3, types: [j$.util.Spliterator$OfLong] */
                    @Override // j$.util.stream.Sink.OfLong, j$.util.stream.Sink
                    public void accept(long t) {
                        LongStream result = (LongStream) longFunction.apply(t);
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

                    @Override // j$.util.stream.Sink.ChainedLong, j$.util.stream.Sink
                    public boolean cancellationRequested() {
                        this.cancellationRequestedCalled = true;
                        return this.downstream.cancellationRequested();
                    }
                };
            }
        };
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.LongPipeline != java.util.stream.LongPipeline<E_IN> */
    @Override // j$.util.stream.BaseStream
    public LongStream unordered() {
        if (!isOrdered()) {
            return this;
        }
        return new StatelessOp<Long>(this, StreamShape.LONG_VALUE, StreamOpFlag.NOT_ORDERED) { // from class: j$.util.stream.LongPipeline.7
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Sink != java.util.stream.Sink<java.lang.Long> */
            @Override // j$.util.stream.AbstractPipeline
            public Sink<Long> opWrapSink(int flags, Sink<Long> sink) {
                return sink;
            }
        };
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.LongPipeline != java.util.stream.LongPipeline<E_IN> */
    @Override // j$.util.stream.LongStream
    public final LongStream filter(final LongPredicate predicate) {
        Objects.requireNonNull(predicate);
        return new StatelessOp<Long>(this, StreamShape.LONG_VALUE, StreamOpFlag.NOT_SIZED) { // from class: j$.util.stream.LongPipeline.8
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Sink != java.util.stream.Sink<java.lang.Long> */
            @Override // j$.util.stream.AbstractPipeline
            public Sink<Long> opWrapSink(int flags, Sink<Long> sink) {
                return new Sink.ChainedLong<Long>(sink) { // from class: j$.util.stream.LongPipeline.8.1
                    @Override // j$.util.stream.Sink.ChainedLong, j$.util.stream.Sink
                    public void begin(long size) {
                        this.downstream.begin(-1L);
                    }

                    @Override // j$.util.stream.Sink.OfLong, j$.util.stream.Sink
                    public void accept(long t) {
                        if (predicate.test(t)) {
                            this.downstream.accept(t);
                        }
                    }
                };
            }
        };
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.LongPipeline != java.util.stream.LongPipeline<E_IN> */
    @Override // j$.util.stream.LongStream
    public final LongStream peek(final LongConsumer action) {
        Objects.requireNonNull(action);
        return new StatelessOp<Long>(this, StreamShape.LONG_VALUE, 0) { // from class: j$.util.stream.LongPipeline.9
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Sink != java.util.stream.Sink<java.lang.Long> */
            @Override // j$.util.stream.AbstractPipeline
            public Sink<Long> opWrapSink(int flags, Sink<Long> sink) {
                return new Sink.ChainedLong<Long>(sink) { // from class: j$.util.stream.LongPipeline.9.1
                    @Override // j$.util.stream.Sink.OfLong, j$.util.stream.Sink
                    public void accept(long t) {
                        action.accept(t);
                        this.downstream.accept(t);
                    }
                };
            }
        };
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.LongPipeline != java.util.stream.LongPipeline<E_IN> */
    @Override // j$.util.stream.LongStream
    public final LongStream limit(long maxSize) {
        if (maxSize < 0) {
            throw new IllegalArgumentException(Long.toString(maxSize));
        }
        return SliceOps.makeLong(this, 0L, maxSize);
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.LongPipeline != java.util.stream.LongPipeline<E_IN> */
    @Override // j$.util.stream.LongStream
    public final LongStream skip(long n) {
        if (n < 0) {
            throw new IllegalArgumentException(Long.toString(n));
        }
        if (n == 0) {
            return this;
        }
        return SliceOps.makeLong(this, n, -1L);
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.LongPipeline != java.util.stream.LongPipeline<E_IN> */
    @Override // j$.util.stream.LongStream
    public final LongStream takeWhile(LongPredicate predicate) {
        return WhileOps.makeTakeWhileLong(this, predicate);
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.LongPipeline != java.util.stream.LongPipeline<E_IN> */
    @Override // j$.util.stream.LongStream
    public final LongStream dropWhile(LongPredicate predicate) {
        return WhileOps.makeDropWhileLong(this, predicate);
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.LongPipeline != java.util.stream.LongPipeline<E_IN> */
    @Override // j$.util.stream.LongStream
    public final LongStream sorted() {
        return SortedOps.makeLong(this);
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.LongPipeline != java.util.stream.LongPipeline<E_IN> */
    @Override // j$.util.stream.LongStream
    public final LongStream distinct() {
        return boxed().distinct().mapToLong(new ToLongFunction() { // from class: j$.util.stream.LongPipeline$$ExternalSyntheticLambda11
            @Override // java.util.function.ToLongFunction
            public final long applyAsLong(Object obj) {
                long longValue;
                longValue = ((Long) obj).longValue();
                return longValue;
            }
        });
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.LongPipeline != java.util.stream.LongPipeline<E_IN> */
    @Override // j$.util.stream.LongStream
    public void forEach(LongConsumer action) {
        evaluate(ForEachOps.makeLong(action, false));
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.LongPipeline != java.util.stream.LongPipeline<E_IN> */
    @Override // j$.util.stream.LongStream
    public void forEachOrdered(LongConsumer action) {
        evaluate(ForEachOps.makeLong(action, true));
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.LongPipeline != java.util.stream.LongPipeline<E_IN> */
    @Override // j$.util.stream.LongStream
    public final long sum() {
        return reduce(0L, new LongBinaryOperator() { // from class: j$.util.stream.LongPipeline$$ExternalSyntheticLambda9
            @Override // java.util.function.LongBinaryOperator
            public final long applyAsLong(long j, long j2) {
                return j + j2;
            }
        });
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.LongPipeline != java.util.stream.LongPipeline<E_IN> */
    @Override // j$.util.stream.LongStream
    public final OptionalLong min() {
        return reduce(new LongBinaryOperator() { // from class: j$.util.stream.LongPipeline$$ExternalSyntheticLambda10
            @Override // java.util.function.LongBinaryOperator
            public final long applyAsLong(long j, long j2) {
                return Math.min(j, j2);
            }
        });
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.LongPipeline != java.util.stream.LongPipeline<E_IN> */
    @Override // j$.util.stream.LongStream
    public final OptionalLong max() {
        return reduce(new LongBinaryOperator() { // from class: j$.util.stream.LongPipeline$$ExternalSyntheticLambda8
            @Override // java.util.function.LongBinaryOperator
            public final long applyAsLong(long j, long j2) {
                return Math.max(j, j2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ long[] lambda$average$1() {
        return new long[2];
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.LongPipeline != java.util.stream.LongPipeline<E_IN> */
    @Override // j$.util.stream.LongStream
    public final OptionalDouble average() {
        long[] avg = (long[]) collect(new Supplier() { // from class: j$.util.stream.LongPipeline$$ExternalSyntheticLambda4
            @Override // java.util.function.Supplier
            public final Object get() {
                return LongPipeline.lambda$average$1();
            }
        }, new ObjLongConsumer() { // from class: j$.util.stream.LongPipeline$$ExternalSyntheticLambda5
            @Override // java.util.function.ObjLongConsumer
            public final void accept(Object obj, long j) {
                LongPipeline.lambda$average$2((long[]) obj, j);
            }
        }, new BiConsumer() { // from class: j$.util.stream.LongPipeline$$ExternalSyntheticLambda6
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                LongPipeline.lambda$average$3((long[]) obj, (long[]) obj2);
            }

            @Override // java.util.function.BiConsumer
            public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                return BiConsumer$CC.$default$andThen(this, biConsumer);
            }
        });
        if (avg[0] > 0) {
            return OptionalDouble.of(avg[1] / avg[0]);
        }
        return OptionalDouble.empty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$average$2(long[] ll, long i) {
        ll[0] = ll[0] + 1;
        ll[1] = ll[1] + i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$average$3(long[] ll, long[] rr) {
        ll[0] = ll[0] + rr[0];
        ll[1] = ll[1] + rr[1];
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.LongPipeline != java.util.stream.LongPipeline<E_IN> */
    @Override // j$.util.stream.LongStream
    public final long count() {
        return ((Long) evaluate(ReduceOps.makeLongCounting())).longValue();
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.LongPipeline != java.util.stream.LongPipeline<E_IN> */
    @Override // j$.util.stream.LongStream
    public final LongSummaryStatistics summaryStatistics() {
        return (LongSummaryStatistics) collect(new Collectors$$ExternalSyntheticLambda61(), new ObjLongConsumer() { // from class: j$.util.stream.LongPipeline$$ExternalSyntheticLambda0
            @Override // java.util.function.ObjLongConsumer
            public final void accept(Object obj, long j) {
                ((LongSummaryStatistics) obj).accept(j);
            }
        }, new BiConsumer() { // from class: j$.util.stream.LongPipeline$$ExternalSyntheticLambda1
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((LongSummaryStatistics) obj).combine((LongSummaryStatistics) obj2);
            }

            @Override // java.util.function.BiConsumer
            public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                return BiConsumer$CC.$default$andThen(this, biConsumer);
            }
        });
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.LongPipeline != java.util.stream.LongPipeline<E_IN> */
    @Override // j$.util.stream.LongStream
    public final long reduce(long identity, LongBinaryOperator op) {
        return ((Long) evaluate(ReduceOps.makeLong(identity, op))).longValue();
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.LongPipeline != java.util.stream.LongPipeline<E_IN> */
    @Override // j$.util.stream.LongStream
    public final OptionalLong reduce(LongBinaryOperator op) {
        return (OptionalLong) evaluate(ReduceOps.makeLong(op));
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.LongPipeline != java.util.stream.LongPipeline<E_IN> */
    @Override // j$.util.stream.LongStream
    public final <R> R collect(Supplier<R> supplier, ObjLongConsumer<R> accumulator, final BiConsumer<R, R> combiner) {
        Objects.requireNonNull(combiner);
        BinaryOperator<R> operator = new BinaryOperator() { // from class: j$.util.stream.LongPipeline$$ExternalSyntheticLambda7
            @Override // java.util.function.BiFunction
            public /* synthetic */ BiFunction andThen(Function function) {
                return BiFunction$CC.$default$andThen(this, function);
            }

            /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
                jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: j$.util.stream.LongPipeline.lambda$collect$4(java.util.function.BiConsumer, java.lang.Object, java.lang.Object):java.lang.Object
                	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:76)
                	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:51)
                Caused by: java.lang.NullPointerException
                */
            @Override // java.util.function.BiFunction
            public final java.lang.Object apply(java.lang.Object r2, java.lang.Object r3) {
                /*
                    r1 = this;
                    java.util.function.BiConsumer r0 = java.util.function.BiConsumer.this
                    java.lang.Object r2 = j$.util.stream.LongPipeline.lambda$collect$4(r0, r2, r3)
                    return r2
                */
                throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.LongPipeline$$ExternalSyntheticLambda7.apply(java.lang.Object, java.lang.Object):java.lang.Object");
            }
        };
        return (R) evaluate(ReduceOps.makeLong(supplier, accumulator, operator));
    }

    /*  JADX ERROR: NullPointerException in pass: MarkMethodsForInline
        java.lang.NullPointerException
        */
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ java.lang.Object lambda$collect$4(java.util.function.BiConsumer r0, java.lang.Object r1, java.lang.Object r2) {
        /*
            r0.accept(r1, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.LongPipeline.lambda$collect$4(java.util.function.BiConsumer, java.lang.Object, java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.LongPipeline != java.util.stream.LongPipeline<E_IN> */
    @Override // j$.util.stream.LongStream
    public final boolean anyMatch(LongPredicate predicate) {
        return ((Boolean) evaluate(MatchOps.makeLong(predicate, MatchOps.MatchKind.ANY))).booleanValue();
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.LongPipeline != java.util.stream.LongPipeline<E_IN> */
    @Override // j$.util.stream.LongStream
    public final boolean allMatch(LongPredicate predicate) {
        return ((Boolean) evaluate(MatchOps.makeLong(predicate, MatchOps.MatchKind.ALL))).booleanValue();
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.LongPipeline != java.util.stream.LongPipeline<E_IN> */
    @Override // j$.util.stream.LongStream
    public final boolean noneMatch(LongPredicate predicate) {
        return ((Boolean) evaluate(MatchOps.makeLong(predicate, MatchOps.MatchKind.NONE))).booleanValue();
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.LongPipeline != java.util.stream.LongPipeline<E_IN> */
    @Override // j$.util.stream.LongStream
    public final OptionalLong findFirst() {
        return (OptionalLong) evaluate(FindOps.makeLong(true));
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.LongPipeline != java.util.stream.LongPipeline<E_IN> */
    @Override // j$.util.stream.LongStream
    public final OptionalLong findAny() {
        return (OptionalLong) evaluate(FindOps.makeLong(false));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Long[] lambda$toArray$5(int x$0) {
        return new Long[x$0];
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.LongPipeline != java.util.stream.LongPipeline<E_IN> */
    @Override // j$.util.stream.LongStream
    public final long[] toArray() {
        return Nodes.flattenLong((Node.OfLong) evaluateToArrayNode(new IntFunction() { // from class: j$.util.stream.LongPipeline$$ExternalSyntheticLambda2
            @Override // java.util.function.IntFunction
            public final Object apply(int i) {
                return LongPipeline.lambda$toArray$5(i);
            }
        })).asPrimitiveArray();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public static class Head<E_IN> extends LongPipeline<E_IN> {
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.LongPipeline$Head != java.util.stream.LongPipeline$Head<E_IN> */
        @Override // j$.util.stream.LongPipeline, j$.util.stream.AbstractPipeline, j$.util.stream.BaseStream
        public /* bridge */ /* synthetic */ LongStream parallel() {
            return (LongStream) super.parallel();
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.LongPipeline$Head != java.util.stream.LongPipeline$Head<E_IN> */
        @Override // j$.util.stream.LongPipeline, j$.util.stream.AbstractPipeline, j$.util.stream.BaseStream
        public /* bridge */ /* synthetic */ LongStream sequential() {
            return (LongStream) super.sequential();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.LongPipeline$Head != java.util.stream.LongPipeline$Head<E_IN> */
        public Head(Supplier<? extends Spliterator<Long>> supplier, int sourceFlags, boolean parallel) {
            super(supplier, sourceFlags, parallel);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<java.lang.Long> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.LongPipeline$Head != java.util.stream.LongPipeline$Head<E_IN> */
        public Head(Spliterator<Long> spliterator, int sourceFlags, boolean parallel) {
            super(spliterator, sourceFlags, parallel);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.LongPipeline$Head != java.util.stream.LongPipeline$Head<E_IN> */
        @Override // j$.util.stream.AbstractPipeline
        final boolean opIsStateful() {
            throw new UnsupportedOperationException();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.LongPipeline$Head != java.util.stream.LongPipeline$Head<E_IN> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Sink != java.util.stream.Sink<java.lang.Long> */
        @Override // j$.util.stream.AbstractPipeline
        public final Sink<E_IN> opWrapSink(int flags, Sink<Long> sink) {
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.LongPipeline$Head != java.util.stream.LongPipeline$Head<E_IN> */
        @Override // j$.util.stream.LongPipeline, j$.util.stream.LongStream
        public void forEach(LongConsumer action) {
            if (!isParallel()) {
                LongPipeline.adapt(sourceStageSpliterator()).forEachRemaining(action);
            } else {
                super.forEach(action);
            }
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.LongPipeline$Head != java.util.stream.LongPipeline$Head<E_IN> */
        @Override // j$.util.stream.LongPipeline, j$.util.stream.LongStream
        public void forEachOrdered(LongConsumer action) {
            if (!isParallel()) {
                LongPipeline.adapt(sourceStageSpliterator()).forEachRemaining(action);
            } else {
                super.forEachOrdered(action);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public static abstract class StatelessOp<E_IN> extends LongPipeline<E_IN> {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.LongPipeline$StatelessOp != java.util.stream.LongPipeline$StatelessOp<E_IN> */
        @Override // j$.util.stream.LongPipeline, j$.util.stream.AbstractPipeline, j$.util.stream.BaseStream
        public /* bridge */ /* synthetic */ LongStream parallel() {
            return (LongStream) super.parallel();
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.LongPipeline$StatelessOp != java.util.stream.LongPipeline$StatelessOp<E_IN> */
        @Override // j$.util.stream.LongPipeline, j$.util.stream.AbstractPipeline, j$.util.stream.BaseStream
        public /* bridge */ /* synthetic */ LongStream sequential() {
            return (LongStream) super.sequential();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.AbstractPipeline != java.util.stream.AbstractPipeline<?, E_IN, ?> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.LongPipeline$StatelessOp != java.util.stream.LongPipeline$StatelessOp<E_IN> */
        public StatelessOp(AbstractPipeline<?, E_IN, ?> abstractPipeline, StreamShape inputShape, int opFlags) {
            super(abstractPipeline, opFlags);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.LongPipeline$StatelessOp != java.util.stream.LongPipeline$StatelessOp<E_IN> */
        @Override // j$.util.stream.AbstractPipeline
        final boolean opIsStateful() {
            return false;
        }
    }

    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    static abstract class StatefulOp<E_IN> extends LongPipeline<E_IN> {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        @Override // j$.util.stream.AbstractPipeline
        abstract <P_IN> Node<Long> opEvaluateParallel(PipelineHelper<Long> pipelineHelper, Spliterator<P_IN> spliterator, IntFunction<Long[]> intFunction);

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.LongPipeline$StatefulOp != java.util.stream.LongPipeline$StatefulOp<E_IN> */
        @Override // j$.util.stream.LongPipeline, j$.util.stream.AbstractPipeline, j$.util.stream.BaseStream
        public /* bridge */ /* synthetic */ LongStream parallel() {
            return (LongStream) super.parallel();
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.LongPipeline$StatefulOp != java.util.stream.LongPipeline$StatefulOp<E_IN> */
        @Override // j$.util.stream.LongPipeline, j$.util.stream.AbstractPipeline, j$.util.stream.BaseStream
        public /* bridge */ /* synthetic */ LongStream sequential() {
            return (LongStream) super.sequential();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.AbstractPipeline != java.util.stream.AbstractPipeline<?, E_IN, ?> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.LongPipeline$StatefulOp != java.util.stream.LongPipeline$StatefulOp<E_IN> */
        public StatefulOp(AbstractPipeline<?, E_IN, ?> abstractPipeline, StreamShape inputShape, int opFlags) {
            super(abstractPipeline, opFlags);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.LongPipeline$StatefulOp != java.util.stream.LongPipeline$StatefulOp<E_IN> */
        @Override // j$.util.stream.AbstractPipeline
        final boolean opIsStateful() {
            return true;
        }
    }
}