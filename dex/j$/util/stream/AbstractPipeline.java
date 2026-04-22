package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import j$.util.stream.BaseStream;
import j$.util.stream.Node;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Supplier;

/* JADX INFO: Access modifiers changed from: package-private */
public abstract class AbstractPipeline<E_IN, E_OUT, S extends BaseStream<E_OUT, S>> extends PipelineHelper<E_OUT> implements BaseStream<E_OUT, S> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String MSG_CONSUMED = "source already consumed or closed";
    private static final String MSG_STREAM_LINKED = "stream has already been operated upon or closed";
    private int combinedFlags;
    private int depth;
    private boolean linkedOrConsumed;
    private AbstractPipeline nextStage;
    private boolean parallel;
    private final AbstractPipeline previousStage;
    private boolean sourceAnyStateful;
    private Runnable sourceCloseAction;
    protected final int sourceOrOpFlags;
    private Spliterator<?> sourceSpliterator;
    private final AbstractPipeline sourceStage;
    private Supplier<? extends Spliterator<?>> sourceSupplier;

    abstract <P_IN> Node<E_OUT> evaluateToNode(PipelineHelper<E_OUT> pipelineHelper, Spliterator<P_IN> spliterator, boolean z, IntFunction<E_OUT[]> intFunction);

    abstract boolean forEachWithCancel(Spliterator<E_OUT> spliterator, Sink<E_OUT> sink);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract StreamShape getOutputShape();

    abstract Spliterator<E_OUT> lazySpliterator(Supplier<? extends Spliterator<E_OUT>> supplier);

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // j$.util.stream.PipelineHelper
    public abstract Node.Builder<E_OUT> makeNodeBuilder(long j, IntFunction<E_OUT[]> intFunction);

    abstract boolean opIsStateful();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Sink<E_IN> opWrapSink(int i, Sink<E_OUT> sink);

    abstract <P_IN> Spliterator<E_OUT> wrap(PipelineHelper<E_OUT> pipelineHelper, Supplier<Spliterator<P_IN>> supplier, boolean z);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.AbstractPipeline != java.util.stream.AbstractPipeline<E_IN, E_OUT, S extends j$.util.stream.BaseStream<E_OUT, S>> */
    public AbstractPipeline(Supplier<? extends Spliterator<?>> supplier, int sourceFlags, boolean parallel) {
        this.previousStage = null;
        this.sourceSupplier = supplier;
        this.sourceStage = this;
        this.sourceOrOpFlags = StreamOpFlag.STREAM_MASK & sourceFlags;
        this.combinedFlags = (~(this.sourceOrOpFlags << 1)) & StreamOpFlag.INITIAL_OPS_VALUE;
        this.depth = 0;
        this.parallel = parallel;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<?> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.AbstractPipeline != java.util.stream.AbstractPipeline<E_IN, E_OUT, S extends j$.util.stream.BaseStream<E_OUT, S>> */
    public AbstractPipeline(Spliterator<?> spliterator, int sourceFlags, boolean parallel) {
        this.previousStage = null;
        this.sourceSpliterator = spliterator;
        this.sourceStage = this;
        this.sourceOrOpFlags = StreamOpFlag.STREAM_MASK & sourceFlags;
        this.combinedFlags = (~(this.sourceOrOpFlags << 1)) & StreamOpFlag.INITIAL_OPS_VALUE;
        this.depth = 0;
        this.parallel = parallel;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.AbstractPipeline != java.util.stream.AbstractPipeline<?, E_IN, ?> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.AbstractPipeline != java.util.stream.AbstractPipeline<E_IN, E_OUT, S extends j$.util.stream.BaseStream<E_OUT, S>> */
    public AbstractPipeline(AbstractPipeline<?, E_IN, ?> abstractPipeline, int opFlags) {
        if (abstractPipeline.linkedOrConsumed) {
            throw new IllegalStateException(MSG_STREAM_LINKED);
        }
        abstractPipeline.linkedOrConsumed = true;
        abstractPipeline.nextStage = this;
        this.previousStage = abstractPipeline;
        this.sourceOrOpFlags = StreamOpFlag.OP_MASK & opFlags;
        this.combinedFlags = StreamOpFlag.combineOpFlags(opFlags, abstractPipeline.combinedFlags);
        this.sourceStage = abstractPipeline.sourceStage;
        if (opIsStateful()) {
            this.sourceStage.sourceAnyStateful = true;
        }
        this.depth = abstractPipeline.depth + 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.AbstractPipeline != java.util.stream.AbstractPipeline<E_IN, E_OUT, S extends j$.util.stream.BaseStream<E_OUT, S>> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.TerminalOp != java.util.stream.TerminalOp<E_OUT, R> */
    public final <R> R evaluate(TerminalOp<E_OUT, R> terminalOp) {
        if (this.linkedOrConsumed) {
            throw new IllegalStateException(MSG_STREAM_LINKED);
        }
        this.linkedOrConsumed = true;
        if (isParallel()) {
            return terminalOp.evaluateParallel(this, sourceSpliterator(terminalOp.getOpFlags()));
        }
        return terminalOp.evaluateSequential(this, sourceSpliterator(terminalOp.getOpFlags()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.AbstractPipeline != java.util.stream.AbstractPipeline<E_IN, E_OUT, S extends j$.util.stream.BaseStream<E_OUT, S>> */
    public final Node<E_OUT> evaluateToArrayNode(IntFunction<E_OUT[]> generator) {
        if (this.linkedOrConsumed) {
            throw new IllegalStateException(MSG_STREAM_LINKED);
        }
        this.linkedOrConsumed = true;
        if (!isParallel() || this.previousStage == null || !opIsStateful()) {
            return evaluate(sourceSpliterator(0), true, generator);
        }
        this.depth = 0;
        return opEvaluateParallel(this.previousStage, this.previousStage.sourceSpliterator(0), generator);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<E_OUT> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.AbstractPipeline != java.util.stream.AbstractPipeline<E_IN, E_OUT, S extends j$.util.stream.BaseStream<E_OUT, S>> */
    public final Spliterator<E_OUT> sourceStageSpliterator() {
        if (this != this.sourceStage) {
            throw new IllegalStateException();
        }
        if (this.linkedOrConsumed) {
            throw new IllegalStateException(MSG_STREAM_LINKED);
        }
        this.linkedOrConsumed = true;
        if (this.sourceStage.sourceSpliterator != null) {
            Spliterator<E_OUT> spliterator = (Spliterator<E_OUT>) this.sourceStage.sourceSpliterator;
            this.sourceStage.sourceSpliterator = null;
            return spliterator;
        } else if (this.sourceStage.sourceSupplier != null) {
            Spliterator<E_OUT> spliterator2 = (Spliterator) this.sourceStage.sourceSupplier.get();
            this.sourceStage.sourceSupplier = null;
            return spliterator2;
        } else {
            throw new IllegalStateException(MSG_CONSUMED);
        }
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.AbstractPipeline != java.util.stream.AbstractPipeline<E_IN, E_OUT, S extends j$.util.stream.BaseStream<E_OUT, S>> */
    @Override // j$.util.stream.BaseStream
    public final S sequential() {
        this.sourceStage.parallel = $assertionsDisabled;
        return this;
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.AbstractPipeline != java.util.stream.AbstractPipeline<E_IN, E_OUT, S extends j$.util.stream.BaseStream<E_OUT, S>> */
    @Override // j$.util.stream.BaseStream
    public final S parallel() {
        this.sourceStage.parallel = true;
        return this;
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.AbstractPipeline != java.util.stream.AbstractPipeline<E_IN, E_OUT, S extends j$.util.stream.BaseStream<E_OUT, S>> */
    @Override // j$.util.stream.BaseStream, java.lang.AutoCloseable
    public void close() {
        this.linkedOrConsumed = true;
        this.sourceSupplier = null;
        this.sourceSpliterator = null;
        if (this.sourceStage.sourceCloseAction != null) {
            Runnable closeAction = this.sourceStage.sourceCloseAction;
            this.sourceStage.sourceCloseAction = null;
            closeAction.run();
        }
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.AbstractPipeline != java.util.stream.AbstractPipeline<E_IN, E_OUT, S extends j$.util.stream.BaseStream<E_OUT, S>> */
    @Override // j$.util.stream.BaseStream
    public S onClose(Runnable closeHandler) {
        Runnable composeWithExceptions;
        if (this.linkedOrConsumed) {
            throw new IllegalStateException(MSG_STREAM_LINKED);
        }
        Objects.requireNonNull(closeHandler);
        Runnable existingHandler = this.sourceStage.sourceCloseAction;
        AbstractPipeline abstractPipeline = this.sourceStage;
        if (existingHandler == null) {
            composeWithExceptions = closeHandler;
        } else {
            composeWithExceptions = Streams.composeWithExceptions(existingHandler, closeHandler);
        }
        abstractPipeline.sourceCloseAction = composeWithExceptions;
        return this;
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<E_OUT> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.AbstractPipeline != java.util.stream.AbstractPipeline<E_IN, E_OUT, S extends j$.util.stream.BaseStream<E_OUT, S>> */
    @Override // j$.util.stream.BaseStream
    public Spliterator<E_OUT> spliterator() {
        if (this.linkedOrConsumed) {
            throw new IllegalStateException(MSG_STREAM_LINKED);
        }
        this.linkedOrConsumed = true;
        if (this == this.sourceStage) {
            if (this.sourceStage.sourceSpliterator != null) {
                Spliterator<E_OUT> spliterator = (Spliterator<E_OUT>) this.sourceStage.sourceSpliterator;
                this.sourceStage.sourceSpliterator = null;
                return spliterator;
            } else if (this.sourceStage.sourceSupplier != null) {
                Supplier<? extends Spliterator<?>> supplier = this.sourceStage.sourceSupplier;
                this.sourceStage.sourceSupplier = null;
                return lazySpliterator(supplier);
            } else {
                throw new IllegalStateException(MSG_CONSUMED);
            }
        }
        return wrap(this, new Supplier() { // from class: j$.util.stream.AbstractPipeline$$ExternalSyntheticLambda0
            @Override // java.util.function.Supplier
            public final Object get() {
                return AbstractPipeline.this.m49lambda$spliterator$0$javautilstreamAbstractPipeline();
            }
        }, isParallel());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.AbstractPipeline != java.util.stream.AbstractPipeline<E_IN, E_OUT, S extends j$.util.stream.BaseStream<E_OUT, S>> */
    /* renamed from: lambda$spliterator$0$java-util-stream-AbstractPipeline  reason: not valid java name */
    public /* synthetic */ Spliterator m49lambda$spliterator$0$javautilstreamAbstractPipeline() {
        return sourceSpliterator(0);
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.AbstractPipeline != java.util.stream.AbstractPipeline<E_IN, E_OUT, S extends j$.util.stream.BaseStream<E_OUT, S>> */
    @Override // j$.util.stream.BaseStream
    public final boolean isParallel() {
        return this.sourceStage.parallel;
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.AbstractPipeline != java.util.stream.AbstractPipeline<E_IN, E_OUT, S extends j$.util.stream.BaseStream<E_OUT, S>> */
    final int getStreamFlags() {
        return StreamOpFlag.toStreamFlags(this.combinedFlags);
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<?> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.AbstractPipeline != java.util.stream.AbstractPipeline<E_IN, E_OUT, S extends j$.util.stream.BaseStream<E_OUT, S>> */
    private Spliterator<?> sourceSpliterator(int terminalFlags) {
        Spliterator<E_OUT> spliterator;
        int i;
        if (this.sourceStage.sourceSpliterator != null) {
            Spliterator spliterator2 = this.sourceStage.sourceSpliterator;
            this.sourceStage.sourceSpliterator = null;
            spliterator = spliterator2;
        } else if (this.sourceStage.sourceSupplier != null) {
            Spliterator spliterator3 = this.sourceStage.sourceSupplier.get();
            this.sourceStage.sourceSupplier = null;
            spliterator = spliterator3;
        } else {
            throw new IllegalStateException(MSG_CONSUMED);
        }
        if (isParallel() && this.sourceStage.sourceAnyStateful) {
            int depth = 1;
            AbstractPipeline u = this.sourceStage;
            spliterator = spliterator;
            AbstractPipeline p = this.sourceStage.nextStage;
            while (u != this) {
                int thisOpFlags = p.sourceOrOpFlags;
                if (p.opIsStateful()) {
                    depth = 0;
                    if (StreamOpFlag.SHORT_CIRCUIT.isKnown(thisOpFlags)) {
                        thisOpFlags &= ~StreamOpFlag.IS_SHORT_CIRCUIT;
                    }
                    spliterator = p.opEvaluateParallelLazy(u, spliterator);
                    if (spliterator.hasCharacteristics(64)) {
                        i = ((~StreamOpFlag.NOT_SIZED) & thisOpFlags) | StreamOpFlag.IS_SIZED;
                    } else {
                        i = ((~StreamOpFlag.IS_SIZED) & thisOpFlags) | StreamOpFlag.NOT_SIZED;
                    }
                    thisOpFlags = i;
                }
                p.depth = depth;
                p.combinedFlags = StreamOpFlag.combineOpFlags(thisOpFlags, u.combinedFlags);
                u = p;
                depth++;
                spliterator = spliterator;
                p = p.nextStage;
            }
        }
        if (terminalFlags != 0) {
            this.combinedFlags = StreamOpFlag.combineOpFlags(terminalFlags, this.combinedFlags);
        }
        return spliterator;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.AbstractPipeline != java.util.stream.AbstractPipeline<E_IN, E_OUT, S extends j$.util.stream.BaseStream<E_OUT, S>> */
    @Override // j$.util.stream.PipelineHelper
    public final StreamShape getSourceShape() {
        AbstractPipeline p = this;
        while (p.depth > 0) {
            p = p.previousStage;
        }
        return p.getOutputShape();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<P_IN> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.AbstractPipeline != java.util.stream.AbstractPipeline<E_IN, E_OUT, S extends j$.util.stream.BaseStream<E_OUT, S>> */
    @Override // j$.util.stream.PipelineHelper
    public final <P_IN> long exactOutputSizeIfKnown(Spliterator<P_IN> spliterator) {
        if (StreamOpFlag.SIZED.isKnown(getStreamAndOpFlags())) {
            return spliterator.getExactSizeIfKnown();
        }
        return -1L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<P_IN> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.AbstractPipeline != java.util.stream.AbstractPipeline<E_IN, E_OUT, S extends j$.util.stream.BaseStream<E_OUT, S>> */
    /* JADX WARN: Incorrect return type in method signature: <P_IN:Ljava/lang/Object;S::Lj$/util/stream/Sink<TE_OUT;>;>(TS;Lj$/util/Spliterator<TP_IN;>;)TS; */
    @Override // j$.util.stream.PipelineHelper
    public final Sink wrapAndCopyInto(Sink sink, Spliterator spliterator) {
        copyInto(wrapSink((Sink) Objects.requireNonNull(sink)), spliterator);
        return sink;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<P_IN> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.AbstractPipeline != java.util.stream.AbstractPipeline<E_IN, E_OUT, S extends j$.util.stream.BaseStream<E_OUT, S>> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Sink != java.util.stream.Sink<P_IN> */
    @Override // j$.util.stream.PipelineHelper
    public final <P_IN> void copyInto(Sink<P_IN> sink, Spliterator<P_IN> spliterator) {
        Objects.requireNonNull(sink);
        if (!StreamOpFlag.SHORT_CIRCUIT.isKnown(getStreamAndOpFlags())) {
            sink.begin(spliterator.getExactSizeIfKnown());
            spliterator.forEachRemaining(sink);
            sink.end();
            return;
        }
        copyIntoWithCancel(sink, spliterator);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<P_IN> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.AbstractPipeline != java.util.stream.AbstractPipeline<E_IN, E_OUT, S extends j$.util.stream.BaseStream<E_OUT, S>> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Sink != java.util.stream.Sink<P_IN> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // j$.util.stream.PipelineHelper
    public final <P_IN> boolean copyIntoWithCancel(Sink<P_IN> sink, Spliterator<P_IN> spliterator) {
        AbstractPipeline p = this;
        while (p.depth > 0) {
            p = p.previousStage;
        }
        sink.begin(spliterator.getExactSizeIfKnown());
        boolean cancelled = p.forEachWithCancel(spliterator, sink);
        sink.end();
        return cancelled;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.AbstractPipeline != java.util.stream.AbstractPipeline<E_IN, E_OUT, S extends j$.util.stream.BaseStream<E_OUT, S>> */
    @Override // j$.util.stream.PipelineHelper
    public final int getStreamAndOpFlags() {
        return this.combinedFlags;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.AbstractPipeline != java.util.stream.AbstractPipeline<E_IN, E_OUT, S extends j$.util.stream.BaseStream<E_OUT, S>> */
    public final boolean isOrdered() {
        return StreamOpFlag.ORDERED.isKnown(this.combinedFlags);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.AbstractPipeline != java.util.stream.AbstractPipeline<E_IN, E_OUT, S extends j$.util.stream.BaseStream<E_OUT, S>> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Sink != java.util.stream.Sink<E_OUT> */
    @Override // j$.util.stream.PipelineHelper
    public final <P_IN> Sink<P_IN> wrapSink(Sink<E_OUT> sink) {
        Objects.requireNonNull(sink);
        AbstractPipeline p = this;
        Consumer consumer = sink;
        while (p.depth > 0) {
            p = p.previousStage;
            consumer = p.opWrapSink(p.previousStage.combinedFlags, (Sink) consumer);
        }
        return (Sink<P_IN>) consumer;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<P_IN> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.AbstractPipeline != java.util.stream.AbstractPipeline<E_IN, E_OUT, S extends j$.util.stream.BaseStream<E_OUT, S>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // j$.util.stream.PipelineHelper
    public final <P_IN> Spliterator<E_OUT> wrapSpliterator(final Spliterator<P_IN> spliterator) {
        if (this.depth == 0) {
            return spliterator;
        }
        return wrap(this, new Supplier() { // from class: j$.util.stream.AbstractPipeline$$ExternalSyntheticLambda1
            @Override // java.util.function.Supplier
            public final Object get() {
                return AbstractPipeline.lambda$wrapSpliterator$1(Spliterator.this);
            }
        }, isParallel());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Spliterator lambda$wrapSpliterator$1(Spliterator sourceSpliterator) {
        return sourceSpliterator;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<P_IN> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.AbstractPipeline != java.util.stream.AbstractPipeline<E_IN, E_OUT, S extends j$.util.stream.BaseStream<E_OUT, S>> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.Node$Builder != java.util.stream.Node$Builder<E_OUT> */
    @Override // j$.util.stream.PipelineHelper
    public final <P_IN> Node<E_OUT> evaluate(Spliterator<P_IN> spliterator, boolean flatten, IntFunction<E_OUT[]> generator) {
        if (isParallel()) {
            return evaluateToNode(this, spliterator, flatten, generator);
        }
        return ((Node.Builder) wrapAndCopyInto(makeNodeBuilder(exactOutputSizeIfKnown(spliterator), generator), spliterator)).build();
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<P_IN> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.AbstractPipeline != java.util.stream.AbstractPipeline<E_IN, E_OUT, S extends j$.util.stream.BaseStream<E_OUT, S>> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.PipelineHelper != java.util.stream.PipelineHelper<E_OUT> */
    <P_IN> Node<E_OUT> opEvaluateParallel(PipelineHelper<E_OUT> pipelineHelper, Spliterator<P_IN> spliterator, IntFunction<E_OUT[]> generator) {
        throw new UnsupportedOperationException("Parallel evaluation is not supported");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object[] lambda$opEvaluateParallelLazy$2(int i) {
        return new Object[i];
    }

    /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<P_IN> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.AbstractPipeline != java.util.stream.AbstractPipeline<E_IN, E_OUT, S extends j$.util.stream.BaseStream<E_OUT, S>> */
    /* JADX WARN: Generic types in debug info not equals: j$.util.stream.PipelineHelper != java.util.stream.PipelineHelper<E_OUT> */
    <P_IN> Spliterator<E_OUT> opEvaluateParallelLazy(PipelineHelper<E_OUT> pipelineHelper, Spliterator<P_IN> spliterator) {
        return opEvaluateParallel(pipelineHelper, spliterator, new IntFunction() { // from class: j$.util.stream.AbstractPipeline$$ExternalSyntheticLambda2
            @Override // java.util.function.IntFunction
            public final Object apply(int i) {
                return AbstractPipeline.lambda$opEvaluateParallelLazy$2(i);
            }
        }).spliterator();
    }
}