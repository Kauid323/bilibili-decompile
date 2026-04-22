package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import j$.util.function.Consumer$CC;
import j$.util.function.DoubleConsumer$CC;
import j$.util.function.IntConsumer$CC;
import j$.util.function.LongConsumer$CC;
import j$.util.stream.DoublePipeline;
import j$.util.stream.IntPipeline;
import j$.util.stream.LongPipeline;
import j$.util.stream.Node;
import j$.util.stream.ReferencePipeline;
import j$.util.stream.Sink;
import j$.util.stream.WhileOps;
import java.util.Comparator;
import java.util.concurrent.CountedCompleter;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.DoublePredicate;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.LongConsumer;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

final class WhileOps {
    static final int TAKE_FLAGS = StreamOpFlag.NOT_SIZED | StreamOpFlag.IS_SHORT_CIRCUIT;
    static final int DROP_FLAGS = StreamOpFlag.NOT_SIZED;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public interface DropWhileOp<T> {
        DropWhileSink<T> opWrapSink(Sink<T> sink, boolean z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public interface DropWhileSink<T> extends Sink<T> {
        long getDropCount();
    }

    WhileOps() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.AbstractPipeline != java.util.stream.AbstractPipeline<?, T, ?> */
    public static <T> Stream<T> makeTakeWhileRef(AbstractPipeline<?, T, ?> abstractPipeline, final Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate);
        return new ReferencePipeline.StatefulOp<T, T>(abstractPipeline, StreamShape.REFERENCE, TAKE_FLAGS) { // from class: j$.util.stream.WhileOps.1
            /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<P_IN> */
            /* JADX WARN: Generic types in debug info not equals: j$.util.stream.PipelineHelper != java.util.stream.PipelineHelper<T> */
            @Override // j$.util.stream.AbstractPipeline
            <P_IN> Spliterator<T> opEvaluateParallelLazy(PipelineHelper<T> pipelineHelper, Spliterator<P_IN> spliterator) {
                if (StreamOpFlag.ORDERED.isKnown(pipelineHelper.getStreamAndOpFlags())) {
                    return opEvaluateParallel(pipelineHelper, spliterator, Nodes.castingArray()).spliterator();
                }
                return new UnorderedWhileSpliterator.OfRef.Taking(pipelineHelper.wrapSpliterator(spliterator), false, predicate);
            }

            /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<P_IN> */
            /* JADX WARN: Generic types in debug info not equals: j$.util.stream.PipelineHelper != java.util.stream.PipelineHelper<T> */
            @Override // j$.util.stream.ReferencePipeline.StatefulOp, j$.util.stream.AbstractPipeline
            <P_IN> Node<T> opEvaluateParallel(PipelineHelper<T> pipelineHelper, Spliterator<P_IN> spliterator, IntFunction<T[]> generator) {
                return (Node) new TakeWhileTask(this, pipelineHelper, spliterator, generator).invoke();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Sink != java.util.stream.Sink<T> */
            @Override // j$.util.stream.AbstractPipeline
            public Sink<T> opWrapSink(int flags, Sink<T> sink) {
                return new Sink.ChainedReference<T, T>(sink) { // from class: j$.util.stream.WhileOps.1.1
                    boolean take = true;

                    @Override // j$.util.stream.Sink.ChainedReference, j$.util.stream.Sink
                    public void begin(long size) {
                        this.downstream.begin(-1L);
                    }

                    @Override // java.util.function.Consumer
                    public void accept(T t) {
                        if (this.take) {
                            boolean test = predicate.test(t);
                            this.take = test;
                            if (test) {
                                this.downstream.accept(t);
                            }
                        }
                    }

                    @Override // j$.util.stream.Sink.ChainedReference, j$.util.stream.Sink
                    public boolean cancellationRequested() {
                        return !this.take || this.downstream.cancellationRequested();
                    }
                };
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j$.util.stream.WhileOps$2  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public class AnonymousClass2 extends IntPipeline.StatefulOp<Integer> {
        final /* synthetic */ IntPredicate val$predicate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.AbstractPipeline != java.util.stream.AbstractPipeline<?, java.lang.Integer, ?> */
        AnonymousClass2(AbstractPipeline abstractPipeline, StreamShape inputShape, int opFlags, IntPredicate intPredicate) {
            super(abstractPipeline, inputShape, opFlags);
            this.val$predicate = intPredicate;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<P_IN> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.PipelineHelper != java.util.stream.PipelineHelper<java.lang.Integer> */
        @Override // j$.util.stream.AbstractPipeline
        <P_IN> Spliterator<Integer> opEvaluateParallelLazy(PipelineHelper<Integer> pipelineHelper, Spliterator<P_IN> spliterator) {
            if (StreamOpFlag.ORDERED.isKnown(pipelineHelper.getStreamAndOpFlags())) {
                return opEvaluateParallel(pipelineHelper, spliterator, new IntFunction() { // from class: j$.util.stream.WhileOps$2$$ExternalSyntheticLambda0
                    @Override // java.util.function.IntFunction
                    public final Object apply(int i) {
                        return WhileOps.AnonymousClass2.lambda$opEvaluateParallelLazy$0(i);
                    }
                }).spliterator();
            }
            return new UnorderedWhileSpliterator.OfInt.Taking((Spliterator.OfInt) pipelineHelper.wrapSpliterator(spliterator), false, this.val$predicate);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ Integer[] lambda$opEvaluateParallelLazy$0(int x$0) {
            return new Integer[x$0];
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<P_IN> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.PipelineHelper != java.util.stream.PipelineHelper<java.lang.Integer> */
        @Override // j$.util.stream.IntPipeline.StatefulOp, j$.util.stream.AbstractPipeline
        <P_IN> Node<Integer> opEvaluateParallel(PipelineHelper<Integer> pipelineHelper, Spliterator<P_IN> spliterator, IntFunction<Integer[]> generator) {
            return (Node) new TakeWhileTask(this, pipelineHelper, spliterator, generator).invoke();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Sink != java.util.stream.Sink<java.lang.Integer> */
        @Override // j$.util.stream.AbstractPipeline
        public Sink<Integer> opWrapSink(int flags, Sink<Integer> sink) {
            return new Sink.ChainedInt<Integer>(sink) { // from class: j$.util.stream.WhileOps.2.1
                boolean take = true;

                @Override // j$.util.stream.Sink.ChainedInt, j$.util.stream.Sink
                public void begin(long size) {
                    this.downstream.begin(-1L);
                }

                @Override // j$.util.stream.Sink.OfInt, j$.util.stream.Sink
                public void accept(int t) {
                    if (this.take) {
                        boolean test = AnonymousClass2.this.val$predicate.test(t);
                        this.take = test;
                        if (test) {
                            this.downstream.accept(t);
                        }
                    }
                }

                @Override // j$.util.stream.Sink.ChainedInt, j$.util.stream.Sink
                public boolean cancellationRequested() {
                    return !this.take || this.downstream.cancellationRequested();
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.AbstractPipeline != java.util.stream.AbstractPipeline<?, java.lang.Integer, ?> */
    public static IntStream makeTakeWhileInt(AbstractPipeline<?, Integer, ?> abstractPipeline, IntPredicate predicate) {
        Objects.requireNonNull(predicate);
        return new AnonymousClass2(abstractPipeline, StreamShape.INT_VALUE, TAKE_FLAGS, predicate);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j$.util.stream.WhileOps$3  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public class AnonymousClass3 extends LongPipeline.StatefulOp<Long> {
        final /* synthetic */ LongPredicate val$predicate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.AbstractPipeline != java.util.stream.AbstractPipeline<?, java.lang.Long, ?> */
        AnonymousClass3(AbstractPipeline abstractPipeline, StreamShape inputShape, int opFlags, LongPredicate longPredicate) {
            super(abstractPipeline, inputShape, opFlags);
            this.val$predicate = longPredicate;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<P_IN> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.PipelineHelper != java.util.stream.PipelineHelper<java.lang.Long> */
        @Override // j$.util.stream.AbstractPipeline
        <P_IN> Spliterator<Long> opEvaluateParallelLazy(PipelineHelper<Long> pipelineHelper, Spliterator<P_IN> spliterator) {
            if (StreamOpFlag.ORDERED.isKnown(pipelineHelper.getStreamAndOpFlags())) {
                return opEvaluateParallel(pipelineHelper, spliterator, new IntFunction() { // from class: j$.util.stream.WhileOps$3$$ExternalSyntheticLambda0
                    @Override // java.util.function.IntFunction
                    public final Object apply(int i) {
                        return WhileOps.AnonymousClass3.lambda$opEvaluateParallelLazy$0(i);
                    }
                }).spliterator();
            }
            return new UnorderedWhileSpliterator.OfLong.Taking((Spliterator.OfLong) pipelineHelper.wrapSpliterator(spliterator), false, this.val$predicate);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ Long[] lambda$opEvaluateParallelLazy$0(int x$0) {
            return new Long[x$0];
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<P_IN> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.PipelineHelper != java.util.stream.PipelineHelper<java.lang.Long> */
        @Override // j$.util.stream.LongPipeline.StatefulOp, j$.util.stream.AbstractPipeline
        <P_IN> Node<Long> opEvaluateParallel(PipelineHelper<Long> pipelineHelper, Spliterator<P_IN> spliterator, IntFunction<Long[]> generator) {
            return (Node) new TakeWhileTask(this, pipelineHelper, spliterator, generator).invoke();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Sink != java.util.stream.Sink<java.lang.Long> */
        @Override // j$.util.stream.AbstractPipeline
        public Sink<Long> opWrapSink(int flags, Sink<Long> sink) {
            return new Sink.ChainedLong<Long>(sink) { // from class: j$.util.stream.WhileOps.3.1
                boolean take = true;

                @Override // j$.util.stream.Sink.ChainedLong, j$.util.stream.Sink
                public void begin(long size) {
                    this.downstream.begin(-1L);
                }

                @Override // j$.util.stream.Sink.OfLong, j$.util.stream.Sink
                public void accept(long t) {
                    if (this.take) {
                        boolean test = AnonymousClass3.this.val$predicate.test(t);
                        this.take = test;
                        if (test) {
                            this.downstream.accept(t);
                        }
                    }
                }

                @Override // j$.util.stream.Sink.ChainedLong, j$.util.stream.Sink
                public boolean cancellationRequested() {
                    return !this.take || this.downstream.cancellationRequested();
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.AbstractPipeline != java.util.stream.AbstractPipeline<?, java.lang.Long, ?> */
    public static LongStream makeTakeWhileLong(AbstractPipeline<?, Long, ?> abstractPipeline, LongPredicate predicate) {
        Objects.requireNonNull(predicate);
        return new AnonymousClass3(abstractPipeline, StreamShape.LONG_VALUE, TAKE_FLAGS, predicate);
    }

    /* renamed from: j$.util.stream.WhileOps$4  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    class AnonymousClass4 extends DoublePipeline.StatefulOp<Double> {
        final /* synthetic */ DoublePredicate val$predicate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.AbstractPipeline != java.util.stream.AbstractPipeline<?, java.lang.Double, ?> */
        AnonymousClass4(AbstractPipeline abstractPipeline, StreamShape inputShape, int opFlags, DoublePredicate doublePredicate) {
            super(abstractPipeline, inputShape, opFlags);
            this.val$predicate = doublePredicate;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<P_IN> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.PipelineHelper != java.util.stream.PipelineHelper<java.lang.Double> */
        @Override // j$.util.stream.AbstractPipeline
        <P_IN> Spliterator<Double> opEvaluateParallelLazy(PipelineHelper<Double> pipelineHelper, Spliterator<P_IN> spliterator) {
            if (StreamOpFlag.ORDERED.isKnown(pipelineHelper.getStreamAndOpFlags())) {
                return opEvaluateParallel(pipelineHelper, spliterator, new IntFunction() { // from class: j$.util.stream.WhileOps$4$$ExternalSyntheticLambda0
                    @Override // java.util.function.IntFunction
                    public final Object apply(int i) {
                        return WhileOps.AnonymousClass4.lambda$opEvaluateParallelLazy$0(i);
                    }
                }).spliterator();
            }
            return new UnorderedWhileSpliterator.OfDouble.Taking((Spliterator.OfDouble) pipelineHelper.wrapSpliterator(spliterator), false, this.val$predicate);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ Double[] lambda$opEvaluateParallelLazy$0(int x$0) {
            return new Double[x$0];
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<P_IN> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.PipelineHelper != java.util.stream.PipelineHelper<java.lang.Double> */
        @Override // j$.util.stream.DoublePipeline.StatefulOp, j$.util.stream.AbstractPipeline
        <P_IN> Node<Double> opEvaluateParallel(PipelineHelper<Double> pipelineHelper, Spliterator<P_IN> spliterator, IntFunction<Double[]> generator) {
            return (Node) new TakeWhileTask(this, pipelineHelper, spliterator, generator).invoke();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Sink != java.util.stream.Sink<java.lang.Double> */
        @Override // j$.util.stream.AbstractPipeline
        public Sink<Double> opWrapSink(int flags, Sink<Double> sink) {
            return new Sink.ChainedDouble<Double>(sink) { // from class: j$.util.stream.WhileOps.4.1
                boolean take = true;

                @Override // j$.util.stream.Sink.ChainedDouble, j$.util.stream.Sink
                public void begin(long size) {
                    this.downstream.begin(-1L);
                }

                @Override // j$.util.stream.Sink.OfDouble, j$.util.stream.Sink, java.util.function.DoubleConsumer
                public void accept(double t) {
                    if (this.take) {
                        boolean test = AnonymousClass4.this.val$predicate.test(t);
                        this.take = test;
                        if (test) {
                            this.downstream.accept(t);
                        }
                    }
                }

                @Override // j$.util.stream.Sink.ChainedDouble, j$.util.stream.Sink
                public boolean cancellationRequested() {
                    return !this.take || this.downstream.cancellationRequested();
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.AbstractPipeline != java.util.stream.AbstractPipeline<?, java.lang.Double, ?> */
    public static DoubleStream makeTakeWhileDouble(AbstractPipeline<?, Double, ?> abstractPipeline, DoublePredicate predicate) {
        Objects.requireNonNull(predicate);
        return new AnonymousClass4(abstractPipeline, StreamShape.DOUBLE_VALUE, TAKE_FLAGS, predicate);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.AbstractPipeline != java.util.stream.AbstractPipeline<?, T, ?> */
    public static <T> Stream<T> makeDropWhileRef(AbstractPipeline<?, T, ?> abstractPipeline, Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate);
        return new C1Op(abstractPipeline, StreamShape.REFERENCE, DROP_FLAGS, predicate);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: j$.util.stream.WhileOps$1Op  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public class C1Op<T> extends ReferencePipeline.StatefulOp<T, T> implements DropWhileOp<T> {
        final /* synthetic */ Predicate val$predicate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.AbstractPipeline != java.util.stream.AbstractPipeline<?, T, ?> */
        /* JADX WARN: Multi-variable type inference failed */
        public C1Op(AbstractPipeline abstractPipeline, AbstractPipeline<?, T, ?> abstractPipeline2, StreamShape streamShape, int i) {
            super(abstractPipeline, abstractPipeline2, streamShape);
            this.val$predicate = i;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<P_IN> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.PipelineHelper != java.util.stream.PipelineHelper<T> */
        @Override // j$.util.stream.AbstractPipeline
        <P_IN> Spliterator<T> opEvaluateParallelLazy(PipelineHelper<T> pipelineHelper, Spliterator<P_IN> spliterator) {
            if (StreamOpFlag.ORDERED.isKnown(pipelineHelper.getStreamAndOpFlags())) {
                return opEvaluateParallel(pipelineHelper, spliterator, Nodes.castingArray()).spliterator();
            }
            return new UnorderedWhileSpliterator.OfRef.Dropping(pipelineHelper.wrapSpliterator(spliterator), false, this.val$predicate);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<P_IN> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.PipelineHelper != java.util.stream.PipelineHelper<T> */
        @Override // j$.util.stream.ReferencePipeline.StatefulOp, j$.util.stream.AbstractPipeline
        <P_IN> Node<T> opEvaluateParallel(PipelineHelper<T> pipelineHelper, Spliterator<P_IN> spliterator, IntFunction<T[]> generator) {
            return (Node) new DropWhileTask(this, pipelineHelper, spliterator, generator).invoke();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Sink != java.util.stream.Sink<T> */
        @Override // j$.util.stream.AbstractPipeline
        public Sink<T> opWrapSink(int flags, Sink<T> sink) {
            return opWrapSink((Sink) sink, false);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: j$.util.stream.WhileOps$1Op$1OpSink  reason: invalid class name */
        /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
        public class C1OpSink extends Sink.ChainedReference<T, T> implements DropWhileSink<T> {
            long dropCount;
            boolean take;
            final /* synthetic */ boolean val$retainAndCountDroppedElements;
            final /* synthetic */ Sink val$sink;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1OpSink(Sink sink, boolean z) {
                super(sink);
                this.val$sink = sink;
                this.val$retainAndCountDroppedElements = z;
            }

            @Override // java.util.function.Consumer
            public void accept(T t) {
                boolean takeElement;
                if (!this.take) {
                    boolean test = C1Op.this.val$predicate.test(t);
                    this.take = !test;
                    if (test) {
                        takeElement = false;
                        if (this.val$retainAndCountDroppedElements && !takeElement) {
                            this.dropCount++;
                        }
                        if (!this.val$retainAndCountDroppedElements || takeElement) {
                            this.downstream.accept(t);
                        }
                        return;
                    }
                }
                takeElement = true;
                if (this.val$retainAndCountDroppedElements) {
                    this.dropCount++;
                }
                if (!this.val$retainAndCountDroppedElements) {
                }
                this.downstream.accept(t);
            }

            @Override // j$.util.stream.WhileOps.DropWhileSink
            public long getDropCount() {
                return this.dropCount;
            }
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Sink != java.util.stream.Sink<T> */
        @Override // j$.util.stream.WhileOps.DropWhileOp
        public DropWhileSink<T> opWrapSink(Sink<T> sink, boolean retainAndCountDroppedElements) {
            return new C1OpSink(sink, retainAndCountDroppedElements);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.AbstractPipeline != java.util.stream.AbstractPipeline<?, java.lang.Integer, ?> */
    public static IntStream makeDropWhileInt(AbstractPipeline<?, Integer, ?> abstractPipeline, IntPredicate predicate) {
        Objects.requireNonNull(predicate);
        return new C2Op(abstractPipeline, StreamShape.INT_VALUE, DROP_FLAGS, predicate);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j$.util.stream.WhileOps$2Op  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public class C2Op extends IntPipeline.StatefulOp<Integer> implements DropWhileOp<Integer> {
        final /* synthetic */ IntPredicate val$predicate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.AbstractPipeline != java.util.stream.AbstractPipeline<?, java.lang.Integer, ?> */
        /* JADX WARN: Multi-variable type inference failed */
        public C2Op(AbstractPipeline abstractPipeline, AbstractPipeline<?, Integer, ?> abstractPipeline2, StreamShape streamShape, int i) {
            super(abstractPipeline, abstractPipeline2, streamShape);
            this.val$predicate = i;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<P_IN> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.PipelineHelper != java.util.stream.PipelineHelper<java.lang.Integer> */
        @Override // j$.util.stream.AbstractPipeline
        <P_IN> Spliterator<Integer> opEvaluateParallelLazy(PipelineHelper<Integer> pipelineHelper, Spliterator<P_IN> spliterator) {
            if (StreamOpFlag.ORDERED.isKnown(pipelineHelper.getStreamAndOpFlags())) {
                return opEvaluateParallel(pipelineHelper, spliterator, new IntFunction() { // from class: j$.util.stream.WhileOps$2Op$$ExternalSyntheticLambda0
                    @Override // java.util.function.IntFunction
                    public final Object apply(int i) {
                        return WhileOps.C2Op.lambda$opEvaluateParallelLazy$0(i);
                    }
                }).spliterator();
            }
            return new UnorderedWhileSpliterator.OfInt.Dropping((Spliterator.OfInt) pipelineHelper.wrapSpliterator(spliterator), false, this.val$predicate);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ Integer[] lambda$opEvaluateParallelLazy$0(int x$0) {
            return new Integer[x$0];
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<P_IN> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.PipelineHelper != java.util.stream.PipelineHelper<java.lang.Integer> */
        @Override // j$.util.stream.IntPipeline.StatefulOp, j$.util.stream.AbstractPipeline
        <P_IN> Node<Integer> opEvaluateParallel(PipelineHelper<Integer> pipelineHelper, Spliterator<P_IN> spliterator, IntFunction<Integer[]> generator) {
            return (Node) new DropWhileTask(this, pipelineHelper, spliterator, generator).invoke();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Sink != java.util.stream.Sink<java.lang.Integer> */
        @Override // j$.util.stream.AbstractPipeline
        public Sink<Integer> opWrapSink(int flags, Sink<Integer> sink) {
            return opWrapSink(sink, false);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: j$.util.stream.WhileOps$2Op$1OpSink  reason: invalid class name */
        /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
        public class C1OpSink extends Sink.ChainedInt<Integer> implements DropWhileSink<Integer> {
            long dropCount;
            boolean take;
            final /* synthetic */ boolean val$retainAndCountDroppedElements;
            final /* synthetic */ Sink val$sink;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1OpSink(Sink sink, boolean z) {
                super(sink);
                this.val$sink = sink;
                this.val$retainAndCountDroppedElements = z;
            }

            @Override // j$.util.stream.Sink.OfInt, j$.util.stream.Sink
            public void accept(int t) {
                boolean takeElement;
                if (!this.take) {
                    boolean test = C2Op.this.val$predicate.test(t);
                    this.take = !test;
                    if (test) {
                        takeElement = false;
                        if (this.val$retainAndCountDroppedElements && !takeElement) {
                            this.dropCount++;
                        }
                        if (!this.val$retainAndCountDroppedElements || takeElement) {
                            this.downstream.accept(t);
                        }
                        return;
                    }
                }
                takeElement = true;
                if (this.val$retainAndCountDroppedElements) {
                    this.dropCount++;
                }
                if (!this.val$retainAndCountDroppedElements) {
                }
                this.downstream.accept(t);
            }

            @Override // j$.util.stream.WhileOps.DropWhileSink
            public long getDropCount() {
                return this.dropCount;
            }
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Sink != java.util.stream.Sink<java.lang.Integer> */
        @Override // j$.util.stream.WhileOps.DropWhileOp
        public DropWhileSink<Integer> opWrapSink(Sink<Integer> sink, boolean retainAndCountDroppedElements) {
            return new C1OpSink(sink, retainAndCountDroppedElements);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.AbstractPipeline != java.util.stream.AbstractPipeline<?, java.lang.Long, ?> */
    public static LongStream makeDropWhileLong(AbstractPipeline<?, Long, ?> abstractPipeline, LongPredicate predicate) {
        Objects.requireNonNull(predicate);
        return new C3Op(abstractPipeline, StreamShape.LONG_VALUE, DROP_FLAGS, predicate);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j$.util.stream.WhileOps$3Op  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public class C3Op extends LongPipeline.StatefulOp<Long> implements DropWhileOp<Long> {
        final /* synthetic */ LongPredicate val$predicate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.AbstractPipeline != java.util.stream.AbstractPipeline<?, java.lang.Long, ?> */
        /* JADX WARN: Multi-variable type inference failed */
        public C3Op(AbstractPipeline abstractPipeline, AbstractPipeline<?, Long, ?> abstractPipeline2, StreamShape streamShape, int i) {
            super(abstractPipeline, abstractPipeline2, streamShape);
            this.val$predicate = i;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<P_IN> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.PipelineHelper != java.util.stream.PipelineHelper<java.lang.Long> */
        @Override // j$.util.stream.AbstractPipeline
        <P_IN> Spliterator<Long> opEvaluateParallelLazy(PipelineHelper<Long> pipelineHelper, Spliterator<P_IN> spliterator) {
            if (StreamOpFlag.ORDERED.isKnown(pipelineHelper.getStreamAndOpFlags())) {
                return opEvaluateParallel(pipelineHelper, spliterator, new IntFunction() { // from class: j$.util.stream.WhileOps$3Op$$ExternalSyntheticLambda0
                    @Override // java.util.function.IntFunction
                    public final Object apply(int i) {
                        return WhileOps.C3Op.lambda$opEvaluateParallelLazy$0(i);
                    }
                }).spliterator();
            }
            return new UnorderedWhileSpliterator.OfLong.Dropping((Spliterator.OfLong) pipelineHelper.wrapSpliterator(spliterator), false, this.val$predicate);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ Long[] lambda$opEvaluateParallelLazy$0(int x$0) {
            return new Long[x$0];
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<P_IN> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.PipelineHelper != java.util.stream.PipelineHelper<java.lang.Long> */
        @Override // j$.util.stream.LongPipeline.StatefulOp, j$.util.stream.AbstractPipeline
        <P_IN> Node<Long> opEvaluateParallel(PipelineHelper<Long> pipelineHelper, Spliterator<P_IN> spliterator, IntFunction<Long[]> generator) {
            return (Node) new DropWhileTask(this, pipelineHelper, spliterator, generator).invoke();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Sink != java.util.stream.Sink<java.lang.Long> */
        @Override // j$.util.stream.AbstractPipeline
        public Sink<Long> opWrapSink(int flags, Sink<Long> sink) {
            return opWrapSink(sink, false);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: j$.util.stream.WhileOps$3Op$1OpSink  reason: invalid class name */
        /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
        public class C1OpSink extends Sink.ChainedLong<Long> implements DropWhileSink<Long> {
            long dropCount;
            boolean take;
            final /* synthetic */ boolean val$retainAndCountDroppedElements;
            final /* synthetic */ Sink val$sink;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1OpSink(Sink sink, boolean z) {
                super(sink);
                this.val$sink = sink;
                this.val$retainAndCountDroppedElements = z;
            }

            @Override // j$.util.stream.Sink.OfLong, j$.util.stream.Sink
            public void accept(long t) {
                boolean takeElement;
                if (!this.take) {
                    boolean test = C3Op.this.val$predicate.test(t);
                    this.take = !test;
                    if (test) {
                        takeElement = false;
                        if (this.val$retainAndCountDroppedElements && !takeElement) {
                            this.dropCount++;
                        }
                        if (!this.val$retainAndCountDroppedElements || takeElement) {
                            this.downstream.accept(t);
                        }
                        return;
                    }
                }
                takeElement = true;
                if (this.val$retainAndCountDroppedElements) {
                    this.dropCount++;
                }
                if (!this.val$retainAndCountDroppedElements) {
                }
                this.downstream.accept(t);
            }

            @Override // j$.util.stream.WhileOps.DropWhileSink
            public long getDropCount() {
                return this.dropCount;
            }
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Sink != java.util.stream.Sink<java.lang.Long> */
        @Override // j$.util.stream.WhileOps.DropWhileOp
        public DropWhileSink<Long> opWrapSink(Sink<Long> sink, boolean retainAndCountDroppedElements) {
            return new C1OpSink(sink, retainAndCountDroppedElements);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.AbstractPipeline != java.util.stream.AbstractPipeline<?, java.lang.Double, ?> */
    public static DoubleStream makeDropWhileDouble(AbstractPipeline<?, Double, ?> abstractPipeline, DoublePredicate predicate) {
        Objects.requireNonNull(predicate);
        return new C4Op(abstractPipeline, StreamShape.DOUBLE_VALUE, DROP_FLAGS, predicate);
    }

    /* renamed from: j$.util.stream.WhileOps$4Op  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    class C4Op extends DoublePipeline.StatefulOp<Double> implements DropWhileOp<Double> {
        final /* synthetic */ DoublePredicate val$predicate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.AbstractPipeline != java.util.stream.AbstractPipeline<?, java.lang.Double, ?> */
        /* JADX WARN: Multi-variable type inference failed */
        public C4Op(AbstractPipeline abstractPipeline, AbstractPipeline<?, Double, ?> abstractPipeline2, StreamShape streamShape, int i) {
            super(abstractPipeline, abstractPipeline2, streamShape);
            this.val$predicate = i;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<P_IN> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.PipelineHelper != java.util.stream.PipelineHelper<java.lang.Double> */
        @Override // j$.util.stream.AbstractPipeline
        <P_IN> Spliterator<Double> opEvaluateParallelLazy(PipelineHelper<Double> pipelineHelper, Spliterator<P_IN> spliterator) {
            if (StreamOpFlag.ORDERED.isKnown(pipelineHelper.getStreamAndOpFlags())) {
                return opEvaluateParallel(pipelineHelper, spliterator, new IntFunction() { // from class: j$.util.stream.WhileOps$4Op$$ExternalSyntheticLambda0
                    @Override // java.util.function.IntFunction
                    public final Object apply(int i) {
                        return WhileOps.C4Op.lambda$opEvaluateParallelLazy$0(i);
                    }
                }).spliterator();
            }
            return new UnorderedWhileSpliterator.OfDouble.Dropping((Spliterator.OfDouble) pipelineHelper.wrapSpliterator(spliterator), false, this.val$predicate);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ Double[] lambda$opEvaluateParallelLazy$0(int x$0) {
            return new Double[x$0];
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<P_IN> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.PipelineHelper != java.util.stream.PipelineHelper<java.lang.Double> */
        @Override // j$.util.stream.DoublePipeline.StatefulOp, j$.util.stream.AbstractPipeline
        <P_IN> Node<Double> opEvaluateParallel(PipelineHelper<Double> pipelineHelper, Spliterator<P_IN> spliterator, IntFunction<Double[]> generator) {
            return (Node) new DropWhileTask(this, pipelineHelper, spliterator, generator).invoke();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Sink != java.util.stream.Sink<java.lang.Double> */
        @Override // j$.util.stream.AbstractPipeline
        public Sink<Double> opWrapSink(int flags, Sink<Double> sink) {
            return opWrapSink(sink, false);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: j$.util.stream.WhileOps$4Op$1OpSink  reason: invalid class name */
        /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
        public class C1OpSink extends Sink.ChainedDouble<Double> implements DropWhileSink<Double> {
            long dropCount;
            boolean take;
            final /* synthetic */ boolean val$retainAndCountDroppedElements;
            final /* synthetic */ Sink val$sink;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1OpSink(Sink sink, boolean z) {
                super(sink);
                this.val$sink = sink;
                this.val$retainAndCountDroppedElements = z;
            }

            @Override // j$.util.stream.Sink.OfDouble, j$.util.stream.Sink, java.util.function.DoubleConsumer
            public void accept(double t) {
                boolean takeElement;
                if (!this.take) {
                    boolean test = C4Op.this.val$predicate.test(t);
                    this.take = !test;
                    if (test) {
                        takeElement = false;
                        if (this.val$retainAndCountDroppedElements && !takeElement) {
                            this.dropCount++;
                        }
                        if (!this.val$retainAndCountDroppedElements || takeElement) {
                            this.downstream.accept(t);
                        }
                        return;
                    }
                }
                takeElement = true;
                if (this.val$retainAndCountDroppedElements) {
                    this.dropCount++;
                }
                if (!this.val$retainAndCountDroppedElements) {
                }
                this.downstream.accept(t);
            }

            @Override // j$.util.stream.WhileOps.DropWhileSink
            public long getDropCount() {
                return this.dropCount;
            }
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Sink != java.util.stream.Sink<java.lang.Double> */
        @Override // j$.util.stream.WhileOps.DropWhileOp
        public DropWhileSink<Double> opWrapSink(Sink<Double> sink, boolean retainAndCountDroppedElements) {
            return new C1OpSink(sink, retainAndCountDroppedElements);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public static abstract class UnorderedWhileSpliterator<T, T_SPLITR extends Spliterator<T>> implements Spliterator<T> {
        static final int CANCEL_CHECK_COUNT = 63;
        final AtomicBoolean cancel;
        int count;
        final boolean noSplitting;
        final T_SPLITR s;
        boolean takeOrDrop;

        @Override // j$.util.Spliterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Spliterator.CC.$default$forEachRemaining(this, consumer);
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ boolean hasCharacteristics(int i) {
            return Spliterator.CC.$default$hasCharacteristics(this, i);
        }

        abstract T_SPLITR makeSpliterator(T_SPLITR t_splitr);

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.WhileOps$UnorderedWhileSpliterator != java.util.stream.WhileOps$UnorderedWhileSpliterator<T, T_SPLITR extends j$.util.Spliterator<T>> */
        UnorderedWhileSpliterator(T_SPLITR s, boolean noSplitting) {
            this.takeOrDrop = true;
            this.s = s;
            this.noSplitting = noSplitting;
            this.cancel = new AtomicBoolean();
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.WhileOps$UnorderedWhileSpliterator != java.util.stream.WhileOps$UnorderedWhileSpliterator<T, T_SPLITR extends j$.util.Spliterator<T>> */
        UnorderedWhileSpliterator(T_SPLITR s, UnorderedWhileSpliterator<T, T_SPLITR> unorderedWhileSpliterator) {
            this.takeOrDrop = true;
            this.s = s;
            this.noSplitting = unorderedWhileSpliterator.noSplitting;
            this.cancel = unorderedWhileSpliterator.cancel;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.WhileOps$UnorderedWhileSpliterator != java.util.stream.WhileOps$UnorderedWhileSpliterator<T, T_SPLITR extends j$.util.Spliterator<T>> */
        @Override // j$.util.Spliterator
        public long estimateSize() {
            return this.s.estimateSize();
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.WhileOps$UnorderedWhileSpliterator != java.util.stream.WhileOps$UnorderedWhileSpliterator<T, T_SPLITR extends j$.util.Spliterator<T>> */
        @Override // j$.util.Spliterator
        public int characteristics() {
            return this.s.characteristics() & (-16449);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.WhileOps$UnorderedWhileSpliterator != java.util.stream.WhileOps$UnorderedWhileSpliterator<T, T_SPLITR extends j$.util.Spliterator<T>> */
        @Override // j$.util.Spliterator
        public long getExactSizeIfKnown() {
            return -1L;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.WhileOps$UnorderedWhileSpliterator != java.util.stream.WhileOps$UnorderedWhileSpliterator<T, T_SPLITR extends j$.util.Spliterator<T>> */
        @Override // j$.util.Spliterator
        public Comparator<? super T> getComparator() {
            return this.s.getComparator();
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.WhileOps$UnorderedWhileSpliterator != java.util.stream.WhileOps$UnorderedWhileSpliterator<T, T_SPLITR extends j$.util.Spliterator<T>> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // j$.util.Spliterator
        public T_SPLITR trySplit() {
            Spliterator<T> trySplit = this.noSplitting ? null : this.s.trySplit();
            if (trySplit != null) {
                return (T_SPLITR) makeSpliterator(trySplit);
            }
            return null;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.WhileOps$UnorderedWhileSpliterator != java.util.stream.WhileOps$UnorderedWhileSpliterator<T, T_SPLITR extends j$.util.Spliterator<T>> */
        boolean checkCancelOnCount() {
            return (this.count == 0 && this.cancel.get()) ? false : true;
        }

        /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
        static abstract class OfRef<T> extends UnorderedWhileSpliterator<T, Spliterator<T>> implements Consumer<T> {
            final Predicate<? super T> p;
            T t;

            @Override // java.util.function.Consumer
            public /* synthetic */ Consumer andThen(Consumer consumer) {
                return Consumer$CC.$default$andThen(this, consumer);
            }

            /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<T> */
            /* JADX WARN: Generic types in debug info not equals: j$.util.stream.WhileOps$UnorderedWhileSpliterator$OfRef != java.util.stream.WhileOps$UnorderedWhileSpliterator$OfRef<T> */
            OfRef(Spliterator<T> spliterator, boolean noSplitting, Predicate<? super T> p) {
                super(spliterator, noSplitting);
                this.p = p;
            }

            /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<T> */
            /* JADX WARN: Generic types in debug info not equals: j$.util.stream.WhileOps$UnorderedWhileSpliterator$OfRef != java.util.stream.WhileOps$UnorderedWhileSpliterator$OfRef<T> */
            OfRef(Spliterator<T> spliterator, OfRef<T> ofRef) {
                super(spliterator, ofRef);
                this.p = ofRef.p;
            }

            /* JADX WARN: Generic types in debug info not equals: j$.util.stream.WhileOps$UnorderedWhileSpliterator$OfRef != java.util.stream.WhileOps$UnorderedWhileSpliterator$OfRef<T> */
            @Override // java.util.function.Consumer
            public void accept(T t) {
                this.count = (this.count + 1) & UnorderedWhileSpliterator.CANCEL_CHECK_COUNT;
                this.t = t;
            }

            /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
            static final class Taking<T> extends OfRef<T> {
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<T> */
                /* JADX WARN: Generic types in debug info not equals: j$.util.stream.WhileOps$UnorderedWhileSpliterator$OfRef$Taking != java.util.stream.WhileOps$UnorderedWhileSpliterator$OfRef$Taking<T> */
                public Taking(Spliterator<T> spliterator, boolean noSplitting, Predicate<? super T> p) {
                    super(spliterator, noSplitting, p);
                }

                /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<T> */
                /* JADX WARN: Generic types in debug info not equals: j$.util.stream.WhileOps$UnorderedWhileSpliterator$OfRef$Taking != java.util.stream.WhileOps$UnorderedWhileSpliterator$OfRef$Taking<T> */
                Taking(Spliterator<T> spliterator, Taking<T> taking) {
                    super(spliterator, taking);
                }

                /* JADX WARN: Generic types in debug info not equals: j$.util.stream.WhileOps$UnorderedWhileSpliterator$OfRef$Taking != java.util.stream.WhileOps$UnorderedWhileSpliterator$OfRef$Taking<T> */
                @Override // j$.util.Spliterator
                public boolean tryAdvance(Consumer<? super T> action) {
                    boolean test = true;
                    if (this.takeOrDrop && checkCancelOnCount() && this.s.tryAdvance(this)) {
                        boolean test2 = this.p.test((T) this.t);
                        test = test2;
                        if (test2) {
                            action.accept((T) this.t);
                            return true;
                        }
                    }
                    this.takeOrDrop = false;
                    if (!test) {
                        this.cancel.set(true);
                    }
                    return false;
                }

                /* JADX WARN: Generic types in debug info not equals: j$.util.stream.WhileOps$UnorderedWhileSpliterator$OfRef$Taking != java.util.stream.WhileOps$UnorderedWhileSpliterator$OfRef$Taking<T> */
                @Override // j$.util.stream.WhileOps.UnorderedWhileSpliterator, j$.util.Spliterator
                public Spliterator<T> trySplit() {
                    if (this.cancel.get()) {
                        return null;
                    }
                    return super.trySplit();
                }

                /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<T> */
                /* JADX WARN: Generic types in debug info not equals: j$.util.stream.WhileOps$UnorderedWhileSpliterator$OfRef$Taking != java.util.stream.WhileOps$UnorderedWhileSpliterator$OfRef$Taking<T> */
                @Override // j$.util.stream.WhileOps.UnorderedWhileSpliterator
                Spliterator<T> makeSpliterator(Spliterator<T> spliterator) {
                    return new Taking(spliterator, this);
                }
            }

            /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
            static final class Dropping<T> extends OfRef<T> {
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<T> */
                /* JADX WARN: Generic types in debug info not equals: j$.util.stream.WhileOps$UnorderedWhileSpliterator$OfRef$Dropping != java.util.stream.WhileOps$UnorderedWhileSpliterator$OfRef$Dropping<T> */
                public Dropping(Spliterator<T> spliterator, boolean noSplitting, Predicate<? super T> p) {
                    super(spliterator, noSplitting, p);
                }

                /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<T> */
                /* JADX WARN: Generic types in debug info not equals: j$.util.stream.WhileOps$UnorderedWhileSpliterator$OfRef$Dropping != java.util.stream.WhileOps$UnorderedWhileSpliterator$OfRef$Dropping<T> */
                Dropping(Spliterator<T> spliterator, Dropping<T> dropping) {
                    super(spliterator, dropping);
                }

                /* JADX WARN: Code restructure failed: missing block: B:13:0x0025, code lost:
                    if (r0 == false) goto L15;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:14:0x0027, code lost:
                    r4.cancel.set(true);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:15:0x002d, code lost:
                    r5.accept((T) r4.t);
                 */
                /* JADX WARN: Generic types in debug info not equals: j$.util.stream.WhileOps$UnorderedWhileSpliterator$OfRef$Dropping != java.util.stream.WhileOps$UnorderedWhileSpliterator$OfRef$Dropping<T> */
                @Override // j$.util.Spliterator
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public boolean tryAdvance(Consumer<? super T> action) {
                    boolean adv;
                    if (this.takeOrDrop) {
                        this.takeOrDrop = false;
                        boolean dropped = false;
                        while (true) {
                            adv = this.s.tryAdvance(this);
                            if (!adv || !checkCancelOnCount() || !this.p.test((T) this.t)) {
                                break;
                            }
                            dropped = true;
                        }
                        return adv;
                    }
                    return this.s.tryAdvance(action);
                }

                /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<T> */
                /* JADX WARN: Generic types in debug info not equals: j$.util.stream.WhileOps$UnorderedWhileSpliterator$OfRef$Dropping != java.util.stream.WhileOps$UnorderedWhileSpliterator$OfRef$Dropping<T> */
                @Override // j$.util.stream.WhileOps.UnorderedWhileSpliterator
                Spliterator<T> makeSpliterator(Spliterator<T> spliterator) {
                    return new Dropping(spliterator, this);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
        public static abstract class OfInt extends UnorderedWhileSpliterator<Integer, Spliterator.OfInt> implements IntConsumer, Spliterator.OfInt {
            final IntPredicate p;
            int t;

            @Override // java.util.function.IntConsumer
            public /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
                return IntConsumer$CC.$default$andThen(this, intConsumer);
            }

            @Override // j$.util.Spliterator.OfPrimitive
            public /* bridge */ /* synthetic */ void forEachRemaining(IntConsumer intConsumer) {
                forEachRemaining((IntConsumer) intConsumer);
            }

            @Override // j$.util.stream.WhileOps.UnorderedWhileSpliterator, j$.util.Spliterator
            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                Spliterator.OfInt.CC.$default$forEachRemaining((Spliterator.OfInt) this, consumer);
            }

            @Override // j$.util.Spliterator.OfInt
            /* renamed from: forEachRemaining  reason: avoid collision after fix types in other method */
            public /* synthetic */ void forEachRemaining2(IntConsumer intConsumer) {
                Spliterator.OfInt.CC.$default$forEachRemaining((Spliterator.OfInt) this, intConsumer);
            }

            @Override // j$.util.Spliterator.OfPrimitive
            public /* bridge */ /* synthetic */ boolean tryAdvance(IntConsumer intConsumer) {
                boolean tryAdvance;
                tryAdvance = tryAdvance((IntConsumer) intConsumer);
                return tryAdvance;
            }

            @Override // j$.util.Spliterator
            public /* synthetic */ boolean tryAdvance(Consumer consumer) {
                return Spliterator.OfInt.CC.$default$tryAdvance((Spliterator.OfInt) this, consumer);
            }

            @Override // j$.util.stream.WhileOps.UnorderedWhileSpliterator, j$.util.Spliterator
            public /* bridge */ /* synthetic */ Spliterator.OfInt trySplit() {
                return (Spliterator.OfInt) super.trySplit();
            }

            @Override // j$.util.stream.WhileOps.UnorderedWhileSpliterator, j$.util.Spliterator
            public /* bridge */ /* synthetic */ Spliterator.OfPrimitive trySplit() {
                return (Spliterator.OfPrimitive) super.trySplit();
            }

            OfInt(Spliterator.OfInt s, boolean noSplitting, IntPredicate p) {
                super(s, noSplitting);
                this.p = p;
            }

            OfInt(Spliterator.OfInt s, OfInt parent) {
                super(s, parent);
                this.p = parent.p;
            }

            @Override // java.util.function.IntConsumer
            public void accept(int t) {
                this.count = (this.count + 1) & UnorderedWhileSpliterator.CANCEL_CHECK_COUNT;
                this.t = t;
            }

            /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
            static final class Taking extends OfInt {
                /* JADX INFO: Access modifiers changed from: package-private */
                public Taking(Spliterator.OfInt s, boolean noSplitting, IntPredicate p) {
                    super(s, noSplitting, p);
                }

                Taking(Spliterator.OfInt s, OfInt parent) {
                    super(s, parent);
                }

                @Override // j$.util.stream.WhileOps.UnorderedWhileSpliterator.OfInt, j$.util.Spliterator.OfPrimitive
                public boolean tryAdvance(IntConsumer action) {
                    boolean test = true;
                    if (this.takeOrDrop && checkCancelOnCount() && ((Spliterator.OfInt) this.s).tryAdvance((IntConsumer) this)) {
                        boolean test2 = this.p.test(this.t);
                        test = test2;
                        if (test2) {
                            action.accept(this.t);
                            return true;
                        }
                    }
                    this.takeOrDrop = false;
                    if (!test) {
                        this.cancel.set(true);
                    }
                    return false;
                }

                @Override // j$.util.stream.WhileOps.UnorderedWhileSpliterator, j$.util.Spliterator
                public Spliterator.OfInt trySplit() {
                    if (this.cancel.get()) {
                        return null;
                    }
                    return (Spliterator.OfInt) super.trySplit();
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                @Override // j$.util.stream.WhileOps.UnorderedWhileSpliterator
                public Spliterator.OfInt makeSpliterator(Spliterator.OfInt s) {
                    return new Taking(s, this);
                }
            }

            /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
            static final class Dropping extends OfInt {
                @Override // j$.util.stream.WhileOps.UnorderedWhileSpliterator.OfInt, j$.util.stream.WhileOps.UnorderedWhileSpliterator, j$.util.Spliterator
                public /* bridge */ /* synthetic */ Spliterator.OfInt trySplit() {
                    return (Spliterator.OfInt) super.trySplit();
                }

                @Override // j$.util.stream.WhileOps.UnorderedWhileSpliterator.OfInt, j$.util.stream.WhileOps.UnorderedWhileSpliterator, j$.util.Spliterator
                public /* bridge */ /* synthetic */ Spliterator.OfPrimitive trySplit() {
                    return (Spliterator.OfPrimitive) super.trySplit();
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                public Dropping(Spliterator.OfInt s, boolean noSplitting, IntPredicate p) {
                    super(s, noSplitting, p);
                }

                Dropping(Spliterator.OfInt s, OfInt parent) {
                    super(s, parent);
                }

                /* JADX WARN: Code restructure failed: missing block: B:13:0x0027, code lost:
                    if (r0 == false) goto L15;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:14:0x0029, code lost:
                    r4.cancel.set(true);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:15:0x002f, code lost:
                    r5.accept(r4.t);
                 */
                @Override // j$.util.stream.WhileOps.UnorderedWhileSpliterator.OfInt, j$.util.Spliterator.OfPrimitive
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public boolean tryAdvance(IntConsumer action) {
                    boolean adv;
                    if (this.takeOrDrop) {
                        this.takeOrDrop = false;
                        boolean dropped = false;
                        while (true) {
                            adv = ((Spliterator.OfInt) this.s).tryAdvance((IntConsumer) this);
                            if (!adv || !checkCancelOnCount() || !this.p.test(this.t)) {
                                break;
                            }
                            dropped = true;
                        }
                        return adv;
                    }
                    return ((Spliterator.OfInt) this.s).tryAdvance(action);
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                @Override // j$.util.stream.WhileOps.UnorderedWhileSpliterator
                public Spliterator.OfInt makeSpliterator(Spliterator.OfInt s) {
                    return new Dropping(s, this);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
        public static abstract class OfLong extends UnorderedWhileSpliterator<Long, Spliterator.OfLong> implements LongConsumer, Spliterator.OfLong {
            final LongPredicate p;
            long t;

            @Override // java.util.function.LongConsumer
            public /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
                return LongConsumer$CC.$default$andThen(this, longConsumer);
            }

            @Override // j$.util.Spliterator.OfPrimitive
            public /* bridge */ /* synthetic */ void forEachRemaining(LongConsumer longConsumer) {
                forEachRemaining((LongConsumer) longConsumer);
            }

            @Override // j$.util.stream.WhileOps.UnorderedWhileSpliterator, j$.util.Spliterator
            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                Spliterator.OfLong.CC.$default$forEachRemaining((Spliterator.OfLong) this, consumer);
            }

            @Override // j$.util.Spliterator.OfLong
            /* renamed from: forEachRemaining  reason: avoid collision after fix types in other method */
            public /* synthetic */ void forEachRemaining2(LongConsumer longConsumer) {
                Spliterator.OfLong.CC.$default$forEachRemaining((Spliterator.OfLong) this, longConsumer);
            }

            @Override // j$.util.Spliterator.OfPrimitive
            public /* bridge */ /* synthetic */ boolean tryAdvance(LongConsumer longConsumer) {
                boolean tryAdvance;
                tryAdvance = tryAdvance((LongConsumer) longConsumer);
                return tryAdvance;
            }

            @Override // j$.util.Spliterator
            public /* synthetic */ boolean tryAdvance(Consumer consumer) {
                return Spliterator.OfLong.CC.$default$tryAdvance((Spliterator.OfLong) this, consumer);
            }

            @Override // j$.util.stream.WhileOps.UnorderedWhileSpliterator, j$.util.Spliterator
            public /* bridge */ /* synthetic */ Spliterator.OfLong trySplit() {
                return (Spliterator.OfLong) super.trySplit();
            }

            @Override // j$.util.stream.WhileOps.UnorderedWhileSpliterator, j$.util.Spliterator
            public /* bridge */ /* synthetic */ Spliterator.OfPrimitive trySplit() {
                return (Spliterator.OfPrimitive) super.trySplit();
            }

            OfLong(Spliterator.OfLong s, boolean noSplitting, LongPredicate p) {
                super(s, noSplitting);
                this.p = p;
            }

            OfLong(Spliterator.OfLong s, OfLong parent) {
                super(s, parent);
                this.p = parent.p;
            }

            @Override // java.util.function.LongConsumer
            public void accept(long t) {
                this.count = (this.count + 1) & UnorderedWhileSpliterator.CANCEL_CHECK_COUNT;
                this.t = t;
            }

            /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
            static final class Taking extends OfLong {
                /* JADX INFO: Access modifiers changed from: package-private */
                public Taking(Spliterator.OfLong s, boolean noSplitting, LongPredicate p) {
                    super(s, noSplitting, p);
                }

                Taking(Spliterator.OfLong s, OfLong parent) {
                    super(s, parent);
                }

                @Override // j$.util.stream.WhileOps.UnorderedWhileSpliterator.OfLong, j$.util.Spliterator.OfPrimitive
                public boolean tryAdvance(LongConsumer action) {
                    boolean test = true;
                    if (this.takeOrDrop && checkCancelOnCount() && ((Spliterator.OfLong) this.s).tryAdvance((LongConsumer) this)) {
                        boolean test2 = this.p.test(this.t);
                        test = test2;
                        if (test2) {
                            action.accept(this.t);
                            return true;
                        }
                    }
                    this.takeOrDrop = false;
                    if (!test) {
                        this.cancel.set(true);
                    }
                    return false;
                }

                @Override // j$.util.stream.WhileOps.UnorderedWhileSpliterator, j$.util.Spliterator
                public Spliterator.OfLong trySplit() {
                    if (this.cancel.get()) {
                        return null;
                    }
                    return (Spliterator.OfLong) super.trySplit();
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                @Override // j$.util.stream.WhileOps.UnorderedWhileSpliterator
                public Spliterator.OfLong makeSpliterator(Spliterator.OfLong s) {
                    return new Taking(s, this);
                }
            }

            /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
            static final class Dropping extends OfLong {
                @Override // j$.util.stream.WhileOps.UnorderedWhileSpliterator.OfLong, j$.util.stream.WhileOps.UnorderedWhileSpliterator, j$.util.Spliterator
                public /* bridge */ /* synthetic */ Spliterator.OfLong trySplit() {
                    return (Spliterator.OfLong) super.trySplit();
                }

                @Override // j$.util.stream.WhileOps.UnorderedWhileSpliterator.OfLong, j$.util.stream.WhileOps.UnorderedWhileSpliterator, j$.util.Spliterator
                public /* bridge */ /* synthetic */ Spliterator.OfPrimitive trySplit() {
                    return (Spliterator.OfPrimitive) super.trySplit();
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                public Dropping(Spliterator.OfLong s, boolean noSplitting, LongPredicate p) {
                    super(s, noSplitting, p);
                }

                Dropping(Spliterator.OfLong s, OfLong parent) {
                    super(s, parent);
                }

                /* JADX WARN: Code restructure failed: missing block: B:13:0x0027, code lost:
                    if (r0 == false) goto L15;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:14:0x0029, code lost:
                    r5.cancel.set(true);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:15:0x002f, code lost:
                    r6.accept(r5.t);
                 */
                @Override // j$.util.stream.WhileOps.UnorderedWhileSpliterator.OfLong, j$.util.Spliterator.OfPrimitive
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public boolean tryAdvance(LongConsumer action) {
                    boolean adv;
                    if (this.takeOrDrop) {
                        this.takeOrDrop = false;
                        boolean dropped = false;
                        while (true) {
                            adv = ((Spliterator.OfLong) this.s).tryAdvance((LongConsumer) this);
                            if (!adv || !checkCancelOnCount() || !this.p.test(this.t)) {
                                break;
                            }
                            dropped = true;
                        }
                        return adv;
                    }
                    return ((Spliterator.OfLong) this.s).tryAdvance(action);
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                @Override // j$.util.stream.WhileOps.UnorderedWhileSpliterator
                public Spliterator.OfLong makeSpliterator(Spliterator.OfLong s) {
                    return new Dropping(s, this);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
        public static abstract class OfDouble extends UnorderedWhileSpliterator<Double, Spliterator.OfDouble> implements DoubleConsumer, Spliterator.OfDouble {
            final DoublePredicate p;
            double t;

            @Override // java.util.function.DoubleConsumer
            public /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
                return DoubleConsumer$CC.$default$andThen(this, doubleConsumer);
            }

            @Override // j$.util.Spliterator.OfPrimitive
            public /* bridge */ /* synthetic */ void forEachRemaining(DoubleConsumer doubleConsumer) {
                forEachRemaining((DoubleConsumer) doubleConsumer);
            }

            @Override // j$.util.stream.WhileOps.UnorderedWhileSpliterator, j$.util.Spliterator
            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                Spliterator.OfDouble.CC.$default$forEachRemaining((Spliterator.OfDouble) this, consumer);
            }

            @Override // j$.util.Spliterator.OfDouble
            /* renamed from: forEachRemaining  reason: avoid collision after fix types in other method */
            public /* synthetic */ void forEachRemaining2(DoubleConsumer doubleConsumer) {
                Spliterator.OfDouble.CC.$default$forEachRemaining((Spliterator.OfDouble) this, doubleConsumer);
            }

            @Override // j$.util.Spliterator.OfPrimitive
            public /* bridge */ /* synthetic */ boolean tryAdvance(DoubleConsumer doubleConsumer) {
                boolean tryAdvance;
                tryAdvance = tryAdvance((DoubleConsumer) doubleConsumer);
                return tryAdvance;
            }

            @Override // j$.util.Spliterator
            public /* synthetic */ boolean tryAdvance(Consumer consumer) {
                return Spliterator.OfDouble.CC.$default$tryAdvance((Spliterator.OfDouble) this, consumer);
            }

            @Override // j$.util.stream.WhileOps.UnorderedWhileSpliterator, j$.util.Spliterator
            public /* bridge */ /* synthetic */ Spliterator.OfDouble trySplit() {
                return (Spliterator.OfDouble) super.trySplit();
            }

            @Override // j$.util.stream.WhileOps.UnorderedWhileSpliterator, j$.util.Spliterator
            public /* bridge */ /* synthetic */ Spliterator.OfPrimitive trySplit() {
                return (Spliterator.OfPrimitive) super.trySplit();
            }

            OfDouble(Spliterator.OfDouble s, boolean noSplitting, DoublePredicate p) {
                super(s, noSplitting);
                this.p = p;
            }

            OfDouble(Spliterator.OfDouble s, OfDouble parent) {
                super(s, parent);
                this.p = parent.p;
            }

            @Override // java.util.function.DoubleConsumer
            public void accept(double t) {
                this.count = (this.count + 1) & UnorderedWhileSpliterator.CANCEL_CHECK_COUNT;
                this.t = t;
            }

            /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
            static final class Taking extends OfDouble {
                /* JADX INFO: Access modifiers changed from: package-private */
                public Taking(Spliterator.OfDouble s, boolean noSplitting, DoublePredicate p) {
                    super(s, noSplitting, p);
                }

                Taking(Spliterator.OfDouble s, OfDouble parent) {
                    super(s, parent);
                }

                @Override // j$.util.stream.WhileOps.UnorderedWhileSpliterator.OfDouble, j$.util.Spliterator.OfPrimitive
                public boolean tryAdvance(DoubleConsumer action) {
                    boolean test = true;
                    if (this.takeOrDrop && checkCancelOnCount() && ((Spliterator.OfDouble) this.s).tryAdvance((DoubleConsumer) this)) {
                        boolean test2 = this.p.test(this.t);
                        test = test2;
                        if (test2) {
                            action.accept(this.t);
                            return true;
                        }
                    }
                    this.takeOrDrop = false;
                    if (!test) {
                        this.cancel.set(true);
                    }
                    return false;
                }

                @Override // j$.util.stream.WhileOps.UnorderedWhileSpliterator, j$.util.Spliterator
                public Spliterator.OfDouble trySplit() {
                    if (this.cancel.get()) {
                        return null;
                    }
                    return (Spliterator.OfDouble) super.trySplit();
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                @Override // j$.util.stream.WhileOps.UnorderedWhileSpliterator
                public Spliterator.OfDouble makeSpliterator(Spliterator.OfDouble s) {
                    return new Taking(s, this);
                }
            }

            /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
            static final class Dropping extends OfDouble {
                @Override // j$.util.stream.WhileOps.UnorderedWhileSpliterator.OfDouble, j$.util.stream.WhileOps.UnorderedWhileSpliterator, j$.util.Spliterator
                public /* bridge */ /* synthetic */ Spliterator.OfDouble trySplit() {
                    return (Spliterator.OfDouble) super.trySplit();
                }

                @Override // j$.util.stream.WhileOps.UnorderedWhileSpliterator.OfDouble, j$.util.stream.WhileOps.UnorderedWhileSpliterator, j$.util.Spliterator
                public /* bridge */ /* synthetic */ Spliterator.OfPrimitive trySplit() {
                    return (Spliterator.OfPrimitive) super.trySplit();
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                public Dropping(Spliterator.OfDouble s, boolean noSplitting, DoublePredicate p) {
                    super(s, noSplitting, p);
                }

                Dropping(Spliterator.OfDouble s, OfDouble parent) {
                    super(s, parent);
                }

                /* JADX WARN: Code restructure failed: missing block: B:13:0x0027, code lost:
                    if (r0 == false) goto L15;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:14:0x0029, code lost:
                    r5.cancel.set(true);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:15:0x002f, code lost:
                    r6.accept(r5.t);
                 */
                @Override // j$.util.stream.WhileOps.UnorderedWhileSpliterator.OfDouble, j$.util.Spliterator.OfPrimitive
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public boolean tryAdvance(DoubleConsumer action) {
                    boolean adv;
                    if (this.takeOrDrop) {
                        this.takeOrDrop = false;
                        boolean dropped = false;
                        while (true) {
                            adv = ((Spliterator.OfDouble) this.s).tryAdvance((DoubleConsumer) this);
                            if (!adv || !checkCancelOnCount() || !this.p.test(this.t)) {
                                break;
                            }
                            dropped = true;
                        }
                        return adv;
                    }
                    return ((Spliterator.OfDouble) this.s).tryAdvance(action);
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                @Override // j$.util.stream.WhileOps.UnorderedWhileSpliterator
                public Spliterator.OfDouble makeSpliterator(Spliterator.OfDouble s) {
                    return new Dropping(s, this);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public static final class TakeWhileTask<P_IN, P_OUT> extends AbstractShortCircuitTask<P_IN, P_OUT, Node<P_OUT>, TakeWhileTask<P_IN, P_OUT>> {
        private volatile boolean completed;
        private final IntFunction<P_OUT[]> generator;
        private final boolean isOrdered;
        private final AbstractPipeline<P_OUT, P_OUT, ?> op;
        private boolean shortCircuited;
        private long thisNodeSize;

        /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<P_IN> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.AbstractPipeline != java.util.stream.AbstractPipeline<P_OUT, P_OUT, ?> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.PipelineHelper != java.util.stream.PipelineHelper<P_OUT> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.WhileOps$TakeWhileTask != java.util.stream.WhileOps$TakeWhileTask<P_IN, P_OUT> */
        TakeWhileTask(AbstractPipeline<P_OUT, P_OUT, ?> abstractPipeline, PipelineHelper<P_OUT> pipelineHelper, Spliterator<P_IN> spliterator, IntFunction<P_OUT[]> generator) {
            super(pipelineHelper, spliterator);
            this.op = abstractPipeline;
            this.generator = generator;
            this.isOrdered = StreamOpFlag.ORDERED.isKnown(pipelineHelper.getStreamAndOpFlags());
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<P_IN> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.WhileOps$TakeWhileTask != java.util.stream.WhileOps$TakeWhileTask<P_IN, P_OUT> */
        TakeWhileTask(TakeWhileTask<P_IN, P_OUT> takeWhileTask, Spliterator<P_IN> spliterator) {
            super(takeWhileTask, spliterator);
            this.op = takeWhileTask.op;
            this.generator = takeWhileTask.generator;
            this.isOrdered = takeWhileTask.isOrdered;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<P_IN> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.WhileOps$TakeWhileTask != java.util.stream.WhileOps$TakeWhileTask<P_IN, P_OUT> */
        @Override // j$.util.stream.AbstractTask
        public TakeWhileTask<P_IN, P_OUT> makeChild(Spliterator<P_IN> spliterator) {
            return new TakeWhileTask<>(this, spliterator);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.WhileOps$TakeWhileTask != java.util.stream.WhileOps$TakeWhileTask<P_IN, P_OUT> */
        @Override // j$.util.stream.AbstractShortCircuitTask
        public final Node<P_OUT> getEmptyResult() {
            return Nodes.emptyNode(this.op.getOutputShape());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Node != java.util.stream.Node<P_OUT> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Node$Builder != java.util.stream.Node$Builder<P_OUT> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Sink != java.util.stream.Sink<P_OUT> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.WhileOps$TakeWhileTask != java.util.stream.WhileOps$TakeWhileTask<P_IN, P_OUT> */
        @Override // j$.util.stream.AbstractTask
        public final Node<P_OUT> doLeaf() {
            Node.Builder<P_OUT> makeNodeBuilder = this.helper.makeNodeBuilder(-1L, this.generator);
            boolean copyIntoWithCancel = this.helper.copyIntoWithCancel(this.helper.wrapSink(this.op.opWrapSink(this.helper.getStreamAndOpFlags(), makeNodeBuilder)), this.spliterator);
            this.shortCircuited = copyIntoWithCancel;
            if (copyIntoWithCancel) {
                cancelLaterNodes();
            }
            Node<P_OUT> build = makeNodeBuilder.build();
            this.thisNodeSize = build.count();
            return build;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Node != java.util.stream.Node<P_OUT> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.WhileOps$TakeWhileTask != java.util.stream.WhileOps$TakeWhileTask<P_IN, P_OUT> */
        @Override // j$.util.stream.AbstractTask, java.util.concurrent.CountedCompleter
        public final void onCompletion(CountedCompleter<?> caller) {
            Node<P_OUT> merge;
            if (!isLeaf()) {
                this.shortCircuited = ((TakeWhileTask) this.leftChild).shortCircuited | ((TakeWhileTask) this.rightChild).shortCircuited;
                if (this.isOrdered && this.canceled) {
                    this.thisNodeSize = 0L;
                    merge = getEmptyResult();
                } else if (this.isOrdered && ((TakeWhileTask) this.leftChild).shortCircuited) {
                    this.thisNodeSize = ((TakeWhileTask) this.leftChild).thisNodeSize;
                    merge = ((TakeWhileTask) this.leftChild).getLocalResult();
                } else {
                    this.thisNodeSize = ((TakeWhileTask) this.leftChild).thisNodeSize + ((TakeWhileTask) this.rightChild).thisNodeSize;
                    merge = merge();
                }
                setLocalResult(merge);
            }
            this.completed = true;
            super.onCompletion(caller);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.WhileOps$TakeWhileTask != java.util.stream.WhileOps$TakeWhileTask<P_IN, P_OUT> */
        Node<P_OUT> merge() {
            if (((TakeWhileTask) this.leftChild).thisNodeSize == 0) {
                return ((TakeWhileTask) this.rightChild).getLocalResult();
            }
            if (((TakeWhileTask) this.rightChild).thisNodeSize == 0) {
                return ((TakeWhileTask) this.leftChild).getLocalResult();
            }
            return Nodes.conc(this.op.getOutputShape(), ((TakeWhileTask) this.leftChild).getLocalResult(), ((TakeWhileTask) this.rightChild).getLocalResult());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.WhileOps$TakeWhileTask != java.util.stream.WhileOps$TakeWhileTask<P_IN, P_OUT> */
        @Override // j$.util.stream.AbstractShortCircuitTask
        public void cancel() {
            super.cancel();
            if (this.isOrdered && this.completed) {
                setLocalResult(getEmptyResult());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public static final class DropWhileTask<P_IN, P_OUT> extends AbstractTask<P_IN, P_OUT, Node<P_OUT>, DropWhileTask<P_IN, P_OUT>> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final IntFunction<P_OUT[]> generator;
        private long index;
        private final boolean isOrdered;
        private final AbstractPipeline<P_OUT, P_OUT, ?> op;
        private long thisNodeSize;

        /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<P_IN> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.AbstractPipeline != java.util.stream.AbstractPipeline<P_OUT, P_OUT, ?> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.PipelineHelper != java.util.stream.PipelineHelper<P_OUT> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.WhileOps$DropWhileTask != java.util.stream.WhileOps$DropWhileTask<P_IN, P_OUT> */
        DropWhileTask(AbstractPipeline<P_OUT, P_OUT, ?> abstractPipeline, PipelineHelper<P_OUT> pipelineHelper, Spliterator<P_IN> spliterator, IntFunction<P_OUT[]> generator) {
            super(pipelineHelper, spliterator);
            this.op = abstractPipeline;
            this.generator = generator;
            this.isOrdered = StreamOpFlag.ORDERED.isKnown(pipelineHelper.getStreamAndOpFlags());
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<P_IN> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.WhileOps$DropWhileTask != java.util.stream.WhileOps$DropWhileTask<P_IN, P_OUT> */
        DropWhileTask(DropWhileTask<P_IN, P_OUT> dropWhileTask, Spliterator<P_IN> spliterator) {
            super(dropWhileTask, spliterator);
            this.op = dropWhileTask.op;
            this.generator = dropWhileTask.generator;
            this.isOrdered = dropWhileTask.isOrdered;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<P_IN> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.WhileOps$DropWhileTask != java.util.stream.WhileOps$DropWhileTask<P_IN, P_OUT> */
        @Override // j$.util.stream.AbstractTask
        public DropWhileTask<P_IN, P_OUT> makeChild(Spliterator<P_IN> spliterator) {
            return new DropWhileTask<>(this, spliterator);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Node != java.util.stream.Node<P_OUT> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Node$Builder != java.util.stream.Node$Builder<P_OUT> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.WhileOps$DropWhileOp != java.util.stream.WhileOps$DropWhileOp<P_OUT> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.WhileOps$DropWhileSink != java.util.stream.WhileOps$DropWhileSink<P_OUT> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.WhileOps$DropWhileTask != java.util.stream.WhileOps$DropWhileTask<P_IN, P_OUT> */
        @Override // j$.util.stream.AbstractTask
        public final Node<P_OUT> doLeaf() {
            long sizeIfKnown;
            boolean z = true;
            boolean isChild = !isRoot();
            if (isChild && this.isOrdered && StreamOpFlag.SIZED.isPreserved(this.op.sourceOrOpFlags)) {
                sizeIfKnown = this.op.exactOutputSizeIfKnown(this.spliterator);
            } else {
                sizeIfKnown = -1;
            }
            Node.Builder<P_OUT> makeNodeBuilder = this.helper.makeNodeBuilder(sizeIfKnown, this.generator);
            DropWhileSink opWrapSink = ((DropWhileOp) this.op).opWrapSink(makeNodeBuilder, (this.isOrdered && isChild) ? false : false);
            this.helper.wrapAndCopyInto(opWrapSink, this.spliterator);
            Node<P_OUT> build = makeNodeBuilder.build();
            this.thisNodeSize = build.count();
            this.index = opWrapSink.getDropCount();
            return build;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Node != java.util.stream.Node<P_OUT> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.WhileOps$DropWhileTask != java.util.stream.WhileOps$DropWhileTask<P_IN, P_OUT> */
        @Override // j$.util.stream.AbstractTask, java.util.concurrent.CountedCompleter
        public final void onCompletion(CountedCompleter<?> caller) {
            if (!isLeaf()) {
                if (this.isOrdered) {
                    this.index = ((DropWhileTask) this.leftChild).index;
                    if (this.index == ((DropWhileTask) this.leftChild).thisNodeSize) {
                        this.index += ((DropWhileTask) this.rightChild).index;
                    }
                }
                this.thisNodeSize = ((DropWhileTask) this.leftChild).thisNodeSize + ((DropWhileTask) this.rightChild).thisNodeSize;
                Node<P_OUT> merge = merge();
                setLocalResult(isRoot() ? doTruncate(merge) : merge);
            }
            super.onCompletion(caller);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.WhileOps$DropWhileTask != java.util.stream.WhileOps$DropWhileTask<P_IN, P_OUT> */
        private Node<P_OUT> merge() {
            if (((DropWhileTask) this.leftChild).thisNodeSize == 0) {
                return ((DropWhileTask) this.rightChild).getLocalResult();
            }
            if (((DropWhileTask) this.rightChild).thisNodeSize == 0) {
                return ((DropWhileTask) this.leftChild).getLocalResult();
            }
            return Nodes.conc(this.op.getOutputShape(), ((DropWhileTask) this.leftChild).getLocalResult(), ((DropWhileTask) this.rightChild).getLocalResult());
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Node != java.util.stream.Node<P_OUT> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.WhileOps$DropWhileTask != java.util.stream.WhileOps$DropWhileTask<P_IN, P_OUT> */
        private Node<P_OUT> doTruncate(Node<P_OUT> node) {
            if (this.isOrdered) {
                return node.truncate(this.index, node.count(), this.generator);
            }
            return node;
        }
    }
}