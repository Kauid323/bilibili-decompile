package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import j$.util.concurrent.ConcurrentHashMap;
import j$.util.function.Consumer$CC;
import j$.util.function.DoubleConsumer$CC;
import j$.util.function.IntConsumer$CC;
import j$.util.function.LongConsumer$CC;
import j$.util.stream.ForEachOps;
import j$.util.stream.Node;
import j$.util.stream.Sink;
import java.util.concurrent.CountedCompleter;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.LongConsumer;

final class ForEachOps {
    private ForEachOps() {
    }

    public static <T> TerminalOp<T, Void> makeRef(Consumer<? super T> action, boolean ordered) {
        Objects.requireNonNull(action);
        return new ForEachOp.OfRef(action, ordered);
    }

    public static TerminalOp<Integer, Void> makeInt(IntConsumer action, boolean ordered) {
        Objects.requireNonNull(action);
        return new ForEachOp.OfInt(action, ordered);
    }

    public static TerminalOp<Long, Void> makeLong(LongConsumer action, boolean ordered) {
        Objects.requireNonNull(action);
        return new ForEachOp.OfLong(action, ordered);
    }

    public static TerminalOp<Double, Void> makeDouble(DoubleConsumer action, boolean ordered) {
        Objects.requireNonNull(action);
        return new ForEachOp.OfDouble(action, ordered);
    }

    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    static abstract class ForEachOp<T> implements TerminalOp<T, Void>, TerminalSink<T, Void> {
        private final boolean ordered;

        @Override // j$.util.stream.Sink, java.util.function.DoubleConsumer
        public /* synthetic */ void accept(double d) {
            Sink.CC.$default$accept(this, d);
        }

        @Override // j$.util.stream.Sink
        public /* synthetic */ void accept(int i) {
            Sink.CC.$default$accept((Sink) this, i);
        }

        @Override // j$.util.stream.Sink
        public /* synthetic */ void accept(long j) {
            Sink.CC.$default$accept((Sink) this, j);
        }

        @Override // java.util.function.Consumer
        public /* synthetic */ Consumer andThen(Consumer consumer) {
            return Consumer$CC.$default$andThen(this, consumer);
        }

        @Override // j$.util.stream.Sink
        public /* synthetic */ void begin(long j) {
            Sink.CC.$default$begin(this, j);
        }

        @Override // j$.util.stream.Sink
        public /* synthetic */ boolean cancellationRequested() {
            return Sink.CC.$default$cancellationRequested(this);
        }

        @Override // j$.util.stream.Sink
        public /* synthetic */ void end() {
            Sink.CC.$default$end(this);
        }

        @Override // j$.util.stream.TerminalOp
        public /* synthetic */ StreamShape inputShape() {
            StreamShape streamShape;
            streamShape = StreamShape.REFERENCE;
            return streamShape;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ForEachOps$ForEachOp != java.util.stream.ForEachOps$ForEachOp<T> */
        protected ForEachOp(boolean ordered) {
            this.ordered = ordered;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ForEachOps$ForEachOp != java.util.stream.ForEachOps$ForEachOp<T> */
        @Override // j$.util.stream.TerminalOp
        public int getOpFlags() {
            if (this.ordered) {
                return 0;
            }
            return StreamOpFlag.NOT_ORDERED;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<S> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ForEachOps$ForEachOp != java.util.stream.ForEachOps$ForEachOp<T> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.PipelineHelper != java.util.stream.PipelineHelper<T> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // j$.util.stream.TerminalOp
        public <S> Void evaluateSequential(PipelineHelper<T> pipelineHelper, Spliterator<S> spliterator) {
            return ((ForEachOp) pipelineHelper.wrapAndCopyInto(this, spliterator)).get();
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<S> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ForEachOps$ForEachOp != java.util.stream.ForEachOps$ForEachOp<T> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.PipelineHelper != java.util.stream.PipelineHelper<T> */
        @Override // j$.util.stream.TerminalOp
        public <S> Void evaluateParallel(PipelineHelper<T> pipelineHelper, Spliterator<S> spliterator) {
            if (this.ordered) {
                new ForEachOrderedTask(pipelineHelper, spliterator, this).invoke();
                return null;
            }
            new ForEachTask(pipelineHelper, spliterator, pipelineHelper.wrapSink(this)).invoke();
            return null;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ForEachOps$ForEachOp != java.util.stream.ForEachOps$ForEachOp<T> */
        @Override // java.util.function.Supplier
        public Void get() {
            return null;
        }

        /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
        static final class OfRef<T> extends ForEachOp<T> {
            final Consumer<? super T> consumer;

            /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ForEachOps$ForEachOp$OfRef != java.util.stream.ForEachOps$ForEachOp$OfRef<T> */
            OfRef(Consumer<? super T> consumer, boolean ordered) {
                super(ordered);
                this.consumer = consumer;
            }

            /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ForEachOps$ForEachOp$OfRef != java.util.stream.ForEachOps$ForEachOp$OfRef<T> */
            @Override // java.util.function.Consumer
            public void accept(T t) {
                this.consumer.accept(t);
            }
        }

        /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
        static final class OfInt extends ForEachOp<Integer> implements Sink.OfInt {
            final IntConsumer consumer;

            @Override // j$.util.stream.Sink.OfInt
            public /* synthetic */ void accept(Integer num) {
                Sink.OfInt.CC.$default$accept((Sink.OfInt) this, num);
            }

            @Override // java.util.function.Consumer
            public /* bridge */ /* synthetic */ void accept(Object obj) {
                Sink.OfInt.CC.$default$accept(this, obj);
            }

            @Override // java.util.function.IntConsumer
            public /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
                return IntConsumer$CC.$default$andThen(this, intConsumer);
            }

            OfInt(IntConsumer consumer, boolean ordered) {
                super(ordered);
                this.consumer = consumer;
            }

            @Override // j$.util.stream.ForEachOps.ForEachOp, j$.util.stream.TerminalOp
            public StreamShape inputShape() {
                return StreamShape.INT_VALUE;
            }

            @Override // j$.util.stream.ForEachOps.ForEachOp, j$.util.stream.Sink
            public void accept(int t) {
                this.consumer.accept(t);
            }
        }

        /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
        static final class OfLong extends ForEachOp<Long> implements Sink.OfLong {
            final LongConsumer consumer;

            @Override // j$.util.stream.Sink.OfLong
            public /* synthetic */ void accept(Long l) {
                Sink.OfLong.CC.$default$accept((Sink.OfLong) this, l);
            }

            @Override // java.util.function.Consumer
            public /* bridge */ /* synthetic */ void accept(Object obj) {
                Sink.OfLong.CC.$default$accept(this, obj);
            }

            @Override // java.util.function.LongConsumer
            public /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
                return LongConsumer$CC.$default$andThen(this, longConsumer);
            }

            OfLong(LongConsumer consumer, boolean ordered) {
                super(ordered);
                this.consumer = consumer;
            }

            @Override // j$.util.stream.ForEachOps.ForEachOp, j$.util.stream.TerminalOp
            public StreamShape inputShape() {
                return StreamShape.LONG_VALUE;
            }

            @Override // j$.util.stream.ForEachOps.ForEachOp, j$.util.stream.Sink
            public void accept(long t) {
                this.consumer.accept(t);
            }
        }

        /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
        static final class OfDouble extends ForEachOp<Double> implements Sink.OfDouble {
            final DoubleConsumer consumer;

            @Override // j$.util.stream.Sink.OfDouble
            public /* synthetic */ void accept(Double d) {
                Sink.OfDouble.CC.$default$accept((Sink.OfDouble) this, d);
            }

            @Override // java.util.function.Consumer
            public /* bridge */ /* synthetic */ void accept(Object obj) {
                Sink.OfDouble.CC.$default$accept(this, obj);
            }

            @Override // java.util.function.DoubleConsumer
            public /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
                return DoubleConsumer$CC.$default$andThen(this, doubleConsumer);
            }

            OfDouble(DoubleConsumer consumer, boolean ordered) {
                super(ordered);
                this.consumer = consumer;
            }

            @Override // j$.util.stream.ForEachOps.ForEachOp, j$.util.stream.TerminalOp
            public StreamShape inputShape() {
                return StreamShape.DOUBLE_VALUE;
            }

            @Override // j$.util.stream.ForEachOps.ForEachOp, j$.util.stream.Sink, java.util.function.DoubleConsumer
            public void accept(double t) {
                this.consumer.accept(t);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public static final class ForEachTask<S, T> extends CountedCompleter<Void> {
        private final PipelineHelper<T> helper;
        private final Sink<S> sink;
        private Spliterator<S> spliterator;
        private long targetSize;

        /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<S> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ForEachOps$ForEachTask != java.util.stream.ForEachOps$ForEachTask<S, T> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.PipelineHelper != java.util.stream.PipelineHelper<T> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Sink != java.util.stream.Sink<S> */
        ForEachTask(PipelineHelper<T> pipelineHelper, Spliterator<S> spliterator, Sink<S> sink) {
            super(null);
            this.sink = sink;
            this.helper = pipelineHelper;
            this.spliterator = spliterator;
            this.targetSize = 0L;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<S> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ForEachOps$ForEachTask != java.util.stream.ForEachOps$ForEachTask<S, T> */
        ForEachTask(ForEachTask<S, T> forEachTask, Spliterator<S> spliterator) {
            super(forEachTask);
            this.spliterator = spliterator;
            this.sink = forEachTask.sink;
            this.targetSize = forEachTask.targetSize;
            this.helper = forEachTask.helper;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<S> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ForEachOps$ForEachTask != java.util.stream.ForEachOps$ForEachTask<S, T> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Sink != java.util.stream.Sink<S> */
        @Override // java.util.concurrent.CountedCompleter
        public void compute() {
            Spliterator<S> trySplit;
            ForEachTask<S, T> forEachTask;
            Spliterator<S> spliterator = this.spliterator;
            long sizeEstimate = spliterator.estimateSize();
            long j = this.targetSize;
            long sizeThreshold = j;
            if (j == 0) {
                long suggestTargetSize = AbstractTask.suggestTargetSize(sizeEstimate);
                sizeThreshold = suggestTargetSize;
                this.targetSize = suggestTargetSize;
            }
            boolean isShortCircuit = StreamOpFlag.SHORT_CIRCUIT.isKnown(this.helper.getStreamAndOpFlags());
            boolean forkRight = false;
            Sink<S> sink = this.sink;
            ForEachTask<S, T> forEachTask2 = this;
            while (true) {
                if (isShortCircuit && sink.cancellationRequested()) {
                    break;
                } else if (sizeEstimate <= sizeThreshold || (trySplit = spliterator.trySplit()) == null) {
                    break;
                } else {
                    ForEachTask<S, T> forEachTask3 = new ForEachTask<>(forEachTask2, trySplit);
                    forEachTask2.addToPendingCount(1);
                    if (forkRight) {
                        forkRight = false;
                        spliterator = trySplit;
                        forEachTask = forEachTask2;
                        forEachTask2 = forEachTask3;
                    } else {
                        forkRight = true;
                        forEachTask = forEachTask3;
                    }
                    forEachTask.fork();
                    sizeEstimate = spliterator.estimateSize();
                }
            }
            forEachTask2.helper.copyInto(sink, spliterator);
            forEachTask2.spliterator = null;
            forEachTask2.propagateCompletion();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public static final class ForEachOrderedTask<S, T> extends CountedCompleter<Void> {
        private final Sink<T> action;
        private final ConcurrentHashMap<ForEachOrderedTask<S, T>, ForEachOrderedTask<S, T>> completionMap;
        private final PipelineHelper<T> helper;
        private final ForEachOrderedTask<S, T> leftPredecessor;
        private Node<T> node;
        private Spliterator<S> spliterator;
        private final long targetSize;

        /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<S> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ForEachOps$ForEachOrderedTask != java.util.stream.ForEachOps$ForEachOrderedTask<S, T> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.PipelineHelper != java.util.stream.PipelineHelper<T> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Sink != java.util.stream.Sink<T> */
        protected ForEachOrderedTask(PipelineHelper<T> pipelineHelper, Spliterator<S> spliterator, Sink<T> sink) {
            super(null);
            this.helper = pipelineHelper;
            this.spliterator = spliterator;
            this.targetSize = AbstractTask.suggestTargetSize(spliterator.estimateSize());
            this.completionMap = new ConcurrentHashMap<>(Math.max(16, AbstractTask.getLeafTarget() << 1));
            this.action = sink;
            this.leftPredecessor = null;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<S> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ForEachOps$ForEachOrderedTask != java.util.stream.ForEachOps$ForEachOrderedTask<S, T> */
        ForEachOrderedTask(ForEachOrderedTask<S, T> forEachOrderedTask, Spliterator<S> spliterator, ForEachOrderedTask<S, T> forEachOrderedTask2) {
            super(forEachOrderedTask);
            this.helper = forEachOrderedTask.helper;
            this.spliterator = spliterator;
            this.targetSize = forEachOrderedTask.targetSize;
            this.completionMap = forEachOrderedTask.completionMap;
            this.action = forEachOrderedTask.action;
            this.leftPredecessor = forEachOrderedTask2;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ForEachOps$ForEachOrderedTask != java.util.stream.ForEachOps$ForEachOrderedTask<S, T> */
        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            doCompute(this);
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<S> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ForEachOps$ForEachOrderedTask != java.util.stream.ForEachOps$ForEachOrderedTask<S, T> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Node$Builder != java.util.stream.Node$Builder<T> */
        private static <S, T> void doCompute(ForEachOrderedTask<S, T> forEachOrderedTask) {
            Spliterator<S> trySplit;
            ForEachOrderedTask<S, T> forEachOrderedTask2;
            Spliterator<S> spliterator = ((ForEachOrderedTask) forEachOrderedTask).spliterator;
            long sizeThreshold = ((ForEachOrderedTask) forEachOrderedTask).targetSize;
            boolean forkRight = false;
            while (spliterator.estimateSize() > sizeThreshold && (trySplit = spliterator.trySplit()) != null) {
                ForEachOrderedTask<S, T> forEachOrderedTask3 = new ForEachOrderedTask<>(forEachOrderedTask, trySplit, ((ForEachOrderedTask) forEachOrderedTask).leftPredecessor);
                ForEachOrderedTask<S, T> forEachOrderedTask4 = new ForEachOrderedTask<>(forEachOrderedTask, spliterator, forEachOrderedTask3);
                forEachOrderedTask.addToPendingCount(1);
                forEachOrderedTask4.addToPendingCount(1);
                ((ForEachOrderedTask) forEachOrderedTask).completionMap.put(forEachOrderedTask3, forEachOrderedTask4);
                if (((ForEachOrderedTask) forEachOrderedTask).leftPredecessor != null) {
                    forEachOrderedTask3.addToPendingCount(1);
                    if (((ForEachOrderedTask) forEachOrderedTask).completionMap.replace(((ForEachOrderedTask) forEachOrderedTask).leftPredecessor, forEachOrderedTask, forEachOrderedTask3)) {
                        forEachOrderedTask.addToPendingCount(-1);
                    } else {
                        forEachOrderedTask3.addToPendingCount(-1);
                    }
                }
                if (forkRight) {
                    forkRight = false;
                    spliterator = trySplit;
                    forEachOrderedTask = forEachOrderedTask3;
                    forEachOrderedTask2 = forEachOrderedTask4;
                } else {
                    forkRight = true;
                    forEachOrderedTask = forEachOrderedTask4;
                    forEachOrderedTask2 = forEachOrderedTask3;
                }
                forEachOrderedTask2.fork();
            }
            if (forEachOrderedTask.getPendingCount() > 0) {
                IntFunction<T[]> generator = new IntFunction() { // from class: j$.util.stream.ForEachOps$ForEachOrderedTask$$ExternalSyntheticLambda0
                    @Override // java.util.function.IntFunction
                    public final Object apply(int i) {
                        return ForEachOps.ForEachOrderedTask.lambda$doCompute$0(i);
                    }
                };
                ((ForEachOrderedTask) forEachOrderedTask).node = ((Node.Builder) ((ForEachOrderedTask) forEachOrderedTask).helper.wrapAndCopyInto(((ForEachOrderedTask) forEachOrderedTask).helper.makeNodeBuilder(((ForEachOrderedTask) forEachOrderedTask).helper.exactOutputSizeIfKnown(spliterator), generator), spliterator)).build();
                ((ForEachOrderedTask) forEachOrderedTask).spliterator = null;
            }
            forEachOrderedTask.tryComplete();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ Object[] lambda$doCompute$0(int size) {
            return new Object[size];
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.ForEachOps$ForEachOrderedTask != java.util.stream.ForEachOps$ForEachOrderedTask<S, T> */
        @Override // java.util.concurrent.CountedCompleter
        public void onCompletion(CountedCompleter<?> caller) {
            if (this.node != null) {
                this.node.forEach(this.action);
                this.node = null;
            } else if (this.spliterator != null) {
                this.helper.wrapAndCopyInto(this.action, (Spliterator<S>) this.spliterator);
                this.spliterator = null;
            }
            ForEachOrderedTask<S, T> remove = this.completionMap.remove(this);
            if (remove != null) {
                remove.tryComplete();
            }
        }
    }
}